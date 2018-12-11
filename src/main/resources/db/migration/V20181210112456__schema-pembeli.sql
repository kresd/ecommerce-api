create table pembeli
(
  id              character varying(64)   not null primary key,
  nama            character varying(100)  not null,
  telp            character varying(100)  not null,
  alamat          character varying(100)  not null,
  email           character varying(100)  not null
);