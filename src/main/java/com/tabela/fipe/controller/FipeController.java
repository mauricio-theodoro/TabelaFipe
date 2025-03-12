package com.tabela.fipe.controller;


import com.tabela.fipe.service.FipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fipe")
public class FipeController {

    private final FipeService fipeService;

    public FipeController(FipeService fipeService) {
        this.fipeService = fipeService;
    }

    @GetMapping("/marcas")
    public String listarMarcas() {
        return fipeService.obterMarcas();
    }
}
