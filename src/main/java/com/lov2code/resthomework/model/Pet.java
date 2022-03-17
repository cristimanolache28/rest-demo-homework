package com.lov2code.resthomework.model;

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
    private List<String> photoUrls = new ArrayList<>();

    @NotNull
    private List<Tag> tags = new ArrayList<>();

    @NotNull
    private String status;

    public Pet(Category category) {
        this.category = category;
    }
}
