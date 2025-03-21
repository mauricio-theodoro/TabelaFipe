package com.tabela.fipe.controller;

import com.tabela.fipe.model.Carro;
import com.tabela.fipe.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public ResponseEntity<List<Carro>> listarTodos() {
        List<Carro> carros = carroService.listarCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {
        return carroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carro> criarCarro(@Valid @RequestBody Carro carro) {
        Carro novoCarro = carroService.salvarCarro(carro);
        return ResponseEntity.ok(novoCarro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @Valid @RequestBody Carro carro) {
        Carro carroAtualizado = carroService.atualizarCarro(id, carro);
        return ResponseEntity.ok(carroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCarro(@PathVariable Long id) {
        carroService.deletarCarro(id);
        return ResponseEntity.ok("Carro deletado com sucesso!");
    }

    // Captura exceções para retornar mensagens mais amigáveis
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
