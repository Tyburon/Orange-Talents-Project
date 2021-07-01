package com.zup.orange.modules.vaccine.repository;

import com.zup.orange.modules.vaccine.model.Vaccines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinesRepository extends JpaRepository<Vaccines, Long> {

}
