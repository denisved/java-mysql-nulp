USE Vedernikov_7_28;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_input_check_birth_place //
CREATE TRIGGER before_family_tree_input_check_birth_place
BEFORE INSERT
ON family_tree FOR EACH ROW
BEGIN 
	IF (new.birth_place IS NOT NULL) AND 
    (new.birth_place NOT IN ("Lviv", "Zashkiv", "Zarudtsi")) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Birth place can be only in Lviv, Zashkiv and Zarudtsi";
	END IF;
END //

DROP TRIGGER IF EXISTS before_family_tree_update_check_birth_place //
CREATE TRIGGER before_family_tree_update_check_birth_place
BEFORE UPDATE
ON family_tree FOR EACH ROW
BEGIN 
	IF (new.birth_place IS NOT NULL) AND 
    (new.birth_place NOT IN ("Lviv", "Zashkiv", "Zarudtsi")) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Birth place can be only in Lviv, Zashkiv and Zarudtsi";
	END IF;
END //

DELIMITER //
DROP TRIGGER IF EXISTS before_family_partner_input_check_birth_date //
CREATE TRIGGER before_family_partner_input_check_birth_date
BEFORE INSERT
ON family_partner FOR EACH ROW
BEGIN 
	IF (new.birth_date IS NOT NULL) AND (new.birth_date > CURDATE()) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Birth date can not be bigger than current date!";
	END IF;
END //

DROP TRIGGER IF EXISTS before_family_partner_update_check_birth_date //
CREATE TRIGGER before_family_partner_update_check_birth_date
BEFORE UPDATE
ON family_partner FOR EACH ROW
BEGIN 
	IF (new.birth_date IS NOT NULL) AND (new.birth_date > CURDATE()) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Birth date can not be bigger than current date!";
	END IF;
END //

DELIMITER //
DROP TRIGGER IF EXISTS family_value_update_ban //
CREATE TRIGGER family_value_update_ban
BEFORE UPDATE
ON family_value FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "You can not update anything in family_value table!";
END //