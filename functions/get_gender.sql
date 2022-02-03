CREATE DEFINER=`root`@`localhost` FUNCTION `get_gender`(gender CHAR(1)) RETURNS varchar(6) CHARSET utf8mb4
BEGIN
	return(SELECT gender_full FROM gender WHERE gender.gender=gender);
END