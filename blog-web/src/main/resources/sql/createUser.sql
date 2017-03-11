CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `code` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_code` (`code`),
  UNIQUE KEY `index_email` (`email`),
  KEY `index_mobile` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
