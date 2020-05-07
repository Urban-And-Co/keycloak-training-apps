set schema 'cerbere';

/*==============================================================*/
/* Table: CLIENT - Short Code : CLI                             */
/*==============================================================*/
    create table CLIENT (
        ID varchar(36) not null,
        CODE varchar(10) not null,
        NAME varchar(100) not null,
        DESCRIPTION varchar(255),
       constraint PK_CLIENT PRIMARY KEY (ID),
       constraint UQ_CLI_CODE unique (CODE)
    );

/*==============================================================*/
/* Table: ACTOR - Short Code : ACT                              */
/*==============================================================*/
    create table ACTOR (
        ID varchar(36) not null,
        TITLE varchar(20),
        GENDER varchar(20),
        FIRST_NAME varchar(50),
        LAST_NAME varchar(50),
        USERNAME varchar(20) not null,
        EMAIL varchar(150),
        CREATION_DATE timestamp not null,
        ADDRESS varchar(150),
        CITY varchar(50),
        COUNTRY varchar(5),
        POSTAL_CODE varchar(15),
        PROVINCE varchar(100),
        PASSWORD varchar(100),
        PHONE_NUMBER varchar(20),
        constraint PK_ACTOR primary key (ID),
        constraint UQ_ACT_USERNAME unique (USERNAME)
    );
	
/*==============================================================*/
/* Table: CLI_ROLE - Short Code : ROL                           */
/*==============================================================*/
    create table CLI_ROLE (
        ID varchar(36) not null,
        CODE varchar(10) not null,
        NAME varchar(50) not null,
        DESCRIPTION varchar(100),
        CLI_ID varchar(50) not null,
       constraint PK_CLI_ROLE PRIMARY KEY (ID),
       constraint UQ_ROL_CODE unique (CODE, CLI_ID),
       constraint FK_ROL_CLI foreign key (CLI_ID) references CLIENT (ID)
    );
	
/*==============================================================*/
/* Table: ACTOR_ROLE - Short Code : ACR                         */
/*==============================================================*/
    create table ACTOR_ROLE (
        ACT_ID varchar(36) NOT NULL,
        ROL_ID varchar(36) NOT NULL,
  CONSTRAINT PK_ACTOR_ROLE PRIMARY KEY (ACT_ID, ROL_ID),
  CONSTRAINT FK_ACR_ROL FOREIGN KEY (ROL_ID)
      REFERENCES CLI_ROLE (ID) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT FK_ACR_ACT FOREIGN KEY (ACT_ID)
      REFERENCES ACTOR (ID) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

/*==============================================================*/
/* Table: GEO_GROUP - Short Code : GRP                          */
/*==============================================================*/
    create table GEO_GROUP (
        ID varchar(36) not null,
        CODE varchar(10) not null,
        NAME varchar(50) not null,
        DESCRIPTION varchar(100),
        CLI_ID varchar(50) not null,
       constraint PK_GEO_GROUP PRIMARY KEY (ID),
       constraint UQ_GRP_CODE unique (CODE, CLI_ID),
       constraint FK_GRP_CLI foreign key (CLI_ID) references CLIENT (ID)
    );

/*==============================================================*/
/* Table: ACTOR_GEO_GROUP - Short Code : ACG                    */
/*==============================================================*/
    create table ACTOR_GEO_GROUP (
        ACT_ID varchar(36) NOT NULL,
        GRP_ID varchar(36) NOT NULL,
  CONSTRAINT PK_ACTOR_GEO_GROUP PRIMARY KEY (ACT_ID, GRP_ID),
  CONSTRAINT FK_ACR_GRP FOREIGN KEY (GRP_ID)
      REFERENCES GEO_GROUP (ID) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT FK_ACR_ACT FOREIGN KEY (ACT_ID)
      REFERENCES ACTOR (ID) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

