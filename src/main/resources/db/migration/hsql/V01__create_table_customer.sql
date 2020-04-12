CREATE SEQUENCE customer_id_seq AS BIGINT START WITH 1 INCREMENT BY 1;

CREATE TABLE customer (
  id BIGINT GENERATED BY DEFAULT AS SEQUENCE customer_id_seq PRIMARY KEY,
  name VARCHAR(80) NOT NULL,
  cpf VARCHAR(11) NOT NULL
);