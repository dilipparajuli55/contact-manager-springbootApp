package com.dilipcodes.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String name;
    private String email;
    @Column(unique = true)
    private String jobTitle;
    private String address;
    private int phoneNumber;
    @Column(length = 500)
    private String description;

    // Mapping
    @ManyToOne
    private User user;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contact(int cid, String name, String email, String jobTitle, String address, int phoneNumber, String description) {
        this.cid = cid;
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public Contact() {

    }
}
