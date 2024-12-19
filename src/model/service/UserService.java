package model.service;

import model.entity.User;
import model.repository.IUserRepository;

import java.util.List;

public class UserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        this.userRepository.save(user);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

}
