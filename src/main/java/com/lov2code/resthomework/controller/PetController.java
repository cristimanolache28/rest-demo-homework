package com.lov2code.resthomework.controller;

import com.lov2code.resthomework.exception.DataNotFoundException;
import com.lov2code.resthomework.exception.InvalidDataException;
import com.lov2code.resthomework.model.Pet;
import com.lov2code.resthomework.service.pet.PetServiceImpl;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Optional;

@Api(value = "Pet Rest Controller", tags = "/pets")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pets")
public class PetController {

    private final PetServiceImpl petService;

    @ApiOperation(value = "Get all pets", response = Pet.class)
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 404, message = "Not Found!"),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }


    // add basic information about this method
    @ApiOperation(value = "Save a pet", response = Pet.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not Authorized!"),
            @ApiResponse(code = 403, message = "Access denied!"),
            @ApiResponse(code = 404, message = "Not Found!")})
    @Validated
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void savePet(@RequestBody @ApiParam @Valid Pet pet, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new InvalidDataException("The new pet couldn't be created.");
        }
        petService.savePet(pet);
    }


    @ApiOperation(value = "Update an existing pet", response = Pet.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update pet"),
            @ApiResponse(code = 401, message = "Not Authorized!"),
            @ApiResponse(code = 400, message = "Missing or invalid request body"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Pet not found")})
    @Validated
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updatePet(@PathVariable("petId") Long id, @RequestBody Pet pet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException("The pet couldn't be updated.");
        }
        petService.updatePetById(pet, id);
    }


    @ApiOperation(value = "Return pet by id", response = Pet.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not Authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Pet not found")})
    @Validated
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Pet> getPetById(@PathVariable Long id) {
        if(id == null) {
            throw new InvalidDataException("Invalid Id");
        }
        return petService.findPetById(id);
    }


    @ApiOperation(value = "Delete a pet", response = Pet.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted pet."),
            @ApiResponse(code = 401, message = "Not Authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Pet not found"),
            @ApiResponse(code = 500, message = "Internal Error")})
    @DeleteMapping(path = "/{id}")
    public void deletePetById(@PathVariable() Long id) {
        if(id == null) {
            throw new InvalidDataException("Pet not found for id");
        }
        petService.deletePetById(id);
    }

//    @Validated
//    @PostMapping(value = "/{id}/uploadImage")
//    public void uploadImage(@PathVariable Long id, @RequestPar)

}




