package VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class CashInventory {

    private Map<Coin, Integer> inventory = new HashMap<Coin, Integer>();
    public int getQuantity(Coin number){
        Integer value = inventory.get(number);
        return value == null? 0 : value ;
    }
    public void add(Coin number){
        int count = inventory.get(number);
        inventory.put(number, count+1);
    }
    public void deduct(Coin number) {
        if (hasItem(number)) {
            int count = inventory.get(number);
            inventory.put(number, count - 1);
        }
    }
    public boolean hasItem(Coin number){
        return getQuantity(number) > 0;
    }
    public void clear(){
        inventory.clear();
    }
    public void put(Coin number, int quantity) {
        inventory.put(number, quantity);
    }







}
