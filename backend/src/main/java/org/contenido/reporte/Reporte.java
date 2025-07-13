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

    public Reporte (String tituloHoja, TipoDocumento extencion/*, String[] encabezado*/, List<Object[]> datos) {
        this.workbook = extencion.getDocumento();
        createSheet(tituloHoja);
        this.extencion = extencion;
        this.datos = datos;
        //this.encabezado = encabezado;
    }
    private void createSheet(String titlteSheet) {
        // Supón que workbook es tu XSSFWorkbook y sheetName es el nombre de la hoja
        if (workbook.getSheet(titlteSheet) != null) {
            // El nombre ya existe, puedes lanzar una excepción, renombrar, o eliminar la hoja
            // Por ejemplo, renombrar:
            int i = 1;
            String newSheetName = titlteSheet;
            while (workbook.getSheet(newSheetName) != null) {
                newSheetName = titlteSheet + "_" + i;
                i++;
            }
            titlteSheet = newSheetName;
        }
        this.hoja = workbook.createSheet(titlteSheet);
    }
    abstract protected void cortarEncabezado();

    abstract protected void cortarCuerpo();
    
    abstract public void exportarReporte();

    public void setDireccionGuardado(String direccionGuardado) {
        this.direccionGuardado = direccionGuardado;
    }
}
