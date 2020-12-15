package com.frontier.back.lemon_tree.data.entity;

public class Employee extends Model {
    private String name;

    private String email;

    private String password;

    public Employee() { }

    public Employee(int id, String name, String email) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
