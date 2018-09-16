create table pcstore_types(
	id int not null,
	name varchar(100),
	primary key(id)
);

create table pcstore_vendors(
	id int not null,
	vendor_name nvarchar(50),
	primary key(id)
);

create table pcstore_list(
	id int not null,
	name nvarchar(50),
	primary key(id)
);

create table pcstore_products (
	id int not null,
	list_id int,
	type_id int,
	name varchar(100),
	release_date date,
	price double,
	vendor_id int,
	detail nvarchar(1000),
	image BLOB,
	warranty nvarchar(1000),
	rate int,
	quantity int,
	primary key (id),
	foreign key (vendor_id) references pcstore_vendors(id),
	foreign key (type_id) references pcstore_types(id),
	foreign key (list_id) references pcstore_list(id)
);

create table pcstore_product_images(
	id int not null,
	procducts_id int,
	image BLOB,
	primary key(id),
	foreign key (procducts_id) references pcstore_products(id)
);

create table pcstore_users(
	id int not null,
	username varchar(20),
	password varchar(100),
	name nvarchar(50),
	email varchar(50),
	date_of_birth date,
	primary key(id)
);

create table pcstore_comments(
	id int not null,
	procducts_id int,
	user_id int,
	comment_time datetime,
	primary key(id),
	foreign key (procducts_id) references pcstore_products(id),
	foreign key (user_id) references pcstore_users(id)
);

create table pcstore_saveoff(
	id int not null,
	product_id int,
	discount int,
	discount_date date,
	primary key(id),
	foreign key (product_id) references pcstore_products(id)
);

create table pcstore_events(
	id int not null,
	name varchar(100),
	content text,
	primary key(id)
);

create table pcstore_bills(
	id int not null,
	user_id int,
	product_id int,
	amount int,
	buy_date datetime,
	primary key(id),
	foreign key (product_id) references pcstore_products(id),
	foreign key (user_id) references pcstore_users(id)
);

create table pcstore_privileges(
	id int not null,
	name varchar(10),
	primary key(id)
);

create table pcstore_employee(
	id int not null,
	username varchar(20),
	password varchar(100),
	name nvarchar(50),
	email varchar(50),
	date_of_birth date,
	privilege_id int,
	primary key(id),
	foreign key(privilege_id) references pcstore_privileges(id)
);


