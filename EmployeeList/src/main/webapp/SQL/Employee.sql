GRANT ALL PRIVILEGES ON *.* TO javauser@localhost
    IDENTIFIED BY 'javadude' WITH GRANT OPTION;
create database practice;
use practice;
create table employee (
                          ID int not null auto_increment primary key,
                          FullName varchar(200) not null,
                          Birthday varchar(10) not null,
                          Address varchar(200) not null,
                          Position  varchar(100) not null,
                          Department varchar(100) not null
);

INSERT INTO employee (FullName, Birthday, Address, Position , Department) VALUES ('Thanh Tung', '09/09/2001', 'Ha Noi', 'Giam Doc', 'Hanh Chinh');