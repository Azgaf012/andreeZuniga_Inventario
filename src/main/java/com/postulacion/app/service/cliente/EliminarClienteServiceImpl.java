package com.postulacion.app.service.cliente;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EliminarClienteServiceImpl implements EliminarClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ListarClienteServiceImpl listarClienteService;

    @Override
    public boolean eliminarCliente(Long id) {
        Cliente cliente = listarClienteService.obtenerCliente(id);
        clienteRepository.delete(cliente);
        return true;
    }
}
