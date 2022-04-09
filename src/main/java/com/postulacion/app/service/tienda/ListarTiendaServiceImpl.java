package com.postulacion.app.service.tienda;

import com.postulacion.app.enitity.Tienda;
import com.postulacion.app.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarTiendaServiceImpl implements ListarTiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    @Override
    public Tienda listarTienda(Long id){
        return tiendaRepository.findById(id).orElse(null);
    }
}
