package com.santiago.GA7_220501096_AA5_EV01.authentication.controller;

import com.santiago.GA7_220501096_AA5_EV01.authentication.persistence.AuthenticationPersistence;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Map;

@RestController

public class AuthenticationController {
    AuthenticationPersistence authenticationPersistence = new AuthenticationPersistence();

    @PostMapping ("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody Map<String, String> body) throws SQLException {
        authenticationPersistence.saveNewUser(body.get("password"), body.get("user"));
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PostMapping ("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody Map<String, String> body) throws SQLException {
        boolean isValid = authenticationPersistence.signIn(body.get("password"), body.get("user"));
        return new ResponseEntity<>(isValid, HttpStatus.CREATED);

    }
}
