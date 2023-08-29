/*
 Navicat Premium Data Transfer

 Source Server         : mcnc
 Source Server Type    : PostgreSQL
 Source Server Version : 130012 (130012)
 Source Host           : localhost:5432
 Source Catalog        : postgres
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130012 (130012)
 File Encoding         : 65001

 Date: 29/08/2023 08:42:18
*/


-- ----------------------------
-- Sequence structure for emp_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."emp_id_seq";
CREATE SEQUENCE "public"."emp_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Table structure for Emp99
-- ----------------------------
DROP TABLE IF EXISTS "public"."Emp99";
CREATE TABLE "public"."Emp99" (
  "id" int4 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "salary" int4 NOT NULL,
  "designation" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS "public"."emp";
CREATE TABLE "public"."emp" (
  "id" int4 NOT NULL DEFAULT nextval('emp_id_seq'::regclass),
  "name" varchar(30) COLLATE "pg_catalog"."default",
  "salary" int4,
  "designation" varchar(30) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS "public"."student";
CREATE TABLE "public"."student" (
  "id" int4 NOT NULL DEFAULT nextval('emp_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "gender" varchar(255) COLLATE "pg_catalog"."default",
  "subject" varchar(255) COLLATE "pg_catalog"."default",
  "is_deleted" bool
)
;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."emp_id_seq"
OWNED BY "public"."emp"."id";
SELECT setval('"public"."emp_id_seq"', 20, true);

-- ----------------------------
-- Primary Key structure for table Emp99
-- ----------------------------
ALTER TABLE "public"."Emp99" ADD CONSTRAINT "Emp99_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table emp
-- ----------------------------
ALTER TABLE "public"."emp" ADD CONSTRAINT "emp_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table student
-- ----------------------------
ALTER TABLE "public"."student" ADD CONSTRAINT "student_pkey" PRIMARY KEY ("id");
