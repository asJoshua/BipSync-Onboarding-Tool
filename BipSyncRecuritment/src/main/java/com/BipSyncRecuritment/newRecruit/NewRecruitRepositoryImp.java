package com.BipSyncRecuritment.newRecruit;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewRecruitRepositoryImp implements NewRecruitRepository {
    private JdbcTemplate jdbc;
    private RowMapper<NewRecruit> newRecruitRowMapper;

    public NewRecruitRepositoryImp(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;

        setNewRecruitRowMapper();
    }

    private void setNewRecruitRowMapper() {

        newRecruitRowMapper = (rs, i) -> new NewRecruit(
                rs.getLong("recruit_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("date_of_birth"),
                rs.getString("phone_number"),
                rs.getString("passport_number"),
                rs.getString("national_insurance_number"),
                rs.getString("email"),
                rs.getString("position"),
                rs.getString("date_of_hire"),
                rs.getString("emergency_contact_name"),
                rs.getString("emergency_contact_phone")
        );
    }

    public NewRecruit getNewRecruit(Long id) {
        String sql = "select * from recruits where recruit_id = ?";
        return jdbc.queryForObject(sql, newRecruitRowMapper, id);
    }

    public List<NewRecruit> getNewRecruits() {
        String sql = "select * from recruits";
        return jdbc.query(sql, newRecruitRowMapper);
    }

    public void save(NewRecruit aNewRecruit) {

        if (aNewRecruit.isNew()) {
            insert(aNewRecruit);
        } else {
            update(aNewRecruit);
        }


    }

    private void update(NewRecruit aNewRecruit) {
        String menuInsertSql =
                "update recruits set first_name = ?, last_name = ?, date_of_birth = ?, phone_number = ?, passport_number = ?, national_insurance_number = ?, email = ?, position = ?, date_of_hire = ?, emergency_contact_name = ?, emergency_contact_phone = ? where recruit_id = ?";
        jdbc.update(menuInsertSql,
                aNewRecruit.getFirstName(),
                aNewRecruit.getLastName(),
                aNewRecruit.getDateOfBirth(),
                aNewRecruit.getPhoneNumber(),
                aNewRecruit.getPassportNumber(),
                aNewRecruit.getNationalInsuranceNumber(),
                aNewRecruit.getEmail(),
                aNewRecruit.getPosition(),
                aNewRecruit.getDateOfHire(),
                aNewRecruit.getEmergencyContactName(),
                aNewRecruit.getEmergencyContactPhoneNumber(),
                aNewRecruit.getRecruitId()
        );
    }

    private void insert(NewRecruit aNewRecruit) {
        String menuInsertSql =
                "insert into recruits " +
                        "(first_name, last_name, date_of_birth, phone_number, passport_number, national_insurance_number, email, position, date_of_hire, emergency_contact_name, emergency_contact_phone)" +
                        " values (?,?,?,?,?,?,?,?,?,?,?)";
        jdbc.update(menuInsertSql,
                aNewRecruit.getFirstName(),
                aNewRecruit.getLastName(),
                aNewRecruit.getDateOfBirth(),
                aNewRecruit.getPhoneNumber(),
                aNewRecruit.getPassportNumber(),
                aNewRecruit.getNationalInsuranceNumber(),
                aNewRecruit.getEmail(),
                aNewRecruit.getPosition(),
                aNewRecruit.getDateOfHire(),
                aNewRecruit.getEmergencyContactName(),
                aNewRecruit.getEmergencyContactPhoneNumber()
        );
    }
}
