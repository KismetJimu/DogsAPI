package tech.elektron.spring.dogsapi.services;

import tech.elektron.spring.dogsapi.models.BreedImagesResponse;
import tech.elektron.spring.dogsapi.models.BreedsResponse;

public interface DataService {
    BreedsResponse getAllBreeds();
    BreedImagesResponse getBreedImages(String breed);
    BreedImagesResponse getBreedImages(String breed, String subBreed);
}
