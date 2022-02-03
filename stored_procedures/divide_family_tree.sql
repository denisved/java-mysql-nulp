CREATE DEFINER=`root`@`localhost` PROCEDURE `divide_family_tree`()
BEGIN
DECLARE done bool default false;

DECLARE id INT;
DECLARE name VARCHAR(45);
DECLARE surname VARCHAR(45);
DECLARE birth_date DATE;
DECLARE death_date DATE;
DECLARE birth_place VARCHAR(60);
DECLARE death_place VARCHAR(60);
DECLARE credit_card_number VARCHAR(45);
DECLARE partner_id INT;
DECLARE gender CHAR(1);
DECLARE parent_tree_id INT;


DECLARE tree_cursor cursor for select * from family_tree;
declare continue handler for not found set done = true;

set @cur_datetime = current_timestamp();

set @create_query = concat("CREATE TABLE `family_tree_", @cur_datetime, "_first` (", 
	"id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,",
    "`name` VARCHAR(45) NOT NULL,",
	"`surname` VARCHAR(45) NOT NULL,",
	"`birth_date` DATE,",
	"`death_date` DATE,",
	"`birth_place` VARCHAR(60),",
	"`death_place` VARCHAR(60),",
	"`credit_card_number` VARCHAR(45),",
	"`partner_id` INT UNIQUE,",
	"`gender` CHAR(1) NOT NULL,",
    "`parent_tree_id` INT",
    ");"); 
prepare create_statement from @create_query;
execute create_statement;
deallocate prepare create_statement; 
   
set @create_query = concat("CREATE TABLE `family_tree_", @cur_datetime, "_second` (", 
	"id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,",
    "`name` VARCHAR(45) NOT NULL,",
	"`surname` VARCHAR(45) NOT NULL,",
	"`birth_date` DATE,",
	"`death_date` DATE,",
	"`birth_place` VARCHAR(60),",
	"`death_place` VARCHAR(60),",
	"`credit_card_number` VARCHAR(45),",
	"`partner_id` INT UNIQUE,",
	"`gender CHAR(1)` NOT NULL,",
    "`parent_tree_id` INT",
    ");"); 
prepare create_statement from @create_query;
execute create_statement;
deallocate prepare create_statement;

open tree_cursor;
tree_loop: loop
		fetch tree_cursor into id, `name`, surname, birth_date,
        death_date, birth_place, death_place, credit_card_number,
        partner_id, gender, parent_tree_id;
        IF done=true THEN
				LEAVE tree_loop;
		END IF;
        
        IF rand()>0.5 THEN
				set @temp_query=CONCAT("INSERT into `family_tree_", @cur_datetime, "_first`",
                "(`name`, surname, birth_date, death_date, birth_place, death_place,
                credit_card_number, partner_id, gender, parent_tree_id) VALUES(", 
            "'", `name`, "',", "'", surname, "',", birth_date, ",", death_date, ",", 
            "'", birth_place, "',", "'", death_place, "',", credit_card_number, ",", partner_id, ",",
            "'", gender, "',", parent_tree_id, ");");
        ELSE
				set @temp_query=CONCAT("INSERT into `family_tree_", @cur_datetime, "_second`",
                "(`name`, surname, birth_date, death_date, birth_place, death_place,
                credit_card_number, partner_id, gender, parent_tree_id) VALUES(", 
            "'", `name`, "',", "'", surname, "',", birth_date, ",", death_date, ",", 
            "'", birth_place, "',", "'", death_place, "',", credit_card_number, ",", partner_id, ",",
            "'", gender, "',", parent_tree_id, ");");
		END IF;
        PREPARE temp_statement FROM @temp_query;
        EXECUTE temp_statement;
        DEALLOCATE PREPARE temp_statement;
end loop;
close tree_cursor;
END