package com.srtmaker.request;


import com.fasterxml.jackson.annotation.JsonProperty;

public class SrtRequest {

    @JsonProperty
    private String name;

    @JsonProperty
    private String textValue;

    @JsonProperty
    private int wordsPerMinute;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public int getWordsPerMinute() {
        return wordsPerMinute;
    }

    public void setWordsPerMinute(int wordsPerMinute) {
        this.wordsPerMinute = wordsPerMinute;
    }
}
