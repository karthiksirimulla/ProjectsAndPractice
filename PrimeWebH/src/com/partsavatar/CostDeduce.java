package com.partsavatar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CostDeduce
{
    public static void main( String[] args )
    {
        Map<String, Integer> shoppingCart = new HashMap<>();
        shoppingCart.put( "product1", 3 );
        shoppingCart.put( "product2", 6 );
        shoppingCart.put( "product3", 5 );

        Address addr = new Address();
        addr.setWarehouse( Warehouse.EDMONTON );

        Map<Warehouse, Map<String, Integer>> res = getInventoryAllocation( shoppingCart, addr );
        System.out.println( res.toString() );

    }

    public static Map<Warehouse, Map<String, Integer>> getInventoryAllocation( Map<String, Integer> shoppingCart,
                                                                               Address addressOfCustomer )
    {
        Map<Warehouse, Map<String, Integer>> invMap = new HashMap<Warehouse, Map<String, Integer>>();
        List<Warehouse> nearWarehouseList = getNearestWarehouses( addressOfCustomer );
        shoppingCart.entrySet().forEach( e -> {
            nearWarehouseList.forEach( w -> {
                invMap.put( w, new HashMap<String, Integer>()
                {
                    {
                        if( null != getInventory( e.getKey() ).get( w ) && getInventory( e.getKey() ).get( w ) > 0 )
                            put( e.getKey(), getInventory( e.getKey() ).get( w ) );
                    }
                } );
            } );
        } );
        return invMap;

    }

    public static Map<Warehouse, Integer> getInventory( String product )
    {
        Map<Warehouse, Integer> inventory = new HashMap<>();
        switch( product )
        {
            case "product1":
            {
                inventory.put( Warehouse.EDMONTON, 2 );
                inventory.put( Warehouse.MONTREAL, 5 );
                inventory.put( Warehouse.EDMONTON, 7 );
                return inventory;
            }
            case "product2":
            {
                inventory.put( Warehouse.EDMONTON, 1 );
                inventory.put( Warehouse.MONTREAL, 3 );
                inventory.put( Warehouse.EDMONTON, 6 );
                inventory.put( Warehouse.VANCOUVER, 5 );
                return inventory;
            }
            case "product3":
            {
                inventory.put( Warehouse.MONTREAL, 2 );
                inventory.put( Warehouse.EDMONTON, 5 );
                inventory.put( Warehouse.VANCOUVER, 9 );
                return inventory;
            }
            default:
                return inventory;
        }

    }

    public static List<Warehouse> getNearestWarehouses( Address addressOfCustomer )
    {
        List<Warehouse> nearLoc = new ArrayList<>();
        switch( addressOfCustomer.warehouse )
        {
            case EDMONTON:
            {
                nearLoc.add( Warehouse.EDMONTON );
                nearLoc.add( Warehouse.MONTREAL );
                nearLoc.add( Warehouse.TORONTO );
                return nearLoc;
            }
            case MONTREAL:
            {
                nearLoc.add( Warehouse.MONTREAL );
                nearLoc.add( Warehouse.TORONTO );
                nearLoc.add( Warehouse.VANCOUVER );
                return nearLoc;
            }
            case TORONTO:
            {
                nearLoc.add( Warehouse.TORONTO );
                nearLoc.add( Warehouse.VANCOUVER );
                nearLoc.add( Warehouse.EDMONTON );
                return nearLoc;
            }
            case VANCOUVER:
            {
                nearLoc.add( Warehouse.VANCOUVER );
                nearLoc.add( Warehouse.EDMONTON );
                nearLoc.add( Warehouse.MONTREAL );
                return nearLoc;
            }

            default:
                return nearLoc;
        }

    }

}
