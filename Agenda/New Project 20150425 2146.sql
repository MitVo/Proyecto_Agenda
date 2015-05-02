SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT;
SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS;
SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION;
SET NAMES utf8;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=NO_AUTO_VALUE_ON_ZERO */;


CREATE DATABASE /*!32312 IF NOT EXISTS*/ `agenda`;
USE `agenda`;
CREATE TABLE `persona` (
  `persona_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(65) NOT NULL,
  `apellido` varchar(65) NOT NULL,
  `mail` varchar(45) NOT NULL,
  PRIMARY KEY (`persona_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
INSERT INTO `persona` (`persona_id`,`nombre`,`apellido`,`mail`) VALUES (1,'Ali','Baba','alibaba@gmail.com'),(2,'Alexander','Bravo Martinez','alexb760@gmail.com');
CREATE TABLE `proyecto` (
  `proyecto_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(65) NOT NULL,
  `descripcion` longtext NOT NULL,
  PRIMARY KEY (`proyecto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
INSERT INTO `proyecto` (`proyecto_id`,`nombre`,`descripcion`) VALUES (1,'Hibernate','hibernate.com'),(2,'Hibernate 2.0','Loremzo ipzum hheuehueh heuheuheu ');
CREATE TABLE `tarea` (
  `tarea_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(65) NOT NULL,
  `descripcion` mediumtext NOT NULL,
  `fecha` date NOT NULL,
  `ejecucion` int(11) NOT NULL,
  `estado_tarea` tinyint(1) NOT NULL,
  `persona_id` int(11) NOT NULL,
  `proyecto_id` int(11) NOT NULL,
  PRIMARY KEY (`tarea_id`),
  KEY `fk_tarea_persona_idx` (`persona_id`),
  KEY `fk_tarea_proyecto1_idx` (`proyecto_id`),
  CONSTRAINT `fk_tarea_persona` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`persona_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarea_proyecto1` FOREIGN KEY (`proyecto_id`) REFERENCES `proyecto` (`proyecto_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
INSERT INTO `tarea` (`tarea_id`,`nombre`,`descripcion`,`fecha`,`ejecucion`,`estado_tarea`,`persona_id`,`proyecto_id`) VALUES (1,'exposicion de ali baba','Hablara de hibernet','2015-03-24',2,0,1,1),(2,'Ejercicio No1','Ejercicio desarrollo Con Hibernate','2015-04-19',0,1,2,2);
CREATE TABLE `notificacion` (
  `notificacion_id` int(11) NOT NULL,
  `tarea_tarea_id` int(11) NOT NULL,
  PRIMARY KEY (`notificacion_id`),
  KEY `fk_Notificacion_tarea1_idx` (`tarea_tarea_id`),
  CONSTRAINT `fk_Notificacion_tarea1` FOREIGN KEY (`tarea_tarea_id`) REFERENCES `tarea` (`tarea_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT;
SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS;
SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
