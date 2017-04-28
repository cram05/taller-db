INSERT INTO USUARIO VALUES (1, 'carlos', 'carlos');
INSERT INTO USUARIO VALUES (2, 'pedro', 'pedro');
INSERT INTO USUARIO VALUES (3, 'ana', 'ana');

insert into rol values (1,'secretaria');
insert into rol values (2,'caja');
insert into rol values (3,'cliente');

insert into user_rol values(3, 1, false);
insert into user_rol values(1, 3, false);
insert into user_rol values(2, 2, false);

insert into funcion values(1, 'add producto a carrito');
insert into funcion values(2, 'ver producto');
insert into funcion values(3, 'pagar compra');
insert into funcion values(4, 'emitir factura');
insert into funcion values(5, 'anadir producto a catalogo');
insert into funcion values(6, 'ver lista de venta');
insert into funcion values(7, 'eliminar producto del catalogo');
insert into funcion values(8, 'anadir producto de oferta');
insert into funcion values(9, 'eliminar producto de oferta');
insert into funcion values(10, 'ver detalles de compra');

insert into rol_funcion values (2, 4, false);
insert into rol_funcion values (2, 6, false);
insert into rol_funcion values (3, 1, false);
insert into rol_funcion values (3, 3, false);
insert into rol_funcion values (3, 10, false);
insert into rol_funcion values (3, 2, false);
insert into rol_funcion values (1, 5, false);
insert into rol_funcion values (1, 6, false);
insert into rol_funcion values (1, 7, false);
insert into rol_funcion values (1, 8, false);
insert into rol_funcion values (1, 9, false);

insert into iu values (1, 'ventana lista de venta');
insert into iu values (2, 'ventana productos');
insert into iu values (3, 'Ventana productos de oferta');
insert into iu values (4, 'ventana detalle de compra');
insert into iu values (5, 'Formularios de factura');
insert into iu values (6, 'Ventana actualizar productos');
insert into iu values (7, 'Ventana actualizar productos de oferta');
insert into iu values (9, 'Ventana productos musicas');
insert into iu values (10, 'Ventana productos libros');
insert into iu values (11, 'Ventana productos libros');

insert into funcion_iu values (1, 3, false);
insert into funcion_iu values (1, 9, false);
insert into funcion_iu values (1, 10, false);
insert into funcion_iu values (1, 11, false);
insert into funcion_iu values (2, 2, false);
insert into funcion_iu values (2, 3, false);
insert into funcion_iu values (2, 9, false);
insert into funcion_iu values (2, 10, false);
insert into funcion_iu values (2, 11, false);
insert into funcion_iu values (3, 4, false);
insert into funcion_iu values (4, 5, false);
insert into funcion_iu values (5, 6, false);
insert into funcion_iu values (6, 1, false);
insert into funcion_iu values (7, 6, false);
insert into funcion_iu values (8, 7, false);
insert into funcion_iu values (9, 7, false);
insert into funcion_iu values (10, 4, false);