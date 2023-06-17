package com.ontrack.api.api.controllers;

import com.ontrack.api.api.dao.CredenciaisUser;
import com.ontrack.api.api.dao.UserIdResponse;
import com.ontrack.api.api.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<UserIdResponse> login(@RequestBody CredenciaisUser credenciais) {
        Long Id = loginService.login(credenciais);
        if(Id != null) {
            UserIdResponse response = new UserIdResponse(Id);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}
