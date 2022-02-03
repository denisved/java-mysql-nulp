CREATE DEFINER=`root`@`localhost` PROCEDURE `select_tree_value_joint`(IN tree_name VARCHAR(45), IN value_name VARCHAR(100))
BEGIN
	SELECT family_tree.name, family_value.name FROM family_tree_family_value_joint
    INNER JOIN family_tree ON family_tree_family_value_joint.family_tree_id = family_tree.id
    INNER JOIN family_value ON family_tree_family_value_joint.family_value_id = family_value.id
    WHERE (tree_name = '' OR family_tree.name = tree_name) AND (value_name = '' OR family_value.name = value_name);
END