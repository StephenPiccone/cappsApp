package com.example.stephenpiccone.cappsapp;
import java.util.List;
import java.util.Map;

import ca.roumani.i2c.CountryDB;
import ca.roumani.i2c.Country;


public class Game
{
    private CountryDB db;

    public Game()
    {
        this.db = new CountryDB();
    }

    public String qa()
    {
        List<String> capitals = db.getCapitals();
        int n = capitals.size();
        int index = (int) (n * Math.random());
        String c = capitals.get(index);
        Map<String, Country> data = db.getData();
        Country ref = data.get(c);
        String capital = ref.getCapital();
        String country = ref.getName();
        String answer;
        if(Math.random() <0.5)
        {
            answer = capital + " is the capital of?\n" + country;
        }
        else{
            answer = "What is the capital of " + country + "?\n" + capital;
        }
        return answer;

    }

    public static void main(String[] args)
    {

    }
}


