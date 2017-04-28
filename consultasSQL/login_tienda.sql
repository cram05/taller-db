CREATE TABLE IU (
  idIU INT NOT NULL,
  nombre VARCHAR NULL,
  PRIMARY KEY(idIU)
);

CREATE TABLE Rol (
  idRol INT NOT NULL,
  nombre VARCHAR NULL,
  PRIMARY KEY(idRol)
);

CREATE TABLE Funcion (
  idFuncion INT NOT NULL,
  nombre VARCHAR NULL,
  PRIMARY KEY(idFuncion)
);

CREATE TABLE Usuario (
  idUser INT NOT NULL,
  nombre VARCHAR NOT NULL,
  contrasena VARCHAR(10) NOT NULL,
  activo BOOL NULL,
  PRIMARY KEY(idUser)
);

CREATE TABLE Sesion (
  idSesion SERIAL NOT NULL,
  Usuario_idUser INT NOT NULL,
  PID INT NOT NULL,
  fec_ini DATE NULL,
  fec_fin DATE NULL,
  activo BOOL NULL,
  PRIMARY KEY(idSesion, Usuario_idUser),
  FOREIGN KEY(Usuario_idUser)
    REFERENCES Usuario(idUser)
      ON DELETE SET NULL
      ON UPDATE CASCADE
);

CREATE TABLE Tipo_IU (
  idTipo_IU INT NOT NULL,
  IU_idIU INT NOT NULL,
  PRIMARY KEY(idTipo_IU, IU_idIU),
  FOREIGN KEY(IU_idIU)
    REFERENCES IU(idIU)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE User_Rol (
  Usuario_idUser INT NOT NULL,
  Rol_idRol INT NOT NULL,
  activo BOOL NULL,
  PRIMARY KEY(Usuario_idUser, Rol_idRol),
  FOREIGN KEY(Usuario_idUser)
    REFERENCES Usuario(idUser)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Rol_idRol)
    REFERENCES Rol(idRol)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Funcion_Rol (
  Funcion_idFuncion INT NOT NULL,
  IU_idIU INT NOT NULL,
  Activo BOOL NULL,
  PRIMARY KEY(Funcion_idFuncion, IU_idIU),
  FOREIGN KEY(Funcion_idFuncion)
    REFERENCES Funcion(idFuncion)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(IU_idIU)
    REFERENCES IU(idIU)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Rol_Funcion (
  Rol_idRol INT NOT NULL,
  Funcion_idFuncion INT NOT NULL,
  activo BOOL NULL,
  PRIMARY KEY(Rol_idRol, Funcion_idFuncion),
  FOREIGN KEY(Rol_idRol)
    REFERENCES Rol(idRol)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Funcion_idFuncion)
    REFERENCES Funcion(idFuncion)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


