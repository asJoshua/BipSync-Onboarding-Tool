package com.BipSyncRecuritment.landingPage;

import com.BipSyncRecuritment.login.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandingPageRepository{
    List<NewRecruit> getNewRecruits();
    NewRecruit getNewRecruit(Long id);
    void save(NewRecruit newRecruit);
}
