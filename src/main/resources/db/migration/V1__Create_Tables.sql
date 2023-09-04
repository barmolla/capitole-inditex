create table if not exists brand (
    id bigint not null,
    name varchar(255) not null,
    primary key (id)
);

create table if not exists product (
    id bigint not null,
    brand_id bigint not null,
    name varchar(255) not null,
    primary key (id),
    foreign key(brand_id) references brand(id)
);

create table if not exists price (
    price_list bigint not null,
    priority int not null,
    price numeric(8,2) not null,
    currency varchar(10) not null,
    brand_id bigint not null,
    product_id bigint not null,
    start_date timestamp not null,
    end_date timestamp not null,
    primary key (price_list),
    foreign key(brand_id) references brand(id),
    foreign key(product_id) references product(id)
);