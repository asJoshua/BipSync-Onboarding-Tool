package com.BipSyncRecuritment.landingPage;

import java.util.List;

public class NewRecruitService {
    private List<NewRecruit> newRecruits;
    private static NewRecruitService singleton;

    public static NewRecruitService getInstance() {
        if (singleton == null) {
            singleton = new NewRecruitService();
        }
        return singleton;
    }

    public List<NewRecruit>getNewRecruits(){
        return newRecruits;
    }
    public void addNewRecruit(NewRecruit newRecruit){
        newRecruits.add(newRecruit);
    }
}
