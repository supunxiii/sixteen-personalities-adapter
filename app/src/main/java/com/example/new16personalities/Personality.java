package com.example.new16personalities;

import static java.nio.charset.StandardCharsets.UTF_8;

import android.content.Context;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class Personality {
    String number;
    String title;
    String type;
    String description;
    String cover;

    public Personality(String number, String title, String type, String description, String cover) {
        this.number = number;
        this.title = title;
        this.type = type;
        this.description = description;
        this.cover = cover;
    }
    @NonNull
    static ArrayList<Personality> getPersonalities(String filename, Context context){
        ArrayList<Personality> personalityArrayList = new ArrayList<>();
        try {
            InputStream inputstream = context.getAssets().open(filename);
            byte[] buffer=new byte[inputstream.available()];
            inputstream.read(buffer);
            inputstream.close();

            //JSONObject json=new JSONObject(new String(buffer), StandardCharsets.UTF_8));
            JSONObject json=new JSONObject(new String(buffer,UTF_8));
            JSONArray personalities=json.getJSONArray("personalities");

            for(int i=0;i<personalities.length();i++){
                personalityArrayList.add(new Personality(personalities.getJSONObject(i).getString("Number"),
                        personalities.getJSONObject(i).getString("Title"),
                        personalities.getJSONObject(i).getString("Type"),
                        personalities.getJSONObject(i).getString("Description"),
                        personalities.getJSONObject(i).getString("Cover")
                ));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return personalityArrayList;
    }
}

