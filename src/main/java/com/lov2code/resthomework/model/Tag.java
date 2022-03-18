package com.lov2code.resthomework.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Tag {

    private long id;

    @NotNull
    @Size(min = 2, max = 15)
    private String name;

    public Tag(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
