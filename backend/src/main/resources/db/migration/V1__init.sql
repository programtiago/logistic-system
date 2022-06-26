CREATE TABLE client

(
    client_id   bigint(20) not null AUTO_INCREMENT,
    name varchar(50) not null,
    email varchar(100) not null,
    contact varchar(10) not null,
    nib varchar(25) not null,
    client_type varchar(10)

    primary key(client_id)
)