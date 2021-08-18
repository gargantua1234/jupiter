package com.arek.application;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BeanDeserialization {
    private int id;
    private final String name;

    public BeanDeserialization() {
        id = -1;
        name = "Empty";
    }

    @JsonCreator
    public BeanDeserialization(
            @JsonProperty("theName") final String name) {
        this.name = name;
    }
}
