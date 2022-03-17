package com.lov2code.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Pet Rest Controller", tags = "/pet") // TODO: to stady
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pet")
public class PetController {
}
