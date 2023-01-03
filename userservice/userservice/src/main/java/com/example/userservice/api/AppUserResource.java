package com.example.userservice.api;

import com.example.userservice.domain.AppUser;
import com.example.userservice.domain.Role;
import com.example.userservice.service.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AppUserResource {
    private final AppUserService appUserService;
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getUsers(){
        return ResponseEntity.ok().body(appUserService.getUsers());
    }
    @PostMapping("/users/save")
    public ResponseEntity<AppUser>saveUser(@RequestBody AppUser appUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/users/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveUser(appUser));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/role/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveRole(role));
    }
    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
        appUserService.addRoleToUser(form.getUsername(),form.getRoleName());
        return ResponseEntity.ok().build();
    }

}
@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}
