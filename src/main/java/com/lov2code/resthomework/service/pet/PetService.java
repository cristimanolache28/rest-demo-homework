package com.lov2code.resthomework.service.pet;


import com.lov2code.resthomework.model.Pet;

import java.util.Optional;

public interface PetService {

    void savePet(Pet pet);
    Pet updatePetById(Pet pet, Long id);
    Optional<Pet> findPetById(Long id);
    void deletePet(Long id);

}

// X TODO: add a new pet to store /pet
// X TODO: update un existing /pet
// TODO: finds pets by status /pet/findByStatus
// X TODO: find pet by ID /pat/{petId}
// TODO: updates a pet in the store with form data /pet/{petId}
// X TODO: deletes a pet /pet/{petId}
// TODO: uploads an image /pet/{petId}/uploadImage