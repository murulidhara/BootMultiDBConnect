--CREATE DATABASE db1 /*!40100 DEFAULT CHARACTER SET utf8 */;
--CREATE DATABASE db2 /*!40100 DEFAULT CHARACTER SET utf8 */;

DROP TABLE IF EXISTS user1;
--CREATE TABLE user1 (
--  id int(11) NOT NULL auto_increment,
--  username varchar(100) NOT NULL default '',
--  email varchar(100) NOT NULL default '',
--  PRIMARY KEY  (id)
--) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
CREATE TABLE user1 (
  id INTEGER NOT NULL PRIMARY KEY,
  username VARCHAR(100) NOT NULL default '',
  email  VARCHAR(100) NOT NULL default '',
   PRIMARY KEY  (id)
);