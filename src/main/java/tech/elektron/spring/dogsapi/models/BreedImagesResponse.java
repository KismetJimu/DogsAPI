package tech.elektron.spring.dogsapi.models;

import java.io.Serializable;

public class BreedImagesResponse extends AbstractBasicResponse implements Serializable {
    private String[] message;

    public String[] getMessage() {
        return message.clone();
    }

    public void setMessage(final String[] message) {
        this.message = message.clone();
    }
}
