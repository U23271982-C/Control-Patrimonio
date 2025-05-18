# 🏛️ Sistema de Control Patrimonial

Aplicación de escritorio desarrollada en **Java SE** con arquitectura en capas, centrada en la gestión de ambientes e inmuebles. Este sistema implementa múltiples técnicas modernas de desarrollo orientado a objetos, validación, persistencia y control de errores.

---

## ✅ Características técnicas

- 📐 **Arquitectura en capas**: separación clara entre modelo, DTO, DAO, servicio, mapeadores, utilidad y vista.
- 🔁 **Mapeo DTO ↔ Modelo** usando mapeadores personalizados (`AmbienteMapper`, `InmuebleMapper`), sin inyección externa.
- 🔄 **DTOs anidados**: entidades que contienen otras entidades, convertidas manualmente por mapeadores.
- 🛡️ **Validación declarativa**: mediante anotaciones de Jakarta Bean Validation (`@NotBlank`, `@Size`, etc.) y grupos personalizados (`EnCrear`, `EnActualizar`).
- 🔎 **Validación programática**: validaciones manuales adicionales en los servicios con `ValidadorUtilidad`.
- 🧱 **Patrón DAO**: interacción con la base de datos encapsulada en objetos DAO que ejecutan **procedimientos almacenados**.
- 🧵 **Pool de conexiones**: gestión eficiente de recursos mediante `ConexionPool`, evitando sobrecarga por múltiples conexiones.
- ⚙️ **Procedimientos almacenados (MySQL)**: acceso a la base de datos completamente desacoplado del SQL embebido.
- 🧪 **Control centralizado de errores**: excepciones específicas (`ValidacionExcepcion`, `NegocioExcepcion`, `PersistenciaExcepcion`) + utilidad `NotificacionUtil` para UI.
- 🧰 **Interfaz gráfica en Swing**: ventanas diseñadas con componentes nativos de Java.
- 🧼 **Código limpio**: uso de `Optional`, `Objects.nonNull`, validación null-safe y principios SOLID.
- 🔄 **Servicios genéricos**: clases de servicio que implementan interfaces base reutilizables (`ServicioCrud<T, DTO>`).
- 🔍 **Detección de errores antes de la capa de persistencia**: validaciones del DTO antes de cualquier consulta a la base de datos.

---

## 🗂️ Estructura del proyecto
src/
├── controlador/
│   └── interfaces y clases de controlación que permite la interación de la capa visiual con la lógica del negocio
├── dao/
│   └── interfaces y clases DAO con llamadas a procedimientos almacenados
├── dto/
│   └── Clases DTO con anotaciones de validación y relaciones anidadas
├── excepcion/
│   └── ValidacionExcepcion.java
│   └── NegocioExcepcion.java
│   └── PersistenciaExcepcion.java
├── mapeo/
│   └── Convertidor.java (interface genérica)
│   └── AmbienteMapper.java
│   └── InmuebleMapper.java
├── modelo/
│   └── Entidades persistentes (POJOs)
├── servicio/
│   └── interfaces y clases que implementan lógica de negocio
├── persistencia/
│   └── ConexionPool.java (singleton para DataSource)
├── utilidad/
│   └── NotificacionUtil.java (JOptionPane)
│   └── ValidadorUtilidad.java (integración con Bean Validation)
├── validacion/
│   └── EnCrear.java
│   └── EnActualizar.java
│   └── EnLeer.java
├── vista/
│   └── Interfaces de usuario con Java Swing (falta implementación)

---
## 🧪 Validación de datos

- Uso de anotaciones como `@NotBlank`, `@Size`, `@NotNull` en los DTO.
- Validaciones con **grupos personalizados**: `EnCrear`, `EnActualizar`, lo que permite reutilizar las mismas clases DTO para diferentes contextos.



  ``
    @NotBlank(message = "El nombre es obligatorio", groups = {EnCrear.class, EnActualizar.class})
    @Size(min = 3, max = 50, message = "Debe tener entre 3 y 50 caracteres", groups = EnCrear.class)
Validación manual: ValidatorUtilidad.validar(dto, EnCrear.class);

---
## ⚠️ Control de excepciones
- Se capturan errores por tipo: validación, negocio y persistencia.
- Manejador centralizado de errores gráficos:

   ` NotificacionUtil.mostrarError(e);`

- Ejemplo de excepción personalizada:


    public class PersistenciaExcepcion extends RuntimeException {
        public PersistenciaExcepcion(String message, Throwable cause) {
            super(message, cause);
        }
    }
---
## 🧩 Conexión a base de datos
- Acceso desacoplado a través de un pool de conexiones:


    public class ConexionPool {
        private static final DataSource dataSource;
        // configuración de DataSource y Singleton
    }
- Uso de procedimientos almacenados en MySQL para registrar, actualizar, listar y eliminar.


    CALL pa_Registrar_Ambiente(?, ?);
---
## 🛠️ Tecnologías y herramientas
| Herramientas  |   Uso|
| ------------ | ------------ |
| Java SE 17+  |   Lenguaje principal|
|  Java Swing | Interfa gráfica de usuario  |
|  JDBC | Conexión con la base de datos  |
|  MySQL |  Motor de base de datos |
|  Stored Procedures |  Lógica SQL encapsulada |
|  Bean Validation | Validación declarativa con grupos  |
|  Maven |  Gestión de dependencias y estructura del proyecto |
| JOptionPane  |  Diálogos de interacción visual |
---
## ⚙️ Cómo ejecutar

1. Clonar el repositorio:

    git clone https://github.com/U23271982-C/Control-Patrimonial.git
2.	Abrir en IntelliJ IDEA o tu IDE favorito.
3.	Configurar las credenciales de la base de datos en ConexionPool.java.
4.	Ejecutar la clase Main (si tienes una).
5.	¡Listo! Interactúa con la interfaz de usuario.
------
## 📌 Pendientes o mejoras

- Migrar validación a nivel de interfaz gráfica.
- Optimizar carga parcial (solo campos necesarios).
- Aplicar patrón Repository si se escala a Spring Boot.
- Test unitarios con JUnit y Mockito.
---
## 📝 Licencia

Uso académico y libre para fines educativos.
