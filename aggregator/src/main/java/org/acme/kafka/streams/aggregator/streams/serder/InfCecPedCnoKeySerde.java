package org.acme.kafka.streams.aggregator.streams.serder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.acme.kafka.streams.aggregator.model.iidr.InfCecPedCnoKey;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import java.io.IOException;
import java.util.Map;

public class InfCecPedCnoKeySerde implements Serde<InfCecPedCnoKey> {

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
    public Serializer<InfCecPedCnoKey> serializer() {
        return new Serializer<>() {
            @Override
            public byte[] serialize(String topic, InfCecPedCnoKey data) {
                try {
                    return objectMapper.writeValueAsBytes(data);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Erro ao serializar o objeto: " + data, e);
                }
            }
        };
    }

    @Override
    public Deserializer<InfCecPedCnoKey> deserializer() {
        return new Deserializer<>() {
            @Override
            public InfCecPedCnoKey deserialize(String topic, byte[] data) {
                try {
                    return objectMapper.readValue(data, InfCecPedCnoKey.class);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Erro ao desserializar o objeto", e);
                }
            }
        };
    }
}
