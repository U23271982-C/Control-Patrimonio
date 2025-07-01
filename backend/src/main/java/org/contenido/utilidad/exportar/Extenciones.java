package org.contenido.utilidad.exportar;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public enum Extenciones {
    XLSX(new ExportarExcel(), new XSSFWorkbook(), ".xlsx");

    private Exportador exportador;
    private Workbook workbook;
    private String extension;

    Extenciones(Exportador exportador, Workbook workbook, String extension) {
        this.exportador = exportador;
        this.workbook = workbook;
        this.extension = extension;
    }

    public Exportador getExportador() {
        return exportador;
    }

    public void setExportador(Exportador exportador) {
        this.exportador = exportador;
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
