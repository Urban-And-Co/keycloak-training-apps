set schema 'cerbere';

alter table CLI_ROLE drop constraint if exists FK_ROL_CLI;
alter table ACTOR_ROLE drop constraint if exists FK_ACR_ROL;
alter table ACTOR_ROLE drop constraint if exists FK_ACR_ACT;
alter table GEO_GROUP drop constraint if exists FK_GRP_CLI;
alter table ACTOR_GEO_GROUP drop constraint if exists FK_ACR_GRP;
alter table ACTOR_GEO_GROUP drop constraint if exists FK_ACR_ACT;

drop table IF EXISTS CLIENT cascade;
drop table IF EXISTS ACTOR cascade;
drop table IF EXISTS CLI_ROLE cascade;
drop table IF EXISTS ACTOR_ROLE cascade;
drop table IF EXISTS GEO_GROUP cascade;
drop table IF EXISTS ACTOR_GEO_GROUP cascade;