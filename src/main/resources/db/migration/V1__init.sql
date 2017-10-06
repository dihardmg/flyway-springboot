CREATE TABLE peserta (
  id varchar(255) PRIMARY KEY NOT NULL,
  email varchar(255) NOT NULL UNIQUE,
  nama varchar(150) NOT NULL,
  tanggal_lahir date NOT NULL
);