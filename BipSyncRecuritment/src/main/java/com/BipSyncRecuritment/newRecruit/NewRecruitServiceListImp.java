package com.BipSyncRecuritment.newRecruit;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewRecruitServiceListImp implements NewRecruitService {
    private NewRecruitRepository newRecruitRepository;

    public NewRecruitServiceListImp(NewRecruitRepository aNewrecruitRepository) {
        this.newRecruitRepository = aNewrecruitRepository;
    }

    public List<NewRecruit> getMenuItems() {
        return newRecruitRepository.getNewRecruits();
    }

    public NewRecruit getMenuItem(Long id) {
        return newRecruitRepository.getNewRecruit(id);
    }

    @Override
    public List<NewRecruit> getNewRecruits() {
        return null;
    }

    @Override
    public NewRecruit getNewRecruit(Long id) {
        return null;
    }

    public void save(NewRecruit menuItem) {
        newRecruitRepository.save(menuItem);
    }
}

