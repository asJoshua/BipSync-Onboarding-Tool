package com.BipSyncRecuritment.Staff;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StaffRepository {
    List<staffInfo> getStaffInfo();
    staffInfo getStaffInfo(Long id);
    void addStaffInfo(staffInfo staffInfo);

    void updateStaffInfo(staffInfo staffInfo);
    void save(staffInfo staffInfo);

}








