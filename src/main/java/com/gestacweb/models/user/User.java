package com.gestacweb.models.user;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING, length=20)
@NamedQueries({
                @NamedQuery(name = "findUserById", query = "select u from User u where u.id = :id"),
                @NamedQuery(name = "findByEmail", query = "select u from User u where u.email = :email"),
                @NamedQuery(name = "findAllUsers", query = "select u from User u")
})
@DiscriminatorValue(User.USER)
public class User implements Serializable{

    public static final String SOURCE = "SOURCE";
    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";

    private long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String type;

    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "type", updatable = false, insertable = false, nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
