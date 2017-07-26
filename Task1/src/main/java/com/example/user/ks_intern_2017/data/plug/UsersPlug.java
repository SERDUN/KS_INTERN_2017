package com.example.user.ks_intern_2017.data.plug;


import com.example.user.ks_intern_2017.data.model.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 23.07.2017.
 */

public class UsersPlug {
    private ArrayList<User> users = new ArrayList<>();

    public UsersPlug(int count){
        for (int i = 0; i < count; i++)
            users.add(generateRandomUser(i));
    }




    public  ArrayList<User> getUsers() {
        return users;
    }

    private  User generateRandomUser(int id) {
        String name = generateWord(4, 5,true);
        boolean isOnline = Math.random() < 0.5;
        String email = generateWord(5, 6,false) + "@" + generateWord(2, 4,false) + "." + generateWord(1, 3,false);
        User.Category category = User.Category.values()[(int) (Math.random() * 4)];
        User user = new User(++id, name, isOnline, email, category);
        return user;

    }


    private  String generateWord(int startWithIndex, int endWithIndex, boolean isUpperFirstChar) {
        String chars = "qwertyuiopasdfghjklzxcvbnm";
        StringBuilder rand = new StringBuilder();
        int count = (int) (startWithIndex + Math.random() * endWithIndex);
        for (int i = 0; i < count; i++)
            rand.append(chars.charAt((int) (Math.random() * chars.length())));
        String name;
        if (isUpperFirstChar)
            name = rand.toString().substring(0, 1).toUpperCase() + rand.toString().substring(1);
        else
            name = rand.toString();

        return name;
    }


}
