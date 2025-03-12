package com.tabela.fipe.service;

import com.tabela.fipe.model.Carro;
import com.tabela.fipe.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> listarCarros() {
        return carroRepository.findAll();
    }

    public Optional<Carro> buscarPorId(Long id) {
        return carroRepository.findById(id);
    }

    public Carro salvarCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro atualizarCarro(Long id, Carro novoCarro) {
        return carroRepository.findById(id)
                .map(carro -> {
                    carro.setMarca(novoCarro.getMarca());
                    carro.setModelo(novoCarro.getModelo());
                    carro.setAno(novoCarro.getAno());
                    carro.setValor(novoCarro.getValor());
                    return carroRepository.save(carro);
                })
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
    }

    public void deletarCarro(Long id) {
        carroRepository.deleteById(id);
    }
}
