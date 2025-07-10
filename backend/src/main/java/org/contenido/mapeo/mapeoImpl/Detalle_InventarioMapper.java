package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.Detalle_InventarioDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.*;

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
        Inventario inventario = new Inventario(rs.getInt(22),rs.getString(23),rs.getString(24),(rs.getDate(25)).toLocalDate());
        Rol_Responsable rol= new Rol_Responsable(rs.getInt(19),rs.getString(20),rs.getString(21));
        Responsable responsable = new Responsable(rs.getInt(13),rs.getString(14),rs.getString(15),rs.getString(16),rol,rs.getString(17),rs.getString(18));
        Ambiente ambiente= new Ambiente(rs.getInt(11),rs.getString(12), null);
        Categoria categoria = new Categoria(rs.getInt(8),rs.getString(9),rs.getString(10));
        Estado estado = new Estado(rs.getInt(6),rs.getString(7));
        Bien bien = new Bien(rs.getInt(2),rs.getString(3),rs.getString(4),(rs.getDate(5)).toLocalDate(),estado,categoria,ambiente, responsable);
        Detalle_Inventario entidad = new Detalle_Inventario(rs.getInt(1),bien,inventario);
        return entidad;
    }
}
