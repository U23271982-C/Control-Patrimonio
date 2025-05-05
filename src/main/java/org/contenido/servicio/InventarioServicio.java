package org.contenido.servicio;

import org.contenido.dao.DAO;
import org.contenido.dao.daoImplementado.InventarioDAO;

public class InventarioServicio {
    private DAO dao;
    public InventarioServicio(DAO dao){
        this.dao = dao;
    }
}
