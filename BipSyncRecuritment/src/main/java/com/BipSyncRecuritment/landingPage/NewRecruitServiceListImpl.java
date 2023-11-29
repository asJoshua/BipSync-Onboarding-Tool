package com.BipSyncRecuritment.landingPage;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewRecruitServiceListImpl implements NewRecruitService {
    private LandingPageRepository landingPageRepository;

    public NewRecruitServiceListImpl(LandingPageRepository aLandingPageRepository){
        this.landingPageRepository = aLandingPageRepository;
    }

    public List<NewRecruit> getNewRecruits(){
        return landingPageRepository.getNewRecruits();
    }

    public NewRecruit getNewRecruit(Long id){
        return landingPageRepository.getNewRecruit(id);
    }

    public void save(NewRecruit newRecruit) {
        landingPageRepository.save(newRecruit);
    }
}
