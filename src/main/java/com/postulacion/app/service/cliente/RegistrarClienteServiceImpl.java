package com.postulacion.app.service.cliente;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrarClienteServiceImpl implements RegistrarClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        Cliente clienteCreated = clienteRepository.save(cliente);
        return clienteCreated;
    }
}
