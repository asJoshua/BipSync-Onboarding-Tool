package com.BipSyncRecuritment.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserLoginDetailsService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ResetPasswordTokenRepository tokenRepository;

    @Autowired
    JavaMailSender javaMailSender;

//loads users details by their username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username or Password not found");
        }
        return new UserLoginDetails(
                user.getUsername(),
                user.getUserEmail(),
                user.getUserFirstName(),
                user.getUserLastName(),
                user.getPassword(),
                authorities(user.getRoles()));

    }


    public User registerStaff(String username, String userEmail, String userFirstName, String userLastName, String password, Set<String> roles) {
        User newStaffUser = new User(username, userEmail, userFirstName, userLastName, passwordEncoder.encode(password), roles);
        userRepository.save(newStaffUser);
        return newStaffUser;
    }

    // authority granted  to user with specific roles
    public Collection<? extends GrantedAuthority> authorities(Set<String> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }


    public String sendResetPasswordEmail(User user) {
            String resetLink = generateResetToken(user);

            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("testingforproject2023@gmail.com");// input the senders email ID
            msg.setTo(user.getUserEmail());

            msg.setSubject("Reset Your Password");
            msg.setText( "Please click on this link to Reset your Password :" + resetLink );

            javaMailSender.send(msg);



        return "success";
    }


    public String generateResetToken(User user) {
        UUID uuid = UUID.randomUUID();
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime expiryDateTime = currentDateTime.plusMinutes(05);
        ResetPasswordToken resetToken = new ResetPasswordToken();
        resetToken.setUser(user);
        resetToken.setToken(uuid.toString());
        resetToken.setExpiryDateTime(expiryDateTime);
        resetToken.setUser(user);
        ResetPasswordToken token = tokenRepository.save(resetToken);
        if (token != null) {
            String endpointUrl = "http://localhost:8080/resetPassword";
            return endpointUrl + "/" + resetToken.getToken();
        }
        return "";
    }



    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean hasExipred(LocalDateTime expiryDateTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return expiryDateTime.isAfter(currentDateTime);
    }





}
