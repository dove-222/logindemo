package com.smart.entity;


import java.util.Objects;

public class User {
    private Integer id;
    private String username;
    private String password;
    private int userAge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserAge() {
        return userAge;
    }

    public User(){}

    public User(Integer id, String username, String password, int userAge) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userAge = userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
        Double i = 100.0;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userAge == user.userAge &&
                id.equals(user.id) &&
                username.equals(user.username) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, userAge);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
