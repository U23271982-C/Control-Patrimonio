package org.contenido.reporte;

import org.apache.poi.ss.usermodel.Row;
import org.contenido.utilidad.NotificacionUtil;
import org.contenido.utilidad.exportar.Exportador;
import org.contenido.utilidad.exportar.ExportarExcel;
import org.contenido.utilidad.exportar.TipoDocumento;

import java.util.List;

public class ReporteXLSX extends ReportePlantilla {
    Row filaEncabezado;

    public ReporteXLSX(String tituloHoja, String tituloLibro, String direccionGuardado, List<Object[]> datos) {
        super(tituloHoja, TipoDocumento.XLSX, datos);
        super.direccionGuardado = String.format
                ("%s%s%s", direccionGuardado, tituloLibro, TipoDocumento.XLSX.getExtension());
        crearReporte();

    }

    private void formatearEncabezadoHojaCalculo() {
        String[] e = super.encabezado;

        this.filaEncabezado = super.hoja.createRow(0);

        // llenamos las celadas del encabezado
        for (int i = 0; i < e.length; i++) {
            this.filaEncabezado.createCell(i).setCellValue(e[i]);
        }
    }

    private void formatearCuerpoHojaCalculo() {
        // formatear el cuerpo del reporte
        int filaComienzoCuerpo = 1;
        for (Object[] filaCuerpo : super.contenido) {
            Row fila = super.hoja.createRow(filaComienzoCuerpo++);
            for (int i = 0; i < filaCuerpo.length; i++) {
                fila.createCell(i).setCellValue(filaCuerpo[i].toString());
            }
        }
    }

    private void crearReporte() {
        formatearEncabezadoHojaCalculo();
        formatearCuerpoHojaCalculo();
    }

    @Override
    public void exportarReporte(){
        Exportador exportador = super.extencion.getExportador();
        boolean exprtaExcel = exportador instanceof ExportarExcel;

        try {
            crearReporte();
            exportador.exportar( super.workbook , super.direccionGuardado);
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }

    }
}
