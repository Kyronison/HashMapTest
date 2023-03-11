package com.example.hashmaptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String maxKey = summarizeFloats(articleMapOne, articleMapOne1, articleMapOne2);
        Log.d("ARFA","Key with the maximum value is " + maxKey);
    }
    public static HashMap<String, Float> articleMapOne;
    static {
        articleMapOne = new HashMap<>();
        articleMapOne.put("biscuits", 0.51223f);
        articleMapOne.put("milk", 0.12341f);
    }
    public static HashMap<String, Float> articleMapOne1;
    static {
        articleMapOne1 = new HashMap<>();
        articleMapOne1.put("biscuits", 0.2312321f);
        articleMapOne1.put("milk", 0.4123412f);
    }
    public static HashMap<String, Float> articleMapOne2;
    static {
        articleMapOne2 = new HashMap<>();
        articleMapOne2.put("biscuits", 0.6312321f);
        articleMapOne2.put("milk", 0.9123412f);
        articleMapOne2.put("CARAMEL",10.5f);
    }

    public String summarizeFloats(HashMap<String, Float> map1, HashMap<String, Float> map2, HashMap<String, Float> map3) {
        HashMap<String, Float> newMap = new HashMap<>();
        String maxKey = null;
        float maxValue = 0;

        // Summarize float values into newMap
        for(Map.Entry<String, Float> entry : map1.entrySet()) {
            String key = entry.getKey();
            Float value = entry.getValue();
            if(newMap.containsKey(key)) {
                newMap.put(key, newMap.get(key) + value);
            } else {
                newMap.put(key, value);
            }
        }

        for(Map.Entry<String, Float> entry : map2.entrySet()) {
            String key = entry.getKey();
            Float value = entry.getValue();
            if(newMap.containsKey(key)) {
                newMap.put(key, newMap.get(key) + value);
            } else {
                newMap.put(key, value);
            }
        }

        for(Map.Entry<String, Float> entry : map3.entrySet()) {
            String key = entry.getKey();
            Float value = entry.getValue();
            if(newMap.containsKey(key)) {
                newMap.put(key, newMap.get(key) + value);
            } else {
                newMap.put(key, value);
            }
        }

        // Find key with maximum value
        for(Map.Entry<String, Float> entry : newMap.entrySet()) {
            String key = entry.getKey();
            Float value = entry.getValue();
            if(value > maxValue) {
                maxKey = key;
                maxValue = value;
            }
        }
        return maxKey;
    }
}