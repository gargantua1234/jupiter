package com.arek.application;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
public class ObjectBean {
    private String name;
    private Map<String, String> properties;
//    private String json;

    public List<String> getValues() {
        return values;
    }

    public void setValues(final List<String> values) {
        this.values = values;
    }

    private List<String> values;

    public String getName() {
        return name;
    }

    @JsonGetter("name")
    public String getBetterName() {
        return "should be new getter for jackson " + name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(final Map<String, String> properties) {
        this.properties = properties;
    }

//    public String getJson() {
//        return json;
//    }
//
//    @JsonRawValue
//    public void setJson(final String json) {
//        this.json = json;
//    }
}
