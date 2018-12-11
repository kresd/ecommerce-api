create table toko
(
  id              character varying(64)   not null primary key,
  nama            character varying(100)  not null,
  alamat          character varying(100)  not null
);

create table produk
(
  id                character varying(64)   not null primary key,
  nama_produk       character varying(100)  not null,
  stock             int                     not null,
  harga             decimal                 not null,
  toko_id           character varying(64)   not null
);

alter table produk
  add constraint fk_toko_produk foreign key (toko_id)
  references toko (id) on update cascade on delete restrict;


create table produk_toko
(
  toko_id     character varying(64) not null,
  produk_id   character varying(64) not null
);

alter table produk_toko
  add constraint fk_produk_toko_id foreign key (toko_id)
  references toko (id) on update cascade on delete cascade;

alter table produk_toko
  add constraint fk_produk_toko_produk_id foreign key (produk_id)
  references produk (id) on update cascade on delete cascade;