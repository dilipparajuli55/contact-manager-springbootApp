package com.dilipcodes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @NotBlank(message = "Username can not be  blank.")
    @Size(min = 5, max = 20, message = "Username should be between 5 to 20 characters long.")
    private String userName;
    @Column(unique = true)
    @Email
    private String userEmail;
    private String password;
    private String userImageUrl;
    @Column(length = 500)
    private String userAbout;
    private String userRole;
    private boolean isActive;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Contact> contacts = new ArrayList<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getUserAbout() {
        return userAbout;
    }

    public void setUserAbout(String userAbout) {
        this.userAbout = userAbout;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User(int userId, String userName, String userEmail, String password, String userImageUrl, String userAbout, String userRole, boolean isActive) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.userImageUrl = userImageUrl;
        this.userAbout = userAbout;
        this.userRole = userRole;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", userImageUrl='" + userImageUrl + '\'' +
                ", userAbout='" + userAbout + '\'' +
                ", userRole='" + userRole + '\'' +
                ", isActive=" + isActive +
                ", contacts=" + contacts +
                '}';
    }

    public User() {
    }
}
