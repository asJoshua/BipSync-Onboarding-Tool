package com.BipSyncRecuritment.Staff;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffRepositoryImpl implements StaffRepository {
    private JdbcTemplate jdbc;
    private RowMapper<staffInfo> staffInfoMapper;

    public StaffRepositoryImpl(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setStaffInfoMapper();
    }

    private void setStaffInfoMapper() {
        staffInfoMapper = (rs, rowNum) -> new staffInfo(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("email"),
                rs.getString("role")
        );
    }

    public List<staffInfo> getStaffInfo() {
        String sql = "SELECT * FROM staffInfo";
        return jdbc.query(sql, staffInfoMapper);
    }

    public staffInfo getStaffInfo(Long id) {
        String sql = "SELECT * FROM staffInfo WHERE id = ?";
        return jdbc.queryForObject(sql, staffInfoMapper, id);
    }

    public void addStaffInfo(staffInfo staffInfo) {
        String sql = "INSERT INTO staffInfo (name, surname, email, role) VALUES (?, ?, ?, ?)";
        jdbc.update(sql, staffInfo.getName(), staffInfo.getLastName(), staffInfo.getEmail(), staffInfo.getRole());
    }
    @Override
    public void updateStaffInfo(staffInfo staff) {
        String sql = "UPDATE staffInfo SET name = ?, surname = ?, email = ?, role = ? WHERE id = ?";
        jdbc.update(sql, staff.getName(), staff.getLastName(), staff.getEmail(), staff.getRole(), staff.getId());

    }


    @Override
    public void save(staffInfo staffInfo) {


    }
}
