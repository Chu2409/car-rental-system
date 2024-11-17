DELETE FROM users WHERE email = 'juan@gmail.com';

INSERT INTO users ("name", "last_name", "email", "password", "role") VALUES ('Juanito', 'Alimaña', 'juan@gmail.com', '$2a$10$Sd6uoK/PWNfzN1CevYQFs.HpTp9yp0WCi6PgYzLSRAaszeTm1Vdue', 'Administrador');

-- Password 123456