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
    IN p_idRol_Responsable INT,
    IN p_nombre VARCHAR(30),
    IN p_dni VARCHAR(12),
    IN p_mail VARCHAR(30),
    IN p_usuario VARCHAR(30),
    IN p_contrasena VARBINARY(255)
BEGIN
    INSERT INTO Responsable(idRol_Responsable, nombre, dni, mail, usuario, contrasena)
    VALUES(p_idRol_Responsable, p_nombre, p_dni, p_mail, p_usuario, AES_ENCRYPT(p_contrasena,'Clave123');
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

-- 1. Leer Rol_Responsable
CREATE PROCEDURE pa_Leer_Rol_Responsable(IN p_idRol_Responsable INT)
BEGIN
    SELECT RR.idRol_Responsable, RR.descripcion, RR.nombrerol
    FROM Rol_Responsable RR
    WHERE RR.idRol_Responsable = p_idRol_Responsable;
END //

-- 2. Leer Responsable (con Rol_Responsable)
CREATE PROCEDURE pa_Leer_Responsable(IN p_idResponsable INT)
BEGIN
    SELECT R.idResponsable, R.idRol_Responsable,
           RR.nombrerol, RR.descripcion AS Rol_descripcion,
           R.nombre AS Responsable_nombre, R.dni, R.mail, R.usuario,
           CAST(AES_DECRYPT(R.contrasena, 'Clave123') AS VARBINARY) AS Contrasena
    FROM Responsable R
    INNER JOIN Rol_Responsable RR ON R.idRol_Responsable = RR.idRol_Responsable
    WHERE R.idResponsable = p_idResponsable;
END //

-- 3. Leer Inventario
CREATE PROCEDURE pa_Leer_Inventario(IN p_idInventario INT)
BEGIN
    SELECT I.idInventario, I.nombre AS Inventario_nombre, I.descripcion AS Inventario_descripcion,
           I.fechainicio, I.fechafin
    FROM Inventario I
    WHERE I.idInventario = p_idInventario;
END //

-- 4. Leer Inmueble
CREATE PROCEDURE pa_Leer_Inmueble(IN p_idInmueble INT)
BEGIN
    SELECT IM.idInmueble, IM.nombre AS Inmueble_nombre, IM.descripcion AS Inmueble_descripcion
    FROM Inmueble IM
    WHERE IM.idInmueble = p_idInmueble;
END //

-- 5. Leer Ambiente (con Inmueble)
CREATE PROCEDURE pa_Leer_Ambiente(IN p_idAmbiente INT)
BEGIN
    SELECT A.idAmbiente, A.nombre AS Ambiente_nombre, A.idInmueble,
           IM.nombre AS Inmueble_nombre, IM.descripcion AS Inmueble_descripcion
    FROM Ambiente A
    INNER JOIN Inmueble IM ON A.idInmueble = IM.idInmueble
    WHERE A.idAmbiente = p_idAmbiente;
END //

-- 6. Leer Estado
CREATE PROCEDURE pa_Leer_Estado(IN p_idEstado INT)
BEGIN
    SELECT E.idEstado, E.tipo AS Estado_tipo
    FROM Estado E
    WHERE E.idEstado = p_idEstado;
END //

-- 7. Leer Categoria
CREATE PROCEDURE pa_Leer_Categoria(IN p_idCategoria INT)
BEGIN
    SELECT C.idCategoria, C.nombre AS Categoria_nombre, C.descripcion AS Categoria_descripcion
    FROM Categoria C
    WHERE C.idCategoria = p_idCategoria;
END //

-- 8. Leer Bien (con Estado, Categoria, Ambiente, Responsable y Rol_Responsable)
CREATE PROCEDURE pa_Leer_Bien(IN p_idBien INT)
BEGIN
    SELECT B.idBien, B.nombre AS Bien_nombre, B.descripcion AS Bien_descripcion, B.fecharegistro,
           B.idEstadoActual, EST.tipo AS Estado_tipo,
           B.idCategoria, CAT.nombre AS Categoria_nombre, CAT.descripcion AS Categoria_descripcion,
           B.idAmbiente, AMB.nombre AS Ambiente_nombre,
           B.idResponsableActual, RES.nombre AS Responsable_nombre, RES.dni, RES.mail, RES.usuario,
           RES.contraseña,
           RES.idRol_Responsable,
           RR.nombrerol, RR.descripcion AS Rol_descripcion
    FROM Bien B
    LEFT JOIN Estado EST ON B.idEstadoActual = EST.idEstado
    LEFT JOIN Categoria CAT ON B.idCategoria = CAT.idCategoria
    LEFT JOIN Ambiente AMB ON B.idAmbiente = AMB.idAmbiente
    LEFT JOIN Responsable RES ON B.idResponsableActual = RES.idResponsable
    LEFT JOIN Rol_Responsable RR ON RES.idRol_Responsable = RR.idRol_Responsable
    WHERE B.idBien = p_idBien;
END //

-- 9. Leer Detalle_Inventario (con Bien e Inventario y demás relaciones)
CREATE PROCEDURE pa_Leer_Detalle_Inventario(IN p_idDetalle_Inventario INT)
BEGIN
    SELECT D.idDetalle_Inventario,
           B.idBien, B.nombre AS Bien_nombre, B.descripcion AS Bien_descripcion, B.fecharegistro,
           B.idEstadoActual, EST.tipo AS Estado_tipo,
           B.idCategoria, CAT.nombre AS Categoria_nombre, CAT.descripcion AS Categoria_descripcion,
           B.idAmbiente, AMB.nombre AS Ambiente_nombre,
           B.idResponsableActual, RES.nombre AS Responsable_nombre,
           D.idInventario, I.nombre AS Inventario_nombre, I.descripcion AS Inventario_descripcion,
           I.fechainicio, I.fechafin
    FROM Detalle_Inventario D
    INNER JOIN Bien B ON D.idBien = B.idBien
    INNER JOIN Estado EST ON B.idEstadoActual = EST.idEstado
    INNER JOIN Categoria CAT ON B.idCategoria = CAT.idCategoria
    INNER JOIN Ambiente AMB ON B.idAmbiente = AMB.idAmbiente
    INNER JOIN Responsable RES ON B.idResponsableActual = RES.idResponsable
    LEFT JOIN Rol_Responsable RR ON RES.idRol_Responsable = RR.idRol_Responsable
    INNER JOIN Inventario I ON D.idInventario = I.idInventario
    WHERE D.idDetalle_Inventario = p_idDetalle_Inventario;
END //

-- 10. Leer Asignacion (Bien + Responsable + Rol_Responsable)
CREATE PROCEDURE pa_Leer_Asignacion(IN p_idAsignacion INT)
BEGIN
    SELECT A.idAsignacion,
           B.idBien, B.nombre AS Bien_nombre,
           R.idResponsable, R.nombre AS Responsable_nombre, R.dni, R.mail, R.usuario,
           R.contraseña, R.idRol_Responsable,
           RR.nombrerol, RR.descripcion AS Rol_descripcion,
           A.fechainicio, A.fechafin
    FROM Asignacion A
    INNER JOIN Bien B ON A.idBien = B.idBien
    INNER JOIN Responsable R ON A.idResponsable = R.idResponsable
    INNER JOIN Rol_Responsable RR ON R.idRol_Responsable = RR.idRol_Responsable
    WHERE A.idAsignacion = p_idAsignacion;
END //

-- 11. Leer Rotacion (Bien, Ambiente, Responsable + Rol_Responsable)
CREATE PROCEDURE pa_Leer_Rotacion(IN p_idRotacion INT)
BEGIN
    SELECT R.idRotacion,
           B.idBien, B.nombre AS Bien_nombre,
           AMB.idAmbiente, AMB.nombre AS Ambiente_nombre,
           R.motivo,
           RES.idResponsable, RES.nombre AS Responsable_nombre, RES.dni,
           RES.mail, RES.usuario, RES.contraseña, RES.idRol_Responsable,
           RR.nombrerol, RR.descripcion AS Rol_descripcion
    FROM Rotacion R
    INNER JOIN Bien B ON R.idBien = B.idBien
    INNER JOIN Ambiente AMB ON R.idAmbiente = AMB.idAmbiente
    INNER JOIN Responsable RES ON R.idResponsable = RES.idResponsable
    INNER JOIN Rol_Responsable RR ON RES.idRol_Responsable = RR.idRol_Responsable
    WHERE R.idRotacion = p_idRotacion;
END //

-- 12. Leer HistorialEstado (Bien, Estado, Responsable + Rol_Responsable)
CREATE PROCEDURE pa_Leer_HistorialEstado(IN p_idHistorialEstado INT)
BEGIN
    SELECT H.idHistorialEstado,
           B.idBien, B.nombre AS Bien_nombre,
           EST.idEstado, EST.tipo AS Estado_tipo,
           RES.idResponsable, RES.nombre AS Responsable_nombre, RES.dni,
           RES.mail, RES.usuario, RES.contraseña, RES.idRol_Responsable,
           RR.nombrerol, RR.descripcion AS Rol_descripcion,
           H.motivo, H.fechaCambio
    FROM HistorialEstado H
    INNER JOIN Bien B ON H.idBien = B.idBien
    INNER JOIN Estado EST ON H.idEstado = EST.idEstado
    INNER JOIN Responsable RES ON H.idResponsable = RES.idResponsable
    INNER JOIN Rol_Responsable RR ON RES.idRol_Responsable = RR.idRol_Responsable
    WHERE H.idHistorialEstado = p_idHistorialEstado;
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
    IN p_idRol_Responsable INT,
    IN p_nombre VARCHAR(30),
    IN p_dni VARCHAR(12),
    IN p_mail VARCHAR(30),
    IN p_usuario VARCHAR(30),
    IN p_contrasena VARBINARY(255)
BEGIN
    UPDATE Responsable
    SET nombre = COALESCE(NULLIF(p_nombre, ''), nombre),
        idRol_Responsable = COALESCE(NULLIF(p_idRol_Responsable),idRol_Responsable),
        dni = COALESCE(NULLIF(p_dni, ''), dni),
        mail = COALESCE(NULLIF(p_mail, ''), mail),
        usuario = COALESCE(NULLIF(p_usuario, ''), usuario),
        contrasena = COALESCE(
            NULLIF(AES_ENCRYPT(p_contrasena, 'Clave123'), AES_ENCRYPT('', 'Clave123')),
            contrasena
        )
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

--9. Procedimiento para crear bien en relacion con todos los historiales que tenemos
CREATE PROCEDURE pa_Actualizar_Bien_con_Historiales(
    IN p_bien_id INT,
    IN p_estado_id INT,
    IN p_responsable_id INT,
    IN p_ambiente_id INT,
    IN p_motivo_estado VARCHAR(30),
    IN p_motivo_responsable VARCHAR(30),
    IN p_motivo_ambiente VARCHAR(30),
    IN p_admin_id INT
)
BEGIN
    -- Actualizar Estado del Bien y registrar historial
    IF p_estado_id IS NOT NULL THEN
        UPDATE Bien
        SET idEstadoActual = p_estado_id
        WHERE idBien = p_bien_id;

        INSERT INTO HistorialEstado (idBien, idEstado, motivo, fechaCambio, idResponsable)
        VALUES (p_bien_id, p_estado_id, p_motivo_estado, NOW(), p_responsable_id);
    END IF;

    -- Actualizar Responsable del Bien y registrar historial
    IF p_responsable_id IS NOT NULL THEN
        UPDATE Bien
        SET idResponsableActual = p_responsable_id
        WHERE idBien = p_bien_id;

        -- Aquí asumimos que quieres registrar en Asignacion
        INSERT INTO Asignacion (idBien, idResponsable, fechainicio)
        VALUES (p_bien_id, p_responsable_id, CURDATE());
    END IF;

    -- Actualizar Ambiente del Bien y registrar historial
    IF p_ambiente_id IS NOT NULL THEN
        UPDATE Bien
        SET idAmbiente = p_ambiente_id
        WHERE idBien = p_bien_id;

        INSERT INTO Rotacion (idBien, idAmbiente, motivo, idResponsable)
        VALUES (p_bien_id, p_ambiente_id, p_motivo_ambiente, p_responsable_id);
    END IF;
END //

-- 10. Procedimientos para Detalle_Inventario
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

-- 11. Procedimientos para Asignacion
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

-- 12. Procedimientos para Rotacion
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

-- 13. Procedimientos para HistorialEstado
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

-- =========================================
--          PROCEDIMIENTOS LISTAR
-- =========================================

-- 1. Listar Inventario
CREATE PROCEDURE pa_Listar_Inventario()
BEGIN
    SELECT I.idInventario, I.nombre AS Inventario_nombre, I.descripcion AS Inventario_descripcion,
           I.fechainicio, I.fechafin
    FROM Inventario I;
END //

-- 2. Listar Ambiente (para contexto general)
CREATE PROCEDURE pa_Listar_Ambiente()
BEGIN
    SELECT A.idAmbiente, A.nombre AS Ambiente_nombre,
           IM.idInmueble, IM.nombre AS Inmueble_nombre, IM.descripcion AS Inmueble_descripcion
    FROM Ambiente A
    INNER JOIN Inmueble IM ON A.idInmueble = IM.idInmueble;
END //

-- 3. Listar Inmueble
CREATE PROCEDURE pa_Listar_Inmueble()
BEGIN
    SELECT IM.idInmueble, IM.nombre AS Inmueble_nombre, IM.descripcion AS Inmueble_descripcion
    FROM Inmueble IM;
END //

-- 4. Listar Estado
CREATE PROCEDURE pa_Listar_Estado()
BEGIN
    SELECT E.idEstado, E.tipo AS Estado_tipo
    FROM Estado E;
END //

-- 5. Listar Categoria
CREATE PROCEDURE pa_Listar_Categoria()
BEGIN
    SELECT C.idCategoria, C.nombre AS Categoria_nombre, C.descripcion AS Categoria_descripcion
    FROM Categoria C;
END //

-- 6. Listar Rol_Responsable
CREATE PROCEDURE pa_Listar_RolResponsable()
BEGIN
    SELECT RR.idRol_Responsable, RR.nombrerol, RR.descripcion
    FROM Rol_Responsable RR;
END //

-- 7. Listar Responsable (incluye Rol_Responsable)
CREATE PROCEDURE pa_Listar_Responsable()
BEGIN
    SELECT R.idResponsable, R.idRol_Responsable,
           R.nombre AS Responsable_nombre, R.dni, R.mail, R.usuario,
           CAST(AES_DECRYPT(R.contrasena, 'Clave123') AS VARBINARY) AS Contrasena,
           RR.nombrerol, RR.descripcion AS Rol_descripcion
    FROM Responsable R
    INNER JOIN Rol_Responsable RR ON R.idRol_Responsable = RR.idRol_Responsable;
END //

-- 8. Listar Bien (incluye Estado, Categoria, Ambiente, Responsable, Rol)
CREATE PROCEDURE pa_Listar_Bien()
BEGIN
    SELECT B.idBien, B.nombre AS Bien_nombre, B.descripcion AS Bien_descripcion, B.fecharegistro,
           EST.idEstado, EST.tipo AS Estado_tipo,
           CAT.idCategoria, CAT.nombre AS Categoria_nombre, CAT.descripcion AS Categoria_descripcion,
           AMB.idAmbiente, AMB.nombre AS Ambiente_nombre,
           RES.idResponsable, RES.nombre AS Responsable_nombre, RES.dni,
           RES.mail, RES.usuario, RES.contraseña,
           RR.idRol_Responsable, RR.nombrerol, RR.descripcion AS Rol_descripcion
    FROM Bien B
    INNER JOIN Estado EST ON B.idEstadoActual = EST.idEstado
    INNER JOIN Categoria CAT ON B.idCategoria = CAT.idCategoria
    INNER JOIN Ambiente AMB ON B.idAmbiente = AMB.idAmbiente
    INNER JOIN Responsable RES ON B.idResponsableActual = RES.idResponsable
    INNER JOIN Rol_Responsable RR ON RES.idRol_Responsable = RR.idRol_Responsable;
END //

-- 9. Listar Detalle_Inventario (incluye Bien, Inventario, y todas las relaciones)
CREATE PROCEDURE pa_Listar_DetalleInventario()
BEGIN
    SELECT D.idDetalle_Inventario,
           B.idBien, B.nombre AS Bien_nombre, B.descripcion AS Bien_descripcion, B.fecharegistro,
           EST.idEstado, EST.tipo AS Estado_tipo,
           CAT.idCategoria, CAT.nombre AS Categoria_nombre, CAT.descripcion AS Categoria_descripcion,
           AMB.idAmbiente, AMB.nombre AS Ambiente_nombre,
           RES.idResponsable, RES.nombre AS Responsable_nombre, RES.dni, RES.mail, RES.usuario, RES.contraseña,
           RR.idRol_Responsable, RR.nombrerol, RR.descripcion AS Rol_descripcion,
           I.idInventario, I.nombre AS Inventario_nombre, I.descripcion AS Inventario_descripcion,
           I.fechainicio, I.fechafin
    FROM Detalle_Inventario D
    INNER JOIN Bien B ON D.idBien = B.idBien
    INNER JOIN Estado EST ON B.idEstadoActual = EST.idEstado
    INNER JOIN Categoria CAT ON B.idCategoria = CAT.idCategoria
    INNER JOIN Ambiente AMB ON B.idAmbiente = AMB.idAmbiente
    INNER JOIN Responsable RES ON B.idResponsableActual = RES.idResponsable
    INNER JOIN Rol_Responsable RR ON RES.idRol_Responsable = RR.idRol_Responsable
    INNER JOIN Inventario I ON D.idInventario = I.idInventario;
END //

-- 10. Listar Asignacion (incluye Bien, Responsable, Rol)
CREATE PROCEDURE pa_Listar_Asignacion()
BEGIN
    SELECT A.idAsignacion,
           B.idBien, B.nombre AS Bien_nombre,
           RES.idResponsable, RES.nombre AS Responsable_nombre, RES.dni, RES.mail, RES.usuario, RES.contraseña,
           RR.idRol_Responsable, RR.nombrerol, RR.descripcion AS Rol_descripcion,
           A.fechainicio, A.fechafin
    FROM Asignacion A
    INNER JOIN Bien B ON A.idBien = B.idBien
    INNER JOIN Responsable RES ON A.idResponsable = RES.idResponsable
    INNER JOIN Rol_Responsable RR ON RES.idRol_Responsable = RR.idRol_Responsable;
END //

-- 11. Listar Rotacion (incluye Bien, Ambiente, Responsable, Rol)
CREATE PROCEDURE pa_Listar_Rotacion()
BEGIN
    SELECT R.idRotacion,
           B.idBien, B.nombre AS Bien_nombre,
           AMB.idAmbiente, AMB.nombre AS Ambiente_nombre,
           RES.idResponsable, RES.nombre AS Responsable_nombre, RES.dni, RES.mail, RES.usuario, RES.contraseña,
           RR.idRol_Responsable, RR.nombrerol, RR.descripcion AS Rol_descripcion,
           R.motivo
    FROM Rotacion R
    INNER JOIN Bien B ON R.idBien = B.idBien
    INNER JOIN Ambiente AMB ON R.idAmbiente = AMB.idAmbiente
    INNER JOIN Responsable RES ON R.idResponsable = RES.idResponsable
    INNER JOIN Rol_Responsable RR ON RES.idRol_Responsable = RR.idRol_Responsable;
END //

-- 12. Listar HistorialEstado (incluye Bien, Estado, Responsable, Rol)
CREATE PROCEDURE pa_Listar_HistorialEstado()
BEGIN
    SELECT H.idHistorialEstado,
           B.idBien, B.nombre AS Bien_nombre,
           EST.idEstado, EST.tipo AS Estado_tipo,
           RES.idResponsable, RES.nombre AS Responsable_nombre, RES.dni, RES.mail, RES.usuario, RES.contraseña,
           RR.idRol_Responsable, RR.nombrerol, RR.descripcion AS Rol_descripcion,
           H.motivo, H.fechaCambio
    FROM HistorialEstado H
    INNER JOIN Bien B ON H.idBien = B.idBien
    INNER JOIN Estado EST ON H.idEstado = EST.idEstado
    INNER JOIN Responsable RES ON H.idResponsable = RES.idResponsable
    INNER JOIN Rol_Responsable RR ON RES.idRol_Responsable = RR.idRol_Responsable;
END //

-- =========================================
--      PROCEDIMIENTOS VERIFICAR CONTRASEÑA
-- =========================================

CREATE PROCEDURE pa_validarCredenciales(
    IN p_usuario VARCHAR(30),
    IN p_contrasena VARBINARY(255)
)
BEGIN
    SELECT
        R.idResponsable,
        R.idRol_Responsable,
        RR.nombrerol AS Rol,
        RR.descripcion AS Rol_descripcion,
        R.nombre AS Responsable_nombre,
        R.dni,
        R.mail,
        R.usuario,
        CAST(AES_DECRYPT(R.contrasena, 'Clave123') AS VARBINARY) AS Contrasena
    FROM Responsable R
    INNER JOIN Rol_Responsable RR ON R.idRol_Responsable = RR.idRol_Responsable
    WHERE R.usuario = p_usuario
      AND CAST(AES_DECRYPT(R.contrasena, 'Clave123') AS VARBINARY) = p_contrasena;
END//

-- =========================================
--      PROCEDIMIENTOS REPORTES
-- =========================================
-- 1. Reporte Masivo Personalizado
CREATE PROCEDURE pa_Reporte_Masivo_Personalizado(
    IN pEstado VARCHAR(30),
    IN pNombreBien VARCHAR(50),
    IN pFechaRegistro DATE,
    IN pResponsableActual VARCHAR(30),
    IN pTipoCategoria VARCHAR(60),
    IN pNombreAmbiente VARCHAR(40),
    IN pNombreInmueble VARCHAR(50),
    IN pNombreInventario VARCHAR(50)
)
BEGIN
    SELECT
        b.idBien as idbien,
        b.nombre AS nombre_bien,
        b.descripcion as descripcion_bien,
        b.fecharegistro as fecharegistro_bien,
        e.tipo AS estado_actual_bien,
        c.nombre AS tipo_categoria,
        a.nombre AS ambiente,
        i.nombre AS inmueble,
        r.nombre AS responsable_actual,
        inv.nombre AS inventario_asociado
    FROM Bien b
    LEFT JOIN Estado e ON b.idEstadoActual = e.idEstado
    LEFT JOIN Categoria c ON b.idCategoria = c.idCategoria
    LEFT JOIN Ambiente a ON b.idAmbiente = a.idAmbiente
    LEFT JOIN Inmueble i ON a.idInmueble = i.idInmueble
    LEFT JOIN Responsable r ON b.idResponsableActual = r.idResponsable
    LEFT JOIN Detalle_Inventario di ON b.idBien = di.idBien
    LEFT JOIN Inventario inv ON di.idInventario = inv.idInventario
    WHERE
        (e.tipo = pEstado OR pEstado IS NULL)
        AND (b.nombre = pNombreBien OR pNombreBien IS NULL)
        AND (b.fecharegistro = pFechaRegistro OR pFechaRegistro IS NULL)
        AND (r.nombre = pResponsableActual OR pResponsableActual IS NULL)
        AND (c.nombre = pTipoCategoria OR pTipoCategoria IS NULL)
        AND (a.nombre = pNombreAmbiente OR pNombreAmbiente IS NULL)
        AND (i.nombre = pNombreInmueble OR pNombreInmueble IS NULL)
        AND (inv.nombre = pNombreInventario OR pNombreInventario IS NULL);
END//

-- 2. Reporte Masivo General
CREATE PROCEDURE pa_Reporte_Masivo_General(
)
BEGIN
    SELECT
        b.idBien as idbien,
        b.nombre AS nombre_bien,
        b.descripcion as descripcion_bien,
        b.fecharegistro as fecharegistro_bien,
        e.tipo AS estado_actual_bien,
        c.nombre AS tipo_categoria,
        a.nombre AS ambiente,
        i.nombre AS inmueble,
        r.nombre AS responsable_actual,
        inv.nombre AS inventario_asociado
    FROM Bien b
    LEFT JOIN Estado e ON b.idEstadoActual = e.idEstado
    LEFT JOIN Categoria c ON b.idCategoria = c.idCategoria
    LEFT JOIN Ambiente a ON b.idAmbiente = a.idAmbiente
    LEFT JOIN Inmueble i ON a.idInmueble = i.idInmueble
    LEFT JOIN Responsable r ON b.idResponsableActual = r.idResponsable
    LEFT JOIN Detalle_Inventario di ON b.idBien = di.idBien
    LEFT JOIN Inventario inv ON di.idInventario = inv.idInventario
END;
//

DELIMITER ;
