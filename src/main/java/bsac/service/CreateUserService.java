package bsac.service;

import bsac.dao.UserRepository;
import bsac.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    private static String[] allRoles = {"ROLE_USER", "ROLE_TUTOR", "ROLE_ADMIN"};

    public static String[] getAllRoles() {
        return allRoles;
    }


    @Transactional
    public void сreateUser(User user, String nameRole) {
        user.setRole(roleService.createRole(nameRole));
        String codedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(codedPassword);
        userRepository.create(user);
    }

//    @Transactional
//    public boolean ifExistsUserWithLogin(String login) {
//        return userRepository.ifExistsUserWithLogin(login);
//    }

}
