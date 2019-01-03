package com.cave.part2;

import java.util.Arrays;
import java.util.Set;

public class FruitBasket
{
    private String bName;

    private Set<String> fruits;

    public FruitBasket( String bname,
        Set<String> fruits )
    {
        this.bName = bname;
        this.fruits = fruits;
    }

    @Override
    public String toString()
    {
        return "FruitBasket [bName=" + bName + ", fruits=" + Arrays.toString( fruits.toArray() ) + "]";
    }

}
