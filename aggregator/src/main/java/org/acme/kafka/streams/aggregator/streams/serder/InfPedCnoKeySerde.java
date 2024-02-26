package org.acme.kafka.streams.aggregator.streams.serder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.acme.kafka.streams.aggregator.model.iidr.InfPedCnoKey;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import java.io.IOException;
import java.util.Map;

public class InfPedCnoKeySerde implements Serde<InfPedCnoKey> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Nenhuma configuração adicional necessária
    }

    @Override
    public void close() {
        // Nada a ser feito ao fechar o Serde
    }

    @Override
    public Serializer<InfPedCnoKey> serializer() {
        return new Serializer<>() {
            @Override
            public byte[] serialize(String topic, InfPedCnoKey data) {
                try {
                    return objectMapper.writeValueAsBytes(data);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Erro ao serializar o objeto: " + data, e);
                }
            }
        };
    }

    @Override
    public Deserializer<InfPedCnoKey> deserializer() {
        return new Deserializer<>() {
            @Override
            public InfPedCnoKey deserialize(String topic, byte[] data) {
                try {
                    return objectMapper.readValue(data, InfPedCnoKey.class);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Erro ao desserializar o objeto", e);
                }
            }
        };
    }
}
