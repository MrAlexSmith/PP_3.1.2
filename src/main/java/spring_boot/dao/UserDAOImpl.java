package spring_boot.dao;

import spring_boot.models.User;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Query;
import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("delete from User where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}