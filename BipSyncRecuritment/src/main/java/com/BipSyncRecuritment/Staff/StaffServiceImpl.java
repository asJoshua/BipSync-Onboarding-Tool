package com.BipSyncRecuritment.Staff;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffServiceImpl implements StaffService {

    private StaffRepository staffRepository;
    public StaffServiceImpl(StaffRepository aStaffRepository) {
        this.staffRepository = aStaffRepository;
    }
    public List<staffInfo> getStaffInfo() {
        return staffRepository.getStaffInfo();
    }
    public staffInfo getStaffInfo(Long id) {
        return staffRepository.getStaffInfo(id);
    }
    public void addStaffInfo(staffInfo staffInfo) {
        staffRepository.addStaffInfo(staffInfo);
    }

}

