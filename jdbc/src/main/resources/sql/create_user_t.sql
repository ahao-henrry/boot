drop table if exists user_t;
create table user_t
(
  id     int auto_increment primary key,
  name   varchar(64) default '' not null,
  gender int default 0          not null,
  age    int                    not null,
  constraint user_id_uindex
  unique (id)
)
  comment 'user_t';