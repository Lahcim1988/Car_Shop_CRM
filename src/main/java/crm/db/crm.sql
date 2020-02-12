create database crm character set utf8mb4 collate utf8mb4_unicode_ci;

    CREATE TABLE car(
        id int AUTO_INCREMENT,
        customer_id int,
        model varchar(35),
        brand varchar(35),
        manufacture_year varchar(4),
        registration_number varchar(10),
        next_service date,
        PRIMARY KEY(id),
        FOREIGN KEY (customer_id) REFERENCES customer(id)
                    );

CREATE TABLE customer(
        id int AUTO_INCREMENT,
        name varchar(35),
        surname varchar(35),
        birth_day DATE,
        PRIMARY KEY(id)
                    );

CREATE TABLE employee(
        id int AUTO_INCREMENT,
        name varchar(35),
        surname varchar(35),
        address varchar (60),
        phone varchar (10),
        note varchar (255),
        costPerHour double,
        PRIMARY KEY(id)
                     );

CREATE TABLE car_service(
        id int AUTO_INCREMENT,
        employee_id int,
        car_id int not null,
        receive_day date,
        repair_plan_day date,
        repair_start_day date,
        issue_note varchar(255),
        repair_note varchar(255),
        repair_status varchar(12),
        customer_fee double,
        parts_fee double,
        man_hours_cost double,
        man_hours_amount int,
        PRIMARY KEY(id),
        FOREIGN KEY (employee_id) REFERENCES employee(id),
        FOREIGN KEY (car_id) REFERENCES car(id)
                        );