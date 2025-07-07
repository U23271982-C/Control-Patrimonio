package org.contenido.reporte;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.contenido.utilidad.NotificacionUtil;
import org.contenido.utilidad.exportar.TipoDocumento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Reporte {
    protected final LocalDateTime horaFechaActual = LocalDateTime.now();
    protected DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected String[] encabezado;
    protected List<Object[]> contenido;
    protected Workbook workbook;
    protected Sheet hoja;
    protected List<Object[]> datos;
    protected final TipoDocumento extencion;
    protected String direccionGuardado;

    public Reporte (String tituloHoja, TipoDocumento extencion) {
        this.workbook = extencion.getWorkbook();
        this.hoja = workbook.createSheet(tituloHoja);
        this.extencion = extencion;
        try {
            //formatearReporte();
        }  catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    abstract protected void cortarEncabezado();
    
    abstract protected void cortarCuerpo();
    
    abstract public void exportarReporte();

    public void setDireccionGuardado(String direccionGuardado) {
        this.direccionGuardado = direccionGuardado;
    }
}
