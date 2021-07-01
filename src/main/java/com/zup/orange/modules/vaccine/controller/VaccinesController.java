package com.zup.orange.modules.vaccine.controller;

import com.zup.orange.modules.vaccine.model.Vaccines;
import com.zup.orange.modules.vaccine.service.VaccinesService;
import com.zup.orange.modules.validation.Groups;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(value = "/vaccines")
@AllArgsConstructor
public class VaccinesController {

    @Autowired
    private final VaccinesService vaccinesService;


    @GetMapping
    public List<Vaccines> listar() {
        return vaccinesService.getALlVaccinesApplicationRegisters();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Vaccines> criar(@Validated(Groups.UserRegister.class) @RequestBody Vaccines vaccines){

        Vaccines savedRegister = vaccinesService.AddVaccineApplicationRegister(vaccines);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedRegister);
    }


}
