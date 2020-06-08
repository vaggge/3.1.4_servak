package ru.javamentor.dao;

import org.springframework.stereotype.Repository;
import ru.javamentor.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listOfUsers() {
        return (List<User>) entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public void addUser(User user){
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("DELETE FROM User WHERE id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public void updateUser(User user){
        entityManager.merge(user);

    }

    @Override
    public User loadUserByUsername(String username) {
       return (User) entityManager.createQuery("FROM User WHERE username = :username").setParameter("username", username).getSingleResult();
    }

    @Override
    public boolean isUserExist(User user){
        return entityManager.createQuery("FROM User WHERE username = :username").setParameter("username", user.getUsername()).getResultList().size() > 0;
    }

    @Override
    public User getById(long id){
        return (User) entityManager.createQuery("FROM User  where id = :id").setParameter("id", id).getSingleResult();
    }
}
