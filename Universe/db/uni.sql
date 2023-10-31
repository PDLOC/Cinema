﻿create database universe_data
use universe_data
------------------------------------Tài khoản----------------------------------------------
create table Taikhoan(
	Matk varchar(255) primary key,
	Hoten nvarchar(125),
	Email varchar(225),
	Sdt varchar(10),
	Ngaysinh date,
	Matkhau varchar(125),
	Diachi nvarchar(max) null,
	Hinh nvarchar(255) null,
	Mavaitro varchar(10)
);


------------------------------------Vai trò----------------------------------------------
create table Vaitro(
	Mavaitro varchar(10) primary key,
	Tenvaitro nvarchar(255)
);


------------------------------------Phòng Chiếu----------------------------------------------
create table Phong(
	Mapc int identity(1,1) primary key,
	Tenpc nvarchar(225)
);

------------------------------------Phim----------------------------------------------
create table Phim(
	Maphim varchar(10) primary key,
	Matrangthai int,
	Tenphim nvarchar(255),
	Thoiluong varchar(125),
	Namsx int,
	Hinh nvarchar(225)
);

------------------------------------Chi tiết phim----------------------------------------------
create table Chitietphim(
	Mact varchar(10) primary key,
	Maphim varchar(10),
	Loaiphim nvarchar(255),
	Mapc int,
	Tenphim nvarchar(255),
	Khoichieu date,
	Daodien nvarchar(255),
	Dienvien nvarchar(255),
	Noidung nvarchar(max),
	Linkytb varchar(max),
	Hinh nvarchar(225),
);


------------------------------------Lịch chiếu----------------------------------------------
create table Lich(
	STT int identity(1,1) primary key,
	Mact varchar(10),
	Ngaychieu date,
	Giobatdau time,
	Gioketthuc time
);


------------------------------------Vé----------------------------------------------
create table Trangthaiphim(
	Stt int identity(1,1) primary key,
	Trangthai nvarchar(255)
);


------------------------------------Loại vé----------------------------------------------
create table LoaiGhe(
	Maloai int identity(1,1) primary key,
	Loaive nvarchar(125),
	Dongia int 
);

------------------------------------Khuyến mãi----------------------------------------------
create table KhuyenMai (
    Makm varchar(10) primary key,
	Tenkm nvarchar(225),
    Mota nvarchar(255),
    Giamgia float,
    NgayBatDau date,
	NgayKetThuc date
);

------------------------------------Đồ Ăn----------------------------------------------
create table Doan (
	Mada int identity(1,1) primary key,
	Tenda nvarchar(125),
	Soluong int,
	Dongia float,
	Hinh nvarchar(225)
);

------------------------------------Combo----------------------------------------------
create table ComBo(
	STT int identity(1,1) primary key,
	Macb varchar(10),
	Mada int,
	Tencb nvarchar(125),
	Mota nvarchar(225),
	Soluong int,
	Dongia float
);



------------------------------------Vé----------------------------------------------
create table Ve(
	MaVe int identity(1,1) primary key,
	Maloaive int,
	Manv int,
	Makh int,
	Maphim int, 
	STTcombo int,
	Makm varchar(10),
	Ghe varchar(10),
	Tongtien float
);


-----------------------------------------------------------------------------------

insert into Vaitro values
('CUST',N'Khách hàng'),
('STAFF',N'Nhân viên'),
('ADMIN',N'Admin');

insert into Taikhoan values
('phamloc',N'Phạm Đại Lộc','phamloc402@gmail.com','0799815474','09/21/1999','123456',N'53 Trần Quang Khải Q.1',N'user.png','ADMIN'),
('huyvu',N'Nguyễn Huy Vũ','alexred20151@gmail.com','0485698214','09/22/2003','123456',N'50 Lê Lợi Q.1',N'user.png','ADMIN'),
('duyanh',N'Nguyễn Lâm Duy Anh','duyanh@gmail.com','0459874521','09/23/2003','123456',N'50 Lê Lợi Q.1',N'user.png','STAFF'),
('hoangviet',N'Phạm Trần Hoàng Việt','hoangviet@gmail.com','0463215487','09/24/2003','123456',N'50 Nguyễn Kiệm Quận Phú Nhuận',N'user.png','STAFF'),
('theky',N'Mai Thế Kỷ','theky@gmail.com','0415896475','09/25/2000','123456',N'59 Hoàng Sa Q.1',N'user.png','STAFF'),
('huyhoai',N'Đào Trần Huy Hoài','huyhoai@gmail.com','0415689654','09/26/2003','123456',N'50 Lê Lợi Q.1',N'user.png','STAFF'),
('long',N'Long Hoàng','longhoang@gmail.com','0987612345','09/23/2001','123456',N'Nguyễn Xiêu, P.Bến Nghé, Q.1',N'user.png','STAFF'),
('hoangvu',N'Hoàng Vũ','hoangvu@gmail.com','0987612345','01/20/1997','123456',N'Ngô Tât Tố, P.22, Q.Bình Thạnh',N'user.png','STAFF'),
('ducminh',N'Đức Minh','ducminh@gmail.com','0987612455','10/25/1991','123456',N'Phú Mỹ, P.22, Q.Bình Thạnh',N'user.png','STAFF'),
('minhman',N'Minh Mẫn','minhman@gmail.com','0987614444','09/23/1992','123456',N'Hai Bà Trưng, P.Bến Nghé, Q.1',N'user.png','STAFF'),
('hoanganh',N'Phạm Trần Hoàng Anh','hoanganh@gmail.com','0987619999','09/23/1993','123456',N'Lê Văn Sỹ, P.4, Q.3',N'user.png','STAFF'),
('pteo123',N'Phạm Quang Tèo','pqteo402@gmail.com','0799815474','06/21/1987','123456','',N'user.png','CUST'),
('ngloi231',N'Nguyễn Văn Lợi','ngloi@gmail.com','0485698214','01/22/1999','123456','',N'user.png','CUST'),
('ngta213',N'Nguyễn Hồ Thị Tả','nhtta@gmail.com','0459874521','05/23/1980','123456','',N'user.png','CUST'),
('luyen132',N'Lòi Văn Luyện','loiluyen@gmail.com','0463215487','02/24/1983','123456','',N'user.png','CUST'),
('phoa321',N'Phạm Thị Thu Hòa','phoa@gmail.com','0415896475','03/25/1989','123456','',N'user.png','CUST'),
('dkhuong312',N'Dương Văn Khương','dkhuong@gmail.com','0415689654','07/26/2000','123456','',N'user.png','CUST'),
('lnguyen423',N'Long Nguyễn','longn@gmail.com','0987654321','08/25/1956','123456','',N'user.png','CUST'),
('ple432',N'Phụng Lê','phung@gmail.com','0987655555','08/11/1987','123456','',N'user.png','CUST'),
('hnguyen324',N'Hoàng Nguyễn','hoangn@gmail.com','0987658888','08/21/1991','123456','',N'user.png','CUST'),
('dhao412',N'Đường Hạo','haodduong@gmail.com','0987655666','08/17/1980','123456','',N'user.png','CUST'),
('thao413',N'Thạch Hạo','haothach@gmail.com','0987655111','08/19/1989','123456','',N'user.png','CUST')

insert into Phong values
('Cine 1'),
('Cine 2'),
('Cine 3'),
('Cine 4'),
('Cine 5'),
('Cine 6')

insert into Phim values
('P01',1,N'Cậu Bé Bút Chì: Đại Chiến Siêu Năng Lực','94','2023','shin.png'),
('P02',1,N'Huyền thoại Người Dơi','140','2005','batman.png'),
('P03',1,N'Kẻ Ẩn Danh','93','2023','keandanh.png'),
('P04',1,N'Thiện ác đối đầu 3','109','2023','thienacdoidau.png'),
('P05',1,N'Oppenheimer','180','2023','oppenheimer.png'),
('P06',1,N'Địa đàng sụp đổ','129','2023','diadangsupdo.png'),
('P07',1,N'Kẻ Kiến Tạo','133','2023','kekientao.png'),
('P08',1,N'Ánh dương sau hoàng hôn','105','2023','anhduong.png'),
('P09',1,N'Bộ Đôi Báo Thủ','132','2023','bao.png'),
('P010',1,N'Thám tử lừng danh Conan: Tàu ngầm sắt màu đen','110','2023','conan.png'),
('P011',2,N'Ác quỷ ma sơ 2','110','2023','nun.png'),
('P012',2,N'Họa Quỷ','107','2023','oni.png'),
('P013',2,N'Biệt đội đánh thuê 4','103','2023','fight.png'),
('P014',2,N'Án mạng ở Venice','103','2023','mys.png'),
('P015',2,N'Live: Phát Trực Tiếp','91','2023','live.png'),
('P016',2,N'Thành phố ngủ gật','73','2023','sleep.png'),
('P017',2,N'Hổ Cánh Cụt Và Biệt Đội Rừng Xanh 2: Quậy Banh Thế Giới','90','2023','tiger.png'),
('P018',2,N'Đơn Hàng Từ Sát Nhân','101','2023','item.png'),
('P019',2,N'Nhân Duyên Tiền Đình','119','2023','kore.png')



insert into Lich values
('CT01','08/25/2023','07:00','09:00'),
('CT01','08/25/2023','10:00','12:00'),
('CT01','08/26/2023','13:00','15:00'),
('CT02','10/18/2023','10:00','12:00'),
('CT02','10/19/2023','19:00','21:00'),
('CT03','09/25/2023','17:00','19:00'),
('CT03','09/28/2023','21:00','23:00'),
('CT04','08/26/2023','07:00','09:00'),
('CT04','08/27/2023','23:00','02:00'),
('CT05','08/26/2023','07:00','09:00'),
('CT05','08/29/2023','15:00','17:00');


insert into Chitietphim(Mact,Maphim,Loaiphim,Mapc,Tenphim,Khoichieu,Daodien,Dienvien,Noidung,Linkytb,Hinh) values
('CT01','P01',N'Hoạt hình',1,N'Cậu Bé Bút Chì: Đại Chiến Siêu Năng Lực','08/25/2023',N'Hitoshi Ohne',N'Yumiko Kobayashi, Miki Narahashi, Aoi Morikawa, Satomi Kourogi, Suzuki Mogura',N'3DCG! Shin - Cậu Bé Bút Chì: Đại Chiến Siêu Năng Lực ~ Sushi Bay ~. Xoay quanh câu chuyện về hai nguồn sáng 
đặc biệt từ vũ trụ mang theo siêu năng lực đặc biệt tới Trái Đất. Một nguồn sáng tích cực “nhập” vào nhóc Shin, khiến cặp mông núng nính của cậu trở nên nóng bỏng và có khả năng điều khiển những đồ vật xung quanh theo ý muốn. Một thanh niên trẻ khác tên Mitsuru Hiriya cũng nhận được siêu năng 
lực này. Đồng thời, một nhà khoa học xấu xa khác nhăm nhe ý định lợi dụng siêu năng lực của Hiriya để trở thành bá chủ.','https://www.youtube.com/watch?v=O9KQxT8HR_8','shin.png'),

('CT02','P02',N'Hành động',2,N'Kị sĩ bóng đêm','10/18/2023 ',N'Christopher Nolan',N'Christian Bale, Michael Caine, Heath Ledger, Aaron Eckhart',N'Kị Sĩ Bóng Đêm mở đầu bằng cuộc oanh tạc của Joker tại ngân hàng thành phố Gotham. Hắn gài bẫy nhóm cướp và rời đi một mình cùng số tiền khổng lồ. Trong khi đó, Batman, công tố viên Harvey Dent cùng ủy viên James Gordon 
liên minh và đưa ra sắc lệnh chống tội phạm trong thành phố. Tuy nhiên, Joker với tính cách điên loạn vẫn không dừng lại, hắn bắt đầu thâu tóm các 
băng đảng tội phạm và gây ra các cuộc thanh trừng người vô tội để vạch trần danh tính Batman, từng bước đẩy người hùng bóng đêm và các cộng sự vào 
những cái bẫy vô cùng tinh vi.','https://www.youtube.com/watch?v=AW_fVi_YGhE','batman.png'),

('CT03','P03',N'Gia đình, Hài, Hành động',3,N'Kẻ Ẩn Danh','08/25/2023',N'Trần Trọng Dần',N'Kiều Minh Tuấn,Mạc Văn Khoa,Quốc Trường,Vân Trang, Mai Cát Vi...',N'Chuyện kể về Lâm - người 
đàn ông chân chất có quá khứ bí mật, luôn đặt vợ con và hạnh phúc gia đình lên hàng đầu. Thế nhưng, cuộc sống yên bình của gia đình anh bỗng 
chốc bị đảo lộn. Lúc này, Lâm phải bảo vệ những điều mà anh yêu thương bằng mọi giá.','https://www.youtube.com/watch?v=9yVmRrrxoOc','keandanh.png'),

('CT04','P04',N'Hành động',4,N'Thiện ác đối đầu 3','09/26/2023',N'Antoine Fuqua',N'Denzel Washington,Dakota Fanning,David Denman,Sonia Ammar, Remo Girone...',N'Thiện Ác Đối Đầu 3 – The Equalizer 3 (2023) nói 
về Robert McCall chuyển đến sinh sống tại miền Nam nước Ý nhưng phát hiện ra bạn bè của mình bị một tổ chức mafia ở địa phương kiểm soát. Khi tính mạng 
của họ bị đe dọa, ông buộc phải quay trở lại con đường sát thủ để bảo vệ bạn bè.','https://www.youtube.com/watch?v=VEgaQviZZPM','thienacdoidau.png'),

('CT05','P05',N'Hồi hộp, Lịch sử, Tâm lý',5,N'Oppenheimer','08/26/2023',N'Christopher Nolan',N'Cillian Murphy,Florence Pugh,Robert Downey Jr.,...',N'Với nhân vật trung tâm là J. Robert Oppenheimer, nhà vật 
lý lý thuyết người đứng đầu phòng thí nghiệm Los Alamos, thời kỳ Thế chiến II. Ông đóng vai trò quan trọng trong Dự án Manhattan, tiên phong trong 
nhiệm vụ phát triển vũ khí hạt nhân, và được coi là một trong những “cha đẻ của bom nguyên tử”','https://www.youtube.com/watch?v=TBZrZpGKzI4','oppenheimer.png'),

('CT06','P06',N'Hành động, hồi hộp',6,N'Địa đàng sụp đổ','08/26/2023 ',N' Um Tae-hwa',N'Park Bo-young,Park Seo-joon,Park Ji-hoo,Lee Byung-hun,...',N'Địa Đàng Sụp Đổ - Concrete Utopia (2023) Thế giới đã trở thành đống đổ nát sau một trận động đất lớn. Trong khi không ai biết chắc chắn tàn tích trải dài bao xa, hay nguyên nhân gây 
ra trận động đất là gì, thì ở trung tâm Seoul chỉ còn lại một tòa nhà chung cư. Nó được gọi là Căn hộ Hwang Gung.','https://www.youtube.com/watch?v=-b1sTXyGyq0','diadangsupdo.png'),

('CT07','P07',N'Hành động, Phiêu lưu',1,N'Kẻ Kiến Tạo','09/29/2023 ',N'Gareth Edwards',N'John David Washington, Gemma Chan, Ken Watanabe',N'Trong tương lai, thế giới xảy ra một cuộc chiến tranh kéo dài giữa loài người 
và trí tuệ nhân tạo (AI). Joshua (John David Washington) - 1 cựu đặc vụ lì lợm, được thuê để giết “The Creator” - kẻ được xem là đầu não của AI và đã tạo ra 1 loại vũ khí bí 
ẩn đủ mạnh để kết thúc cuộc chiến và quét sạch nhân loại. Joshua lần theo mọi dấu vết và biết được rằng thứ vũ khí hủy diệt bí ẩn đó lại chỉ là một AI trong hình hài một đứa bé.','https://www.youtube.com/watch?v=XMvMTmDYtyE','kekientao.png'),

('CT08','P08',N'Tình cảm, Kinh dị',2,N'Ánh dương sau hoàng hôn','09/22/2023',N'Bhandit Thongdee',N'Chawarin Perdpiriyawong, Pruk Panich, Anyarin Terathananpat',N'Nhân duyên trời định giữa 2 
con người xa lạ được khởi nguồn từ lời nguyền gia tộc buộc Quý nam Phra Ploeng (Zee Pruk Panich) phải ghép tử vi kịp thời với tri kỷ của mình là Saeng Rawee (NuNew Chawarin Perdpiriyawong) nếu 
không muốn kiếp nạn đại hung sẽ ứng nghiệm vào năm 25 tuổi. Sinh ra đã được định sẵn là mảnh ghép hoàn hảo của đối phương nhưng Phra Ploeng và Rawee lại có màn chào hỏi “kẻ ngang - người dọc” khiến đôi tri kỷ trước lạ sau thương này 
phải trải qua nhiều thử thách cũng như sự cản trở bởi thế lực tâm linh để hoá giải lời nguyền.','https://www.youtube.com/watch?v=UaF85KlH0Pc','anhduong.png'),

('CT09','P09',N'Hành động',3,N'Bộ Đôi Báo Thủ','09/01/2023',N'Kim Seong-hun',N'Ha Jung-woo, Joo Ji-hoon, Anas El Baz',N'Lấy cảm hứng từ một sự kiện có thật - lần đầu tiên một nhà 
ngoại giao bị bắt cóc trong lịch sử Hàn Quốc, bộ phim hành động Ransomed (tựa Việt: Bộ Đôi Báo Thủ) xoay quanh hành trình giải cứu người đồng nghiệp 
đang mất tích của nhà ngoại giao Min-jun (Ha Jung-woo thủ vai) và tài xế taxi Pan-su (Ju Ji-hoon thủ vai) ở Beirut, Lebanon vào năm 1986.','https://www.youtube.com/watch?v=04PzA6hMTj4','bao.png'),

('CT010','P010',N'Hoạt hình, Tâm lý',4,N'Thám tử lừng danh Conan: Tàu ngầm sắt màu đen','07/21/2023',N'Yuzuru Tachikawa',N'Ayumu Murase, Hayashibara Megumi, Takayama Minami',N'Conan Movie 26: Tàu Ngầm Sắt Màu Đen – Detective Conan Movie 26 (2023) 
địa điểm lần này được đặt ở vùng biển gần đảo Hachijo-jima, Tokyo. Các kỹ sư từ khắp nơi trên thế giới đã tập hợp để vận hành toàn diện “Phao Thái Bình Dương”, một 
cơ sở ngoài khơi để kết nối các camera an ninh thuộc sở hữu của lực lượng cảnh sát trên toàn thế giới. Một thử nghiệm về một “công nghệ mới” nhất định 
dựa trên hệ thống nhận dạng khuôn mặt đang được tiến hành ở đó. Trong khi đó, Conan và Đội thám tử nhí đến thăm Hachijo-jima theo lời mời của Sonoko và 
nhận được một cuộc điện thoại từ Subaru Okiya thông báo rằng một nhân viên Europol đã bị sát hại ở Đức bởi Jin của Tổ chức Áo đen.','https://www.youtube.com/watch?v=0bJXtdfb7hg','conan.png'),

('CT011','P011',N'Kinh dị',5,N'Ác quỷ ma sơ 2','09/26/2023',N'Michael Chaves','Taissa Farmiga, Jonas Bloquet, Storm Reid, Anna Popplewell, Bonnie Aarons,…',N'Là phần phim tiếp nối câu chuyện năm 2019 của 
The Nun, phim lấy bối cảnh nước Pháp năm 1956, cùng cái chết bí ẩn của một linh mục, một giai thoại đáng sợ và ám ảnh sẽ mở ra tiếp tục xoay quanh nhân vật 
chính - Sơ Irene. Liệu Sơ Irene có nhận ra, đây chính là hồn ma nữ tu Valak từng có cuộc chiến “sống còn” với cô không lâu trước đây.','https://www.youtube.com/watch?v=g_S_KbYl1sA','nun.png'),

('CT012','P012',N'Kinh dị',6,N'Họa Quỷ','09/17/2023 ',N'Shimizu Takashi',N'Daigo Nishihata, Inori Kirara, Mizuki Yamamoto',N'Nhà khoa học thiên tài Tomohiko Kataoka được trưởng nhóm nghiên cứu 
Synthekai VR yêu cầu tham gia cùng họ trên Đảo Abominable. Ở đó, họ đã tạo ra một không gian ảo cho toàn bộ hòn đảo và họ muốn Tomohiko sử dụng các kỹ thuật 
tiên tiến của mình để nâng cấp dự án. Tuy nhiên, khi Tomohiko đeo kính VR và bước vào thế giới ảo, trời đột nhiên trở nên tối 
tăm và một người phụ nữ bí ẩn xuất hiện. Những cái chết bí ẩn xảy ra với nhân viên công ty công nghệ VR. Có một nỗi sợ hãi chưa từng có đang chờ đợi giữa thực tế và thế giới ảo.','https://www.youtube.com/watch?v=WUuMNNqzEO0','oni.png'),

('CT013','P013',N'Hành động',1,N'Biệt đội đánh thuê 4','09/20/2023 ',N'Scott Waugh',N'Sylvester Stallone, Jason Statham, Dolph Lundgren',N'Biệt Đội Đánh Thuê - gồm cả các gương mặt kỳ cựu và những 
tân binh - đã bắt đầu một nhiệm vụ mới. Lần này, họ sẽ tới một nhà máy vũ khí hạt nhân cũ tại Qadhafi để tóm gọn Suharato Rahmat, kẻ đang âm mưu một 
mình đánh cắp kíp nổ hạt nhân cho gã khách hàng xảo quyệt Ocelot. Rahmat từng là một tay buôn vũ khí người Anh với đội quân của riêng mình. Hắn đã 
thành công đánh cắp va li chứa kíp nổ trước khi Biệt Đội Đánh Thuê kịp tìm đến. Nếu kíp nổ rơi vào tay Ocelot, gã sẽ hủy diệt cả thế giới. Sau khi 
nhiệm vụ tóm gọn Rahmat thất bại, cả đội tiếp tục hành trình trên con thuyền Jantara, nơi bước ngoặt thực sự của câu chuyện xảy ra, và một sự thật 
gây sốc về Ocelot được hé lộ…','https://www.youtube.com/watch?v=TsoMyppHSjM','fight.png'),

('CT014','P014',N'Kinh dị, Tâm lý, Tội phạm',2,N'Án mạng ở Venice','09/10/2023 ',N'Kenneth Branagh',N'Kenneth Branagh,Kelly Reilly,Dương Tử Quỳnh',N'Án Mạng Ở 
Venice – A Haunting in Venice (2023) lấy bối cảnh năm 1947 tại Venice, khi này thám tử tài ba Hercule Poirot đã lui về ở ẩn và rời xa các vụ án dù liên tục 
nhận được nhiều lời mời gọi. Tuy nhiên, những án mạng vẫn chẳng thể rời xa ông khi nhà văn và đồng thời là người bạn cũ lâu năm, Ariadne Oliver, bằng cách 
nào đó đã vượt qua người gác cổng Vitale Portfoglio để gửi đến Poirot một lời đề nghị đặc biệt.','https://www.youtube.com/watch?v=N36PS9Un5U4','mys.png'),

('CT015','P015',N'Kinh dị, Tâm lý',3,N'Live: Phát Trực Tiếp','09/26/2023',N'Khương Ngọc',N'Ngọc Phước, Quốc Khánh, Ngân 98',N'Bộ phim Việt đầu tiên trực diện 
nói về vấn đề bạo lực mạng xã hội. Câu chuyện xoay quanh hai người trẻ đầy tham vọng, bất chấp tất cả để có thể trở nên nổi tiếng trên mạng. Họ dùng đủ cách 
thức lẫn chiêu trò để đạt được mục đích của mình, cho đến khi chính bản thân họ lại thành con mồi mới cho những kẻ trên mạng, những người sẵn sàng lao vào 
tấn công người khác chỉ vì “Không ưa con đó.”','https://www.youtube.com/watch?v=REgmCauEHDM','live.png'),

('CT016','P016',N'Hồi hộp, Tội phạm',4,N'Thành phố ngủ gật','10/13/2023',N'Lương Đình Dũng',N'Quốc Toàn, Minh Hiền, Đức Trí, Tạ Xuân Tuế, Ba Trường,...',N'Nhân vật chính là một chàng thanh 
niên 26 tuổi, sống đơn độc giữa trung tâm thành phố nhộn nhịp, mưu sinh bằng nghề mổ gà. Một ngày, sự xuất hiện 
của nhóm giang hồ và một cô gái điếm đã tác động đến cuộc sống của anh. Điều đó đã làm cho bản năng hoang dã 
của chàng thanh niên trỗi dậy không kiểm soát.','https://www.youtube.com/watch?v=KF5f7AM9UAw','sleep.png'),

('CT017','P017',N'Hoạt hình',5,N'Hổ Cánh Cụt Và Biệt Đội Rừng Xanh 2: Quậy Banh Thế Giới','09/01/2023',N' Yannick Moulin, Benoît Somville, Laurent Bru',N'Jérémie Covillault, Léopoldine Serre, Céline Monsarrat',N'Trong phần 
phim mới nhất này, đội trưởng hổ cánh cụt Maurice và Biệt Đội Rừng Xanh sẽ phải đối đầu với tên hải ly Henri ranh ma - kẻ đang âm mưu bao phủ khu rừng bằng 
một thứ hóa chất có thể phát nổ ngay khi chạm vào nước. Để giải cứu khu rừng, Biệt Đội Rừng Xanh buộc phải chạy đua với thời gian trong cuộc phiêu lưu vòng 
quanh thế giới để tìm ra thuốc giải trước khi mùa mưa đến.','https://www.youtube.com/watch?v=3ot7Do4hKKI','tiger.png'),

('CT018','P018',N'Hình sự',6,N'Đơn Hàng Từ Sát Nhân','09/15/2023',N'Park Hee-kon',N'Shin Hye-sun, Kang Tae-oh, Keum Sae-rok',N'Như bao cô gái chốn công sở, Soo-hyun dù luôn quay cuồng với deadline nhưng vẫn 
không quên đam mê shopping online của mình. Sau khi mua nhầm một đơn hàng "chất lượng kém, xứng đáng 1 sao", Soo-hyun không ngờ rằng đánh giá chân thật của 
mình đã làm một tên sát nhân máu lạnh nổi điên!','https://www.youtube.com/watch?v=NnCgxS3jhZE','item.png'),

('CT019','P019',N'Lãng mạn, Hài',1,N'Nhân Duyên Tiền Đình','09/25/2023',N'Lee Han',N'Yu Hae-jin, Kim Hee-sun, Jung Woo Sung, Jung Da-eun,Han Sun-hwa',N'Chuyện phim xoay quanh nhân vật Chi-ho (Yoo Hae-jin) - nhà nghiên cứu bim bim với 
khả năng nếm vị xuất chúng, nhưng lại ngờ nghệch với mọi thứ xung quanh. Chi-ho là một người cực kỳ hướng nội, thích ở một mình và sống như một cái máy được 
lập trình sẵn mà không hề mắc lỗi dù chỉ một giây. Trong lúc phải đi trả nợ thay cho người anh trai cờ bạc (Cha In-pyo), Chi-ho đã gặp gỡ “nhân viên đòi nợ” Il-young - người phụ nữ 
hướng ngoại, luôn suy nghĩ tích cực về cuộc sống dù đang ở trong hoàn cảnh khó khăn của một bà mẹ đơn thân. Khác biệt về tính cách lẫn ngoại hình 
khiến cả hai trở thành “trái dấu hút nhau”. Sự “trái dấu” này đã đẩy đưa cuộc tình của họ đến vô vàn tình huống “cười ra nước mắt” nhưng cũng không kém phần cảm xúc.','https://www.youtube.com/watch?v=zlPzyxdhQbI','kore.png');


insert into LoaiGhe values
(N'Thường',100000),
(N'VIP',110000),
(N'Couple',250000)

insert into KhuyenMai values
('KM001', N'Khuyến mãi mùa hè', N'Giảm giá cho sản phẩm mùa hè', 0.2, '01/06/2023', '12/10/2023'),
('KM002', N'Khuyến mãi cuối năm', N'Giảm giá cuối năm', 0.15, '01/20/2023', '12/31/2023'),
('KM003', N'Khuyến mãi đón Tết', N'Giảm giá mừng Tết Nguyên Đán', 0.1, '01/01/2024', '03/31/2024');

insert into Doan values
(N'Bắp vị phô mai',50,35000,N'1.JPG'),
(N'Bắp truyền thống',50,30000,N'2.JPG'),
(N'Bắp vị caramel',50,35000,N'3.PNG '),
(N'Coca',100,25000,N'5.JPG'),
(N'Pepsi',100,25000,N'4.JPG')

insert into ComBo values
('CB01',1,N'Ấm áp',N'2 bắp và 1 Pepsi',50,90000),
('CB01',3,N'Ấm áp',N'2 bắp và 1 Pepsi',50,90000),
('CB01',4,N'Ấm áp',N'2 bắp và 1 Pepsi',50,90000),
('CB02',2,N'Cô đơn 1',N'1 bắp và 1 Coca',50,50000),
('CB02',3,N'Cô đơn 1',N'1 bắp và 1 Coca',50,50000),
('CB03',2,N'Cô đơn 2',N'1 bắp và 1 Pepsi',50,50000),
('CB03',4,N'Cô đơn 2',N'1 bắp và 1 Pepsi',50,50000)

insert into Trangthaiphim values
(N'Đang chiếu'),
(N'Sắp chiếu'),
(N'Hết chiếu')


------------------------------------Khóa-----------------------------------
--Tài khoản--
alter table Taikhoan add constraint df_Taikhoan_Hinh default (N'user.png') for Hinh
alter table Taikhoan add constraint fk_tk_vt foreign key(Mavaitro) references Vaitro(Mavaitro)


--Chi tiết phim--
alter table Chitietphim add constraint fk_ctphim_p foreign key(Maphim) references Phim(Maphim)


--Phim--
alter table Phim add constraint fk_p_trangt foreign key(Matrangthai) references Trangthaiphim(Stt)


--Lịch--
alter table Lich add constraint fk_l_ctp foreign key(Mact) references Chitietphim(Mact)


--Combo--
alter table ComBo add constraint fk_cb_da foreign key(Mada) references DoAn(Mada)


--Vé--
alter table Ve add constraint fk_ve_lv foreign key(Maloaive) references LoaiVe(Maloaive)
alter table Ve add constraint fk_ve_nv foreign key(Manv) references NhanVien(Manv)
alter table Ve add constraint fk_ve_kh foreign key(Makh) references KhachHang(Makh)
alter table Ve add constraint fk_ve_phim foreign key(Maphim) references Phim(Maphim)
alter table Ve add constraint fk_ve_km foreign key(Makm) references KhuyenMai(Makm)
alter table Ve add constraint fk_ve_cb foreign key(STTcombo) references Combo(STT)