package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class BienDTO {
    @NotNull( message = "El id no puede ser nulo", groups = {EnActualizar.class})
    private int id;
    @NotNull( message = "El codigo no puede ser nulo", groups = {EnCrear.class})
    @Size(max = 30, message = "El codigo no debe exceder los 30 caracteres", groups = {EnCrear.class , EnActualizar.class})
    private String codigo;
    @NotNull( message = "El nombre no puede ser nulo", groups = {EnCrear.class})
    @Size(max = 50, message = "El nombre no debe exceder los 50 caracteres", groups = {EnCrear.class , EnActualizar.class})
    private String nombre;
    @NotNull( message = "La descripción no puede ser nula", groups = {EnCrear.class})
    @Size(max = 50, message = "La descripción no debe exceder los 50 caracteres", groups = {EnCrear.class , EnActualizar.class})
    private String descripcion;
    @Null( message = "La fecha de registro no puede ser nula", groups = {EnCrear.class})
    private LocalDate fecha_registro;
    @NotNull( message = "El estado actual no puede ser nulo", groups = {EnCrear.class})
    private EstadoDTO estado_actualDTO;
    @NotNull( message = "La categoría no puede ser nulo", groups = {EnCrear.class})
    private CategoriaDTO categoriaDTO;
    @NotNull( message = "El ambiente no puede ser nulo", groups = {EnCrear.class})
    private AmbienteDTO ambienteDTO;
    private ResponsableDTO responsableDTO;

    public BienDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo(){return codigo;}

    public void setCodigo(String codigo){this.codigo = codigo;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public EstadoDTO getEstado_actualDTO() {
        return estado_actualDTO;
    }

    public void setEstado_actualDTO(EstadoDTO estado_actualDTO) {
        this.estado_actualDTO = estado_actualDTO;
    }

    public CategoriaDTO getCategoriaDTO() {
        return categoriaDTO;
    }

    public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
        this.categoriaDTO = categoriaDTO;
    }

    public AmbienteDTO getAmbienteDTO() {
        return ambienteDTO;
    }

    public void setAmbienteDTO(AmbienteDTO ambienteDTO) {
        this.ambienteDTO = ambienteDTO;
    }

    public ResponsableDTO getResponsableDTO() {
        return responsableDTO;
    }

    public void setResponsableDTO(ResponsableDTO responsableDTO) {
        this.responsableDTO = responsableDTO;
    }


    @Override
    public String toString(){
        return this.getNombre();
    }
}
