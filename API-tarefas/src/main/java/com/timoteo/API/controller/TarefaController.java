package com.timoteo.API.controller;

import com.timoteo.API.model.Tarefa;
import com.timoteo.API.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefa(@PathVariable Long id) {
        return tarefaService.buscarTarefa(id);
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.criarTarefa(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizarTarefa(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
    }
}
