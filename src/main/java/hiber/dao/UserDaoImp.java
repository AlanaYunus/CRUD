package hiber.dao;

import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("select e from User e",
                User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(int id) {
        entityManager.createQuery("delete from User where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);

    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

}
