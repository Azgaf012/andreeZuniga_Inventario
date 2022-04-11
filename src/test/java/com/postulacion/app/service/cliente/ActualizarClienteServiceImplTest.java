package com.postulacion.app.service.cliente;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ListarClienteServiceImpl listarClienteService;

    @InjectMocks
    private ActualizarClienteServiceImpl actualizarClienteService;

    @Test
    void actualizarCliente() {
        Cliente cliente = new Cliente("Juan","123456","");
        cliente.setId(1L);

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        when(listarClienteService.obtenerCliente(anyLong())).thenReturn(cliente);
        Cliente clienteActualizado = actualizarClienteService.actualizarCliente(cliente);
        assertNotNull(cliente);
        assertEquals("Juan",cliente.getNombre());
        assertEquals("123456",cliente.getIdentificacion());
    }
}