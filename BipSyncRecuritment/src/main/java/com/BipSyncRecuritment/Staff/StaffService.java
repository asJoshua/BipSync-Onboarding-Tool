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
                new staffInfo(0, "John", "Smith", "07625338801"),
                new staffInfo(1, "Dillon", "Jil", "07625352801"),
                new staffInfo(2, "Arnold", "Ben", "07652833772")
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

