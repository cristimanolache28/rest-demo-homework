package com.lov2code.resthomework.model;

import com.lov2code.resthomework.common.StatusPet;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pet {

    protected Long id;

    @NotNull
    private Category category;

    @NotNull
    @Size(min = 3, max = 30)
    private String name;

    @NotNull
    private String[] photoUrls;

    @NotNull
    private Tag[] tags;

    @NotNull
    private StatusPet status;

    public Pet(Category category, String name, String[] photoUrls, Tag[] tags, StatusPet status) {
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
}
