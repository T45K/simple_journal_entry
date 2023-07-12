use simple_journal_entry_db;

create table companies
(
    id      bigint not null primary key auto_increment,
    name    varchar(256) not null
);
