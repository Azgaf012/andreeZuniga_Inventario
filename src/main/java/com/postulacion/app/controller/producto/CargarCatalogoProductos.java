package com.postulacion.app.controller.producto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postulacion.app.enitity.Producto;
import com.postulacion.app.service.producto.RegistrarProductoService;
import com.postulacion.app.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CargarCatalogoProductos implements CommandLineRunner {

    private RestClient restClient=new RestClient();

    @Autowired
    private RegistrarProductoService registrarProductoService;

    @Override
    public void run(String... args) throws Exception {
        String strProducts = restClient.get("https://mocki.io/v1/f8bec313-6692-4a97-8db3-ce69b96f0cba");
        ObjectMapper objectMapper = new ObjectMapper ();
        Map<String,Object> jsonMap = objectMapper.readValue(strProducts,new TypeReference<Map<String,Object>>(){});

        List<Map<String,Object>> products = (List<Map<String,Object>>) jsonMap.get("prods");

        products.stream().forEach(product -> {
            Producto producto = new Producto();
            producto.setNombre(product.get("name").toString());
            producto.setCodigo(product.get("cod").toString());
            producto.setPrecio(Double.parseDouble(product.get("price").toString()));
            producto.setStock(Integer.parseInt(product.get("stock").toString()));
            registrarProductoService.registrarProducto(producto);
        });
    }
}
