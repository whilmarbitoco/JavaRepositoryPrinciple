package model;

import model.repository.UserRepository;
import model.service.UserService;

public class Model {

    public UserService user;

    public Model() {
        this.user = new UserService(new UserRepository());
    }

}
