package spring_boot.services;

import spring_boot.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUser(int id);
    public void deleteUser(int id);
}
