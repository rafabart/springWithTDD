INSERT INTO customer (name, cpf) VALUES ('Iago', '86730543540');
INSERT INTO customer (name, cpf) VALUES ('Pedro', '55565893569');
INSERT INTO customer (name, cpf) VALUES ('Caue', '38767897100');
INSERT INTO customer (name, cpf) VALUES ('Breno', '78673781620');
INSERT INTO customer (name, cpf) VALUES ('Thiago', '72788740417');

INSERT INTO phone (ddd, number, id_customer) VALUES ('41', '999570146', (SELECT id FROM customer WHERE cpf = '86730543540'));
INSERT INTO phone (ddd, number, id_customer) VALUES ('82', '39945903', (SELECT id FROM customer WHERE cpf = '55565893569'));
INSERT INTO phone (ddd, number, id_customer) VALUES ('86', '35006330', (SELECT id FROM customer WHERE cpf = '38767897100'));
INSERT INTO phone (ddd, number, id_customer) VALUES ('21', '997538804', (SELECT id FROM customer WHERE cpf = '78673781620'));
INSERT INTO phone (ddd, number, id_customer) VALUES ('95', '38416516', (SELECT id FROM customer WHERE cpf = '72788740417'));

INSERT INTO andress (street, number, complement, district, city, state, id_customer) VALUES ('Rua dos Gerânios', 497, 'XXXX', 'Pricumã', 'Boa Vista', 'RR', (SELECT id FROM customer WHERE cpf = '86730543540'));
INSERT INTO andress (street, number, complement, district, city, state, id_customer) VALUES ('Rua dos Gerânios', 497, 'XXXX', 'Pricumã', 'Boa Vista', 'RR', (SELECT id FROM customer WHERE cpf = '55565893569'));
INSERT INTO andress (street, number, complement, district, city, state, id_customer) VALUES ('Rua dos Gerânios', 497, 'XXXX', 'Pricumã', 'Boa Vista', 'RR', (SELECT id FROM customer WHERE cpf = '38767897100'));
INSERT INTO andress (street, number, complement, district, city, state, id_customer) VALUES ('Rua dos Gerânios', 497, 'XXXX', 'Pricumã', 'Boa Vista', 'RR', (SELECT id FROM customer WHERE cpf = '78673781620'));
INSERT INTO andress (street, number, complement, district, city, state, id_customer) VALUES ('Rua dos Gerânios', 497, 'XXXX', 'Pricumã', 'Boa Vista', 'RR', (SELECT id FROM customer WHERE cpf = '72788740417'));