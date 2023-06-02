package com.springboot.Repository;

import com.springboot.model.Gadgets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GadgetsRepository extends JpaRepository<Gadgets,Long> {

}