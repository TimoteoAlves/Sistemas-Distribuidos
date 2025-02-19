package com.timoteo.project.service;

import com.timoteo.project.model.User;
import com.timoteo.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Método para listar todos os usuários
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Método para criar um usuário
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Método para atualizar um usuário
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User não encontrado com esse id " + id));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setResponsibility(userDetails.getResponsibility());
        user.setFirm(userDetails.getFirm());

        return userRepository.save(user);
    }

    // Método para deletar um usuário
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}