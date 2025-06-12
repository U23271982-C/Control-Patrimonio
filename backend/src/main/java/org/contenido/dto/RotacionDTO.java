package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RotacionDTO {
    @NotNull( message = "El id no puede ser nulo",  groups = {EnActualizar.class})
    private int id;
    @NotNull( message = "El id del bien no puede ser nulo",  groups = {EnCrear.class})
    private BienDTO bienDTO;
    @NotNull( message = "El id del ambiente no puede ser nulo",  groups = {EnCrear.class})
    private AmbienteDTO ambienteDTO;
    @NotBlank( message = "El id del responsable no puede ser nulo",  groups = {EnCrear.class})
    @Size(max = 30, message = "El motivo no debe exceder los 30 caracteres")
    private String motivo;
    @NotNull( message = "El id del responsable no puede ser nulo",  groups = {EnCrear.class})
    private ResponsableDTO responsableDTO;

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

    public AmbienteDTO getAmbienteDTO() {
        return ambienteDTO;
    }

    public void setAmbienteDTO(AmbienteDTO ambienteDTO) {
        this.ambienteDTO = ambienteDTO;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public ResponsableDTO getResponsableDTO() {
        return responsableDTO;
    }

    public void setResponsableDTO(ResponsableDTO responsableDTO) {
        this.responsableDTO = responsableDTO;
    }
}
