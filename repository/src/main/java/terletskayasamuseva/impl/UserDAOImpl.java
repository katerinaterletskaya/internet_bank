package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.UserDAO;
import terletskayasamuseva.model.Role;
import terletskayasamuseva.model.User;
import terletskayasamuseva.model.UserInformation;

import java.util.List;


@Repository
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {
    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public User getUserByEmail(String email) {
        return (User) getSession().createQuery("from User where login=:email").setParameter("email", email).uniqueResult();
    }

    @Override
    public User getUser(String email) {
        User user = (User) getSession().createQuery("from User where login=:email").setParameter("email", email).uniqueResult();
        UserInformation userInformation = (UserInformation) getSession().createQuery("from UserInformation  where userId=:id").setParameter("id", user.getId()).uniqueResult();
        user.setUserInformation((UserInformation) getSession().createQuery("from UserInformation  where userId=:id").setParameter("id", user.getId()).uniqueResult());
        return user;
    }

    @Override
    public UserInformation getUserByPassport(String passport) {
        UserInformation info = (UserInformation) getSession().createQuery("from UserInformation where passportNumber=:passport")
                .setParameter("passport", passport).uniqueResult();
        return info;
    }

    @Override
    public Long getIdUserByUserName(String email) {
        return (Long) getSession().createQuery("select u.id from User as u where u.login=:email").setParameter("email", email).uniqueResult();
    }

    @Override
    public void updateUser(User user) {
        UserInformation info = (UserInformation) getSession().createQuery("from UserInformation where userId=:id").setParameter("id", user.getId()).uniqueResult();
        getSession().update(info);
        info.setSurname(user.getUserInformation().getSurname());
        info.setName(user.getUserInformation().getName());
        info.setPatronymic(user.getUserInformation().getPatronymic());
    }


    @Override
    public void updatePassword(User user) {
        User newUser = (User) getSession().createQuery("from User where id=:id").setParameter("id", user.getId()).uniqueResult();
        getSession().update(newUser);
        newUser.setPassword(user.getPassword());
    }

    @Override
    public void updateLogin(User user) {
        User newUser = (User) getSession().createQuery("from User where id=:id").setParameter("id", user.getId()).uniqueResult();
        getSession().update(newUser);
        newUser.setLogin(user.getLogin());
    }

    @Override
    public void updateRole(User user) {
        User newUser = (User) getSession().createQuery("from User where id=:id").setParameter("id", user.getId()).uniqueResult();
        getSession().update(newUser);
        newUser.setRole(user.getRole());
    }

    @Override
    public List<User> getUserForAdmin() {
        return (List<User>) getSession().createQuery("from User as u where u.role=:role")
                .setParameter("role", Role.ROLE_USER).list();
    }

    @Override
    public UserInformation getUserForAccount(User user) {
        UserInformation userInformation = (UserInformation) getSession().createQuery("from UserInformation  " +
                "where surname=:surname and name=:name and patronymic=:patronymic and " +
                "passportNumber=:passport")
                .setParameter("surname", user.getUserInformation().getSurname())
                .setParameter("name", user.getUserInformation().getName())
                .setParameter("patronymic", user.getUserInformation().getPatronymic())
                .setParameter("passport", user.getUserInformation().getPassportNumber());
        return userInformation;
    }
}
