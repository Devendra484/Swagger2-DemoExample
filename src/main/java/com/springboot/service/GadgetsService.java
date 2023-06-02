package com.springboot.service;

import com.springboot.Repository.GadgetsRepository;
import com.springboot.model.Gadgets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GadgetsService {
    @Autowired
    private GadgetsRepository gadgetsRepository;
    public Gadgets saveGadget(Gadgets gadgets){
        return gadgetsRepository.save(gadgets);
    }
    public Gadgets updateGadget(Gadgets gadgets,Long id){
        Gadgets existedGadget=gadgetsRepository.findById(id).get();
        existedGadget=Gadgets.builder()
                .id(existedGadget.getId())
                .gadgetName(gadgets.getGadgetName())
                .gadgetType(gadgets.getGadgetType())
                .cost(gadgets.getCost())
                .manufactureCompany(gadgets.getManufactureCompany())
                .manufactureDate(gadgets.getManufactureDate())
                .build();
        return existedGadget;
    }
    public  Gadgets getGadget(Long id){
        return  gadgetsRepository.findById(id).orElseThrow( ()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Gadget Not Found at  "+id));
    }
    public List<Gadgets> gadgetsList(){
        return gadgetsRepository.findAll();
    }
    public  void deleteGadgets(Long id){
        gadgetsRepository.deleteById(id);
    }
}
