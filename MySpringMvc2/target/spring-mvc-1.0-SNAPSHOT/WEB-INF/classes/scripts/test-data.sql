INSERT INTO worker (fio) VALUES ('Ivanov P.V.');
INSERT INTO worker (fio) VALUES ('Petrov S.K.');
INSERT INTO worker (fio) VALUES ('Smirnov K.V.');


INSERT INTO autosalon (address, worker_id) VALUES ('Moscow', 1);
INSERT INTO autosalon (address, worker_id) VALUES ('Moscow', 1);
INSERT INTO autosalon (address, worker_id) VALUES ('Spb', 2);
INSERT INTO autosalon (address, worker_id) VALUES ('Spb', 2);
INSERT INTO autosalon (address, worker_id) VALUES ('IvanGorod', 3);
INSERT INTO autosalon (address, worker_id) VALUES ('IvanGorod', 3);
INSERT INTO autosalon (address, worker_id) VALUES ('IvanGorod', 3);

INSERT INTO auto (name) VALUES ('BMW');
INSERT INTO auto (name) VALUES ('Cadillac');
INSERT INTO auto (name) VALUES ('VOLVO');

INSERT INTO autosalon_auto (autosalon_id, auto_id) VALUES (3, 2);
INSERT INTO autosalon_auto (autosalon_id, auto_id) VALUES (2, 3);
INSERT INTO autosalon_auto (autosalon_id, auto_id) VALUES (3, 2);
INSERT INTO autosalon_auto (autosalon_id, auto_id) VALUES (1, 1)