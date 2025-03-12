package com.tabela.fipe.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FipeService {

    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/carros/marcas";

    public String obterMarcas() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BASE_URL, String.class);
    }
}
