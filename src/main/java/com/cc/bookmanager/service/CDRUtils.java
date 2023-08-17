package com.cc.bookmanager.service;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class CDRUtils {
    public CDRUtils() {
    }

    public static ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        mapper.setTimeZone(TimeZone.getDefault());
        return mapper;
    }

    public static ObjectMapper createObjectMapperDisableUnknowProp() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return objectMapper;
    }

    public static SimpleDateFormat createSimpleDateFormat(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf;
    }

    public static List<Object> getFieldAsList(Object obj, String key) {
        Map<String, Object> map = (Map)obj;
        return (List)map.get(key);
    }

    public static Map<String, Object> getFieldAsObject(Object obj, String key) {
        Map<String, Object> map = (Map)obj;
        return (Map)map.get(key);
    }
}
