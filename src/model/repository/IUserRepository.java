package model.repository;

import model.entity.User;

import java.util.Optional;

public interface IUserRepository extends IRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
