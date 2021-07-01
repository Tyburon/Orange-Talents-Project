package com.zup.orange.vaccines;

import com.zup.orange.modules.vaccine.model.Vaccines;
import com.zup.orange.modules.vaccine.repository.VaccinesRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class VaccinesRepositoryTest {

    @Autowired
    private VaccinesRepository vaccinesRepository;

    @AfterEach
    void tearDown(){
        vaccinesRepository.deleteAll();
    }

    @Test
    void itShouldBeAbleToCreateNewVaccineRegister(){

        LocalDate application_date = LocalDate.of(2021, 5, 10);

        Vaccines vaccine = new Vaccines(
                "Coronavac",
                1L,
                application_date
        );

        Vaccines vaccineRegister = vaccinesRepository.save(vaccine);

        assertThat(vaccineRegister.getId()).isEqualTo(1L);

    }
}
