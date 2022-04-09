package com.postulacion.app.service.cliente;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActualizarClienteServiceImpl implements ActualizarClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ListarClienteServiceImpl listarClienteService;

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        Cliente clienteActualizar = listarClienteService.obtenerCliente(cliente.getId());
        clienteActualizar.setNombre(cliente.getNombre());
        clienteActualizar.setFoto(cliente.getFoto());

        return clienteRepository.save(clienteActualizar);
    }
}
