package tech.elektron.spring.dogsapi.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import tech.elektron.spring.dogsapi.models.BreedImagesResponse;
import tech.elektron.spring.dogsapi.models.BreedsResponse;

@Service
public class DogCEODataService implements DataService {

    private final String apiUrl = "https://dog.ceo/api";

    @Override
    public BreedsResponse getAllBreeds() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(apiUrl + "/breeds/list/all", BreedsResponse.class);
    }

    @Override
    public BreedImagesResponse getBreedImages(String breed) {
        return getImages(breed, null);
    }

    @Override
    public BreedImagesResponse getBreedImages(String breed, String subBreed) {
        return getImages(breed, subBreed);
    }

    private BreedImagesResponse getImages(String breed, String subBreed) {
        RestTemplate restTemplate = new RestTemplate();
        BreedImagesResponse imagesResponse;
        if (StringUtils.isEmpty(subBreed)) {
            imagesResponse = restTemplate.getForObject(
                    apiUrl + "/breed/{breed}/images",
                    BreedImagesResponse.class,
                    breed);
        } else {
            imagesResponse = restTemplate.getForObject(
                    apiUrl + "/breed/{breed}/{subBreed}/images",
                    BreedImagesResponse.class,
                    breed, subBreed);
        }
        return imagesResponse;
    }
}
