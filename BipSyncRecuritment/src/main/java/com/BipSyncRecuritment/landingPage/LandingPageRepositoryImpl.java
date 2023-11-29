package com.BipSyncRecuritment.landingPage;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LandingPageRepositoryImpl implements LandingPageRepository{
    private JdbcTemplate jdbc;
    private RowMapper<NewRecruit> newRecruitRowMapper;

    public LandingPageRepositoryImpl(JdbcTemplate aJdbc){
        this.jdbc = aJdbc;
        setNewRecruitRowMapper();
    }

    private void setNewRecruitRowMapper() {
        newRecruitRowMapper = (rs, i) -> new NewRecruit(
                rs.getLong("id"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getString("dateOfBirth"),
                rs.getInt("phoneNumber"),
                rs.getInt("passportNumber"),
                rs.getInt("nationalInsuranceNumber"),
                rs.getString("email"),
                rs.getString("position"),
                rs.getString("dateOfHire"),
                rs.getString("emergencyContactName"),
                rs.getString("emergencyContactNumber")
        );
    }

    public List<NewRecruit> getNewRecruits(){
        String sql = "select * from recruits";
        return jdbc.query(sql, newRecruitRowMapper);
    }

    public NewRecruit getNewRecruit(Long id){
        String sql = "select * from recruits where id = ?";
        return jdbc.queryForObject(sql, newRecruitRowMapper, id);
    }

    public void save(NewRecruit aNewRecruit) {
        if (aNewRecruit.isNew()) {
            addNewRecruit(aNewRecruit);
        }
    }

    public void addNewRecruit(NewRecruit aNewRecruit){
        String newRecruitInsertSql =
                "insert into recruits" +
                        "(firstName, lastName, dateOfBirth, phoneNumber, passportNumber, nationalInsuranceNumber, email, position, dateOfHire, emergencyContactName, emergencyContactPhone)" +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbc.update(newRecruitInsertSql,
                aNewRecruit.getFirstName(),
                aNewRecruit.getLastName(),
                aNewRecruit.getDoB(),
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
