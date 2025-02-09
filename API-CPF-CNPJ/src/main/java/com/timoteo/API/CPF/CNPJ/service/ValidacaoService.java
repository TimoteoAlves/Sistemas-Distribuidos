package com.timoteo.API.CPF.CNPJ.service;

import org.springframework.stereotype.Service;

@Service
public class ValidacaoService {

    public boolean validarCPF(String cpf) {
        return cpf != null && cpf.matches("\\d{11}"); // Validação simples
    }

    public boolean validarCNPJ(String cnpj) {
        return cnpj != null && cnpj.matches("\\d{14}"); // Validação simples
    }
}
