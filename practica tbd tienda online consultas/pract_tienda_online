CREATE TABLE Cliente (
  idCliente INT NOT NULL,
  nombre VARCHAR(30) NULL,
  apellido VARCHAR(30) NULL,
  PRIMARY KEY(idCliente)
);

CREATE TABLE Categoria (
  idCat INT NOT NULL,
  nom_cat VARCHAR(20) NULL,
  PRIMARY KEY(idCat)
);

CREATE TABLE Tipo_oferta (
  idTipo_oferta INT NOT NULL,
  descripcion VARCHAR NULL,
  PRIMARY KEY(idTipo_oferta)
);

CREATE TABLE Extension (
  nom_ext VARCHAR(5) NOT NULL,
  Categoria_idCat INT NOT NULL,
  PRIMARY KEY(nom_ext),
  FOREIGN KEY(Categoria_idCat)
    REFERENCES Categoria(idCat)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Carrito (
  idCarrito INT NOT NULL,
  Cliente_idCliente INT NOT NULL,
  PRIMARY KEY(idCarrito, Cliente_idCliente),
  FOREIGN KEY(Cliente_idCliente)
    REFERENCES Cliente(idCliente)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Producto (
  id_prod INT NOT NULL,
  Extension_nom_ext VARCHAR(5) NOT NULL,
  nombre VARCHAR(30) NULL,
  f_creac DATE NULL,
  tam INT NULL,
  PRIMARY KEY(id_prod),
  FOREIGN KEY(Extension_nom_ext)
    REFERENCES Extension(nom_ext)
      ON DELETE SET NULL
      ON UPDATE CASCADE
);

CREATE TABLE Factura (
  idFactura INT NOT NULL,
  Carrito_idCarrito INT NOT NULL,
  Carrito_Cliente_idCliente INT NOT NULL,
  nit_ci INT NULL,
  PRIMARY KEY(idFactura, Carrito_idCarrito, Carrito_Cliente_idCliente),
  FOREIGN KEY(Carrito_idCarrito, Carrito_Cliente_idCliente)
    REFERENCES Carrito(idCarrito, Cliente_idCliente)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Pedido (
  idPedido INT NOT NULL,
  Producto_id_prod INT NOT NULL,
  Carrito_Cliente_idCliente INT NOT NULL,
  Carrito_idCarrito INT NOT NULL,
  Fecha DATE NULL,
  PRIMARY KEY(idPedido, Producto_id_prod, Carrito_Cliente_idCliente, Carrito_idCarrito),
  FOREIGN KEY(Producto_id_prod)
    REFERENCES Producto(id_prod)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Carrito_idCarrito, Carrito_Cliente_idCliente)
    REFERENCES Carrito(idCarrito, Cliente_idCliente)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Precio_det (
  Pedido_idPedido INT NOT NULL,
  Pedido_Producto_id_prod INT NOT NULL,
  Pedido_Carrito_idCarrito INT NOT NULL,
  Pedido_Carrito_Cliente_idCliente INT NOT NULL,
  Tipo_oferta_idTipo_oferta INT NOT NULL,
  precio FLOAT NOT NULL,
  PRIMARY KEY(Pedido_idPedido, Pedido_Producto_id_prod, Pedido_Carrito_idCarrito, Pedido_Carrito_Cliente_idCliente),
  FOREIGN KEY(Pedido_idPedido, Pedido_Producto_id_prod, Pedido_Carrito_Cliente_idCliente, Pedido_Carrito_idCarrito)
    REFERENCES Pedido(idPedido, Producto_id_prod, Carrito_Cliente_idCliente, Carrito_idCarrito)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Tipo_oferta_idTipo_oferta)
    REFERENCES Tipo_oferta(idTipo_oferta)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


