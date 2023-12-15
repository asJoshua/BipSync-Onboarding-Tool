package com.BipSyncRecuritment.NewRecruitTests;

import com.BipSyncRecuritment.newRecruit.NewRecruit;
import com.BipSyncRecuritment.newRecruit.NewRecruitForm;
import com.BipSyncRecuritment.newRecruit.NewRecruitRepository;
import com.BipSyncRecuritment.newRecruit.NewRecruitService;
import jakarta.validation.Valid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AddingNewRecruitTest {
    @Autowired
    private NewRecruitRepository newRecruitService;

    @Test
    public void shouldGetNewRecruitsAfterAddingOne() throws Exception {
        Long recruitId = 5L;
        NewRecruit newNewRecruit = new NewRecruit(recruitId, "Joshua", "Sadleir", "17-11-2004", "07532674885", "78274983", "XX983483", "contact@joshuasadleir.com", "IT", "17-11-2023", "Joshua Sadleir", "07532674885");
        newRecruitService.save(newNewRecruit); // Check if this is actually adding a new recruit.

        List<NewRecruit> newRecruits = newRecruitService.getNewRecruits();
        assertEquals(5, newRecruits.size());
    }

}
