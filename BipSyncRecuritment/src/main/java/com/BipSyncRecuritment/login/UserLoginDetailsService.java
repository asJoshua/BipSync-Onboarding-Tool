package com.BipSyncRecuritment.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserLoginDetailsService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//loads users details by their username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username or Password not found");
        }
        return new UserLoginDetails(
                user.getUsername(),
                user.getPassword(),
                authorities(user.getRoles()),
                user.getFirstname(),
                user.getLastname());
    }


    // authority granted  to user with specific roles like admin or staff
    public Collection<? extends GrantedAuthority> authorities(Set<String> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }

}
