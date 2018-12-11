create table checkout
(
  id                character varying(64)   not null primary key,
  pembeli_id        character varying(64)   not null,
  produk_id         character varying(64)   not null,
  jumlah_barang     int                     not null,
  total_bayar       decimal                 not null
);

alter table checkout
  add constraint fk_pembeli_checkout foreign key (pembeli_id)
  references pembeli (id) on update cascade on delete restrict;

alter table checkout
  add constraint fk_produk_checkout foreign key (produk_id)
  references produk (id) on update cascade on delete restrict;