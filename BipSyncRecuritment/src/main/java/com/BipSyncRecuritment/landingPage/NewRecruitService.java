package com.BipSyncRecuritment.landingPage;

import java.util.List;

public interface NewRecruitService {
    List<NewRecruit> getNewRecruits();

    NewRecruit getNewRecruit(Long id);

    void save(NewRecruit newRecruit);
}