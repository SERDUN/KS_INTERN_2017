package com.example.user.ks_intern_2017.data.model;

import java.io.Serializable;

/**
 * Created by User on 23.07.2017.
 */

public class User implements Serializable {

    public enum Category {
        FRIENDS("friend"),
        FAMILY("family"),
        WORK("work"),
        OTHER("other");

        private final String category;

        private Category(String s) {
            category = s;
        }

        public boolean equalsName(String otherName) {
            return category.equals(otherName);
        }

        public String toString() {
            return this.category;
        }
    }

    private String username;
    private int id;
    private boolean isOnline;
    private String userAddress;
    private Category category;

    public User(int id, String username, boolean isOnline, String userAddress, Category category) {
        this.username = username;
        this.id = id;
        this.isOnline = isOnline;
        this.userAddress = userAddress;
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (isOnline != user.isOnline) return false;
        if (!username.equals(user.username)) return false;
        if (!userAddress.equals(user.userAddress)) return false;
        return category == user.category;

    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + id;
        result = 31 * result + (isOnline ? 1 : 0);
        result = 31 * result + userAddress.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", isOnline=" + isOnline +
                ", userAddress='" + userAddress + '\'' +
                ", category=" + category +
                '}';
    }
}
