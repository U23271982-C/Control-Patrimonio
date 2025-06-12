package org.contenido.utilidad;

import org.contenido.excepcion.ValidacionExcepcion;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidadorUtilidad {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();
    // Se valida un dto, con diferentes marcas de grupos de validación
    // Los errores se guradan y se lanza una excepción, forma de orden de llegada
    public static <T> void validar(T objeto, Class<?>... grupos) {
        Set<ConstraintViolation<T>> errores = validator.validate(objeto, grupos);
        if (!errores.isEmpty()) {
            StringBuilder sb = new StringBuilder("Errores de validación:\n");
            for (ConstraintViolation<T> error : errores) {
                sb.append("- ").append(error.getMessage()).append("\n");
            }
            throw new ValidacionExcepcion(sb.toString());
        }
    }
}
