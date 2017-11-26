create table user (
	id int(10), 
    username varchar(120) , 
    password varchar(120) ,
    primary key (id),
    CONSTRAINT UC_NAME  unique (username)
    );
    