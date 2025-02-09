package com.timoteo.API.CPF.CNPJ;

import com.timoteo.API.CPF.CNPJ.service.ValidacaoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ValidacaoController {
    
    private final ValidacaoService validacaoService;

    public ValidacaoController(ValidacaoService validacaoService) {
        this.validacaoService = validacaoService;
    }

    @GetMapping("/CPF/{cpf}")
    public String validarCPF(@PathVariable String cpf) {
        return validacaoService.validarCPF(cpf) ? "CPF Válido" : "CPF Inválido";
    }

    @GetMapping("/CNPJ/{cnpj}")
    public String validarCNPJ(@PathVariable String cnpj) {
        return validacaoService.validarCNPJ(cnpj) ? "CNPJ Válido" : "CNPJ Inválido";
    }
}
