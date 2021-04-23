# salesman-project
### เป็นโปรเจ็คที่จัดการกับ order,ข้อมูลของลูกค้า และสินค้า
# How to install
### 1.clone project https://github.com/kfangttxku/salesman-project.git และ api ทั้งหมด ได้แก่
### https://github.com/kfangttxku/customer-api.git , https://github.com/kfangttxku/order-api2.git , https://github.com/kfangttxku/product-api.git
### 2.ทำการสร้าง database ใน mysql workbench โดยใช้คำสั่งดังนี้
### CREATE DATABASE salesman;
### USE salesman;
###
### CREATE TABLE customer (
###   customer_id INT NOT NULL AUTO_INCREMENT,
###   customer_name VARCHAR(30) NOT NULL,
###   customer_address VARCHAR(30) NOT NULL,
###   customer_phone VARCHAR(10) NOT NULL,
###   PRIMARY KEY (customer_id)
### );
### CREATE TABLE orders (
###   order_id INT NOT NULL AUTO_INCREMENT,
###   customer_id INT NOT NULL,
###   product_id INT NOT NULL,
###   product_amount INT NOT NULL,
###  order_status VARCHAR(30) NOT NULL,
###   order_date DATE NOT NULL,
###   PRIMARY KEY (order_id)
### );
### CREATE TABLE product (
###   product_id INT NOT NULL AUTO_INCREMENT,
###   product_name VARCHAR(30) NOT NULL,
###   product_price double NOT NULL,
###   product_stock INT NOT NULL,
###   PRIMARY KEY (product_id)
### );
# การ run project
### 1.run database
### 2.run program ทั้งหมดที่ได้ git clone
### 3.เปิด browser แล้วค้นหา http://localhost:8090/home เพื่อเปิดหน้า project 
### 4.http://localhost:8091/api/customer , http://localhost:8092/api/product ,http://localhost:8093/api/orders (สามารถใช้ link ทั้ง 3 นี้เพื่อดู api ได้)
# Link Slide
### https://www.canva.com/design/DAEcIYaUsOA/9uNASJhHuaS2jh3fDm5bLg/view?utm_content=DAEcIYaUsOA&utm_campaign=designshare&utm_medium=link&utm_source=publishsharelink
# รายชื่อสมาชิก
#### ฐิติพงศ์ พูนวิทย์ 6110405965
#### ณธกฤต ลลิตพุฒิโชค 6110405990
#### อดิรุจ  มุกดา 6110406261
#### ณัฐพงษ์ เหียนขุนทด 6110406015 (ไม่มีส่วนช่วยเหลือในการทำงานกลุ่มแม้แต่งานเดียว (app vs app : joox vs spotify , advance topic : kanban , project salesman))

