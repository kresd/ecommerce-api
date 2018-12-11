insert into toko (id, nama, alamat) values
('001', 'D-Robotics', 'Surabaya'),
('002', 'Mitra Elektro', 'Jakarta'),
('003', 'Batik Nusantara', 'Yogyakarta'),
('004', 'Distro Dago', 'Bandung');

insert into produk (id, nama_produk, stock, harga, toko_id) VALUES
('001','PCB - Bolong', 10, 5000, '001'),
('002','Sensor Infrared', 10, 25000, '001'),
('003','Motor Servo', 10, 50000, '001'),

('004','Sensor Ultrasonik', 20, 35000, '002'),
('005','Arduino Nano', 20, 80000, '002'),
('006','Raspberry-Pi B', 20, 500000, '002'),

('007','Batik Hijau - Lengan Panjang', 30, 25000, '003'),
('008','Batik Biru - Lengan Panjang', 30, 25000, '003'),
('009','Batik Merah - Lengan Pendek', 30, 25000, '003'),

('010','Kaos Daiwa - Putih', 25, 55000, '004'),
('011','Jaket Supreme - Hitam', 25, 250000, '004'),
('012','Celana Chino - Moca', 25, 100000, '004');