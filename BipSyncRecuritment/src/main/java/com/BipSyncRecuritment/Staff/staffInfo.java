package com.BipSyncRecuritment.Staff;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor

public class staffInfo {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String role;

}
