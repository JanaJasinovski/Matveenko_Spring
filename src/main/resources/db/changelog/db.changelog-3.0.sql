--liquibase formatted sql

--changeset jjasinovskaja:1
ALTER TABLE users
ADD COLUMN image VARCHAR(64);

--changeset jjasinovskaja:2
ALTER TABLE users_aud
ADD COLUMN image VARCHAR(64);