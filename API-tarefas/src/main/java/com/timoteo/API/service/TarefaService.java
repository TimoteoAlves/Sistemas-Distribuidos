package com.timoteo.API.service;

import com.timoteo.API.model.Tarefa;
import com.timoteo.API.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa buscarTarefa(Long id) {
        return tarefaRepository.findById(id).orElseThrow();
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada) {
        Tarefa tarefa = buscarTarefa(id);
        tarefa.setDescricao(tarefaAtualizada.getDescricao());
        tarefa.setConcluida(tarefaAtualizada.isConcluida());
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefa(Long id) {
        Tarefa tarefa = buscarTarefa(id);
        tarefaRepository.delete(tarefa);
    }
}
