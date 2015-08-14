
CREATE DATABASE IF NOT EXISTS travelEu;
use travelEu;

CREATE TABLE `Country` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL UNIQUE,
  `permalink` varchar(50) NOT NULL UNIQUE,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `City` (
   `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL UNIQUE,
  `permalink` varchar(50) NOT NULL UNIQUE,
  `description` text NOT NULL,
  `country_id` int(10) NOT NULL,
   PRIMARY KEY (`id`),
   CONSTRAINT `city_fk_country` FOREIGN KEY (`country_id`) REFERENCES `Country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `Attraction` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL UNIQUE,
  `permalink` varchar(50) NOT NULL UNIQUE,
  `description` text NOT NULL,
  `address` varchar(200),
  `phone` varchar(50),
  `email` varchar(50),
  `website` varchar(100),
  `hours` varchar(100),
  `travelInstructions` text,  
  `siteRating` int(1),
  `tips` text,
  `city_id` int(10) NOT NULL,
   PRIMARY KEY (`id`),
   CONSTRAINT `attraction_fk_city` FOREIGN KEY (`city_id`) REFERENCES `City` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE Attraction MODIFY siteRating float(2,1);
--ALTER TABLE Country ADD UNIQUE (name);


--syntax for renaming column constraint type
--ALTER TABLE Country MODIFY description text NOT NULL;

--syntax for adding new column
--ALTER TABLE table_name MODIFY COLUMN column_name datatype

CREATE TABLE `Category` (
    `id` int(10) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL UNIQUE,
    `permalink` varchar(50) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 
CREATE TABLE `Attraction_Category` (
    `attraction_id` int(10) NOT NULL,
    `category_id` int(10) NOT NULL,
    PRIMARY KEY (`attraction_id`, `category_id`),
    INDEX `FK_CATEGORY` (`category_id`),
    CONSTRAINT `FK_ATTRACTION` FOREIGN KEY (`attraction_id`) REFERENCES `Attraction` (`id`),
    CONSTRAINT `FK_CATEGORY` FOREIGN KEY (`category_id`) REFERENCES `Category` (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


