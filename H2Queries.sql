CREATE TABLE CATEGORY(
catid varchar(20),
catname varchar(255) not null,
catdescription varchar(max) not null,
catimg varchar,
constraint pk_category_catId primary key (catId)
);

CREATE TABLE SUPPLIER(
supid varchar(20),
supname varchar(255) not null,
supaddress varchar(255) not null,
supcontact varchar(20) not null,
supemail varchar(255) not null,
constraint pk_supplier_supId primary key(supid)
);
ALTER TABLE Supplier
ADD supimg varchar(225);


CREATE TABLE PRODUCT(
p_id varchar(20),
catid varchar(20),
supid varchar(20),
p_name varchar(255) not null,
p_desc varchar(255) not null,
p_img varchar,
p_quantity int(20),
p_price decimal(7,2) not null,
p_author varchar(100),
out_of_stock boolean,
constraint pk_product_p_Id primary key(p_Id),
constraint fk_product_catId foreign key(catId) references category(catId) on delete set null,
constraint fk_product_supId foreign key(supId) references supplier(supId) on delete set null
);
Alter Table Product 
Drop Column p_img;
Alter Table Product
Add Column productimg varchar(225);

SELECT * FROM PRODUCT ;

create table customer(
customer_id varchar,
customer_first_name varchar,
customer_last_name varchar,
contactno varchar ,
gender varchar ,
email varchar,
password varchar ,
username varchar ,
enabled boolean,
constraint pk_customer_customerId primary key(customer_id),
);
ALTER TABLE Customer
ADD Column Customer_First_Name varchar;
SELECT * FROM CUSTOMER;
ALTER TABLE Customer
ADD Column Customer_Last_Name varchar;
SELECT * FROM CUSTOMER;

create table cart(
cartid varchar(30),
customer_id varchar(30),
no_of_products int(20),
total_price decimal(8),
constraint pk_cart_cartId primary key(cartid),
constraint fk_cart_customer_id foreign key(customer_id) references CUSTOMER(customer_id) on delete cascade
);
select * from cart;

create table cartDetail(
cartdetailid varchar(20),
p_id varchar(20),
customer_id varchar(20),
cartid varchar(20),
quantity decimal(10),
price_total decimal(15,2),
constraint pk_cartDetail_cartDetailid primary key (cartDetailid),
constraint fk_cartDetail_p_Id foreign key (p_id) references product(p_id),
constraint fk_cartDetail_userId foreign key(customer_id) references customer(customer_id),
constraint fk_cartDetail_cartId foreign key(cartid) references cart(cartid)
);

create table BillingAddress(
    billingadd_id varchar,
    street varchar,
    apartment varchar,
    city varchar,
    state varchar,
    country varchar,
    zip varchar,
    constraint pk_BillingAddress_billingAddress_id primary key (billingadd_id),
);

create table ShippingAddress(
    shippingadd_id varchar,
    street varchar,
    apartment varchar,
    city varchar,
    state varchar,
    country varchar,
    zip varchar,
    constraint pk_ShippingAddress_shippingAddress_id primary key (shippingadd_id),
);

create table user(
userid varchar not null,
username varchar not null,
password varchar not null,
enabled boolean not null,
constraint pk_user_userid primary key(userid)
);

create table userauthority(
userauth_id varchar not null,
username varchar not null,
auth_role varchar not null,
constraint fk_userauthority_username foreign key (username) references user(username),
constraint pk_userauthority_userauthid primary key(userauth_id)
);

create table user_role
(
user_id varchar(15),
role_id int default 30,
primary key(user_id, role_id)
);

insert into category (catId,catName,catDescription,catImg) values ('C001','Cookbooks', 'Food and Wine','no-image.jpg');
insert into category (catId,catName,catDescription,catImg) values ('C002','Primary Textbooks', 'Primary School Textbooks','no-image.jpg');
insert into category (catId,catName,catDescription,catImg) values ('C003','Secondary Textbooks', 'Secondary School Textbooks','no-image.jpg');
insert into category (catId,catName,catDescription,catImg) values ('C004', 'Biographies','Biographies and Autobiogrpahies - all authors','no-image.jpg');


insert into supplier (supId,supName,supAddress,supContact, supEmail) values ('S001','Infinite Books', '11 Forest Walk, #03-02, Powai, Mumbai','98898989','infinite@gmail.com')
insert into supplier (supId,supName,supAddress,supContact, supEmail) values ('S002','Borders Book Supplier', '3 KK Marg, Jacob Circle, Mahalakshmi, Mumbai', '91198989', 'contact@borders.com');

insert into product (p_id,catid,supid,p_name, p_desc,p_img,p_quantity,p_price,p_author) values ('P001','C004','S001','The Diary of a Young Girl','Writings from Anne Frank when she was in hiding during the Nazi Invasion','anne-frank.jpg',20, 35.99,'Anne Frank');
insert into product (p_id,catid,supid,p_name, p_desc,p_img,p_quantity,p_price,p_author) values ('P002','C003','S002','High School English Grammar and Composition','Reference book for English grammar','English-book.jpg',50, 25.00,'P.C.Wren')

insert into user (userid,usercontact,first_name, last_name, gender,password,useremail) values ('U001','9619637445','Dan','Brown','female','niit','happy@yahoo.com','address');
insert into user (userid,usercontact,first_name, last_name, gender,password,useremail) values ('U002','9920677878','Ash','Rao','male','password123','bodh@yahoo.com','address');



create table user(
userid varchar(30),
usercontact varchar(30) not null,
first_name varchar(50) not null,
last_name varchar(50) not null,
gender varchar(10) not null,
password varchar(200) not null,
useremail varchar(255) not null,
address varchar(max),
constraint pk_user_userID primary key(userID)
);
select * from user;

create table role
(
role_id int primary key,
name varchar(15) unique, not null
);

