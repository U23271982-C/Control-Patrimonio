package org.contenido.reporte;

import java.util.ArrayList;
import java.util.List;

import org.contenido.utilidad.NotificacionUtil;
import org.contenido.utilidad.exportar.TipoDocumento;

public abstract class ReportePlantilla extends Reporte {

    public ReportePlantilla(String tituloHoja, TipoDocumento extencion/*, String[] encabezado*/,List<Object[]> listaTabla) {
        super(tituloHoja, extencion/*, encabezado*/,listaTabla);
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

    @Override
    protected void cortarEncabezado() {
        int numColumnas = this.datos.getFirst().length;

        this.encabezado = new String[numColumnas];
        // se corta fila encabezados
        for (int i = 0; i < numColumnas; i++) {
            this.encabezado[i] = this.datos.getFirst()[i].toString();
        }
    }

    // corta el cuerpo de la consulta
    @Override
    protected void cortarCuerpo() {
        this.contenido = new ArrayList<>();
        // se corta solo datos cuerpo, pasa contenido
        for (int i = 1; i < datos.size(); i++) {
            this.contenido.add(datos.get(i));
        }
    }
    
    private void formatearReporte() {
        cortarEncabezado();
        cortarCuerpo();
        // Ajustar el tamaño de las columnas
        for(int i = 0; i < encabezado.length; i++){
            hoja.autoSizeColumn(i);
        }
    }

}
