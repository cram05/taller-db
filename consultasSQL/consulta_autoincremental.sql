--insert into sesion values (DEFAULT, 2, 2131, '01/01/2017',NULL,TRUE);
--SELECT currval(pg_get_serial_sequence('SESION', 'idsesion'));
select * from sesion, usuario where iduser=usuario_iduser;