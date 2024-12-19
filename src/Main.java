import model.Model;
import model.entity.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Model models = new Model();

        for(User u : models.user.getAll()) {
            System.out.println(u.getEmail());
            System.out.println(u.getId());
        }

        models.user.create(new User("hello@test.com", "harry"));

        for(User u : models.user.getAll()) {
            System.out.println(u.getEmail());
            System.out.println(u.getId());
        }
    }

}