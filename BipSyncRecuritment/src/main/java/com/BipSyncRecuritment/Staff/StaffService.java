package com.BipSyncRecuritment.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffService {
    private List<staffInfo> staffList;
    private static StaffService singleton;

    private StaffService() {
        staffList= new ArrayList<>();
        staffList.addAll(
        staffList = List.of(
                new staffInfo(0, "John", "Smith", "JohnSmith@bipsync.com", "IT admin"),
                new staffInfo(1, "Dillon", "Jil", "DillonJ@bipsync.com","Hr"),
                new staffInfo(2, "Arnold", "Ben", "ArBen@bipsync.com","Tech support"),
                new staffInfo(3, "Timmy", "mac", "mac@bipsync.com","IT"),
                new staffInfo(4, "Billy", "Smith", "BillSmith@bipsync.com","Data analyst"),
                new staffInfo(5, "Heather", "Thomas", "HeatherHR@bipsync.com","Hr manager")



        )
        );
    }

    public static StaffService getInstance() {
        if (singleton == null) {
            singleton = new StaffService();
        }
        return singleton;
    }


    public List<staffInfo> getStaffList() {
        return staffList;
    }
    public staffInfo getStaffList(int id) {
        return staffList.stream().filter(staffInfo ->
                staffList.get(id).equals(id)).findFirst().orElse(null);
    }



}

