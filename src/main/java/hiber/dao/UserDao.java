package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> allUsers();

    void add(User user);

    void delete(int id);

    void edit(User user);

    User getById(int id);
}
