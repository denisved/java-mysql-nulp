USE Vedernikov_7_28;

DELIMITER //
DROP TRIGGER IF EXISTS before_gender_update //
CREATE TRIGGER before_gender_update
BEFORE UPDATE
ON gender FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "You can't update genders!";
END //

DROP TRIGGER IF EXISTS before_gender_delete //
CREATE TRIGGER before_gender_delete
BEFORE DELETE
ON gender FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "You can't delete genders!";
END //

DROP TRIGGER IF EXISTS before_family_partner_delete //
CREATE TRIGGER before_family_partner_delete
BEFORE DELETE
ON family_partner FOR EACH ROW
BEGIN 
	IF  old.id IN (SELECT id FROM family_tree) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "You can't delete this data as it is a FK data for family tree table!";
	END IF;
END //

DROP TRIGGER IF EXISTS before_family_partner_input //
CREATE TRIGGER before_family_partner_input
BEFORE INSERT 
ON family_partner FOR EACH ROW
BEGIN 
	IF new.gender NOT IN (SELECT gender FROM gender) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Error! There is no such gender in gender table!";
	END IF;
END //

DROP TRIGGER IF EXISTS before_family_tree_delete //
CREATE TRIGGER before_family_tree_delete
BEFORE DELETE
ON family_tree FOR EACH ROW
BEGIN 
	IF  old.id IN (SELECT family_tree_id FROM family_tree_family_value_joint) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "You can't delete this data as it is a foreign key in family_tree_family_value_joint table";
	END IF;
    
    IF  old.id IN (SELECT parent_tree_id FROM family_tree) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "You can't delete this data as it is a foreign key in family_tree table";
	END IF;
END //

DROP TRIGGER IF EXISTS before_family_tree_input //
CREATE TRIGGER before_family_tree_input
BEFORE INSERT 
ON family_tree FOR EACH ROW
BEGIN 
	IF new.gender NOT IN (SELECT gender FROM gender) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such gender in gender table!";
	END IF;
    
    IF new.partner_id NOT IN (SELECT id FROM family_partner) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such id in family_partner table";
	END IF;
    
    IF (new.parent_tree_id IS NOT NULL) AND (new.parent_tree_id NOT IN (SELECT id FROM family_tree)) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such id in family_tree table!";
	END IF;
END //

DROP TRIGGER IF EXISTS before_family_tree_update //
CREATE TRIGGER before_family_tree_update
BEFORE UPDATE
ON family_tree FOR EACH ROW
BEGIN 
	IF new.gender != old.gender THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "You can't update gender!";
	END IF;
    
    IF new.partner_id NOT IN (SELECT id FROM family_partner) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such id in family_partner table";
	END IF;
    
    IF (old.parent_tree_id IS NULL) AND (new.parent_tree_id NOT IN (SELECT id FROM family_tree)) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such id in family_tree table!";
	END IF;
    
    IF (old.parent_tree_id IS NOT NULL) AND (new.parent_tree_id != old.parent_tree_id) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "You can't update parent_tree_id!";
	END IF;
END //

DROP TRIGGER IF EXISTS before_family_value_delete //
CREATE TRIGGER before_family_value_delete
BEFORE DELETE
ON family_value FOR EACH ROW
BEGIN 
	IF  old.id IN (SELECT family_value_id FROM family_tree_family_value_joint) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "You can't delete this data as it is a foreign key error";
	END IF;
END //

DROP TRIGGER IF EXISTS before_family_tree_family_value_joint_update //
CREATE TRIGGER before_family_tree_family_value_joint_update
BEFORE UPDATE
ON family_tree_family_value_joint FOR EACH ROW
BEGIN 
	IF new.family_value_id NOT IN (SELECT id FROM family_value) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such id in family_value!";
	END IF;
    
    IF new.family_tree_id NOT IN (SELECT id FROM family_tree) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such id in family_tree!";
	END IF;
END //

DROP TRIGGER IF EXISTS before_family_tree_family_value_joint_input //
CREATE TRIGGER before_family_tree_family_value_joint_input
BEFORE INSERT
ON family_tree_family_value_joint FOR EACH ROW
BEGIN 
	IF new.family_value_id NOT IN (SELECT id FROM family_value) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such id in family_value!";
	END IF;
    
    IF new.family_tree_id NOT IN (SELECT id FROM family_tree) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "There is no such id in family_tree!";
	END IF;
END //


