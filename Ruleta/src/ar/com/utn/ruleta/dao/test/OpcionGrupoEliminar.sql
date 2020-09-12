delete  from ruleta.opcion_grupo where apu_id = (select apu_id from ruleta.apuestas where jug_id = (SELECT jug_id FROM ruleta.jugadores where jug_nombre ='Lucas_test'));
delete  from ruleta.apuestas where jug_id = (SELECT jug_id FROM ruleta.jugadores where jug_nombre ='Lucas_test');
delete FROM ruleta.jugadores where jug_nombre like '%_test';