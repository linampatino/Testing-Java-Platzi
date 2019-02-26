create table if not exists movies(
	 id int auto_increment primary key,
	 name varchar(50) not null,
	 minutes int not null,
	 genre varchar(50) not null
);

insert into movies(name, minutes, genre) values
('movie 1', 90, 'THRILLER'),
('movie 2', 120, 'THRILLER'),
('movie 3', 90, 'ACTION');
