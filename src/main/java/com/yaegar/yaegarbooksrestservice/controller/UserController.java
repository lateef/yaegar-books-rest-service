package com.yaegar.yaegarbooksrestservice.controller;

import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.model.UserConfirmation;
import com.yaegar.yaegarbooksrestservice.service.UserService;
import com.yaegar.yaegarbooksrestservice.util.AuthenticationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    private AuthenticationManager authenticationManager;
    private UserService userService;

    public UserController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody final User user) {
        return ResponseEntity.ok().body(userService.register(user, new UserConfirmation()));
    }

    @RequestMapping(value = "/confirm-user", method = RequestMethod.POST)
    public ResponseEntity<UserConfirmation> confirmUser(@RequestBody final UserConfirmation userConfirmation) {
        final UserConfirmation userConfirmation1 = userService.confirmUser(userConfirmation);
        HttpHeaders headers = AuthenticationUtils.getAuthenticatedUser(userConfirmation1.getUser());
        return ResponseEntity.ok().headers(headers).body(userConfirmation1);
    }

    @RequestMapping(value = "/log-in", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody final User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getPhoneNumber(), user.getPassword())
        );
        Optional<User> optionalUser = userService.getUserByPhoneNumber(authentication.getPrincipal().toString());
        if (optionalUser.isPresent()) {
            final User user1 = optionalUser.get();
            return getUserResponseEntity(user1);
        }
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(value = "/do-nothing", method = RequestMethod.GET)
    public ResponseEntity<User> doNothing() {
        return ResponseEntity.ok(new User());
    }

    private ResponseEntity<User> getUserResponseEntity(User user) {
        user.eraseCredentials();
        HttpHeaders headers = AuthenticationUtils.getAuthenticatedUser(user);
        return ResponseEntity.ok().headers(headers).body(user);
    }
}
