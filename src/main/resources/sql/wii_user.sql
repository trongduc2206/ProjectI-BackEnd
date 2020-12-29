DROP TABLE IF EXISTS "public"."company";
CREATE TABLE "public"."company" (
  "id" bigserial PRIMARY KEY NOT NULL,
  "created_time" timestamp(6) NOT NULL,
  "last_updated_time" timestamp(6),
  "creator" varchar(35),
  "last_updated_id" int8,
  "is_actived" bool NOT NULL DEFAULT TRUE,
  "name" varchar(120) NOT NULL, -- Ten to chuc phat
  "code" varchar(30) UNIQUE, -- Ma to chuc phat hanh
  "phone_number" varchar(14), -- So dien thoai
  "email" varchar(80),
  "full_address" varchar (160), -- dia chi
  "website" varchar(120),
  "biz_no" varchar(30), -- So giay phep kinh doanh
  "biz_issue_by" varchar(80), -- Don vi cap giay phep kinh doanh
  "biz_issue_date" date, -- Ngay cap giay phep kinh doanh
  "rep_name" varchar(80), -- Nguoi dai dien
  "rep_role" varchar(60), -- chuc vu nguoi dai dien
  "rep_email" varchar(80), -- email nguoi dai dien
  "rep_phone" varchar(80), -- so dien thoai nguoi dai dien
  "tax_number" varchar(30), --Ma so thue
  "fax_number" varchar(15), -- So Fax
  "contract_no" varchar(40), -- Ma hop dong
  "contract_date" date --Ngay ky hop dong
);

DROP TABLE IF EXISTS "public"."wii_user";
CREATE TABLE "public"."wii_user" (
  "id" bigserial PRIMARY KEY NOT NULL,
  "created_time" timestamp(6) NOT NULL,
  "last_updated_time" timestamp(6),
  "creator" varchar(35),
  "last_updated_id" int8,
  "company_id" int8,
  "is_actived" bool NOT NULL DEFAULT TRUE,
  "user_name" varchar(120) UNIQUE, 
  "email" varchar(30) UNIQUE, 
  "phone_number" varchar(14) NOT NULL UNIQUE,
  "first_name" varchar(30),
  "middle_name" varchar(30),
  "last_name" varchar(30),
  "full_name" varchar(80),
  "birthday" date,
  "city" varchar(30),
  "district" varchar(40),
  "sub_district" varchar(40),
  "full_address" varchar (160), 
  "postal_code" varchar(15),
  "identity_number" varchar(30) UNIQUE, -- CMT
  "identity_issue_by" varchar(60), -- CMT cap boi
  "identity_issue_date" date, -- Ngay cap CMT
  "passport_number" varchar(30) UNIQUE,
  "passport_issue_date" date,
  "passport_expired_date" date,
  "passport_issue_by" varchar(60),
  "nationality" varchar(40), -- Quoc Tich
  "is_foregin" bool NOT NULL DEFAULT FALSE,
  "is_staff" bool NOT NULL DEFAULT FALSE,
  "gender" varchar(10), -- MALE/FEMALE/UNDEFINED
  "password" varchar(120) NOT NULL,
  "title" varchar(10), --MR/MRSS/DR ..
  "occupation" varchar(60), -- Nghề nghiệp
  "current_job" varchar(60),
  "current_job_role" varchar(60),
  "current_company" varchar(60),
  "custody_code" varchar(30), --Mã VSD
  "customer_code" varchar(30), -- Internal customer code
  "active_code" varchar(60), -- Ma phuc vu viec active account
  "is_locked" bool NOT NULL DEFAULT FALSE,
  "allow_withdraw" bool NOT NULL DEFAULT TRUE,
  "allow_transfer" bool NOT NULL DEFAULT TRUE,
  "allow_trade" bool NOT NULL DEFAULT TRUE,
  "must_change_pass" bool NOT NULL DEFAULT FALSE,
  "secrect_key" varchar(120),
  "reset_key" varchar(120),
  "referal_code" varchar(120),
  "tax_number" varchar(30),
  "status" varchar(10), --INIT,DOCUMENT_UPLOADED,OP_REVIEWED,APPROVED
  "salt" varchar(30)
);


--BANK ACCOUNT
DROP TABLE IF EXISTS "public"."bank_account";
CREATE TABLE "public"."bank_account" (
  "id" bigserial PRIMARY KEY NOT NULL,
  "created_time" timestamp(6) NOT NULL,
  "last_updated_time" timestamp(6),
  "creator" varchar(35),
  "last_updated_id" int8,
  "company_id" int8,
  "is_actived" bool NOT NULL DEFAULT TRUE,
  "user_id" int8 NOT NULL,
  "bank_account_name" varchar(60),
  "bank_account_number" varchar(18),
  "ccv_encrypt" varchar(30),
  "account_expired_date" date,
  "account_issue_date" date,
  "bank_name" varchar(60), -- Ten ngan hang
  "bank_code" varchar(10), -- Ma ngan hang 
  "swift_code" varchar(10), -- Swift code
  "status" varchar(10)
  );



--User Document 
DROP TABLE IF EXISTS "public"."user_document";
CREATE TABLE "public"."user_document" (
  "id" bigserial PRIMARY KEY NOT NULL,
  "created_time" timestamp(6) NOT NULL,
  "last_updated_time" timestamp(6),
  "creator" varchar(35),
  "last_updated_id" int8,
  "company_id" int8,
  "is_actived" bool NOT NULL DEFAULT TRUE,
  "user_id" int8 NOT NULL,
  "doc_type" varchar(10), -- AVATAR/IDENTITY/PASSPORT/CONTRACT
  "name" varchar(60),
  "file_type" varchar(10), --PDF,PNG,JPEG,DOCX,EXCEL
  "description" varchar(350),
  "path" varchar(160),
  "status" varchar(10) --INIT,OP_REVIEWED,APPROVED
  );


DROP TABLE IF EXISTS "public"."wii_staff";
CREATE TABLE "public"."wii_staff" (
  "id" bigserial PRIMARY KEY NOT NULL,
  "created_time" timestamp(6) NOT NULL,
  "last_updated_time" timestamp(6),
  "creator" varchar(35),
  "last_updated_id" int8,
  "company_id" int8,
  "is_actived" bool NOT NULL DEFAULT TRUE,
  "user_id" int8 NOT NULL,
  "company_phone_number" varchar(14),
  "company_email" varchar(60),
  "staff_code" varchar(30) NOT NULL UNIQUE,
  "joined_date" date,
  "title" varchar(50),
  "division" varchar(60),
  "personal_email" varchar(60),
  "personal_phone_number" varchar(15),
  "manager_name" varchar(80),
  "manager_id" int8,
  "status" varchar(10)
);

DROP TABLE IF EXISTS "public"."roles";
CREATE TABLE "public"."roles"(
  "id" bigserial PRIMARY KEY NOT NULL,
  "created_time" timestamp(6) NOT NULL,
  "last_updated_time" timestamp(6),
  "creator" varchar(35),
  "last_updated_id" int8,
  "company_id" int8,
  "is_actived" bool NOT NULL DEFAULT TRUE,
  "name" varchar(60) NOT NULL,
  "description" varchar(255)
);


DROP TABLE IF EXISTS "public"."actions";
CREATE TABLE "public"."actions" (
  "id" bigserial PRIMARY KEY NOT NULL,
  "created_time" timestamp(6) NOT NULL,
  "last_updated_time" timestamp(6),
  "creator" varchar(35),
  "last_updated_id" int8,
  "company_id" int8,
  "is_actived" bool NOT NULL DEFAULT TRUE,
  "subject" varchar(20) NOT NULL, --USER/PRODDUCT/INVENTORY/STRUCTURE/ORDER/HISTORICAL
  "action" varchar(10) NOT NULL, --CREATE/EDIT/DELETE/VIEW/SEARCH/LIST/REPORT/DOWNLOAD/UPLOAD/IMPORT/EXPORT
  "description" varchar(255)
);


DROP TABLE IF EXISTS "public"."group";
CREATE TABLE "public"."group" (
  "id" bigserial PRIMARY KEY NOT NULL,
  "created_time" timestamp(6) NOT NULL,
  "last_updated_time" timestamp(6),
  "creator" varchar(35),
  "last_updated_id" int8,
  "company_id" int8,
  "is_actived" bool NOT NULL DEFAULT TRUE,
  "name" varchar(60), --SALE/OP/ACCOUNTANT/BOD/BI
  "description" varchar(255)
);


DROP TABLE IF EXISTS "public"."group_actions";
CREATE TABLE "public"."group_actions" (
  "id" bigserial PRIMARY KEY NOT NULL,
  "created_time" timestamp(6) NOT NULL,
  "last_updated_time" timestamp(6),
  "creator" varchar(35),
  "last_updated_id" int8,
  "company_id" int8,
  "is_actived" bool NOT NULL DEFAULT TRUE,
  "group_id" int8 NOT NULL,
  "action_id" int8 NOT NULL,
  "subject_name" varchar(20),
  "action_name" varchar(10)
);


DROP TABLE IF EXISTS "public"."user_acctions";
CREATE TABLE "public"."user_actions" (
  "id" bigserial PRIMARY KEY NOT NULL,
  "created_time" timestamp(6) NOT NULL,
  "last_updated_time" timestamp(6),
  "creator" varchar(35),
  "last_updated_id" int8,
  "company_id" int8,
  "is_actived" bool NOT NULL DEFAULT TRUE,
  "user_id" int8 NOT NULL,
  "staff_id" int8,
  "action_id" int8 NOT NULL,
  "subject_name" varchar(20),
  "action_name" varchar(10)
);


DROP TABLE IF EXISTS "public"."user_group";
CREATE TABLE "public"."user_group" (
  "id" bigserial PRIMARY KEY NOT NULL,
  "created_time" timestamp(6) NOT NULL,
  "last_updated_time" timestamp(6),
  "creator" varchar(35),
  "last_updated_id" int8,
  "company_id" int8,
  "is_actived" bool NOT NULL DEFAULT TRUE,
  "group_id" int8 NOT NULL,
  "user_id" int8 NOT NULL,
  "staff_id" int8,
  "group_name" varchar(20)
);
