package com.BipSyncRecuritment.RegisterStaffTests;

import com.BipSyncRecuritment.employees.Task;
import com.BipSyncRecuritment.login.User;
import com.BipSyncRecuritment.login.UserLoginDetailsService;
import com.BipSyncRecuritment.login.UserRepository;
import com.BipSyncRecuritment.login.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AddingUserTest {

    @Autowired
    private UserLoginDetailsService userLoginDetailsService;


    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserRepository userRepository;

//Test for adding staff user
    @Test
    public void testAddingStaffToUsers() {
        // Given a user is being registered
        String username = "testUser";
        String userEmail = "test@example.com";
        String userFirstName = "Test";
        String userLastName = "User";
        String password = "password";
        Set<String> roles = new HashSet<>(Arrays.asList("STAFF"));

        // When the user is registered
        User registeredUser = userLoginDetailsService.registerStaff(username, userEmail, userFirstName, userLastName, password, roles);

        // Then the users details should be saved
        assertEquals(username, registeredUser.getUsername());
        assertEquals(userEmail, registeredUser.getUserEmail());
        assertEquals(userFirstName, registeredUser.getUserFirstName());
        assertEquals(userLastName, registeredUser.getUserLastName());
//and added to the database

        List<User> users = userServiceImpl.getAllUsers();

        Assertions.assertEquals(3, users.size());

    }

//test for adding duplicate username
    @Test
    public void UsernameExistsTest() {
        //Given  username already exists and duplicate is trying to be added
        String existingUsername = "TestUser";
        userRepository.save(new User(existingUsername, "test@test.com", "Test", "Test", "Test", new HashSet<>(Arrays.asList("STAFF"))));

        // When
        boolean result = userServiceImpl.usernameAlreadyExists(existingUsername);

        // Then
        assertTrue(result, "username already exists");
    }


//test for adding duplicate email
    @Test
    public void EmailExistsTest() {
        // Given  email already exists and duplicate is trying to be added
        String existingEmail = "Test@Test.com";
        userRepository.save(new User("Test", existingEmail, "Test", "Test", "Test", new HashSet<>(Arrays.asList("STAFF"))));

        // When
        boolean result = userServiceImpl.emailAlreadyExists(existingEmail);

        // Then
        assertTrue(result, "Email already exists");
    }
}
