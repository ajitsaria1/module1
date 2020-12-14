package VendingMachine;

import java.util.List;

/** * Declare public API for Vending Machine
     author Karishma Ajitsaria
 * */



public interface VendingMachineDesign {
    public long chooseItemAndGetPrice(Item item);
    public void insertCoin(Coin coin);
    public List<Coin> refund();
    public Bucket<Item, List<Coin>> collectItemAndChange();
    public void reset();
}
