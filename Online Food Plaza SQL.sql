create database fooddb;
use fooddb;

create table Food(foodId int auto_increment primary key,foodName varchar(25),foodType varchar(25),foodCategory varchar(25),foodDesc varchar(25),foodPrice double(10,2),image blob);
create table Customer(custId int auto_increment primary key,custName varchar(25), emailId varchar(25),custPass varchar(25),custAdd varchar(25),custContact varchar(25),custLoc varchar(25));
create table admin(adId int auto_increment primary key, adUsername varchar(25) unique, adPassword varchar(25));
create table Cart(cartId int auto_increment primary key,foodId int,cEmail varchar(25), fquantity varchar(25), fname varchar(25), fprice double(10,2),totalPrice double(20,2));
create table OrderFood(orderId int auto_increment primary key,orderDate Date, totalBill double, cEmail varchar(25),orderStatus varchar(25));
CREATE TABLE OrderDetails (orderDetailId INT AUTO_INCREMENT PRIMARY KEY,orderId INT,foodId INT,fname VARCHAR(25),fquantity VARCHAR(25),fprice DOUBLE(10,2),totalPrice DOUBLE(20,2),OrderStatus VARCHAR(25) DEFAULT'Processing');

desc Food;
desc Customer;
desc admin;
desc Cart;
desc OrderFocod;
desc OrderDetails;

insert into Food(foodName,foodType,foodCategory,foodDesc,foodPrice,image) values 
('VadaPav','Snack','Mumbaikar','Spicy',17.50,null),
('Samosa','Snack','Mumbaikar','Spicy',20.00,null),
('MeduVada','Breakfast','South','Spicy&Tangy',25.50,null);
insert into Customer(custName, emailId, custPass, custAdd, custContact, custLoc) values 
('JagjitSingh','Jagjit@gmail.com','Jagjit','ShivaiNagar',8879072265,'Upvan'),
('AbhishekYadav','Abhi@gmail.com','Abhi','RamBaugh',7045000807,'Upvan');
insert into Cart(foodId,fprice,fquantity,totalPrice,cEmail,fname)values
(1,17.50,2,35.00,'Jagjit@gmail.com','VadaPav'),
(3,25.50,10,255.00,'Abhi@gmail.com','Idli'),
(2,20.00,3,60.00,'Abhi@gmail.com','SamosaPav');
insert into OrderFood(orderDate,totalBill,cEmail,orderStatus)values
('2025-04-30',315.00,'Abhi@gmail.com','Processing'),
('2025-04-30',35.00,'Jagjit@gmail.com','Processing');
insert into admin (adUsername,adPassword) values ("adJagjit","adJagjitSR"),("adAbhi","adAbhiY");

select * from Food;
select * from Customer;
select * from admin;
select * from Cart;
select * from OrderFood;
select * from OrderDetails;

truncate table Food;
truncate table Customer;
truncate table admin;
truncate table Cart;
truncate table OrderFood;
truncate table OrderDetails;

drop table Food;
drop table Customer;
drop table admin;
drop table Cart;
drop table OrderFood;
drop table OrderDetails;

-- drop database fooddb;
