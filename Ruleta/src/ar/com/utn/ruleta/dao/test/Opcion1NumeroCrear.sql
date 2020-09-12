INSERT INTO ruleta.jugadores(JUG_NOMBRE,JUG_APELLIDO,JUG_ALIAS) VALUES("fer_test","diaz_test","ferdi");
INSERT INTO ruleta.apuestas(JUG_ID,APU_RONDA) VALUES((SELECT MAX(JUG_ID) from ruleta.jugadores),1);
-- Test Modificar
INSERT INTO ruleta.opciones_un_numero(OPUN_VALOR,APU_ID,OPUN_SALDO) VALUES(1,(SELECT MAX(APU_ID) from ruleta.apuestas),100);
-- Test Eliminar
INSERT INTO ruleta.opciones_un_numero(OPUN_VALOR,APU_ID,OPUN_SALDO) VALUES(2,(SELECT MAX(APU_ID) from ruleta.apuestas),50);