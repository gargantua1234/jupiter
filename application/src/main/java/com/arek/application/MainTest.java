package com.arek.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public final class MainTest {
    public static void main(String[] args) throws JsonProcessingException {
        serializationExamples();
        deserializationExamples();

    }

    private static void serializationExamples() throws JsonProcessingException {
        final ObjectBean bean = new ObjectBean();
        bean.setName("Test");
        bean.setProperties(Map.of("First", "Value1", "second", "value2"));
//        bean.setJson("{\"attr\":false}");
        bean.setValues(List.of("One", "Two", "Three"));

        final ObjectMapper mapper = new ObjectMapper();
        final String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
        System.out.println(json);

        final ObjectBean readValue = mapper.readerFor(ObjectBean.class)
                .readValue(json);

        System.out.println(readValue);


        final ActionType action = ActionType.DOWNLOAD;
        final String actionJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(action);
        System.out.println(actionJson);

        final BeanDeserialization toDeserialization = new BeanDeserialization();
        final String jsonValue = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(toDeserialization);
        System.out.println(jsonValue);
    }

    private static void deserializationExamples() throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        String json = "{\"id\":1,\"theName\":\"My bean\"}";
        final BeanDeserialization object = mapper.readerFor(BeanDeserialization.class)
                .readValue(json);
        System.out.println(object);

        final String enumExample = "\"Downloading\"";
        final ActionType actionType = mapper.readerFor(ActionType.class)
                .readValue(enumExample);
        System.out.println(actionType);
    }
}
