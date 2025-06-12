package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.Detalle_InventarioDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Detalle_Inventario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Detalle_InventarioMapper implements Convertidor<Detalle_Inventario, Detalle_InventarioDTO>, ResultSetMapper<Detalle_Inventario> {
    private final BienMapper bienMapper;
    private final InventarioMapper inventarioMapper;
    public Detalle_InventarioMapper() {
        this.bienMapper = new BienMapper();
        this.inventarioMapper = new InventarioMapper();
    }

    @Override
    public Detalle_InventarioDTO convertirDTO(Detalle_Inventario modelo) {
        if (modelo == null) throw new NegocioExcepcion("El objeto detalle inventario es nulo");

        Detalle_InventarioDTO dto = new Detalle_InventarioDTO();
        dto.setId(modelo.getId());
        dto.setBienDTO(
                modelo.getBien() != null ?
                        bienMapper.convertirDTO(modelo.getBien()) : null
        );
        dto.setInventarioDTO(
                modelo.getInventario() != null ?
                        inventarioMapper.convertirDTO(modelo.getInventario()) : null
        );
        return dto;
    }

    @Override
    public Detalle_Inventario convertirModelo(Detalle_InventarioDTO dto) {
        if (dto == null) throw new NegocioExcepcion("El objeto detalle inventarioDTO es nulo");
        return new Detalle_Inventario(
                dto.getId(),
                dto.getBienDTO() != null ?
                        bienMapper.convertirModelo(dto.getBienDTO()) : null,
                dto.getInventarioDTO() != null ?
                        inventarioMapper.convertirModelo(dto.getInventarioDTO()) : null
        );
    }

    @Override
    public Detalle_Inventario mapDeResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
