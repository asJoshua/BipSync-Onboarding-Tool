package com.BipSyncRecuritment.newRecruit;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewRecruitForm {

    private Long id;
    @NotEmpty(message = "The name cannot be empty")
    private String firstName;
    @NotEmpty(message = "The name cannot be empty")
    private String lastName;
    public NewRecruitForm() {
        this(0L, "", "");
    }
}