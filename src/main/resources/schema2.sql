--CREATE DATABASE db1 /*!40100 DEFAULT CHARACTER SET utf8 */;
--CREATE DATABASE db2 /*!40100 DEFAULT CHARACTER SET utf8 */;

DROP TABLE IF EXISTS user2;
--CREATE TABLE user2 (
--  id int(11) NOT NULL auto_increment,
--  username varchar(100) NOT NULL default '',
--  email varchar(100) NOT NULL default '',
--  PRIMARY KEY(id)
--) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
CREATE TABLE user2 (
  id INTEGER NOT NULL PRIMARY KEY,
  username VARCHAR(100) NOT NULL default '',
  email  VARCHAR(100) NOT NULL default '',
   PRIMARY KEY  (id)
);