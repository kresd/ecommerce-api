create table transaksi
(
  id                  character varying(64)   not null primary key,
  pembeli_id          character varying(64)   not null,
  produk_id           character varying(64)   not null,
  jumlah_barang       int                     not null,
  total_bayar         decimal                 not null,
  statust_id          character varying(64)   not null,
  tanggal_transaksi   timestamp               not null default now(),
  is_cancel           boolean                 not null default false,
  tanggal_pembatalan  timestamp
);

alter table transaksi
  add constraint fk_pembeli_transaksi foreign key (pembeli_id)
  references pembeli (id) on update cascade on delete restrict;

alter table transaksi
  add constraint fk_produk_transaksi foreign key (produk_id)
  references produk (id) on update cascade on delete restrict;

alter table transaksi
  add constraint fk_statust_transaksi foreign key (statust_id)
  references statust (id) on update cascade on delete restrict;


create table transaksi_details
(
  id              character varying(64) not null primary key,
  transaksi_id    character varying(64) not null,
  produk_id       character varying(64) not null
);

alter table transaksi_details
  add constraint fk_transaksi_detail_transaksi foreign key (transaksi_id)
  references transaksi (id) on update cascade on delete restrict;

alter table transaksi_details
  add constraint fk_transaksi_detail_produk foreign key (produk_id)
  references produk (id) on update cascade on delete restrict;

alter table transaksi_details
  add constraint un_transkasi_detail unique (produk_id, transaksi_id);