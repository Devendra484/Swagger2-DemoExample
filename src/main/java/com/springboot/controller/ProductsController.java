package com.springboot.controller;

import com.springboot.model.ErrorResponseBody;
import com.springboot.model.Gadgets;
import com.springboot.model.MetaData;
import com.springboot.service.GadgetsService;
import com.springboot.service.TimeStamp;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.annotation.Documented;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/electronics")
@Tag(value = "Products")
public class ProductsController {

    @Autowired
    private GadgetsService gadgetsService;
    @Autowired
    private TimeStamp timeStamp;
    @PostMapping("/gadgets")
    @Operation(
            description = "This is Get method of Save Gadgets",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "gadgetName = abcd"+
                            "gadgetType = xyz"+
                            "cost = 20.000"+
                            "manufacturedCompany = lmnop"+
                            "manufactured Date = 2022-10-13"
            )
    )
    public Gadgets addGadget(@RequestBody  Gadgets gadgets){
        return gadgetsService.saveGadget(gadgets);
    }
    @PutMapping("/gadgets/{id}")
    //@Hidden
    public Gadgets updateGadget(@RequestBody Gadgets gadgets,@PathVariable Long id){
        return gadgetsService.updateGadget(gadgets,id);
    }

    @GetMapping("/gadgets/{id}")
    public ResponseEntity<Object> getGadgetById(@PathVariable Long id){
        try {
            Gadgets gadgets=gadgetsService.getGadget(id);
            MetaData metaData=new MetaData(HttpStatus.OK,"success",null);
            HashMap<String,Object> responseBody=new HashMap<>();
            responseBody.put("Meta Data",metaData);
            responseBody.put("Response Body",gadgets);
            return new ResponseEntity<>(responseBody,HttpStatus.OK);
        }catch (ResponseStatusException ex){
            ErrorResponseBody errorResponseBody=new ErrorResponseBody(timeStamp.timeStamp,ex.getStatusCode().value(),ex.getStatusCode(),ex.getReason(),"/electronics/gadgets/"+id);
            return  new ResponseEntity<>(errorResponseBody,ex.getStatusCode());
        }
    }

    @GetMapping("/gadgets/list")
    public List<Gadgets> getAllGadgets(){
        return gadgetsService.gadgetsList();
    }

    @DeleteMapping("/gadgets/{id}")
    public String deleteGadget(@PathVariable Long id){
        gadgetsService.deleteGadgets(id);
        return "Successfully Deleted";
    }

}
