INSERT INTO tb_user (name, email, password) VALUES ('Beatriz', 'Beatriz@gmail.com', '$2a$10$DM/5ajWrwr3al7qbSb9qGePcTEvwABUU3rhSOak.cu7soOr3bmoPq');
INSERT INTO tb_user (name, email, password) VALUES ('wesley', 'wesley@gmail.com', '$2a$10$DM/5ajWrwr3al7qbSb9qGePcTEvwABUU3rhSOak.cu7soOr3bmoPq');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_product (name) VALUES ('TV');
INSERT INTO tb_product (name) VALUES ('Computer');