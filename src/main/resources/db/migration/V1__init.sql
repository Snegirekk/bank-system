create extension if not exists "uuid-ossp";

create table public.addresses (
    id uuid primary key,
    country varchar(2),
    locality varchar not null,
    province varchar,
    address1 varchar not null,
    address2 varchar,
    post_code varchar not null
);

create table public.accounts (
    id uuid primary key,
    amount decimal default 0,
    customer_id uuid,
    transaction_participant_id uuid
);

create table public.customers (
    id uuid primary key,
    first_name varchar not null,
    last_name varchar not null,
    address_id uuid,
    birthday date
);

create table public.transaction_participants (
    id uuid primary key,
    type varchar not null
);

create table public.transactions (
    id uuid primary key,
    source_id uuid,
    target_id uuid,
    amount decimal
);

alter table public.accounts
    add constraint fk_customer_id
        foreign key (customer_id) references public.customers (id),
    add constraint fk_transaction_participant_id
        foreign key (transaction_participant_id) references public.transaction_participants (id);

alter table public.customers
    add constraint fk_address_id
        foreign key (address_id) references public.addresses (id);

alter table public.transactions
    add constraint fk_source_id
        foreign key (source_id) references public.transaction_participants (id),
    add constraint fk_target_id
        foreign key (target_id) references public.transaction_participants (id);