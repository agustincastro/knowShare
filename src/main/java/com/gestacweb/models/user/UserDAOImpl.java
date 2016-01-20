package com.gestacweb.models.user;

import com.gestacweb.models.BaseDAO;
import com.gestacweb.utils.BCrypt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

    private static final Logger LOG = LogManager.getLogger(UserDAOImpl.class);

    public UserDAOImpl(){
        super();
    }

    @Override
    public void save(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        super.save(user);
    }

    @Override
    public User findById(long id) {
        Transaction t = getSession().beginTransaction();
        List result = getSession().getNamedQuery("findUserById").setLong("id", id ).list();
        if (result.size() > 0){
            t.commit();
            return (User)result.get(0);
        }
        t.rollback();
        return null;
    }

    @Override
    public User findByEmail(String email) {
        Transaction t = getSession().beginTransaction();
        List result = getSession().getNamedQuery("findByEmail").setString("email", email).list();
        if (result.size() > 0){
            t.commit();
            return (User)result.get(0);
        }
        t.rollback();
        return null;
    }

    @Override
    public Set<User> getAll() {
        Transaction t = getSession().beginTransaction();
        Set<User> result = new LinkedHashSet<User>(getSession().getNamedQuery("findAllUsers").list());
        t.commit();
        return result;
    }

}
