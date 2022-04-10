package com.postulacion.app.service.cliente;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.repository.ClienteRepository;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
class ListarClienteServiceImplTest {

    @InjectMocks
    private ListarClienteServiceImpl listarClienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    void obtenerCliente() {
        Cliente cliente = new Cliente("Juan Perez","12312312","");
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        assertNotNull(listarClienteService.obtenerCliente(1L));
    }

    @Test
    void listarClientes() {
    }
}