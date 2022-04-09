package com.postulacion.app.service.cliente;

import com.postulacion.app.config.exception.BadRequestException;
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
        if(cliente.getIdentificacion() == null || cliente.getIdentificacion().trim().equals("")){
            throw new BadRequestException("El campo identificacion no puede estar vacio");
        }

        if(cliente.getNombre() == null || cliente.getNombre().trim().equals("")){
            throw new BadRequestException("El campo nombre no puede estar vacio");
        }
        Cliente clienteCreated = clienteRepository.save(cliente);
        return clienteCreated;
    }
}
