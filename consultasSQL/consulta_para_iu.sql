select distinct iu_idiu, iu.nombre 
from(
	select funcion_idfuncion
	from(
		select user_rol.rol_idrol
		from user_rol, usuario
		where user_rol.usuario_iduser=3
	)uno, rol_funcion
	where uno.rol_idrol=rol_funcion.rol_idrol
)dos, funcion_iu, iu
where dos.funcion_idfuncion=funcion_iu.funcion_idfuncion and iu_idiu=iu.idiu;