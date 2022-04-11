package com.postulacion.app.service.cliente;

import com.postulacion.app.config.exception.BadRequestException;
import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegistrarClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private RegistrarClienteServiceImpl registrarClienteService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testRegistrarCliente() {

        when(clienteRepository.save(any(Cliente.class))).thenReturn(new Cliente("Juan Perez","123123123",""));
        Cliente cliente = registrarClienteService.registrarCliente(new Cliente("Juan Perez","123123123",""));
        assertNotNull(cliente);
        assertEquals("Juan Perez",cliente.getNombre());
    }

    @Test
    void testValidacionRegistroCliente() {
        assertThrowsExactly(BadRequestException.class, () -> registrarClienteService.registrarCliente(new Cliente("Juan Perez","","")));
        assertThrowsExactly(BadRequestException.class, () -> registrarClienteService.registrarCliente(new Cliente("","123456123","")));
    }
}