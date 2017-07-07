package com.example.demo.entity;

import com.example.demo.model.user.Email;
import com.example.demo.model.user.Name;
import com.example.demo.model.user.Password;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})})
public final class User extends Object{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "username")) })
    private Name username;

    @Column(nullable = false)
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "email", column = @Column(name = "email")) })
    private Email email;

    @Column(nullable = false)
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "password", column = @Column(name = "password")) })
    private Password password;

    @Column(name="created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private final Date createdAt;

    @Column(name="updated_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updatedAt;

    public User() {
        this.createdAt = new Date();
    }

    public User(Name username, Email email, Password password) {
        this.username = username;
        this.password = password;
        this.email = email;

        this.createdAt = new Date();
        this.updatedAt = new Date();
    }


    public Name getUsername() {

        return username;
    }

    public Email getEmail() {

        return email;
    }

    public Password getPassword() {

        return password;
    }

    public Date getCreatedAt() {

        return createdAt;
    }

    public Date getUpdatedAt() {

        return updatedAt;
    }

    public void rename(Name username) {
        this.username = username;
    }

    public void changeEmail(Email email) {
        this.email = email;
    }

    public void changePassword(Password password) {
        this.password = password;
    }
}
