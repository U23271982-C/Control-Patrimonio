package org.contenido.reporte;

import java.util.ArrayList;
import java.util.List;

import org.contenido.utilidad.NotificacionUtil;
import org.contenido.utilidad.exportar.TipoDocumento;

public abstract class ReportePlantilla extends Reporte {

    public ReportePlantilla(String tituloHoja, TipoDocumento extencion, String[] encabezado,List<Object[]> listaTabla) {
        super(tituloHoja, extencion, encabezado,listaTabla);
        //rellenarDatos();
        formatearReporte();
    }


    private void rellenarDatos() {
        try {
            /*this.datos = List.of(
                    new Object[]{"Orden", "Equipo", "Modelo"},
                    new Object[]{1, "Laptop", "Laptop HP i5"},
                    new Object[]{2, "Mouse", "Mouse inalámbrico"},
                    new Object[]{3, "Monitor", "Monitor Samsung 24p"}
            );*/

        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    // corta el cuerpo de la consulta
    @Override
    protected void cortarCuerpo() {
        this.contenido = new ArrayList<>();
        // se corta solo datos cuerpo, pasa contenido
        this.contenido.addAll(datos);
    }
    
    private void formatearReporte() {
        cortarCuerpo();
        // Ajustar el tamaño de las columnas
        for(int i = 0; i < encabezado.length; i++){
            hoja.autoSizeColumn(i);
        }
    }

}
