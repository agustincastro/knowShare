package com.knowshare.models.user;

import com.knowshare.models.DAO;


public interface UserDAO extends DAO<User> {

    User findByEmail(String email);

}
