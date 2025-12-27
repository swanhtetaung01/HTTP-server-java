package org.swan.httpserver.util;

import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class Json {
    private static ObjectMapper myObjectMapper;
    private static ObjectMapper defaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    public static JsonNode parse(String jsonSrc) throws IOException {
        return myObjectMapper.readTree(jsonSrc);
    }

    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws IOException {
        return myObjectMapper.treeToValue(node, clazz);
    }

    public static JsonNode toJson(Object obj) throws IOException {
        return myObjectMapper.valueToTree(obj);
    }

    public static String stringify(JsonNode node) throws IOException {
        return generateJson(node, false);
    }

    public static String stringifyPretty(JsonNode node) throws IOException {
        return generateJson(node, true);
    }

    private static String generateJson(Object obj, boolean pretty) throws IOException {
         ObjectWriter ow = defaultObjectMapper().writer();
         if (pretty) {
             ow = ow.with(SerializationFeature.INDENT_OUTPUT);
         }
         return ow.writeValueAsString(obj);
    }
}
