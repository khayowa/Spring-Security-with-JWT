package com.example.userservice;

import com.example.userservice.domain.AppUser;
import com.example.userservice.domain.Role;
import com.example.userservice.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(AppUserService appUserService){
        return args -> {
            appUserService.saveRole(new Role(null, "ROLE_USER"));
            appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
            appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
            appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            appUserService.saveUser(new AppUser(null,"John Travolta", "john","1234",new ArrayList<>()));
            appUserService.saveUser(new AppUser(null,"Will Smith", "smith","1234",new ArrayList<>()));
            appUserService.saveUser(new AppUser(null,"Jimmy Carry", "jim","1234",new ArrayList<>()));
            appUserService.saveUser(new AppUser(null,"Arnold Schwarzenegger", "arnold","1234",new ArrayList<>()));

            appUserService.addRoleToUser("john", "ROLE_USER");
            appUserService.addRoleToUser("smith", "ROLE_MANAGER");
            appUserService.addRoleToUser("jim", "ROLE_ADMIN");
            appUserService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
            appUserService.addRoleToUser("jim", "ROLE_SUPER_ADMIN");
            appUserService.addRoleToUser("arnold", "ROLE_USER");



        };
    }

}
