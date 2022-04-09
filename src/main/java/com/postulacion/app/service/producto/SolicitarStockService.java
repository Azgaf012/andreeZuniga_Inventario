package com.postulacion.app.service.producto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postulacion.app.util.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SolicitarStockService {

    private RestClient restClient=new RestClient();

    public Map<String,Object> solicitar(String path) throws Exception {
        String strProducts = restClient.get(path);
        ObjectMapper objectMapper = new ObjectMapper ();
        return objectMapper.readValue(strProducts,new TypeReference<Map<String,Object>>(){});

    }


}
