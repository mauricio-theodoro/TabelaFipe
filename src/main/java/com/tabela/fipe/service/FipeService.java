package com.tabela.fipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@Service
public class FipeService {

    private static final String FIPE_API_URL = "https://parallelum.com.br/fipe/api/v1/carros";

    @Autowired
    private RestTemplate restTemplate;

    // Método para buscar marcas de veículos com tratamento de erro
    public ResponseEntity<?> getMarcas() {
        try {
            String url = FIPE_API_URL + "/marcas";
            Object response = restTemplate.getForObject(url, Object.class);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            return ResponseEntity.status(503).body("Erro ao conectar com a API FIPE. Tente novamente mais tarde.");
        }
    }

    // Método para buscar modelos de uma marca específica
    public ResponseEntity<?> getModelosByMarca(String marcaId) {
        if (marcaId == null || marcaId.isBlank()) {
            return ResponseEntity.badRequest().body("ID da marca não pode ser nulo ou vazio.");
        }
        try {
            String url = FIPE_API_URL + "/marcas/" + marcaId + "/modelos";
            Object response = restTemplate.getForObject(url, Object.class);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            return ResponseEntity.status(503).body("Erro ao buscar modelos. Verifique o ID da marca.");
        }
    }

    // Método para buscar anos de um modelo específico
    public ResponseEntity<?> getAnosByModelo(String marcaId, String modeloId) {
        if (marcaId == null || marcaId.isBlank() || modeloId == null || modeloId.isBlank()) {
            return ResponseEntity.badRequest().body("Marca e modelo não podem ser nulos ou vazios.");
        }
        try {
            String url = FIPE_API_URL + "/marcas/" + marcaId + "/modelos/" + modeloId + "/anos";
            Object response = restTemplate.getForObject(url, Object.class);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            return ResponseEntity.status(503).body("Erro ao buscar anos para o modelo informado.");
        }
    }

    // Método para buscar o preço de um modelo e ano específicos
    public ResponseEntity<?> getPrecoByModeloAno(String marcaId, String modeloId, String anoId) {
        if (marcaId == null || marcaId.isBlank() || modeloId == null || modeloId.isBlank() || anoId == null || anoId.isBlank()) {
            return ResponseEntity.badRequest().body("Marca, modelo e ano não podem ser nulos ou vazios.");
        }
        try {
            String url = FIPE_API_URL + "/marcas/" + marcaId + "/modelos/" + modeloId + "/anos/" + anoId;
            Object response = restTemplate.getForObject(url, Object.class);
            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            return ResponseEntity.status(503).body("Erro ao buscar preço. Verifique os dados informados.");
        }
    }
}
