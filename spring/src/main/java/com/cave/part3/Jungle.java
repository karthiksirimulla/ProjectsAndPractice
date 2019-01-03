package com.cave.part3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Jungle
{
    private Map<String, String> foods = new HashMap<String, String>();
    private Map<String, Animal> animals = new HashMap<String, Animal>();

    public Map<String, String> getFoods()
    {
        return foods;
    }

    public void setFoods( Map<String, String> foods )
    {
        this.foods = foods;
    }

    public Map<String, Animal> getAnimals()
    {
        return animals;
    }

    public void setAnimals( Map<String, Animal> animals )
    {
        this.animals = animals;
    }

    @Override
    public String toString()
    {
        System.out.println( "Foods ---" );
        for( Entry<String, String> entry : foods.entrySet() )
        {
            System.out.println( entry.getKey() + "--" + entry.getValue() );

        }

        System.out.println( "Animals ----" );

        for( Entry<String, Animal> entry : animals.entrySet() )
        {
            System.out.println( entry.getKey() + "--" + entry.getValue() );

        }

        return "";
    }

}
