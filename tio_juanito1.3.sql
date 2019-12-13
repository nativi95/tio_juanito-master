create database if not exists tio_juanito;

use tio_juanito;


CREATE TABLE IF NOT EXISTS `tio_juanito`.`usuarios` (
  `id_usuario` VARCHAR(50) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `clave` VARCHAR(500) NOT NULL,
  `rol` INT(11) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `tio_juanito`.`administradores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`administradores` (
  `id_admin` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NOT NULL,
  `apellido` VARCHAR(150) NOT NULL,
  `dui` VARCHAR(10) NOT NULL,
  `id_usuario` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_admin`),
  INDEX `id_usuario` (`id_usuario` ASC),
  CONSTRAINT `administradores_ibfk_1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `tio_juanito`.`usuarios` (`id_usuario`)
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tio_juanito`.`contratos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`contratos` (
  `id_contrato` INT(11) NOT NULL AUTO_INCREMENT,
  `tarifa` DOUBLE(7,2) NOT NULL,
  `periodo` INT(11) NOT NULL,
  PRIMARY KEY (`id_contrato`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `tio_juanito`.`apoderados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`apoderados` (
  `id_apoderado` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NOT NULL,
  `apellido` VARCHAR(150) NOT NULL,
  `dui` VARCHAR(10) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `id_usuario` VARCHAR(50) NOT NULL,
  `id_contrato` INT(11) NOT NULL,
  PRIMARY KEY (`id_apoderado`),
  INDEX `id_contrato` (`id_contrato` ASC),
  INDEX `id_usuario` (`id_usuario` ASC),
  CONSTRAINT `apoderados_ibfk_1`
    FOREIGN KEY (`id_contrato`)
    REFERENCES `tio_juanito`.`contratos` (`id_contrato`)
    ON UPDATE CASCADE,
  CONSTRAINT `apoderados_ibfk_2`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `tio_juanito`.`usuarios` (`id_usuario`)
    ON UPDATE CASCADE)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `tio_juanito`.`asistentes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`asistentes` (
  `id_asistente` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NOT NULL,
  `apellido` VARCHAR(150) NOT NULL,
  `dui` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_asistente`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `tio_juanito`.`barrios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`barrios` (
  `id_barrio` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_barrio`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `tio_juanito`.`choferes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`choferes` (
  `id_chofer` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NOT NULL,
  `apellido` VARCHAR(150) NOT NULL,
  `dui` VARCHAR(10) NOT NULL,
  `licencia` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_chofer`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `tio_juanito`.`colegios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`colegios` (
  `id_colegio` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NOT NULL,
  `direcion` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id_colegio`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `tio_juanito`.`minibuses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`minibuses` (
  `id_bus` INT(11) NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(10) NOT NULL,
  `marca` VARCHAR(100) NOT NULL,
  `modelo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_bus`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `tio_juanito`.`equipos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`equipos` (
  `id_equipo` INT(11) NOT NULL AUTO_INCREMENT,
  `id_bus` INT(11) NOT NULL,
  `id_chofer` INT(11) NOT NULL,
  `id_asistente` INT(11) NOT NULL,
  PRIMARY KEY (`id_equipo`),
  INDEX `id_asistente` (`id_asistente` ASC),
  INDEX `id_chofer` (`id_chofer` ASC),
  INDEX `id_bus` (`id_bus` ASC),
  CONSTRAINT `equipos_ibfk_1`
    FOREIGN KEY (`id_asistente`)
    REFERENCES `tio_juanito`.`asistentes` (`id_asistente`)
    ON UPDATE CASCADE,
  CONSTRAINT `equipos_ibfk_2`
    FOREIGN KEY (`id_chofer`)
    REFERENCES `tio_juanito`.`choferes` (`id_chofer`)
    ON UPDATE CASCADE,
  CONSTRAINT `equipos_ibfk_3`
    FOREIGN KEY (`id_bus`)
    REFERENCES `tio_juanito`.`minibuses` (`id_bus`)
    ON UPDATE CASCADE)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `tio_juanito`.`ninos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`ninos` (
  `id_nino` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NOT NULL,
  `apellido` VARCHAR(150) NOT NULL,
  `disponibilidad` TINYINT(1) NOT NULL,
  `direcion` VARCHAR(150) NULL DEFAULT NULL,
  `salida` TIME NULL DEFAULT NULL,
  `llegada` TIME NULL DEFAULT NULL,
  `id_apoderado` INT(11) NOT NULL,
  PRIMARY KEY (`id_nino`),
  INDEX `id_apoderado` (`id_apoderado` ASC),
  CONSTRAINT `ninos_ibfk_1`
    FOREIGN KEY (`id_apoderado`)
    REFERENCES `tio_juanito`.`apoderados` (`id_apoderado`)
    ON UPDATE CASCADE)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `tio_juanito`.`modalidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`modalidades` (
  `id_modalidad` INT(11) NOT NULL AUTO_INCREMENT,
  `modalidad` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_modalidad`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `tio_juanito`.`recorridos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`recorridos` (
  `id_recorrido` INT(11) NOT NULL AUTO_INCREMENT,
  `id_modalidad` INT(11) NOT NULL,
  `id_barrio` INT(11) NOT NULL,
  `id_colegio` INT(11) NOT NULL,
  `id_equipo` INT(11) NOT NULL,
  PRIMARY KEY (`id_recorrido`),
  INDEX `id_equipo` (`id_equipo` ASC),
  INDEX `id_modalidad` (`id_modalidad` ASC),
  INDEX `id_barrio` (`id_barrio` ASC),
  INDEX `id_colegio` (`id_colegio` ASC),
  CONSTRAINT `recorridos_ibfk_1`
    FOREIGN KEY (`id_equipo`)
    REFERENCES `tio_juanito`.`equipos` (`id_equipo`)
    ON UPDATE CASCADE,
  CONSTRAINT `recorridos_ibfk_2`
    FOREIGN KEY (`id_modalidad`)
    REFERENCES `tio_juanito`.`modalidades` (`id_modalidad`)
    ON UPDATE CASCADE,
  CONSTRAINT `recorridos_ibfk_3`
    FOREIGN KEY (`id_barrio`)
    REFERENCES `tio_juanito`.`barrios` (`id_barrio`)
    ON UPDATE CASCADE,
  CONSTRAINT `recorridos_ibfk_4`
    FOREIGN KEY (`id_colegio`)
    REFERENCES `tio_juanito`.`colegios` (`id_colegio`)
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tio_juanito`.`espacios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`espacios` (
  `id_recorrido` INT(11) NOT NULL,
  `id_nino` INT(11) NOT NULL,
  INDEX `id_nino` (`id_nino` ASC),
  INDEX `id_recorrido` (`id_recorrido` ASC),
  CONSTRAINT `espacios_ibfk_1`
    FOREIGN KEY (`id_nino`)
    REFERENCES `tio_juanito`.`ninos` (`id_nino`)
    ON UPDATE CASCADE,
  CONSTRAINT `espacios_ibfk_2`
    FOREIGN KEY (`id_recorrido`)
    REFERENCES `tio_juanito`.`recorridos` (`id_recorrido`)
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tio_juanito`.`registros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tio_juanito`.`registros` (
  `id_registro` INT(11) NOT NULL AUTO_INCREMENT,
  `id_recorrido` INT(11) NOT NULL,
  `fecha` DATE NOT NULL,
  `hora_salida` TIME NOT NULL,
  `hora_llegada` TIME NOT NULL,
  `km_salida` DOUBLE NOT NULL,
  `km_llegada` DOUBLE NOT NULL,
  `comentarios` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id_registro`),
  INDEX `id_recorrido` (`id_recorrido` ASC),
  CONSTRAINT `registros_ibfk_1`
    FOREIGN KEY (`id_recorrido`)
    REFERENCES `tio_juanito`.`recorridos` (`id_recorrido`)
    ON UPDATE CASCADE)
ENGINE = InnoDB;
