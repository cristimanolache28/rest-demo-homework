package com.lov2code.resthomework.repository;

import com.lov2code.resthomework.common.StatusPet;
import com.lov2code.resthomework.model.Category;
import com.lov2code.resthomework.model.Pet;
import com.lov2code.resthomework.model.Tag;
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

        Category dogCategory = new Category(1L, "Dogs");
        Category catCategory = new Category(2L, "Cats");
        Category monkeyCategory = new Category(3L, "Monkeys");

        Tag dogTag = new Tag(1L, "Dog Tag");
        Tag catTag = new Tag(2L, "Cat Tag");
        Tag monkeyTag = new Tag(3L, "Monkey Tag");

        // Create dog
        pets.put(1L, new Pet(dogCategory, "Rex",
                        new String[] {"Rex Photo"},
                        new Tag[] {dogTag}, StatusPet.AVAILABLE));

        pets.put(2L, new Pet(dogCategory, "Max",
                        new String[] {"Max Photo"},
                        new Tag[] {dogTag}, StatusPet.PENDING));

        pets.put(3L, new Pet(dogCategory, "Oscar",
                        new String[] {"Oscar Photo"},
                        new Tag[] {dogTag}, StatusPet.SOLD));

        // Create cat
        pets.put(4L, new Pet(catCategory, "Luna",
                        new String[] {"Luna Photo"},
                        new Tag[] {catTag}, StatusPet.AVAILABLE));

        pets.put(5L, new Pet(catCategory, "Milo",
                        new String[] {"Milo Photo"},
                        new Tag[] {catTag}, StatusPet.PENDING));

        pets.put(6L, new Pet(catCategory, "Bella",
                        new String[] {"Bella Photo"},
                        new Tag[] {catTag}, StatusPet.SOLD));

        // Create monkey
        pets.put(7L, new Pet(monkeyCategory, "Golden ",
                        new String[] {"Golden Photo"},
                        new Tag[] {monkeyTag}, StatusPet.AVAILABLE));

        pets.put(8L, new Pet(monkeyCategory, "Mandrill",
                        new String[] {"Mandrill Photo"},
                        new Tag[] {monkeyTag}, StatusPet.PENDING));

        pets.put(9L, new Pet(monkeyCategory, "Barbary ",
                        new String[] {"Barbary  Photo"},
                        new Tag[] {monkeyTag}, StatusPet.SOLD));



    }

    public void savePet(Pet pet) {
        pets.compute(pet.getId(), (key, value) -> pet);
    }

    public Optional<Pet> findPetByID(Long id) {
        return Optional.ofNullable(pets.getOrDefault(id, null));
    }

    public void delete(Long id) {
        pets.remove(id);
    }

    public void update(Pet pet) {
        pets.put(pet.getId(), pet);
    }

    public List<Pet> findAllPets() {
        return new ArrayList<>(pets.values());
    }

}
