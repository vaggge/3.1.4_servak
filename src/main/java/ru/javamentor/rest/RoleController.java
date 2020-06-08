package ru.javamentor.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javamentor.model.Role;
import ru.javamentor.service.RoleService;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {

    RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roleList = roleService.listOfRoles();
        return new ResponseEntity<>(roleList, HttpStatus.OK);
    }

    @PostMapping("/rolesNames")
    public ResponseEntity<List<String>> getRolesNames(HttpEntity<List<Role>> httpEntity) {
        List<String> roleList = roleService.getRolesNames(httpEntity.getBody());
        return new ResponseEntity<>(roleList, HttpStatus.OK);
    }

    @PostMapping("/RolesByName")
    public ResponseEntity<List<Role>> getRolesByName(HttpEntity<List<String>> httpEntity) {
        List<Role> roles = roleService.getRolesByName(httpEntity.getBody());
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

}
