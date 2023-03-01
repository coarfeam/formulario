package com.eamapp.springweb.services;
import java.util.List;
import com.eamapp.springweb.models.entity.Pais;

public interface IPaisService {
    public List<Pais> listar();
    public Pais obtenerporId(Integer id);
}
