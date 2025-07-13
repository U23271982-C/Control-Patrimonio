package org.contenido.utilidad.exportar;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public enum TipoDocumento {
    XLSX(new ExportarExcel(), XSSFWorkbook.class , ".xlsx");

    private Exportador exportador;
    private Class<?> claseDocumento; // Puede recibir cualquier tipo de documento, haciendolo más flexible
    private String extension;

    TipoDocumento(Exportador exportador, Class<?> claseDocumento, String extension) {
        this.exportador = exportador;
        this.claseDocumento = claseDocumento;
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
        try {
            return (T) claseDocumento.getDeclaredConstructor().newInstance(); // ← Aquí se crea nuevo
        } catch (Exception e) {
            throw new RuntimeException("No se pudo crear instancia del documento", e);
        }
    }

    public void setClaseDocumento(Class<?> claseDocumento) {
        this.claseDocumento = claseDocumento;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
