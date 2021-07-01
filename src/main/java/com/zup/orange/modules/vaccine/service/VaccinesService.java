package com.zup.orange.modules.vaccine.service;

import com.zup.orange.modules.vaccine.model.Vaccines;
import com.zup.orange.modules.vaccine.repository.VaccinesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VaccinesService {

    @Autowired
    private final VaccinesRepository vaccinesRepository;

    public List<Vaccines> getALlVaccinesApplicationRegisters () {return  vaccinesRepository.findAll();}

    public Vaccines AddVaccineApplicationRegister(Vaccines vaccines){

        return vaccinesRepository.save(vaccines);

    }

}
