package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import terletskayasamuseva.UserDAO;
import terletskayasamuseva.model.User;
import terletskayasamuseva.model.UserInformation;


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
        logger.info(user.toString());
        UserInformation userInformation = (UserInformation) getSession().createQuery("from UserInformation  where userId=:id").setParameter("id", user.getId()).uniqueResult();
        logger.info(userInformation.toString());
        user.setUserInformation((UserInformation) getSession().createQuery("from UserInformation  where userId=:id").setParameter("id", user.getId()).uniqueResult());
        return user;
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
}
