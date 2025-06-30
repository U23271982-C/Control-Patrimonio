package org.contenido.utilidad.exportar;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.contenido.excepcion.ExportarExcepcion;
import org.contenido.utilidad.NotificacionUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public interface Exportador<Tipo> {
    void exportar(Tipo tipoLibro,String rutaArchivo);
}
