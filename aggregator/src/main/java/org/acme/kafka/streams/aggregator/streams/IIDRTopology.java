package org.acme.kafka.streams.aggregator.streams;

import io.quarkus.kafka.client.serialization.ObjectMapperSerde;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.acme.kafka.streams.aggregator.model.RequestDTO;
import org.acme.kafka.streams.aggregator.model.iidr.InfCecPedCno;
import org.acme.kafka.streams.aggregator.model.iidr.InfCecPedCnoKey;
import org.acme.kafka.streams.aggregator.model.iidr.InfPedCno;
import org.acme.kafka.streams.aggregator.model.iidr.InfPedCnoKey;
import org.acme.kafka.streams.aggregator.streams.serder.InfCecPedCnoKeySerde;
import org.acme.kafka.streams.aggregator.streams.serder.InfPedCnoKeySerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.StreamJoined;

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

        // Define a janela de junção de 5 minutos
        JoinWindows joinWindows = JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofMinutes(5));

        // Stream do tópico INF_PED_CNO
        KStream<String, InfPedCno> infPedCnoStream = builder.stream(
                INF_PED_CNO,
                Consumed.with(infPedCnoSerdeKey, infPedCnoSerdeValue)
        ).selectKey((key, value) -> key.getCdIpcno());

        // Stream do tópico INF_CEC_PED_CNO
        KStream<String, InfCecPedCno> infCecPedCnoStream = builder.stream(
                INF_CEC_PED_CNO,
                Consumed.with(infCecPedCnoSerdeKey, infCecPedCnoSerdeValue)
        ).selectKey((key, value) -> key.getCdIpcno());

        // Realiza o join dos dois streams e envia o resultado para um novo stream
        KStream<String, RequestDTO> joinedStream =
                infPedCnoStream.join(infCecPedCnoStream,
                        (infPedCno, infCecPedCno) -> {
                            RequestDTO requestDTO = new RequestDTO();
                            requestDTO.setDataFromTopic1(infPedCno.toString());
                            requestDTO.setDataFromTopic2(infCecPedCno.toString());
                            return requestDTO;
                        },
                        joinWindows,
                        StreamJoined.with(Serdes.String(), infPedCnoSerdeValue, infCecPedCnoSerdeValue)
                );

        // Enviar o resultado do join para um novo tópico ou processar conforme necessário
        joinedStream.foreach((key, value) -> System.out.println("Key: " + key + " Value: " + value));


        return builder.build();
    }
}
