package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AsignacionDTO {
    @NotNull(message = "El id no puede ser nulo", groups = EnActualizar.class)
    private int id;
    @NotNull(message = "El bien no puede ser nulo", groups = EnCrear.class)
    private BienDTO bienDTO;
    private ResponsableDTO responsableDTO;

    private LocalDate fecha_inicio;

    public AsignacionDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BienDTO getBienDTO() {
        return bienDTO;
    }

    public void setBienDTO(BienDTO bienDTO) {
        this.bienDTO = bienDTO;
    }

    public ResponsableDTO getResponsableDTO() {
        return responsableDTO;
    }

    public void setResponsableDTO(ResponsableDTO responsableDTO) {
        this.responsableDTO = responsableDTO;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
}
