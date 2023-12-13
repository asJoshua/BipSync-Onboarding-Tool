package com.BipSyncRecuritment.newRecruit;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewRecruitServiceListImp implements NewRecruitService {
    private NewRecruitRepository newRecruitRepository;

    public NewRecruitServiceListImp(NewRecruitRepository aNewrecruitRepository) {
        this.newRecruitRepository = aNewrecruitRepository;
    }

    public List<NewRecruit> getNewRecruits() {
        return newRecruitRepository.getNewRecruits();
    }

    public NewRecruit getNewRecruit(Long recruitId) {
        return newRecruitRepository.getNewRecruit(recruitId);
    }

    public void save(NewRecruit menuItem) {
        newRecruitRepository.save(menuItem);
    }
}

