CREATE DATABASE IF NOT EXISTS Vedernikov_7_28;
USE Vedernikov_7_28;

DROP TABLE IF EXISTS family_partner;
DROP TABLE IF EXISTS family_tree;
DROP TABLE IF EXISTS gender;
DROP TABLE IF EXISTS family_value;
DROP TABLE IF EXISTS family_tree_family_value_joint;

CREATE TABLE family_partner (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    birth_date DATE,
    death_date DATE,
    birth_place VARCHAR(60),
    death_place VARCHAR(60),
    marriage_date DATE,
    gender CHAR(1)
);

CREATE TABLE family_tree (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    birth_date DATE,
    death_date DATE,
    birth_place VARCHAR(60),
    death_place VARCHAR(60),
    credit_card_number VARCHAR(45),
    partner_id INT UNIQUE,
    gender CHAR(1) NOT NULL,
    parent_tree_id INT
);

CREATE TABLE gender (
	gender CHAR(1) PRIMARY KEY,
    gender_full VARCHAR(6)
);

CREATE TABLE family_value (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    estimated_cost INT,
    max_cost INT,
    min_cost INT,
    `code` INT
);

CREATE TABLE family_tree_family_value_joint(
	family_tree_id INT,
    family_value_id INT,
    
    CONSTRAINT family_tree_family_value_joint_pk PRIMARY KEY (family_tree_id, family_value_id)
);
