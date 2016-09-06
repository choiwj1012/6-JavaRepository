CREATE TABLE product
(
	productNumber int,
	productName varchar2(50),
	productComment varchar2(500),
	productPrice int,
	productVendorName varchar2(50)
);

select * from product;

select max(productNumber) + 1 from product;