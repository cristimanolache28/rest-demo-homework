package com.lov2code.resthomework.repository;

import com.lov2code.resthomework.model.Category;
import com.lov2code.resthomework.model.Pet;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class PetRepository{

    private Map<Long, Pet> pets = new HashMap<>();

    @PostConstruct // TODO
    private void init() {
        createPet();
    }

    private void createPet() {
        Pet pet = new Pet(new Category(0, "Dog"));
        pet.setId(0);
        pet.setName("Rex");
        pet.setPhotoUrls(Collections.singletonList("It's a photo."));
        pet.setStatus("available");
        pets.put(pet.getId(), pet);

        pet = new Pet(new Category(1, "Cat"));
        pet.setId(1);
        pet.setName("CatName");
        pet.setPhotoUrls(Collections.singletonList("It's a photo with a cat."));
        pet.setStatus("unavailable");
        pets.put(pet.getId(), pet);

    }

    public void save(Pet pet) {
        pets.compute(pet.getId(), (key, value) -> pet);
    }

    public Optional<Pet> findPetByID(Long id) {
        return Optional.ofNullable(pets.getOrDefault(id, null));
    }

    public void delete(Long id) {
        pets.remove(id);
    }

}
