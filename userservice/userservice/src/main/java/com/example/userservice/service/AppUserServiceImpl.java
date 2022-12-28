package com.example.userservice.service;

import com.example.userservice.domain.AppUser;
import com.example.userservice.domain.Role;
import com.example.userservice.repo.AppUserRepo;
import com.example.userservice.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl  implements AppUserService{
    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;
    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("Saving new user {} to the database", appUser.getName());
        return appUserRepo.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        AppUser appUser = appUserRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching user {}", username);
        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all user");
        return appUserRepo.findAll();
    }
}
