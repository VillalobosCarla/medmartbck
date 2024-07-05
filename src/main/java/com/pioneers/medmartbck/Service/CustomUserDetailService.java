package com.pioneers.medmartbck.Service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pioneers.medmartbck.model.User;
import com.pioneers.medmartbck.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
   
    private UserRepository userRepository;

public CustomUserDetailService(UserRepository userRepository){
    this.userRepository = userRepository;
}
public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException{
    User user = userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
    .orElseThrow(()-> new UsernameNotFoundException("User not found with username or email" + usernameOrEmail));
    Set<GrantedAuthority> authorities = user
    .getRoles()
    .stream()
    .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

    return new org.springframework.security.core.userdetails.User(
        user.getEmail(),
        user.getPassword(),
        authorities
    );

}
}
