drop table if exists user_t2;
create table user_t2
(
  id     int auto_increment primary key,
  name   varchar(64) default '' not null,
  gender tinyint default 0          not null,
  age    int                    not null,
  constraint user_id_uindex
  unique (id)
)
  comment 'user';