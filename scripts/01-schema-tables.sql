CREATE SCHEMA IF NOT EXISTS umanagdb AUTHORIZATION umanag_dbo;
SET search_path TO umanagdb;

------------------   user_info
DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info
(
  id          BIGSERIAL,
  nick        VARCHAR(40),
  first_name  VARCHAR(100),
  last_name   VARCHAR(100),
  age         INT,
  phone       VARCHAR(13),
  email       VARCHAR(100),
  created_at TIMESTAMP DEFAULT now() not null,
  status      VARCHAR(10),
  CONSTRAINT user_info$pk PRIMARY KEY (id)
);

CREATE UNIQUE INDEX user_info$nick ON user_info (nick);
ALTER TABLE IF EXISTS user_info
  OWNER to umanag_dbo;


INSERT into user_info (nick, first_name, last_name, age, phone, email, status)
VALUES ('User123', 'John', 'User', 20, '+123456789012', 'dddd@dddd.dev', 'ACTIVE');
INSERT into user_info (nick, first_name, last_name, age, phone, email, status)
VALUES ('User135', 'Pol', 'Star', 20, '+123456789013', 'dddd11@dddd.dev', 'ACTIVE');
INSERT into user_info (nick, first_name, last_name, age, phone, email, status)
VALUES ('User155', 'Nik', 'Dio', 20, '+123456789017', 'dddd12@dddd.dev', 'INACTIVE');
