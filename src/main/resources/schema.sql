-- This is config database from spring in action due to the using of "indentity" in mordern version H2
create table if not exists Taco_Order (
  id bigint generated by default as identity primary key,
  delivery_Name varchar(50) not null,
  delivery_Street varchar(50) not null,
  delivery_City varchar(50) not null,
  delivery_State varchar(2) not null,
  delivery_Zip varchar(10) not null,
  cc_number varchar(16) not null,
  cc_expiration varchar(5) not null,
  cc_cvv varchar(3) not null,
  placed_at timestamp not null
);

create table if not exists Taco (
  id bigint generated by default as identity primary key,
  name varchar(50) not null,
  taco_order bigint not null,
  taco_order_key bigint not null,
  created_at timestamp not null
);

create table if not exists Ingredient_Ref (
  id varchar(4) not null,
  ingredient varchar(4) not null,
  taco bigint not null,
  taco_key bigint not null
);

create table if not exists Ingredient (
  id varchar(4) primary key,
  name varchar(25) not null,
  type varchar(10) not null
);

alter table Taco add foreign key (taco_order) references Taco_Order(id);
alter table Ingredient_Ref add foreign key (ingredient) references Ingredient(id);