drop table product;
drop table userInfo;

CREATE TABLE product
(
	productNumber int,
	productName varchar2(50),
	productComment varchar2(500),
	productPrice int,
	productVendorName varchar2(50)
);

CREATE TABLE userInfo
(
	userNumber int,
	userId varchar2(50),
	userPassword varchar2(50),
	userName varchar2(50)
);
