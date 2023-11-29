package com.BipSyncRecuritment.newRecruit;

import java.util.List;

public interface NewRecruitRepository {
    List<NewRecruit> getNewRecruits();
    NewRecruit getNewRecruit(Long id);
    void save(NewRecruit newRecruit);
}
