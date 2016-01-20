package com.gestacweb.models.user;

import com.gestacweb.models.DAO;


public interface UserDAO extends DAO<User> {

    User findByEmail(String email);

}
