package com.example.userservice.service;

import com.example.userservice.domain.AppUser;
import com.example.userservice.domain.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
