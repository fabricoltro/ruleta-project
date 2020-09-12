delete from ruleta.opciones_un_numero where APU_ID=(select APU_ID from ruleta.apuestas where jug_id=(select JUG_ID FROM ruleta.jugadores where jug_nombre like "%test"));
delete from ruleta.apuestas where JUG_ID=(select JUG_ID from ruleta.jugadores WHERE jug_nombre like "%test");
delete from ruleta.jugadores where jug_nombre like "%test";