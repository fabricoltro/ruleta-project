-- primero elimino las opciones de 2 numeros
delete  from ruleta.opciones_dos_numeros where apu_id = (select apu_id from ruleta.apuestas where jug_id = (SELECT jug_id FROM ruleta.jugadores where jug_nombre ='Fernando_test'))
-- luego las apuestas
delete  from ruleta.apuestas where jug_id = (SELECT jug_id FROM ruleta.jugadores where jug_nombre ='Fernando_test')
-- y por ultimo el jugador
delete FROM ruleta.jugadores where jug_nombre ='Fernando_test'