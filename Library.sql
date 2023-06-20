Create database Library_1
use Library_1

create table Type(
    IdType nvarchar(10) primary key not null,
	Name nvarchar(15) not null
   )
create table Language(
    IdLanguage nvarchar(10) primary key not null,
	Name nvarchar(15) not null
   )
create table NXB(
    IDNXB nvarchar(20) primary key not null,
	Name nvarchar(15) not null
   )
create table Employees(
       idEmployees nvarchar(10) primary key not null,
	   Name nvarchar(30) not null,
	   Account nvarchar(30) not null,
	   Password nvarchar(30) not null,
)
create table Reader(
       IdReader  nvarchar(20) primary key not null,
	   Name nvarchar(20) not null,
	   Address nvarchar(30) not null,
	   CCCD nvarchar(30) not null,
	   Phone nvarchar(30) not null,
	   isdelete nvarchar(10),
)

Create table Book (
      BookId nvarchar(20) Primary key not null,
	  Name nvarchar(25) not null,
	  IdType nvarchar(10) foreign key references Type(IdType) not null,
	  IdLanguage nvarchar(10) foreign key references Language(IdLanguage) not null,
	  Quantity int not null,
	  ImportDate date not null,
	  MaNV nvarchar(10) foreign key references Employees(idEmployees) not null,
	  IDNXB  nvarchar(20) foreign key references NXB(IDNXB),
	  isDelete nvarchar(5),
	  soluongmuon int,


)
create table PhieuMuon(
       IdPhieu  nvarchar(10) primary key not null,
	   IdReader nvarchar(20) foreign key references Reader(IdReader) not null,
	   QuantityBorrow  int  not null,
	   isdelete  nvarchar(10),
	   ngayPhat Date,
	  
)
create table ChiTiet(
       IdPhieu  nvarchar(10) foreign key references PhieuMuon(IdPhieu) not null,
	   BookId nvarchar(20) foreign key references Book(BookId) not null,
	   BorrowDate  Date  not null,
	   BackDate  Date,
	   isdelete nvarchar(5),
	  
)
