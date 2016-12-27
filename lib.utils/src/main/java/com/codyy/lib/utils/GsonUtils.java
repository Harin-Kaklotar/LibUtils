package com.codyy.lib.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojian on 2016/4/20.
 */
public class GsonUtils {
    public static <T> T json2Bean(String jsonString, Class<T> cls) {
        T t;
        try {
            Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
//然后用上面一行写的gson来序列化和反序列化实体类type
//            gson.fromJson(json, type);
//            gson.toJson(type);
//            Gson gson = new Gson();
            t = gson.fromJson(jsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
            t = null;
        }
        return t;
    }

    public static <T> List<T> json2List(String jsonString) {
        List<T> list;
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString, new TypeToken<List<T>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            list = new ArrayList<>();
        }
        return list;
    }

    public static List<Map<String, Object>> listKeyMaps(String jsonString) {
        List<Map<String, Object>> list;
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString,
                    new TypeToken<List<Map<String, Object>>>() {
                    }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            list = new ArrayList<>();
        }
        return list;
    }

    public static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringNullAdapter();
        }
    }

    public static class StringNullAdapter extends TypeAdapter<String> {
        @Override
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }

        @Override
        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }
}
