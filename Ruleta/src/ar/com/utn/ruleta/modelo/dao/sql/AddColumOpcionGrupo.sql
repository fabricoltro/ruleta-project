-- agrega un campo
ALTER TABLE `ruleta`.`opcion_grupo`
ADD COLUMN `APU_ID` INTEGER UNSIGNED NOT NULL
AFTER `OPG_ID`;
-- agrega el fk con apuestas
ALTER TABLE `ruleta`.`opcion_grupo` ADD CONSTRAINT `FK_opcion_grupo_apuesta` FOREIGN KEY `FK_opcion_grupo_apuesta` (`APU_ID`)
    REFERENCES `apuestas` (`APU_ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT;