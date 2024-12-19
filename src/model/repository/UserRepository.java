package model.repository;

import database.Builder;
import database.Database;
import database.Mapper;
import model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository extends Builder implements IUserRepository, Mapper {


    public UserRepository() {
        super("users");
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void save(User entity) {
        String query = insert("email", "name").build();

        try (Connection connection = Database.connection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, entity.getEmail());
            stmt.setString(2, entity.getName());
            stmt.executeUpdate();

        }
        catch (SQLException e) {
            System.out.println("Failed to save user");
        }
    }

    @Override
    public Optional<User> find(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        String query = select().build();
        List<User> users = new ArrayList<>();

        try (Connection connection = Database.connection();
             Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery(query)) {

            while (result.next()) {
                users.add(mapRow(result));
            }

        } catch (SQLException e) {
            System.out.println("Unable to retrieve all users");
        }

        return users;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User mapRow(ResultSet result) throws SQLException {
        User user = new User();
        user.setId(result.getLong("id"));
        user.setName(result.getString("name"));
        user.setEmail(result.getString("email"));
        return user;
    }
}
