package com.BipSyncRecuritment.Staff;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor


public class staffInfo {
    @Id
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 10, message = "Field must be between 2 and 10 characters")
    private String name;
    @Size(min = 2, max = 10, message = "Field must be between 2 and 10 characters")
    @NotBlank(message = "Last Name is required")
    private String lastName;
    @Size(min = 2, max = 10, message = "Field must be between 2 and 20 characters")
    @Email(message = "Invalid email address")
    private String email;
    @Size(min = 2, max = 10, message = "Field must be between 2 and 10 characters")
    @NotBlank(message= "Role is required")
    private String role;

    public staffInfo(){

    }

    public String getEmail() {
        return email;

    }

    public String getName() {
        return name;

    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
