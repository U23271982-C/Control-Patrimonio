USE BDPatrimonioU;
DELIMITER //

-- =============================================
--         PROCEDIMIENTOS CREATE
-- =============================================

-- 1. Procedimientos para Rol_Responsable
CREATE PROCEDURE pa_Registrar_Rol_Responsable(
    IN p_descripcion VARCHAR(80),
    IN p_nombrerol VARCHAR(80))
BEGIN
INSERT INTO Rol_Responsable(descripcion, nombrerol)
VALUES(p_descripcion, p_nombrerol);
END //

-- 2. Procedimientos para Responsable
CREATE PROCEDURE pa_Registrar_Responsable(
    IN p_idResponsable INT,
    IN p_nombre VARCHAR(30),
    IN p_dni VARCHAR(12),
    IN p_mail VARCHAR(30),
    IN p_usuario VARCHAR(30),
    IN p_contraseña VARCHAR(30),
    IN p_cargo VARCHAR(30))
BEGIN
INSERT INTO Responsable(idResponsable, nombre, dni, mail, usuario, contraseña, cargo)
VALUES(p_idResponsable, p_nombre, p_dni, p_mail, p_usuario, p_contraseña, p_cargo);
END //

-- 3. Procedimientos para Inventario
CREATE PROCEDURE pa_Registrar_Inventario(
    IN p_nombre VARCHAR(50),
    IN p_descripcion VARCHAR(50),
    IN p_fechainicio DATETIME,
    IN p_fechafin DATETIME)
BEGIN
INSERT INTO Inventario(nombre, descripcion, fechainicio, fechafin)
VALUES(p_nombre, p_descripcion, p_fechainicio, p_fechafin);
END //

-- 4. Procedimientos para Inmueble
CREATE PROCEDURE pa_Registrar_Inmueble(
    IN p_nombre VARCHAR(50),
    IN p_descripcion VARCHAR(50))
BEGIN
INSERT INTO Inmueble(nombre, descripcion)
VALUES(p_nombre, p_descripcion);
END //

-- 5. Procedimientos para Ambiente
CREATE PROCEDURE pa_Registrar_Ambiente(
    IN p_idInmueble INT,
    IN p_nombre VARCHAR(40))
BEGIN
INSERT INTO Ambiente(idInmueble, nombre)
VALUES(p_idInmueble, p_nombre);
END //

-- 6. Procedimientos para Estado
CREATE PROCEDURE pa_Registrar_Estado(
    IN p_tipo VARCHAR(30))
BEGIN
INSERT INTO Estado(tipo)
VALUES(p_tipo);
END //

-- 7. Procedimientos para Categoria
CREATE PROCEDURE pa_Registrar_Categoria(
    IN p_nombre VARCHAR(60),
    IN p_descripcion VARCHAR(60))
BEGIN
INSERT INTO Categoria(nombre, descripcion)
VALUES(p_nombre, p_descripcion);
END //

-- 8. Procedimientos para Bien
CREATE PROCEDURE pa_Registrar_Bien(
    IN p_nombre VARCHAR(50),
    IN p_descripcion VARCHAR(50),
    IN p_fecharegistro DATE,
    IN p_idEstadoActual INT,
    IN p_idCategoria INT,
    IN p_idAmbiente INT,
    IN p_idResponsableActual INT)
BEGIN
INSERT INTO Bien(nombre, descripcion, fecharegistro, idEstadoActual, idCategoria, idAmbiente, idResponsableActual)
VALUES(p_nombre, p_descripcion, p_fecharegistro, p_idEstadoActual, p_idCategoria, p_idAmbiente, p_idResponsableActual);
END //

-- 9. Procedimientos para Detalle_Inventario
CREATE PROCEDURE pa_Registrar_Detalle_Inventario(
    IN p_idBien INT,
    IN p_idInventario INT)
BEGIN
INSERT INTO Detalle_Inventario(idBien, idInventario)
VALUES(p_idBien, p_idInventario);
END //

-- 10. Procedimientos para Asignacion
CREATE PROCEDURE pa_Registrar_Asignacion(
    IN p_idBien INT,
    IN p_idResponsable INT,
    IN p_fechainicio DATE,
    IN p_fechafin DATE)
BEGIN
INSERT INTO Asignacion(idBien, idResponsable, fechainicio, fechafin)
VALUES(p_idBien, p_idResponsable, p_fechainicio, p_fechafin);
END //

-- 11. Procedimientos para Rotacion
CREATE PROCEDURE pa_Registrar_Rotacion(
    IN p_idBien INT,
    IN p_idAmbiente INT,
    IN p_motivo VARCHAR(30),
    IN p_idResponsable INT)
BEGIN
INSERT INTO Rotacion(idBien, idAmbiente, motivo, idResponsable)
VALUES(p_idBien, p_idAmbiente, p_motivo, p_idResponsable);
END //

-- 12. Procedimientos para HistorialEstado
CREATE PROCEDURE pa_Registrar_HistorialEstado(
    IN p_idBien INT,
    IN p_idEstado INT,
    IN p_idResponsable INT,
    IN p_motivo VARCHAR(30),
    IN p_fechaCambio DATE)
BEGIN
INSERT INTO HistorialEstado(idBien, idEstado, idResponsable, motivo, fechaCambio)
VALUES(p_idBien, p_idEstado, p_idResponsable, p_motivo, p_fechaCambio);
END //

-- =========================================
--          PROCEDIMIENTOS READ
-- =========================================

-- 1. Procedimientos para Rol_Responsable
CREATE PROCEDURE pa_Leer_Rol_Responsable(
    IN p_idRol_Responsable INT)
BEGIN
    IF p_idRol_Responsable IS NOT NULL THEN
        (SELECT *, 1 AS orden FROM Rol_Responsable WHERE idRol_Responsable = p_idRol_Responsable)
        UNION ALL
        (SELECT *, 2 AS orden FROM Rol_Responsable WHERE idRol_Responsable != p_idRol_Responsable
         ORDER BY idRol_Responsable)
        ORDER BY orden, idRol_Responsable;
ELSE
SELECT * FROM Rol_Responsable ORDER BY idRol_Responsable;
END IF;
END //

-- 2. Procedimientos para Responsable
CREATE PROCEDURE pa_Leer_Responsable(
    IN p_idResponsable INT)
BEGIN
    IF p_idResponsable IS NOT NULL THEN
        (SELECT *, 1 AS orden FROM Responsable WHERE idResponsable = p_idResponsable)
        UNION ALL
        (SELECT *, 2 AS orden FROM Responsable WHERE idResponsable != p_idResponsable
         ORDER BY idResponsable)
        ORDER BY orden, idResponsable;
ELSE
SELECT * FROM Responsable ORDER BY idResponsable;
END IF;
END //

-- 3. Procedimientos para Inventario
CREATE PROCEDURE pa_Leer_Inventario(
    IN p_idInventario INT)
BEGIN
    IF p_idInventario IS NOT NULL THEN
        (SELECT *, 1 AS orden FROM Inventario WHERE idInventario = p_idInventario)
        UNION ALL
        (SELECT *, 2 AS orden FROM Inventario WHERE idInventario != p_idInventario
         ORDER BY idInventario)
        ORDER BY orden, idInventario;
ELSE
SELECT * FROM Inventario ORDER BY idInventario;
END IF;
END //

-- 4. Procedimientos para Inmueble
CREATE PROCEDURE pa_Leer_Inmueble(
    IN p_idInmueble INT)
BEGIN
    IF p_idInmueble IS NOT NULL THEN
        (SELECT *, 1 AS orden FROM Inmueble WHERE idInmueble = p_idInmueble)
        UNION ALL
        (SELECT *, 2 AS orden FROM Inmueble WHERE idInmueble != p_idInmueble
         ORDER BY idInmueble)
        ORDER BY orden, idInmueble;
ELSE
SELECT * FROM Inmueble ORDER BY idInmueble;
END IF;
END //

-- 5. Procedimientos para Ambiente
CREATE PROCEDURE pa_Leer_Ambiente(
    IN p_idAmbiente INT)
BEGIN
    IF p_idAmbiente IS NOT NULL THEN
        (SELECT *, 1 AS orden FROM Ambiente WHERE idAmbiente = p_idAmbiente)
        UNION ALL
        (SELECT *, 2 AS orden FROM Ambiente WHERE idAmbiente != p_idAmbiente
         ORDER BY idAmbiente)
        ORDER BY orden, idAmbiente;
ELSE
SELECT * FROM Ambiente ORDER BY idAmbiente;
END IF;
END //

-- 6. Procedimientos para Estado
CREATE PROCEDURE pa_Leer_Estado(
    IN p_idEstado INT)
BEGIN
    IF p_idEstado IS NOT NULL THEN
        (SELECT *, 1 AS orden FROM Estado WHERE idEstado = p_idEstado)
        UNION ALL
        (SELECT *, 2 AS orden FROM Estado WHERE idEstado != p_idEstado
         ORDER BY idEstado)
        ORDER BY orden, idEstado;
ELSE
SELECT * FROM Estado ORDER BY idEstado;
END IF;
END //

-- 7. Procedimientos para Categoria
CREATE PROCEDURE pa_Leer_Categoria(
    IN p_idCategoria INT)
BEGIN
    IF p_idCategoria IS NOT NULL THEN
        (SELECT *, 1 AS orden FROM Categoria WHERE idCategoria = p_idCategoria)
        UNION ALL
        (SELECT *, 2 AS orden FROM Categoria WHERE idCategoria != p_idCategoria
         ORDER BY idCategoria)
        ORDER BY orden, idCategoria;
ELSE
SELECT * FROM Categoria ORDER BY idCategoria;
END IF;
END //

-- 8. Procedimientos para Bien
CREATE PROCEDURE pa_Leer_Bien(
    IN p_idBien INT)
BEGIN
    IF p_idBien IS NOT NULL THEN
        (SELECT *, 1 AS orden FROM Bien WHERE idBien = p_idBien)
        UNION ALL
        (SELECT *, 2 AS orden FROM Bien WHERE idBien != p_idBien
         ORDER BY idBien)
        ORDER BY orden, idBien;
ELSE
SELECT * FROM Bien ORDER BY idBien;
END IF;
END //

-- 9. Procedimientos para Detalle_Inventario
CREATE PROCEDURE pa_Leer_Detalle_Inventario(
    IN p_idDetalle_Inventario INT)
BEGIN
    IF p_idDetalle_Inventario IS NOT NULL THEN
        (SELECT *, 1 AS orden FROM Detalle_Inventario WHERE idDetalle_Inventario = p_idDetalle_Inventario)
        UNION ALL
        (SELECT *, 2 AS orden FROM Detalle_Inventario WHERE idDetalle_Inventario != p_idDetalle_Inventario
         ORDER BY idDetalle_Inventario)
        ORDER BY orden, idDetalle_Inventario;
ELSE
SELECT * FROM Detalle_Inventario ORDER BY idDetalle_Inventario;
END IF;
END //

-- 10. Procedimientos para Asignacion
CREATE PROCEDURE pa_Leer_Asignacion(
    IN p_idAsignacion INT)
BEGIN
    IF p_idAsignacion IS NOT NULL THEN
        (SELECT *, 1 AS orden FROM Asignacion WHERE idAsignacion = p_idAsignacion)
        UNION ALL
        (SELECT *, 2 AS orden FROM Asignacion WHERE idAsignacion != p_idAsignacion
         ORDER BY idAsignacion)
        ORDER BY orden, idAsignacion;
ELSE
SELECT * FROM Asignacion ORDER BY idAsignacion;
END IF;
END //

-- 11. Procedimientos para Rotacion
CREATE PROCEDURE pa_Leer_Rotacion(
    IN p_idRotacion INT)
BEGIN
    IF p_idRotacion IS NOT NULL THEN
        (SELECT *, 1 AS orden FROM Rotacion WHERE idRotacion = p_idRotacion)
        UNION ALL
        (SELECT *, 2 AS orden FROM Rotacion WHERE idRotacion != p_idRotacion
         ORDER BY idRotacion)
        ORDER BY orden, idRotacion;
ELSE
SELECT * FROM Rotacion ORDER BY idRotacion;
END IF;
END //

-- 12. Procedimientos para HistorialEstado
CREATE PROCEDURE pa_Leer_HistorialEstado(
    IN p_idHistorialEstado INT)
BEGIN
    IF p_idHistorialEstado IS NOT NULL THEN
        (SELECT *, 1 AS orden FROM HistorialEstado WHERE idHistorialEstado = p_idHistorialEstado)
        UNION ALL
        (SELECT *, 2 AS orden FROM HistorialEstado WHERE idHistorialEstado != p_idHistorialEstado
         ORDER BY idHistorialEstado)
        ORDER BY orden, idHistorialEstado;
ELSE
SELECT * FROM HistorialEstado ORDER BY idHistorialEstado;
END IF;
END //

-- ===========================================
--        PROCEDIMIENTOS UPDATE
-- ===========================================

-- 1. Procedimientos para Rol_Responsable
CREATE PROCEDURE pa_Actualizar_Rol_Responsable(
    IN p_idRol_Responsable INT,
    IN p_descripcion VARCHAR(80),
    IN p_nombrerol VARCHAR(80))
BEGIN
UPDATE Rol_Responsable
SET descripcion = COALESCE(NULLIF(p_descripcion, ''), descripcion),
    nombrerol = COALESCE(NULLIF(p_nombrerol, ''), nombrerol)
WHERE idRol_Responsable = p_idRol_Responsable;
END //

-- 2. Procedimientos para Responsable
CREATE PROCEDURE pa_Actualizar_Responsable(
    IN p_idResponsable INT,
    IN p_nombre VARCHAR(30),
    IN p_dni VARCHAR(12),
    IN p_mail VARCHAR(30),
    IN p_usuario VARCHAR(30),
    IN p_contraseña VARCHAR(30),
    IN p_cargo VARCHAR(30))
BEGIN
UPDATE Responsable
SET nombre = COALESCE(NULLIF(p_nombre, ''), nombre),
    dni = COALESCE(NULLIF(p_dni, ''), dni),
    mail = COALESCE(NULLIF(p_mail, ''), mail),
    usuario = COALESCE(NULLIF(p_usuario, ''), usuario),
    contraseña = COALESCE(NULLIF(p_contraseña, ''), contraseña),
    cargo = COALESCE(NULLIF(p_cargo, ''), cargo)
WHERE idResponsable = p_idResponsable;
END //

-- 3. Procedimientos para Inventario
CREATE PROCEDURE pa_Actualizar_Inventario(
    IN p_idInventario INT,
    IN p_nombre VARCHAR(50),
    IN p_descripcion VARCHAR(50),
    IN p_fechainicio DATETIME,
    IN p_fechafin DATETIME)
BEGIN
UPDATE Inventario
SET nombre = COALESCE(NULLIF(p_nombre, ''), nombre),
    descripcion = COALESCE(NULLIF(p_descripcion, ''), descripcion),
    fechainicio = COALESCE(p_fechainicio, fechainicio),
    fechafin = COALESCE(p_fechafin, fechafin)
WHERE idInventario = p_idInventario;
END //

-- 4. Procedimientos para Inmueble
CREATE PROCEDURE pa_Actualizar_Inmueble(
    IN p_idInmueble INT,
    IN p_nombre VARCHAR(50),
    IN p_descripcion VARCHAR(50))
BEGIN
UPDATE Inmueble
SET nombre = COALESCE(NULLIF(p_nombre, ''), nombre),
    descripcion = COALESCE(NULLIF(p_descripcion, ''), descripcion)
WHERE idInmueble = p_idInmueble;
END //

-- 5. Procedimientos para Ambiente
CREATE PROCEDURE pa_Actualizar_Ambiente(
    IN p_idAmbiente INT,
    IN p_idInmueble INT,
    IN p_nombre VARCHAR(40))
BEGIN
UPDATE Ambiente
SET idInmueble = COALESCE(p_idInmueble, idInmueble),
    nombre = COALESCE(NULLIF(p_nombre, ''), nombre)
WHERE idAmbiente = p_idAmbiente;
END //

-- 6. Procedimientos para Estado
CREATE PROCEDURE pa_Actualizar_Estado(
    IN p_idEstado INT,
    IN p_tipo VARCHAR(30))
BEGIN
UPDATE Estado
SET tipo = COALESCE(NULLIF(p_tipo, ''), tipo)
WHERE idEstado = p_idEstado;
END //

-- 7. Procedimientos para Categoria
CREATE PROCEDURE pa_Actualizar_Categoria(
    IN p_idCategoria INT,
    IN p_nombre VARCHAR(60),
    IN p_descripcion VARCHAR(60))
BEGIN
UPDATE Categoria
SET nombre = COALESCE(NULLIF(p_nombre, ''), nombre),
    descripcion = COALESCE(NULLIF(p_descripcion, ''), descripcion)
WHERE idCategoria = p_idCategoria;
END //

-- 8. Procedimientos para Bien
CREATE PROCEDURE pa_Actualizar_Bien(
    IN p_idBien INT,
    IN p_nombre VARCHAR(50),
    IN p_descripcion VARCHAR(50),
    IN p_fecharegistro DATE,
    IN p_idEstadoActual INT,
    IN p_idCategoria INT,
    IN p_idAmbiente INT,
    IN p_idResponsableActual INT)
BEGIN
UPDATE Bien
SET nombre = COALESCE(NULLIF(p_nombre, ''), nombre),
    descripcion = COALESCE(NULLIF(p_descripcion, ''), descripcion),
    fecharegistro = COALESCE(p_fecharegistro, fecharegistro),
    idEstadoActual = COALESCE(p_idEstadoActual, idEstadoActual),
    idCategoria = COALESCE(p_idCategoria, idCategoria),
    idAmbiente = COALESCE(p_idAmbiente, idAmbiente),
    idResponsableActual = COALESCE(p_idResponsableActual, idResponsableActual)
WHERE idBien = p_idBien;
END //

-- 9. Procedimientos para Detalle_Inventario
CREATE PROCEDURE pa_Actualizar_Detalle_Inventario(
    IN p_idDetalle_Inventario INT,
    IN p_idBien INT,
    IN p_idInventario INT)
BEGIN
UPDATE Detalle_Inventario
SET idBien = COALESCE(p_idBien, idBien),
    idInventario = COALESCE(p_idInventario, idInventario)
WHERE idDetalle_Inventario = p_idDetalle_Inventario;
END //

-- 10. Procedimientos para Asignacion
CREATE PROCEDURE pa_Actualizar_Asignacion(
    IN p_idAsignacion INT,
    IN p_idBien INT,
    IN p_idResponsable INT,
    IN p_fechainicio DATE,
    IN p_fechafin DATE)
BEGIN
UPDATE Asignacion
SET idBien = COALESCE(p_idBien, idBien),
    idResponsable = COALESCE(p_idResponsable, idResponsable),
    fechainicio = COALESCE(p_fechainicio, fechainicio),
    fechafin = COALESCE(p_fechafin, fechafin)
WHERE idAsignacion = p_idAsignacion;
END //

-- 11. Procedimientos para Rotacion
CREATE PROCEDURE pa_Actualizar_Rotacion(
    IN p_idRotacion INT,
    IN p_idBien INT,
    IN p_idAmbiente INT,
    IN p_motivo VARCHAR(30),
    IN p_idResponsable INT)
BEGIN
UPDATE Rotacion
SET idBien = COALESCE(p_idBien, idBien),
    idAmbiente = COALESCE(p_idAmbiente, idAmbiente),
    motivo = COALESCE(NULLIF(p_motivo, ''), motivo),
    idResponsable = COALESCE(p_idResponsable, idResponsable)
WHERE idRotacion = p_idRotacion;
END //

-- 12. Procedimientos para HistorialEstado
CREATE PROCEDURE pa_Actualizar_HistorialEstado(
    IN p_idHistorialEstado INT,
    IN p_idBien INT,
    IN p_idEstado INT,
    IN p_idResponsable INT,
    IN p_motivo VARCHAR(30),
    IN p_fechaCambio DATE)
BEGIN
UPDATE HistorialEstado
SET idBien = COALESCE(p_idBien, idBien),
    idEstado = COALESCE(p_idEstado, idEstado),
    idResponsable = COALESCE(p_idResponsable, idResponsable),
    motivo = COALESCE(NULLIF(p_motivo, ''), motivo),
    fechaCambio = COALESCE(p_fechaCambio, fechaCambio)
WHERE idHistorialEstado = p_idHistorialEstado;
END //

-- =========================================
--      PROCEDIMIENTOS DELETE
-- =========================================

-- 1. Procedimientos para Rol_Responsable
CREATE PROCEDURE pa_Eliminar_Rol_Responsable(
    IN p_idRol_Responsable INT)
BEGIN
DELETE FROM Rol_Responsable WHERE idRol_Responsable = p_idRol_Responsable;
END //

-- 2. Procedimientos para Responsable
CREATE PROCEDURE pa_Eliminar_Responsable(
    IN p_idResponsable INT)
BEGIN
DELETE FROM Responsable WHERE idResponsable = p_idResponsable;
END //

-- 3. Procedimientos para Inventario
CREATE PROCEDURE pa_Eliminar_Inventario(
    IN p_idInventario INT)
BEGIN
DELETE FROM Inventario WHERE idInventario = p_idInventario;
END //

-- 4. Procedimientos para Inmueble
CREATE PROCEDURE pa_Eliminar_Inmueble(
    IN p_idInmueble INT)
BEGIN
DELETE FROM Inmueble WHERE idInmueble = p_idInmueble;
END //

-- 5. Procedimientos para Ambiente
CREATE PROCEDURE pa_Eliminar_Ambiente(
    IN p_idAmbiente INT)
BEGIN
DELETE FROM Ambiente WHERE idAmbiente = p_idAmbiente;
END //

-- 6. Procedimientos para Estado
CREATE PROCEDURE pa_Eliminar_Estado(
    IN p_idEstado INT)
BEGIN
DELETE FROM Estado WHERE idEstado = p_idEstado;
END //

-- 7. Procedimientos para Categoria
CREATE PROCEDURE pa_Eliminar_Categoria(
    IN p_idCategoria INT)
BEGIN
DELETE FROM Categoria WHERE idCategoria = p_idCategoria;
END //

-- 8. Procedimientos para Bien
CREATE PROCEDURE pa_Eliminar_Bien(
    IN p_idBien INT)
BEGIN
DELETE FROM Bien WHERE idBien = p_idBien;
END //

-- 9. Procedimientos para Detalle_Inventario
CREATE PROCEDURE pa_Eliminar_Detalle_Inventario(
    IN p_idDetalle_Inventario INT)
BEGIN
DELETE FROM Detalle_Inventario WHERE idDetalle_Inventario = p_idDetalle_Inventario;
END //

-- 10. Procedimientos para Asignacion
CREATE PROCEDURE pa_Eliminar_Asignacion(
    IN p_idAsignacion INT)
BEGIN
DELETE FROM Asignacion WHERE idAsignacion = p_idAsignacion;
END //

-- 11. Procedimientos para Rotacion
CREATE PROCEDURE pa_Eliminar_Rotacion(
    IN p_idRotacion INT)
BEGIN
DELETE FROM Rotacion WHERE idRotacion = p_idRotacion;
END //

-- 12. Procedimientos para HistorialEstado
CREATE PROCEDURE pa_Eliminar_HistorialEstado(
    IN p_idHistorialEstado INT)
BEGIN
DELETE FROM HistorialEstado WHERE idHistorialEstado = p_idHistorialEstado;
END //

DELIMITER ;
