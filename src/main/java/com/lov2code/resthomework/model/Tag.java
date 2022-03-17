package com.lov2code.resthomework.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Tag {

    private Long id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;
}
