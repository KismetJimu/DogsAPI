package tech.elektron.spring.dogsapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.elektron.spring.dogsapi.models.BreedsResponse;
import tech.elektron.spring.dogsapi.services.DataService;



@RestController
public class BreedsController {

    private final String breedsApiFrag = "/api/breeds";

    @Autowired
    private DataService dataService;

    /**
     * Returns a JSON object of all available breeds and sub-breeds.
     *
     * This is exactly what comes from the Dog API at
     * https://dog.ceo/api/breeds/list/all
     *
     * @return array of all breeds and sub-breeds
     */

    @RequestMapping(value = breedsApiFrag + "/list/all",
            method = RequestMethod.GET,
            produces = "application/json")

    public BreedsResponse getAllBreeds() {
        return dataService.getAllBreeds();
    }
}
