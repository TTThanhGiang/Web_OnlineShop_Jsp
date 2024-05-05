go 
create database dbQUANLYBANGIAY
go
use dbQUANLYBANGIAY
go
create table tbKHACHHANG
(
	MAKHACHHANG INT IDENTITY(1,1) not null PRIMARY KEY,	
    HOTEN NVARCHAR(100),
    NGAYSINH DATE,
    GIOITINH NVARCHAR(10),
    EMAIL NVARCHAR(100),
    DIACHI NVARCHAR(200),
    TAIKHOAN NVARCHAR(50),
    MATKHAU NVARCHAR(50),
)
go
create table tbDANHMUC
(
	MADANHMUC VARCHAR(20) NOT NULL PRIMARY KEY,
	TENDANHMUC NVARCHAR(200) NULL,
	
)
go

create table tbSANPHAM
(
	MASANPHAM VARCHAR(20) NOT NULL PRIMARY KEY,
	TENSANPHAM NVARCHAR(200) NULL,
	DONGIA NUMERIC(18,0) NULL,
	SOLUONG NUMERIC(18, 0) NULL,
	HINHANH NVARCHAR(50) NULL,
	MOTA NVARCHAR(max) NULL,
	MADANHMUC VARCHAR(20) NULL FOREIGN KEY REFERENCES tbDANHMUC(MADANHMUC)
	on update
		cascade
	on delete
		cascade
)
go
create table tbHOADON
(
	MAHOADON VARCHAR(20) NOT NULL PRIMARY KEY,	
	MAKHACHHANG INT NULL FOREIGN KEY REFERENCES tbKHACHHANG(MAKHACHHANG)
	on update
		cascade
	on delete
		cascade,
	NGAYTAO DATE NULL,
	TRANGTHAI NVARCHAR(50) NOT NULL
)
go
create table tbCHITIETHOADON
(
	MACHITIET  VARCHAR(20) NOT NULL PRIMARY KEY,
	MASANPHAM VARCHAR(20) NULL FOREIGN KEY REFERENCES tbSANPHAM(MASANPHAM)
	on update
		cascade
	on delete
		cascade,
	HD_SOLUONG NUMERIC(18, 0) NULL,
	HD_DONGIA NUMERIC(18,0) NULL,
	MAHOADON VARCHAR(20) NULL FOREIGN KEY REFERENCES tbHOADON(MAHOADON)
	on update
		cascade
	on delete
		cascade
)
create table tbGIOHANG
(
	MAGIOHANG VARCHAR(20) NOT NULL PRIMARY KEY,
    MAKHACHHANG int NULL FOREIGN KEY REFERENCES tbKHACHHANG(MAKHACHHANG)
	on update
		cascade
	on delete
		cascade,
    MASANPHAM VARCHAR(20) NULL FOREIGN KEY REFERENCES tbSANPHAM(MASANPHAM)
	on update
		cascade
	on delete
		cascade,
    SOLUONG INT NULL,
	DONGIA NUMERIC(18,0) NULL
)
go
	insert tbDANHMUC(MADANHMUC,TENDANHMUC)
	values
		('DM0001',N'Giày Chạy'),
		('DM0002',N'Giày Bóng Đá'),
		('DM0003',N'Giày Ngoài Trời'),
		('DM0004',N'Dép'),
		('DM0005',N'Áo thun')

go
insert tbSANPHAM(MASANPHAM,TENSANPHAM,DONGIA,SOLUONG,HINHANH,MOTA,MADANHMUC)
VALUES
	('SP0001','ADIDAS Ultraboost',150,15,'p1.jpg','Adidas long-distance running shoe line featuring the exclusive Boost cushioning technology that provides shock absorption and increased comfort, suitable for long-distance runners.','DM0001'),
	('SP0002','ADIDAS Solarboost',160,15,'p2.jpg','Adidas long-distance running shoe line featuring the Solar Propulsion Rail technology that supports and guides foot motion, reducing fatigue.','DM0001'),
	('SP0003','ADIDAS Adizero Adios',170,15,'p3.jpg','Adidas speed running shoe line, designed with lightweight materials and cushioning for increased speed and support for short-distance runners.','DM0001'),
	('SP0004','ADIDAS Pulseboost HD',180,15,'p4.jpg','Adidas urban running shoe line featuring the Pulseboost HD cushioning technology that increases energy return and grip on all surfaces, suitable for street sports activities.','DM0001'),
	('SP0005','ADDIDAS Supernova',190,15,'p5.jpg','Adidas long-distance running shoe line featuring the Stableframe technology that maintains stability and maximizes shock absorption, suitable for distance running.','DM0001')
go
insert tbSANPHAM(MASANPHAM,TENSANPHAM,DONGIA,SOLUONG,HINHANH,MOTA,MADANHMUC)
VALUES
	('SP0006','ADIDAS Copa Mundial',200,20,'p2.jpg','adidas classic football shoe line made of leather and featuring a rubber outsole, providing durability and good traction.','DM0002'),
	('SP0007','ADIDAS Predator',200,20,'p5.jpg','Adidas signature football shoe line with a thick Demonskin cushioning layer and spikes on the shoe surface for increased grip and ball control.','DM0002'),
	('SP0008','ADIDAS X Ghosted',200,20,'p4.jpg','Adidas speed football shoe line with a lightweight and flexible design, enhancing speed and quick movements.','DM0002'),
	('SP0009','ADIDAS Nemeziz',200,20,'p6.jpg','Adidas flexible football shoe line with a unique design on the upper part of the shoe, providing increased flexibility and reduce slipping.','DM0002'),
	('SP00010','ADIDAS Copa Sense',200,20,'p7.jpg','Adidas latest football shoe line featuring Sensorytouch technology on the shoe surface, increasing the connection between the foot and the ball, providing better comfort and ball control.','DM0002')
go
go
insert tbSANPHAM(MASANPHAM,TENSANPHAM,DONGIA,SOLUONG,HINHANH,MOTA,MADANHMUC)
VALUES
	('SP00011','ADIDAS Terrex Swift R2 GTX',100,15,'p3.jpg','A versatile outdoor shoe with a rubber outsole for slip resistance, an EVA midsole for good support, and a Gore-Tex coating to protect against water and dirt.','DM0003'),
	('SP00012','ADIDAS Terrex Free Hiker',100,15,'p1.jpg','An outdoor hiking shoe with a 3D knit design and Boost midsole for enhanced grip and comfort.','DM0003'),
	('SP00013','ADIDAS Terrex AX3',100,15,'p5.jpg','A mountain climbing shoe with a rubber outsole for slip resistance, an EVA midsole for good support, and a durable upper for protection against rough terrain.','DM0003'),
	('SP00014','ADIDAS Terrex Agravic TR',100,15,'p6.jpg','A trail running shoe with a Continental rubber outsole for superior traction on any surface, a Boost midsole for cushioning and energy return, and a lightweight design for speed.','DM0003'),
	('SP00015','ADIDAS Terrex Two Ultra Parley',100,15,'p3.jpg','An eco-friendly outdoor shoe made with recycled materials, featuring a Continental rubber outsole for grip, a Boost midsole for cushioning, and a breathable upper for comfort.','DM0003')
go
insert tbSANPHAM(MASANPHAM,TENSANPHAM,DONGIA,SOLUONG,HINHANH,MOTA,MADANHMUC)
VALUES
	('SP00016','ADIDAS Adilette',50,18,'dep1.jpg','A simple leather sandal with an EVA footbed and a leather upper.','DM0004'),
	('SP00017','ADIDAS Adissage',50,18,'dep1.jpg','A massage sandal with small nubs on the footbed to stimulate pressure points and relax muscles.','DM0004'),
	('SP00018','ADIDAS Duramo',50,18,'dep1.jpg','A lightweight sandal with an EVA footbed and a synthetic upper.','DM0004'),
	('SP00019','ADIDAS Superstar',50,18,'dep1.jpg','A classic leather sandal with a reinforced toe cap for added durability.','DM0004'),
	('SP00020','ADIDAS Slides',50,18,'dep1.jpg','A slip-on leather sandal with an EVA footbed and a leather upper, often used after workouts or for swimming.','DM0004'),
	('SP00021',N'Giày Cao Gót','130',3,'r1.jpg',N'Áo thun nam cotton, thoải mái, phù hợp nhiều hoàn cảnh. Thiết kế đơn giản, tôn vóc dáng.','DM0003'),
	('SP00022',N'Áo thun nam Cotton Coolmate Basics','120',3,'l1.jpg',N'Áo thun nam cotton, thoải mái, phù hợp nhiều hoàn cảnh. Thiết kế đơn giản, tôn vóc dáng.','DM0005'),
	('SP00023',N'ÁO BLAZER FORM DÀI KHÔNG TAY','160',3,'l3.jpg',N'Áo thun nam cotton, thoải mái, phù hợp nhiều hoàn cảnh. Thiết kế đơn giản, tôn vóc dáng.','DM0005'),
	('SP00024',N'ÁO KIỂU SƠMI CỔ V','90',3,'l5.jpg',N'Áo thun nam cotton, thoải mái, phù hợp nhiều hoàn cảnh. Thiết kế đơn giản, tôn vóc dáng.','DM0005'),
	('SP00025',N'Giày Nike','230',3,'r6.jpg',N'Áo thun nam cotton, thoải mái, phù hợp nhiều hoàn cảnh. Thiết kế đơn giản, tôn vóc dáng.','DM0002'),
	('SP00026',N'Áo thun nam Cotton Compact phiên bản Premium','240',3,'l7.jpg',N'Áo thun nam cotton, thoải mái, phù hợp nhiều hoàn cảnh. Thiết kế đơn giản, tôn vóc dáng.','DM0005'),
	('SP00027',N'Áo thun thể thao dài tay nam Recycle Active','150',3,'l8.jpg',N'Áo thun nam cotton, thoải mái, phù hợp nhiều hoàn cảnh. Thiết kế đơn giản, tôn vóc dáng.','DM0005'),
	('SP00028',N'ÁO BLAZER FORM DÀI KHÔNG TAY','190',3,'l6.jpg',N'Áo thun nam cotton, thoải mái, phù hợp nhiều hoàn cảnh. Thiết kế đơn giản, tôn vóc dáng.','DM0005'),
	('SP00029',N'Giày Cao Gót Phối Khoá Trang Trí Jn','170',3,'r11.jpg',N'Áo thun nam cotton, thoải mái, phù hợp nhiều hoàn cảnh. Thiết kế đơn giản, tôn vóc dáng.','DM0003')

go
insert tbKHACHHANG(HOTEN,NGAYSINH,GIOITINH,EMAIL,DIACHI,TAIKHOAN,MATKHAU)
VALUES
	(N'Lê Ngọc Hào','2003-03-25','Nam','ngcha763@gmail.com',N'158 Trần Cao Vân , Thanh Khê , Đà Nẵng','lengochao','matkhau123'),
	(N'Đoàn Nguyễn Thành Giang','2003-03-25','Nam','ngcha763@gmail.com',N'158 Trần Cao Vân , Thanh Khê , Đà Nẵng','thanhgiang','matkhau123'),
	(N'Cao Nguyễn Vũ','2003-03-25','Nam','ngcha763@gmail.com',N'158 Trần Cao Vân , Thanh Khê , Đà Nẵng','nguyenvu','matkhau123'),
	(N'Hoàng Chung Nghĩa','2003-03-25','Nam','ngcha763@gmail.com',N'158 Trần Cao Vân , Thanh Khê , Đà Nẵng','chungnghia','matkhau123'),
	(N'Đoàn Huỳnh Ngọc Sơn','2003-03-25','Nam','ngcha763@gmail.com',N'158 Trần Cao Vân , Thanh Khê , Đà Nẵng','ngocson','matkhau123')
go
insert tbHOADON(MAHOADON,NGAYTAO,TRANGTHAI)
VALUES
	('HD001','2020-01-01',N'Đã Giao Hàng'),
	('HD002','2021-01-01',N'Đã Giao Hàng'),
	('HD003','2022-01-01',N'Chờ Xử Lý'),
	('HD004','2023-01-01',N'Đang Giao Hàng'),
	('HD005','2020-05-15',N'Đang Giao Hàng'),
	('HD006','2023-02-20',N'Đang Giao Hàng'),
	('HD007','2023-09-15',N'Chờ Xử Lý'),
	('HD008','2022-10-10',N'Đã Giao Hàng'),
	('HD009','2023-03-28',N'Đang Giao Hàng'),
	('HD0010','2023-05-07',N'Chờ Xử Lý')
go
insert tbCHITIETHOADON(MACHITIET,MASANPHAM,HD_SOLUONG,HD_DONGIA,MAHOADON)
VALUES
	('CTHD00001','SP00019',1,50,'HD001'),
	('CTHD00002','SP0001',2,150,'HD002'),
	('CTHD00003','SP00012',1,100,'HD003'),
	('CTHD00004','SP0006',1,200,'HD004'),
	('CTHD00005','SP0008',4,200,'HD005'),
	('CTHD00006','SP00010',1,200,'HD006'),
	('CTHD00007','SP00019',1,50,'HD007'),
	('CTHD00008','SP00020',2,50,'HD008'),
	('CTHD00009','SP0003',1,170,'HD009'),
	('CTHD000010','SP00017',3,50,'HD0010')
	
go
insert tbGIOHANG(MAGIOHANG,MAKHACHHANG,MASANPHAM,SOLUONG,DONGIA)
VALUES
	('GH0001',1,'SP00017',3,50),
	('GH0002',1,'SP0003',1,170),
	('GH0003',2,'SP00017',3,50),
	('GH0004',2,'SP0003',1,170),
	('GH0005',3,'SP00017',3,50),
	('GH0006',3,'SP0003',1,170),
	('GH0007',4,'SP00017',3,50),
	('GH0008',4,'SP0003',1,170),
	('GH0009',5,'SP00017',3,50),
	('GH00010',5,'SP0003',1,170)

--go
--select * from tbSANPHAM order by cast(SUBSTRING(MASANPHAM,3,LEN(MASANPHAM))as int)
/*select * from tbHOADON
go
insert tbKHACHHANG(HOTEN,NGAYSINH,GIOITINH,EMAIL,DIACHI,TAIKHOAN,MATKHAU)
values
(N'Admin','2003-03-25','Nam','ngcha763@gmail.com',N'158 Trần Cao Vân , Thanh Khê , Đà Nẵng','admin','matkhau123')

delete from tbSANPHAM where MASANPHAM = 'SP00030' or MASANPHAM = 'SP00031'
select * from tbSANPHAM where MADANHMUC = 'DM0003' or MADANHMUC = 'DM0002'*/