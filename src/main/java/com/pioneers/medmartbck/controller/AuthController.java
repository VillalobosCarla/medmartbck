package com.pioneers.medmartbck.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pioneers.medmartbck.DTO.LoginRequest;
import com.pioneers.medmartbck.DTO.RegistrationRequest;
import com.pioneers.medmartbck.model.Role;
import com.pioneers.medmartbck.model.User;
import com.pioneers.medmartbck.repository.RoleRepository;
import com.pioneers.medmartbck.repository.UserRepository;

@RestController
@RequestMapping("api/v1/Auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
        public ResponseEntity<?>register(@RequestBody RegistrationRequest registrationRequest){
            if(userRepository.existsByUsername(registrationRequest.getUsername())){
                return new ResponseEntity<>("User is already taken,",HttpStatus.BAD_REQUEST);
            }
            if(userRepository.existsByEmail(registrationRequest.getEmail())){
                return new ResponseEntity<>("User is already taken,",HttpStatus.BAD_REQUEST);
            }
            User user = new User(
                registrationRequest.getUsername(),
                registrationRequest.getEmail(),
                passwordEncoder.encode(registrationRequest.getPassword())
            );
            Role role = roleRepository. findByName("ROLE_ADMIN").get();
            user.setRoles(Collections.singleton(role));

            userRepository.save(user);
            return new ResponseEntity<>("USer registered Successfully", HttpStatus.OK);
        }
    
     @PostMapping("/login")
        public ResponseEntity<String>login(@RequestBody LoginRequest loginRequest){
            try{
                Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(), 
                    loginRequest.getPassword()
                    )
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return new ResponseEntity<>("User logged in successfuly",HttpStatus.OK);
            }catch(Exception e){
                return new ResponseEntity<>("Invalid username or email", HttpStatus.UNAUTHORIZED);
            }
            }
}
