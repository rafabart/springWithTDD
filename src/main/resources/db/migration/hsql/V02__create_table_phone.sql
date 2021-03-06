CREATE SEQUENCE phone_id_seq AS BIGINT START WITH 1 INCREMENT BY 1;

CREATE TABLE phone (
  id BIGINT GENERATED BY DEFAULT AS SEQUENCE phone_id_seq PRIMARY KEY,
  ddd VARCHAR(2) NOT NULL,
  number VARCHAR(9) NOT NULL,
  id_customer BIGINT NOT NULL,
  FOREIGN KEY (id_customer) REFERENCES customer(id)
);