package by.sensor.service;

import by.sensor.moedelapp.User;
import by.sensor.repository.UserRepository;
import by.sensor.roles.Role;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void init() {
        createDefaultUsers();
    }

    private void createDefaultUsers() {
        Role adminRole = roleService.getRoleByName("ADMIN");
        Role viewerRole = roleService.getRoleByName("USER");

        if (adminRole != null && viewerRole != null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(new BCryptPasswordEncoder().encode("admin_password")); // Замените на ваш пароль
            admin.getRole();
            userRepository.save(admin);

            User viewer = new User();
            viewer.setUsername("user");
            viewer.setPassword(new BCryptPasswordEncoder().encode("user_password")); // Замените на ваш пароль
            viewer.getRole();
            userRepository.save(viewer);
        }
    }
}