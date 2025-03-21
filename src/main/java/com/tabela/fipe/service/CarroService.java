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
                    carro.setAnoModelo(novoCarro.getAnoModelo());
                    carro.setValor(novoCarro.getValor());
                    carro.setCombustivel(novoCarro.getCombustivel());
                    carro.setCodigoFipe(novoCarro.getCodigoFipe());
                    carro.setMesReferencia(novoCarro.getMesReferencia());
                    carro.setSiglaCombustivel(novoCarro.getSiglaCombustivel());
                    return carroRepository.save(carro);
                })
                .orElseThrow(() -> new RuntimeException("Carro não encontrado para atualização"));
    }

    public void deletarCarro(Long id) {
        if (!carroRepository.existsById(id)) {
            throw new RuntimeException("Carro não encontrado para deleção");
        }
        carroRepository.deleteById(id);
    }
}
