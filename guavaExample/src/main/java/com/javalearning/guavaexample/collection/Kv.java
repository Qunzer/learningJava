package com.javalearning.guavaexample.collection;

/**
 * Created by renqun.yuan on 2015/8/12.
 */
public class Kv {
    private String key;
    private String value;

    public Kv(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Kv{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
