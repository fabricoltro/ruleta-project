INSERT INTO ruleta.jugadores (JUG_NOMBRE,JUG_APELLIDO,JUG_ALIAS) VALUES('Fernando_test','Diaz','asd')
INSERT INTO ruleta.apuestas(JUG_ID,APU_RONDA) VALUES((select jug_id from ruleta.jugadores where jug_nombre='Fernando_test'),2) 
-- Eliminar
INSERT INTO ruleta.opciones_dos_numeros(COMB2_ID,APU_ID,OPD_SALDO) VALUES((SELECT COMB2_ID FROM ruleta.COMBINACIONES2NUMEROS WHERE COMB2_VALOR1=1 AND COMB2_VALOR2=2),(SELECT MAX(APU_ID) from ruleta.apuestas), 50) 
-- Modificar
INSERT INTO ruleta.opciones_dos_numeros(COMB2_ID,APU_ID,OPD_SALDO) VALUES((SELECT COMB2_ID FROM ruleta.COMBINACIONES2NUMEROS WHERE COMB2_VALOR1=2 AND COMB2_VALOR2=3),(SELECT MAX(APU_ID) from ruleta.apuestas), 100)
-- leer por codigo
INSERT INTO ruleta.opciones_dos_numeros(COMB2_ID,APU_ID,OPD_SALDO) VALUES((SELECT COMB2_ID FROM ruleta.COMBINACIONES2NUMEROS WHERE COMB2_VALOR1=16 AND COMB2_VALOR2=19),(SELECT MAX(APU_ID) from ruleta.apuestas), 150)
-- leer por otro parametro
INSERT INTO ruleta.opciones_dos_numeros(COMB2_ID,APU_ID,OPD_SALDO) VALUES((SELECT COMB2_ID FROM ruleta.COMBINACIONES2NUMEROS WHERE COMB2_VALOR1=26 AND COMB2_VALOR2=27),(SELECT MAX(APU_ID) from ruleta.apuestas), 30)