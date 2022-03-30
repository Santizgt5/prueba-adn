create table company (
      company_id int(11) not null auto_increment,
      name varchar(45) not null,
      description varchar(100) not null,
      born datetime not null,
      nit varchar(45) not null,
      primary key (company_id)
);


create table videogame (
    videogame_id int(11) auto_increment,
    title varchar(45) not null,
    stock int(11) not null,
    companyId int(11) not null,
    releaseDate datetime not null,
    platform varchar(10) not null,
    price float(53) not null,
    primary key (videogame_id),
    foreign key (companyId) references company(company_id)
 );

 create table cart(
    cart_id int(11) auto_increment,
    total float(53) not null,
    primary key (cart_id)
 );

 create table purchaseVideogame(
    videogamepurchase_id int(11) auto_increment,
    videogame varchar(45) not null,
    quantity int(11) not null,
    cartId int(11),
    foreign key (cartId) references cart(cart_id)
 );

