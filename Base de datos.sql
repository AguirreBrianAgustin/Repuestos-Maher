-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema repuestosmaher
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema repuestosmaher
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `repuestosmaher` DEFAULT CHARACTER SET latin1 ;
USE `repuestosmaher` ;

-- -----------------------------------------------------
-- Table `repuestosmaher`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repuestosmaher`.`categorias` (
  `idCategorias` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Estado` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCategorias`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `repuestosmaher`.`provincias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repuestosmaher`.`provincias` (
  `idProvincias` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idProvincias`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `repuestosmaher`.`localidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repuestosmaher`.`localidades` (
  `idLocalidades` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `provincias_idProvincias` INT(11) NOT NULL,
  PRIMARY KEY (`idLocalidades`),
  INDEX `fk_localidades_provincias1_idx` (`provincias_idProvincias` ASC),
  CONSTRAINT `fk_localidades_provincias1`
    FOREIGN KEY (`provincias_idProvincias`)
    REFERENCES `repuestosmaher`.`provincias` (`idProvincias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `repuestosmaher`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repuestosmaher`.`clientes` (
  `idclientes` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Telefono` VARCHAR(45) NULL DEFAULT NULL,
  `Direccion` VARCHAR(45) NULL DEFAULT NULL,
  `Mail` VARCHAR(45) NULL DEFAULT NULL,
  `DNI` INT NULL DEFAULT NULL,
  `Estado` VARCHAR(45) NULL DEFAULT NULL,
  `localidades_idLocalidades` INT(11) NOT NULL,
  PRIMARY KEY (`idclientes`),
  INDEX `fk_clientes_localidades1_idx` (`localidades_idLocalidades` ASC),
  CONSTRAINT `fk_clientes_localidades1`
    FOREIGN KEY (`localidades_idLocalidades`)
    REFERENCES `repuestosmaher`.`localidades` (`idLocalidades`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `repuestosmaher`.`facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repuestosmaher`.`facturas` (
  `idfacturas` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` VARCHAR(45) NULL DEFAULT NULL,
  `Total` FLOAT NULL DEFAULT NULL,
  `clientes_idclientes` INT(11) NOT NULL,
  PRIMARY KEY (`idfacturas`),
  INDEX `fk_facturas_clientes1` (`clientes_idclientes` ASC),
  CONSTRAINT `fk_facturas_clientes1`
    FOREIGN KEY (`clientes_idclientes`)
    REFERENCES `repuestosmaher`.`clientes` (`idclientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `repuestosmaher`.`proveedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repuestosmaher`.`proveedores` (
  `idProveedores` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Telefono` VARCHAR(45) NULL DEFAULT NULL,
  `Estado` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idProveedores`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `repuestosmaher`.`marcas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repuestosmaher`.`marcas` (
  `idmarcas` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `estado` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idmarcas`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `repuestosmaher`.`repuestos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repuestosmaher`.`repuestos` (
  `idRepuestos` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Descripcion` VARCHAR(45) NULL DEFAULT NULL,
  `Precio` FLOAT NULL DEFAULT NULL,
  `Stock` INT(11) NULL DEFAULT NULL,
  `Estado` VARCHAR(45) NULL DEFAULT NULL,
  `marcas_idmarcas` INT(11) NOT NULL,
  `Categorias_idCategorias` INT(11) NOT NULL,
  `Proveedores_idProveedores` INT(11) NOT NULL,
  PRIMARY KEY (`idRepuestos`),
  INDEX `fk_repuestos_marcas1` (`marcas_idmarcas` ASC),
  INDEX `fk_repuestos_Categorias1` (`Categorias_idCategorias` ASC),
  INDEX `fk_repuestos_Proveedores1` (`Proveedores_idProveedores` ASC),
  CONSTRAINT `fk_repuestos_Categorias1`
    FOREIGN KEY (`Categorias_idCategorias`)
    REFERENCES `repuestosmaher`.`categorias` (`idCategorias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_repuestos_Proveedores1`
    FOREIGN KEY (`Proveedores_idProveedores`)
    REFERENCES `repuestosmaher`.`proveedores` (`idProveedores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_repuestos_marcas1`
    FOREIGN KEY (`marcas_idmarcas`)
    REFERENCES `repuestosmaher`.`marcas` (`idmarcas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `repuestosmaher`.`detalle_facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repuestosmaher`.`detalle_facturas` (
  `iddetalle_facturas` INT(11) NOT NULL AUTO_INCREMENT,
  `cantidad` INT(11) NULL DEFAULT NULL,
  `precio` FLOAT NULL DEFAULT NULL,
  `repuestos_idRepuestos` INT(11) NOT NULL,
  `facturas_idfacturas` INT(11) NOT NULL,
  PRIMARY KEY (`iddetalle_facturas`),
  INDEX `fk_detalle_facturas_repuestos1` (`repuestos_idRepuestos` ASC),
  INDEX `fk_detalle_facturas_facturas1` (`facturas_idfacturas` ASC),
  CONSTRAINT `fk_detalle_facturas_facturas1`
    FOREIGN KEY (`facturas_idfacturas`)
    REFERENCES `repuestosmaher`.`facturas` (`idfacturas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_facturas_repuestos1`
    FOREIGN KEY (`repuestos_idRepuestos`)
    REFERENCES `repuestosmaher`.`repuestos` (`idRepuestos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `repuestosmaher`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `repuestosmaher`.`usuarios` (
  `idusuarios` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `permiso` VARCHAR(45) NULL DEFAULT NULL,
  `estado` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idusuarios`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO repuestosmaher.marcas (nombre, estado)
VALUES 
('Chevrolet', '1'),
('Ford', '1'),
('Nissan', '1'),
('Renault', '1'),
('Bugatti', '1'),
('Ferrari', '1'),
('Aston Martin', '1'),
('Pagani', '1'),
('Maybach', '1'),
('Koenigsegg', '1');


INSERT INTO repuestosmaher.proveedores (Nombre, Telefono, Estado)
VALUES 
('Fierros juan', '4985-6658','1'),
('Todo Rodado', '1154-6958','1'),
('Repuestos Libertador', '6492-2215','1'),
('Metatotal', '5412-6649','1'),
('Rulemanes Cazon', '2488-3131','1');

INSERT INTO repuestosmaher.categorias (Nombre, Estado)
VALUES
('32213', '1'),
('1114', '1'),
('1517', '1'),
('Sin categoria', '1');

INSERT INTO repuestosmaher.provincias (Nombre)
VALUES
('Buenos Aires'),
('Catamarca'),
('Chaco'),
('Chubut'),
('Córdoba'),
('Corrientes'),
('Entre Ríos'),
('Formosa'),
('Jujuy'),
('La Rioja'),
('Mendoza'),
('Misiones'),
('Neuquén'),
('Río Negro'),
('Salta'),
('San Juan'),
('San Luis'),
('Santa Cruz'),
('Santa Fe'),
('Santiago del Estero'),
('Tierra del Fuego'),
('Tucumán');

INSERT INTO repuestosmaher.localidades (Nombre, provincias_idProvincias)
VALUES
('Tigre', '1'),
('San Fernando', '1'),
('San isidro', '1'),
('Vicente Lopez', '1');

INSERT INTO repuestosmaher.repuestos (Nombre, Descripcion, Precio, Stock, Estado, marcas_idmarcas, Categorias_idCategorias, Proveedores_idProveedores)
VALUES
('Ruleman', 'Grande de rueda trasera', '1200','40','1','2','1','3'),
('Tuerca', 'Baja medida', '100','100','1','1','3','2'),
('Palier', 'Estriado', '8000','10','1','3','3','3');
