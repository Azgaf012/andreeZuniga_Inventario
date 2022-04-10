package com.postulacion.app.service.cliente;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.repository.ClienteRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListarClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ListarClienteServiceImpl listarClienteService;

    @BeforeEach
    void setUp() {
        //listarClienteService = new ListarClienteServiceImpl( clienteRepository);
    }

    @Test
    void testObtenerCliente() {

        Cliente cliente = mock(Cliente.class);
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(cliente));

        assertNotNull(listarClienteService.obtenerCliente(1L));
    }

    @Test
    void testListarClientes() {
        List<Cliente> clientesMock = List.of(mock(Cliente.class), mock(Cliente.class), mock(Cliente.class));
        when(clienteRepository.findAll()).thenReturn(clientesMock);
        List<Cliente> clientes = listarClienteService.listarClientes();
        assertNotNull(clientes);
        assert(clientes.size() == 3);
    }
}