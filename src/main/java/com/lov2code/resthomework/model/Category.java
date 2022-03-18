package com.lov2code.resthomework.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Category {

    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    private String name;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
