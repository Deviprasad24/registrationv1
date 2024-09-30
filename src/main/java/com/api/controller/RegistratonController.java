package com.api.controller;

import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import com.api.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/registration")
public class RegistratonController {

    //http://localhost:8080/api/v1/registration

    private RegistrationService registrationService;

    public RegistratonController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getAllRegistration(){
        List<RegistrationDto> dtos = registrationService.getAllRegistration();
        return new ResponseEntity<>( dtos, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> createRegistration(
           @Valid @RequestBody RegistrationDto registrationDto,
           BindingResult result
    ){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.CREATED);
        }
        RegistrationDto regDto = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(regDto,HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(
            @RequestParam long id
    ){
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(
            @PathVariable long id,
            @RequestBody Registration registration
    ){
    Registration updateReg = registrationService.updateRegistration(id,registration);
    return new ResponseEntity<>(updateReg,HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getRegistrationById(
            @PathVariable long id
    ){
        RegistrationDto dto=registrationService.getRegistrationById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

}
