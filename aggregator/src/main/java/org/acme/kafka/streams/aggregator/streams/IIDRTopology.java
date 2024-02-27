package org.acme.kafka.streams.aggregator.streams;

import io.quarkus.kafka.client.serialization.ObjectMapperSerde;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.acme.kafka.streams.aggregator.model.RequestDTO;
import org.acme.kafka.streams.aggregator.model.iidr.*;
import org.acme.kafka.streams.aggregator.streams.serder.InfCecPedCnoKeySerde;
import org.acme.kafka.streams.aggregator.streams.serder.InfPedCnoKeySerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;

import java.time.Duration;

@ApplicationScoped
public class IIDRTopology {
    static final String INF_CEC_PED_CNO = "KFK303.vn.jtrach.inf_cec_ped_cno";
    static final String INF_PED_CNO = "KFK304.vn.jtrach.inf_ped_cno";

    @Produces
    public Topology buildTopology() {
        final StreamsBuilder builder = new StreamsBuilder();

        // Defina os Serdes para as chaves e valores dos dois streams
        Serde<InfPedCnoKey> infPedCnoSerdeKey = new InfPedCnoKeySerde();
        ObjectMapperSerde<InfPedCno> infPedCnoSerdeValue = new ObjectMapperSerde<>(InfPedCno.class);

        Serde<InfCecPedCnoKey> infCecPedCnoSerdeKey = new InfCecPedCnoKeySerde();
        ObjectMapperSerde<InfCecPedCno> infCecPedCnoSerdeValue = new ObjectMapperSerde<>(InfCecPedCno.class);

//        ObjectMapperSerde<JoinedKey> joinedKeySerde = new ObjectMapperSerde<>(JoinedKey.class);

        // Stream do tópico INF_PED_CNO
        KStream<String, InfPedCno> infPedCnoStream = builder.stream(
                        INF_PED_CNO,
                        Consumed.with(infPedCnoSerdeKey, infPedCnoSerdeValue)
                )
//                .filter((key, value) -> key.getCdIpcnoUndNeg().equals("98") || key.getCdIpcnoUndNeg().equals("99"))
                .selectKey((key, value) -> {
//                    var joinedKey = new JoinedKey();
//                    joinedKey.setCdIpcno(key.getCdIpcno());
//                    joinedKey.setCdIpcnoSeq(key.getCdIpcnoSeq());
                    return key.getCdIpcno() + key.getCdIpcnoSeq();
                });

        // Stream do tópico INF_CEC_PED_CNO
        KStream<String, InfCecPedCno> infCecPedCnoStream = builder.stream(
                INF_CEC_PED_CNO,
                Consumed.with(infCecPedCnoSerdeKey, infCecPedCnoSerdeValue)
        ) .selectKey((key, value) -> {
//            var joinedKey = new JoinedKey();
//            joinedKey.setCdIpcno(key.getCdIpcno());
//            joinedKey.setCdIpcnoSeq(key.getCdIpcnoSeq());
            return key.getCdIpcno() + key.getCdIpcnoSeq();
        });

        // Realiza o join dos dois streams e envia o resultado para um novo stream
        KStream<String, RequestDTO> joinedStream =
                infPedCnoStream.join(infCecPedCnoStream,
                        (infPedCno, infCecPedCno) -> {
                            RequestDTO requestDTO = new RequestDTO();
                            requestDTO.setDataFromTopic1(infPedCno.toString());
                            requestDTO.setDataFromTopic2(infCecPedCno.toString());
                            return requestDTO;
                        },
                        JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofMinutes(30)),
                        StreamJoined.with(Serdes.String(), infPedCnoSerdeValue, infCecPedCnoSerdeValue)
                );


        // Enviar o resultado do join para um novo tópico ou processar conforme necessário
        joinedStream.foreach((key, value) -> System.out.println("Key: " + key + " Value: " + value));


        return builder.build();
    }
}
