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
                rs.getLong("id"),
                rs.getString("firstName"),
                rs.getString("lastName")
        );
    }

    public NewRecruit getNewRecruit(Long id) {
        String sql = "select * from recruits where id = ?";
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
                "update recruits set firstName = ?, lastName = ? where id = ?";
        jdbc.update(menuInsertSql,
                aNewRecruit.getFirstName(),
                aNewRecruit.getLastName(),
                aNewRecruit.getId()
        );
    }

    private void insert(NewRecruit aNewRecruit) {
        String menuInsertSql =
                "insert into recruits " +
                        "(firstName, lastName)" +
                        " values (?,?)";
        jdbc.update(menuInsertSql,
                aNewRecruit.getFirstName(),
                aNewRecruit.getLastName()
        );
    }
}
