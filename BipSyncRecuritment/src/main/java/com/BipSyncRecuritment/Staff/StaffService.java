package com.BipSyncRecuritment.Staff;

import java.util.List;

public interface StaffService {

    List<staffInfo> getStaffInfo();
    staffInfo getStaffInfo(Long id);

    void addStaffInfo(staffInfo staffInfo);

}
