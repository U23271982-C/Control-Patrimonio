CREATE DATABASE IF NOT EXISTS BDPatrimonioU;
USE BDPatrimonioU;

-- Tabla Rol_Responsable
CREATE TABLE Rol_Responsable(
    idRol_Responsable INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(80),
    nombrerol VARCHAR(80)
);

-- Tabla Responsable
CREATE TABLE Responsable(
    idResponsable INT AUTO_INCREMENT PRIMARY KEY,
    idRol_Responsable INT NOT NULL,
    nombre VARCHAR(30),
    dni VARCHAR(12),
    mail VARCHAR(30),
    usuario VARCHAR(30),
    contrasena VARBINARY(255)
);

-- Tabla Inventario
CREATE TABLE Inventario(
    idInventario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    fechainicio DATETIME NOT NULL,
    fechafin DATETIME NOT NULL
);

-- Tabla Inmueble
CREATE TABLE Inmueble(
    idInmueble INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) NOT NULL
);

-- Tabla Ambiente
CREATE TABLE Ambiente(
    idAmbiente INT AUTO_INCREMENT PRIMARY KEY,
    idInmueble INT NOT NULL,
    nombre VARCHAR(40) NOT NULL
);

-- Tabla Estado
CREATE TABLE Estado(
    idEstado INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(30) NOT NULL
);

-- Tabla Categoria
CREATE TABLE Categoria(
    idCategoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    descripcion VARCHAR(60) NOT NULL
);

-- Tabla Bien
CREATE TABLE Bien(
    idBien INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) NULL,
    fecharegistro DATE NOT NULL,
    idEstadoActual INT,
    idCategoria INT,
    idAmbiente INT,
    idResponsableActual INT
);

-- Tabla Detalle_Inventario
CREATE TABLE Detalle_Inventario(
    idDetalle_Inventario INT AUTO_INCREMENT PRIMARY KEY,
    idBien INT NOT NULL,
    idInventario INT NOT NULL
);

-- Tabla Asignacion
CREATE TABLE Asignacion(
    idAsignacion INT AUTO_INCREMENT PRIMARY KEY,
    idBien INT NOT NULL,
    idResponsable INT NOT NULL,
    fechainicio DATE NOT NULL,
    fechafin DATE NULL
);

-- Tabla Rotacion
CREATE TABLE Rotacion(
    idRotacion INT AUTO_INCREMENT PRIMARY KEY,
    idBien INT NOT NULL,
    idAmbiente INT NOT NULL,
    motivo VARCHAR(30) NOT NULL,
    idResponsable INT NOT NULL
);

-- Tabla HistorialEstado
CREATE TABLE HistorialEstado(
    idHistorialEstado INT AUTO_INCREMENT PRIMARY KEY,
    idBien INT,
    idEstado INT,
    idResponsable INT,
    motivo VARCHAR(30) NULL,
    fechaCambio DATE NOT NULL
);




-- ===========================================================================================================
-- ========================== CREACIÓN DE RELACIONES (FOREIGN KEYS) ==========================================
-- ===========================================================================================================

-- Responsable 1-1 Rol
ALTER TABLE Responsable
ADD CONSTRAINT fk_Responsable_Rol FOREIGN KEY (idRol_Responsable) REFERENCES Rol_Responsable(idRol_Responsable);

-- Relaciones de la tabla Ambiente
ALTER TABLE Ambiente
ADD CONSTRAINT fk_Ambiente_Inmueble FOREIGN KEY (idInmueble) REFERENCES Inmueble(idInmueble);

-- Relaciones de la tabla Bien
ALTER TABLE Bien
ADD CONSTRAINT fk_Bien_Estado FOREIGN KEY (idEstadoActual) REFERENCES Estado(idEstado),
ADD CONSTRAINT fk_Bien_Categoria FOREIGN KEY (idCategoria) REFERENCES Categoria(idCategoria),
ADD CONSTRAINT fk_Bien_Ambiente FOREIGN KEY (idAmbiente) REFERENCES Ambiente(idAmbiente),
ADD CONSTRAINT fk_Bien_Responsable FOREIGN KEY (idResponsableActual) REFERENCES Responsable(idResponsable);

-- Relaciones de Detalle_Inventario
ALTER TABLE Detalle_Inventario
ADD CONSTRAINT fk_DetalleInventario_Bien FOREIGN KEY (idBien) REFERENCES Bien(idBien),
ADD CONSTRAINT fk_DetalleInventario_Inventario FOREIGN KEY (idInventario) REFERENCES Inventario(idInventario);

-- Relaciones de Asignacion
ALTER TABLE Asignacion
ADD CONSTRAINT fk_Asignacion_Bien FOREIGN KEY (idBien) REFERENCES Bien(idBien),
ADD CONSTRAINT fk_Asignacion_Responsable FOREIGN KEY (idResponsable) REFERENCES Responsable(idResponsable);

-- Relaciones de Rotacion
ALTER TABLE Rotacion
ADD CONSTRAINT fk_Rotacion_Bien FOREIGN KEY (idBien) REFERENCES Bien(idBien),
ADD CONSTRAINT fk_Rotacion_Ambiente FOREIGN KEY (idAmbiente) REFERENCES Ambiente(idAmbiente),
ADD CONSTRAINT fk_Rotacion_Responsable FOREIGN KEY (idResponsable) REFERENCES Responsable(idResponsable);

-- Relaciones de HistorialEstado
ALTER TABLE HistorialEstado
ADD CONSTRAINT fk_HistorialEstado_Bien FOREIGN KEY (idBien) REFERENCES Bien(idBien),
ADD CONSTRAINT fk_HistorialEstado_Estado FOREIGN KEY (idEstado) REFERENCES Estado(idEstado),
ADD CONSTRAINT fk_HistorialEstado_Responsable FOREIGN KEY (idResponsable) REFERENCES Responsable(idResponsable);
