package com.mutlucankarinca.rest.webservices.restfullwebservices.User;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount=3;
    static {
        users.add(new User(1,"Mutlucan",new Date()));
        users.add(new User(2,"Ali",new Date()));
        users.add(new User(3,"Veli",new Date()));
    }

    //findAll();
    //saveUser();
    //findUser();
    public List<User> findAll(){
        return users;
    }

    public User saveUser(User user){
        if (user.getId()==null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findUser(Integer id){
        for (User user: users){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(Integer id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
