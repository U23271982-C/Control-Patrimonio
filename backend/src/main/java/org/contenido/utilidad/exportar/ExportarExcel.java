package org.contenido.utilidad.exportar;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.contenido.utilidad.NotificacionUtil;

import java.io.FileOutputStream;

public class ExportarExcel implements Exportador<XSSFWorkbook> {

    @Override
    public void exportar(XSSFWorkbook workbook, String rutaArchivo) {
        try (FileOutputStream fos = new FileOutputStream(rutaArchivo)) {
            workbook.write(fos);
            workbook.close();
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Se guardo correctamente el archivo exitosamente");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }

    }
}
