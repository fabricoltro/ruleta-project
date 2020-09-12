INSERT INTO ruleta.jugadores (JUG_NOMBRE,JUG_APELLIDO,JUG_ALIAS) VALUES('Matias_test','Nahuel','asd');
INSERT INTO ruleta.apuestas(JUG_ID,APU_RONDA) VALUES((select jug_id from ruleta.jugadores where jug_nombre='Matias_test'),2); 
-- Eliminar
INSERT INTO ruleta.opciones_cuatro_numeros(OPCUA_VALOR1,OPCUA_VALOR2,OPCUA_VALOR3,OPCUA_VALOR4,APU_ID) VALUES(1,2,4,5,(SELECT MAX(APU_ID) from ruleta.apuestas)); 
-- Modificar
INSERT INTO ruleta.opciones_cuatro_numeros(OPCUA_VALOR1,OPCUA_VALOR2,OPCUA_VALOR3,OPCUA_VALOR4,APU_ID) VALUES(1,2,4,5,(SELECT MAX(APU_ID) from ruleta.apuestas));
--
INSERT INTO ruleta.opciones_cuatro_numeros(OPCUA_VALOR1,OPCUA_VALOR2,OPCUA_VALOR3,OPCUA_VALOR4,APU_ID) VALUES(1,2,4,5,(SELECT MAX(APU_ID) from ruleta.apuestas));
INSERT INTO ruleta.opciones_cuatro_numeros(OPCUA_VALOR1,OPCUA_VALOR2,OPCUA_VALOR3,OPCUA_VALOR4,APU_ID) VALUES(1,2,4,5,(SELECT MAX(APU_ID) from ruleta.apuestas));
INSERT INTO ruleta.opciones_cuatro_numeros(OPCUA_VALOR1,OPCUA_VALOR2,OPCUA_VALOR3,OPCUA_VALOR4,APU_ID) VALUES(1,2,4,5,(SELECT MAX(APU_ID) from ruleta.apuestas));