INSERT INTO user (ID, USERNAME, PASSWORD) VALUES
	(1, 'NAME-1', null),
	(2, 'NAME-2', null);
	
INSERT INTO user_role (ROLE, USER_ID) VALUES
	('ROLE-1', 1),
	('ROLE-2', 2);
	
INSERT INTO user_address (TYPE_, STREET, CITY, USER_ID) VALUES
	('HOME', 'STREET-1', 'CITY-1', 1),
	('OFFICE', 'STREET-1', 'CITY-1', 1);