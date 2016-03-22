package data.services;

import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import config.ResourceNames;
import data.daos.AuthorizationDao;
import data.daos.UserDao;
import data.entities.Authorization;
import data.entities.Role;
import data.entities.User;

@Service
@Transactional
@PropertySource(ResourceNames.PROPERTIES)
public class Populate {

    private String adminUsername;

    private String adminEmail;

    private String adminPassword;

    @Autowired
    private Environment environment;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthorizationDao authorizationDao;

    @PostConstruct
    public void readAdmin() {
        adminUsername = environment.getProperty("admin.username");
        adminEmail = environment.getProperty("admin.email");
        adminPassword = environment.getProperty("admin.password");
        createDefaultAdmin();
    }

    public void createDefaultAdmin() {
        User adminSaved = userDao.findByUsernameOrEmail(adminUsername);
        if (adminSaved == null) {
            User admin = new User(adminUsername, adminEmail, adminPassword, new GregorianCalendar(1979, 07, 22));
            userDao.save(admin);
            authorizationDao.save(new Authorization(admin, Role.ADMIN));
        }
    }

}
