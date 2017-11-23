drop table if exists role;

drop table if exists user;

create table user (
	 id int(10), 
    name varchar(120) ,
    primary key (id),
    CONSTRAINT UC_NAME  unique (name)
    );
    
    create table role (
     role varchar(150),
     user_id int(10),
     CONSTRAINT FK_USER foreign key (user_id) REFERENCES  user(id)
    );
    