create table bank_account (
    iban varchar(255) primary key,
    balance decimal(15,2) not null default 0
);