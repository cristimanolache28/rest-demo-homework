package com.lov2code.resthomework.service.pet;

import com.lov2code.resthomework.exception.DataNotFoundException;
import com.lov2code.resthomework.model.Pet;
import com.lov2code.resthomework.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService{

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public Pet updatePetById(Pet pet, Long id) {
        Pet existingPet = petRepository.findPetByID(id).orElseThrow(
                () -> new DataNotFoundException("User not exist."));

        // TODO:
        existingPet.setName("Dog2");
        existingPet.setStatus("unavailable");
        existingPet.setPhotoUrls(Collections.singletonList("New Photo"));
        petRepository.save(existingPet);
        return existingPet;
    }

    @Override
    public Optional<Pet> findPetById(Long id) {
        return petRepository.findPetByID(id);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.delete(id);
    }
}
