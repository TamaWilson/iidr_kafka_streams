package org.acme.kafka.streams.aggregator.model;

public class RequestDTO {
        private String dataFromTopic1;
        private String dataFromTopic2;
        // Getters e Setters

        public String getDataFromTopic1() {
            return dataFromTopic1;
        }

        public void setDataFromTopic1(String dataFromTopic1) {
            this.dataFromTopic1 = dataFromTopic1;
        }

        public String getDataFromTopic2() {
            return dataFromTopic2;
        }

        public void setDataFromTopic2(String dataFromTopic2) {
            this.dataFromTopic2 = dataFromTopic2;
        }

        @Override
        public String toString() {
            return "RequestDTO{" +
                    "dataFromTopic1='" + dataFromTopic1 + '\'' +
                    ", dataFromTopic2='" + dataFromTopic2 + '\'' +
                    '}';
        }
    }