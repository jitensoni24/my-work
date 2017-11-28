-- OAuth Details
INSERT IGNORE INTO `oauth_client_details` VALUES ('qms-console', NULL,'eyk5h94c5x', 'read,write', 'password,refresh_token', NULL, NULL, 43200, 43200, NULL, NULL);
INSERT IGNORE INTO `oauth_client_details` VALUES ('swagger-ui', NULL, 'ak8HPbLE3w', 'read,write', 'password,refresh_token', NULL, NULL, 43200, 43200, NULL, NULL);

-- Default Users
INSERT INTO `user` (`id`, `password`, `username`)
VALUES
	(1, '624C76F1BFE236A40748D05FFCE4407DDEAFCF885E37D81E21B9FE921CFF67D1', 'superuser'),
	(2, '8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918', 'admin'),
	(3, '04F8996DA763B7A969B1028EE3007569EAF3A635486DDAB211D512C85B9DF8FB', 'user');

-- User Roles
INSERT INTO `user_role` (`user_id`, `role`)
VALUES
  (1, 'SUPERADMIN'),
  (2, 'ADMIN'),
  (3, 'USER');
