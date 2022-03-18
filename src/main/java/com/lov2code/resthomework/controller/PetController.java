package com.lov2code.resthomework.controller;

import com.lov2code.resthomework.exception.DataNotFoundException;
import com.lov2code.resthomework.exception.InvalidDataException;
import com.lov2code.resthomework.model.Pet;
import com.lov2code.resthomework.service.pet.PetServiceImpl;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Api(value = "Pet Rest Controller", tags = "/pets") // TODO
@RestController
@RequiredArgsConstructor // TODO
@RequestMapping(value = "/pets")
public class PetController {

    private final PetServiceImpl petService;

    @ApiOperation(value = "Get Pet by id ", response = Pet.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not Authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not Found!") })

    @Validated
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void savePet(@RequestBody @ApiParam @Valid Pet pet, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
        {
            throw new InvalidDataException("The new pet couldn't be created.");
        }
        petService.savePet(pet);
    }

    @Validated
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updatePet(@PathVariable("petId") @ApiParam @Valid Long id, Pet pet, BindingResult bindingResult) {
        if (bindingResult.hasErrors() || id < 0) {
            throw new InvalidDataException("The pet couldn't be updated.");
        }
        petService.updatePetById(pet, id);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Pet> getPetById(@PathVariable Long id) {
        if(id < 0) {
            throw new DataNotFoundException("Pet not found for id");
        }

        return petService.findPetById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePerson(@PathVariable() Long id)
    {
        if(id < 0) {
            throw new DataNotFoundException("Pet not found for id");
        }
        petService.deletePet(id);
    }

}



// X TODO: add a new pet to store /pet
// X TODO: update un existing /pet
// TODO: finds pets by status /pet/findByStatus
// X TODO: find pet by ID /pat/{petId}
// TODO: updates a pet in the store with form data /pet/{petId}
// X TODO: deletes a pet /pet/{petId}
// TODO: uploads an image /pet/{petId}/uploadImage
