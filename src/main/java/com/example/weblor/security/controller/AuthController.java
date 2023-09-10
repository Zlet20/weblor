package com.example.weblor.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weblor.common.util.ResponseHelper;
import com.example.weblor.security.dto.LoginRequestDTO;
import com.example.weblor.security.service.AuthService;

import jakarta.validation.Valid;

@RequestMapping("api/v1/auth")
@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("login")
    public Object login(@RequestBody @Valid LoginRequestDTO rq, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseHelper.getResponse(result, HttpStatus.BAD_REQUEST, true);
        }

        String rp = service.login(rq);

        return ResponseHelper.getResponse(rp, HttpStatus.OK, false);
    }
}