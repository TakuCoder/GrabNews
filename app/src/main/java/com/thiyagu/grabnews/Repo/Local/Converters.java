package com.thiyagu.grabnews.Repo.Local;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thiyagu.grabnews.models.news_pojo.Source;

import java.lang.reflect.Type;
public class Converters {
    //For converting Source to Json
    @TypeConverter
    public String from(Source value) {
        if (value == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Source>() {
        }.getType();
        return gson.toJson(value, type);
    }
    @TypeConverter
    public Source to(String value) {
        if (value == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Source>() {
        }.getType();
        return gson.fromJson(value, type);
    }
}
