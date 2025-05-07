package org.contenido.mapeo;

import org.contenido.dto.CategoriaDTO;
import org.contenido.model.Categoria;

public class CategoriaMapper implements Convertidor<Categoria, CategoriaDTO>{
    public CategoriaMapper() {
    }

    @Override
    public CategoriaDTO convertidorDTO(Categoria modelo) {
        return null;
    }

    @Override
    public Categoria convertidorModelo(CategoriaDTO dto) {
        return null;
    }
}
