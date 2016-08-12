package com.knowshare.models.admin;

import com.knowshare.models.user.User;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@DiscriminatorValue(User.ADMIN)
@NamedQueries({
        @NamedQuery(name = "findAdminById", query = "select a from Admin a where a.id = :id"),
        @NamedQuery(name = "findAllAdmins", query = "select a from Admin a")
})
public class Admin extends User {

}
