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
                new staffInfo(0, "Heather", "Perkins", "HeatherHR@bipsync.com", "Hr Manager"),
                new staffInfo(1, "Ben", "Shariff", "BenShariffIT@bipsync.com","IT manager"),
                new staffInfo(2, "Adrian ", "Pennington", "Pemmigton@bipsync.com","Senior software developer"),
                new staffInfo(3, "Chau ", "Mai", "ChaiMai@bipsync.com","Marketing Director"),
                new staffInfo(4, "Billy", "Smith", "BillSmith@bipsync.com","Data analyst"),
                new staffInfo(5, "Luke", "Jones", "LukeJonesDevOps@bipsync.com","DevOps Engineer")



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

