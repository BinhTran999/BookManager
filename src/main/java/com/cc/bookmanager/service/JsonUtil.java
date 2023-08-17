package com.cc.bookmanager.service;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class JsonUtil {
    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static ObjectMapper mapper = CDRUtils.createObjectMapper();
    private static Properties fieldsConvertProp = new Properties();

    public JsonUtil() {
    }

    public static String dumpObject(Object obj) {
        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException var2) {
            logger.error("Cannot dump object to json ", var2);
            return "";
        }
    }

    public static <T> T parseObject(String jsonSt, Class<T> cl) {
        mapper.setDateFormat(sdf);

        try {
            return mapper.readValue(jsonSt, cl);
        } catch (IOException var3) {
            logger.error("Cannot parse object from json ", var3);
            return null;
        }
    }

    public static Map<String, Object> objectToMap(Object obj) {
        return (Map)mapper.convertValue(obj, Map.class);
    }

    public static String preprocess(String message) {
        if (message == null) {
            return null;
        } else {
            String field;
            String fieldReplace;
            for(Iterator var1 = fieldsConvertProp.entrySet().iterator(); var1.hasNext(); message = message.replace("\"" + field + "\"", "\"" + fieldReplace + "\"")) {
                Map.Entry<Object, Object> entry = (Map.Entry)var1.next();
                field = (String)entry.getKey();
                fieldReplace = (String)entry.getValue();
            }

            return message;
        }
    }

    public static Map<String, Object> parseJson(String jsonSt) throws JsonParseException, JsonMappingException, IOException {
        mapper.setDateFormat(sdf);
        return (Map)mapper.readValue(jsonSt, Map.class);
    }

    static {
        try {
            fieldsConvertProp.load((new ClassPathResource("fields_convert.properties")).getInputStream());
        } catch (IOException var1) {
            logger.error("Cannot read fieldsConvert properties", var1);
        }

    }
}

