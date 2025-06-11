package org.contenido.dto;

import org.contenido.modelo.Bien;
import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class Historial_EstadoDTO {
    @NotNull(message = "El id no puede ser nulo", groups = {EnActualizar.class})
    private int id;
    @NotNull(message = "El bien no puede ser nulo", groups = {EnCrear.class})
    private BienDTO bienDTO;
    @NotNull(message = "El estado no puede ser nulo", groups = {EnCrear.class})
    private EstadoDTO estadoDTO;
    @Size(max = 30, message = "El motivo no debe exceder los 30 caracteres")
    private String motivo;
    @NotNull(message = "La fecha de cambio no puede ser nula", groups = {EnCrear.class})
    private LocalDate fecha_cambio;
    @NotNull(message = "El id del responsable no puede ser nulo", groups = {EnCrear.class})
    private ResponsableDTO responsableDTO;

    public Historial_EstadoDTO() {}

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

    public EstadoDTO getEstadoDTO() {
        return estadoDTO;
    }

    public void setEstadoDTO(EstadoDTO estadoDTO) {
        this.estadoDTO = estadoDTO;
    }

    public ResponsableDTO getResponsableDTO() {
        return responsableDTO;
    }

    public void setResponsableDTO(ResponsableDTO responsableDTO) {
        this.responsableDTO = responsableDTO;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFecha_cambio() {
        return fecha_cambio;
    }

    public void setFecha_cambio(LocalDate fecha_cambio) {
        this.fecha_cambio = fecha_cambio;
    }

}
