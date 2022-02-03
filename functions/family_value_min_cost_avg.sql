CREATE DEFINER=`root`@`localhost` FUNCTION `famaly_value_min_cost_avg`() RETURNS int
BEGIN
	return(SELECT AVG(min_cost) FROM family_value);
END