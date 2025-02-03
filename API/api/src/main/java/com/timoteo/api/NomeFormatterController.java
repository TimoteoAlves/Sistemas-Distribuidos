package com.timoteo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class NomeFormatterController {

    private static final Set<String> PRONOMES_VALIDOS = Set.of(
        "Sr.", "Sra.", "Vossa Alteza", "Vossa Eminência", "Vossa Magnificência",
        "Vossa Santidade", "Vossa Majestade", "Vossa Excelência", "Vossa Reverendíssima"
    );

    @GetMapping("/formatar-nome")
    public String formatarNome(
        @RequestParam(required = false) String pronome,
        @RequestParam(required = false) String nome,
        @RequestParam(required = false) String sobrenome
    ) {
        pronome = (pronome != null && PRONOMES_VALIDOS.contains(pronome)) ? pronome : "Caro(a)";
        nome = (nome != null && !nome.trim().isEmpty()) ? nome : "Usuário";
        sobrenome = (sobrenome != null && !sobrenome.trim().isEmpty()) ? sobrenome : "Desconhecido";
        
        return String.format("(%s; %s, %s)", pronome, sobrenome, nome);
    }
}
