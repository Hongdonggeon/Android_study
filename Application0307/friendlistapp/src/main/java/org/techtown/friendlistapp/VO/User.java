package org.techtown.friendlistapp.VO;

public class User {
    private String name;
    private String email;
    private String pro_msg;

    public User(){};

    public User(String name, String email, String pro_msg) {
        this.name = name;
        this.email = email;
        this.pro_msg = pro_msg;
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

    public String getPro_msg() {
        return pro_msg;
    }

    public void setPro_msg(String pro_msg) {
        this.pro_msg = pro_msg;
    }
}