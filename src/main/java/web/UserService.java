package web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    private List<User> userList;

    private int id;

    public UserService() {
        userList = new ArrayList<>();
        userList.add(new User(1, "Jorge","jorge@gmail.com","123",Calendar.getInstance()));
        userList.add(new User(1, "Ana","ana@gmail.com","456",Calendar.getInstance())); 
        id = 3;
    }
    
    public List<User> findAll() {
        return userList;
    }

    public User findOne(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public boolean save(User user) {
        if (userList.contains(user)) {
            return false;
        } else {
            userList.add(user);
            return true;
        }
    }

    public void delete(int id) {
        userList.remove(new User(id));
    }
    
    public int generateId() {
        return id++;
    }
    
    }
