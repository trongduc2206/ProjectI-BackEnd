# CREATE DATABASE IF NOT EXISTS XPROJECT;


DROP TABLE IF EXISTS ITEM_PROPERTY CASCADE;
DROP TABLE IF EXISTS ITEM CASCADE;
DROP TABLE IF EXISTS CATEGORY CASCADE;
DROP TABLE IF EXISTS PRODUCER CASCADE;
DROP TABLE IF EXISTS LOCATION CASCADE;
DROP TABLE IF EXISTS PERIOD CASCADE;
DROP TABLE IF EXISTS PERIOD_TYPE CASCADE;
DROP TABLE IF EXISTS SEASON CASCADE;

USE XPROJECT;


CREATE TABLE IF NOT EXISTS CATEGORY
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active     BOOLEAN,
    is_delete     BOOLEAN,
    description   TEXT,
    creator_id    INTEGER,
    code          VARCHAR(250) UNIQUE,

    name          VARCHAR(250) NOT NULL,
    status        VARCHAR(250),
    icon          VARCHAR(250),
    parent_id     BIGINT    DEFAULT NULL,
    FOREIGN KEY (parent_id) REFERENCES CATEGORY (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS LOCATION
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active     BOOLEAN,
    is_delete     BOOLEAN,
    description   TEXT,
    creator_id    INTEGER,
    status        VARCHAR(250),

    district      VARCHAR(200),
    province      VARCHAR(200),
    country       VARCHAR(200),
    full_address  VARCHAR(200),
    zone          varchar(200),
    longitude     DOUBLE,
    latitude      DOUBLE,
    postal_code   varchar(200)
);

CREATE TABLE IF NOT EXISTS PRODUCER
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_time   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active      BOOLEAN,
    is_delete      BOOLEAN,
    description    TEXT,
    creator_id     INTEGER,
    status         VARCHAR(250),
    code           VARCHAR(250) UNIQUE,

    name           varchar(200) NOT NULL,
    biz_number     varchar(200),
    biz_issue_date TIMESTAMP,
    email          varchar(200),
    phone_number   varchar(200),
    tax_number     varchar(200),
    location_id    BIGINT,

    FOREIGN KEY (location_id) REFERENCES LOCATION (id) ON DELETE CASCADE
);



CREATE TABLE IF NOT EXISTS PERIOD
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active     BOOLEAN,
    is_delete     BOOLEAN,
    description   TEXT,
    creator_id    BIGINT,
    status        VARCHAR(250),

    name          VARCHAR(400) NOT NULL,
    period_type   varchar(400),
    season        varchar(400),
    start_time    TIMESTAMP,
    end_time      TIMESTAMP
);


CREATE TABLE IF NOT EXISTS ITEM
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active     BOOLEAN,
    is_delete     BOOLEAN,
    description   TEXT,
    creator_id    BIGINT,
    status        VARCHAR(250),
    code          VARCHAR(250) UNIQUE,

    icon          varchar(200),
    name          VARCHAR(250) NOT NULL,
    category_id   BIGINT,
    location_id   BIGINT,
    producer_id   BIGINT,
    period_id     BIGINT,
    rating        DOUBLE,
    FOREIGN KEY (category_id) REFERENCES CATEGORY (id) ON DELETE CASCADE,
    FOREIGN KEY (location_id) REFERENCES LOCATION (id) ON DELETE CASCADE,
    FOREIGN KEY (producer_id) REFERENCES PRODUCER (id) ON DELETE CASCADE,
    FOREIGN KEY (period_id) REFERENCES PERIOD (id) ON DELETE CASCADE

);

CREATE TABLE IF NOT EXISTS ITEM_PROPERTY
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active     BOOLEAN,
    is_delete     BOOLEAN,
    description   TEXT,
    creator_id    BIGINT,


    attribute     VARCHAR(200) NOT NULL,
    value         VARCHAR(200),
    item_id       BIGINT,

    FOREIGN KEY (item_id) REFERENCES ITEM (id) ON DELETE CASCADE
);