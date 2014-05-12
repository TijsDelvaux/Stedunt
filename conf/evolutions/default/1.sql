# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table conversation (
  id                        bigint not null,
  constraint pk_conversation primary key (id))
;

create table message (
  id                        bigint not null,
  conversation_id           bigint not null,
  text                      varchar(255),
  date                      timestamp,
  read                      boolean,
  sender_email              varchar(255),
  constraint pk_message primary key (id))
;

create table statistic (
  id                        bigint not null,
  student_email             varchar(255) not null,
  date                      timestamp,
  page                      varchar(255),
  constraint pk_statistic primary key (id))
;

create table student (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  last_name                 varchar(255),
  language                  integer,
  studies                   varchar(255),
  constraint ck_student_language check (language in (0,1)),
  constraint pk_student primary key (email))
;

create table student_advertisement (
  id                        bigint not null,
  student_email             varchar(255),
  course                    varchar(255),
  description               varchar(255),
  test_ad                   boolean,
  constraint pk_student_advertisement primary key (id))
;

create table tutor_advertisement (
  id                        bigint not null,
  student_email             varchar(255),
  course                    varchar(255),
  description               varchar(255),
  test_ad                   boolean,
  price                     double,
  constraint pk_tutor_advertisement primary key (id))
;


create table conversation_student (
  conversation_id                bigint not null,
  student_email                  varchar(255) not null,
  constraint pk_conversation_student primary key (conversation_id, student_email))
;
create sequence conversation_seq;

create sequence message_seq;

create sequence statistic_seq;

create sequence student_seq;

create sequence student_advertisement_seq;

create sequence tutor_advertisement_seq;

alter table message add constraint fk_message_conversation_1 foreign key (conversation_id) references conversation (id) on delete restrict on update restrict;
create index ix_message_conversation_1 on message (conversation_id);
alter table message add constraint fk_message_sender_2 foreign key (sender_email) references student (email) on delete restrict on update restrict;
create index ix_message_sender_2 on message (sender_email);
alter table statistic add constraint fk_statistic_student_3 foreign key (student_email) references student (email) on delete restrict on update restrict;
create index ix_statistic_student_3 on statistic (student_email);
alter table student_advertisement add constraint fk_student_advertisement_stude_4 foreign key (student_email) references student (email) on delete restrict on update restrict;
create index ix_student_advertisement_stude_4 on student_advertisement (student_email);
alter table tutor_advertisement add constraint fk_tutor_advertisement_student_5 foreign key (student_email) references student (email) on delete restrict on update restrict;
create index ix_tutor_advertisement_student_5 on tutor_advertisement (student_email);



alter table conversation_student add constraint fk_conversation_student_conve_01 foreign key (conversation_id) references conversation (id) on delete restrict on update restrict;

alter table conversation_student add constraint fk_conversation_student_stude_02 foreign key (student_email) references student (email) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists conversation;

drop table if exists conversation_student;

drop table if exists message;

drop table if exists statistic;

drop table if exists student;

drop table if exists student_advertisement;

drop table if exists tutor_advertisement;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists conversation_seq;

drop sequence if exists message_seq;

drop sequence if exists statistic_seq;

drop sequence if exists student_seq;

drop sequence if exists student_advertisement_seq;

drop sequence if exists tutor_advertisement_seq;

