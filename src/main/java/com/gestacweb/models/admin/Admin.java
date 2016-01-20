package com.gestacweb.models.admin;

import com.gestacweb.models.user.User;

import javax.persistence.*;

@Entity
@Table(name = "admins")
@DiscriminatorValue(User.ADMIN)
@NamedQueries({
        @NamedQuery(name = "findAdminById", query = "select a from Admin a where a.id = :id"),
        @NamedQuery(name = "findAllAdmins", query = "select a from Admin a")
})
public class Admin extends User {

}
