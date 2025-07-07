package org.contenido.utilidad.exportar;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public enum TipoDocumento {
    XLSX(new ExportarExcel(), new XSSFWorkbook(), ".xlsx");

    private Exportador exportador;
    private Object documento; // Puede recibir cualquier tipo de documento, haciendolo más flexible
    private String extension;

    TipoDocumento(Exportador exportador, Object documento, String extension) {
        this.exportador = exportador;
        this.documento = documento;
        this.extension = extension;
    }

    public Exportador getExportador() {
        return exportador;
    }

    public void setExportador(Exportador exportador) {
        this.exportador = exportador;
    }

    @SuppressWarnings("unchecked")
    public <T> T getDocumento() {
        return (T) documento;
    }

    public void setDocumento(Object documento) {
        this.documento = documento;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
