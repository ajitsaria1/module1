import VendingMachine.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class VendingMachineUnitTest {

    private static VendingMachineDesign vm;

    @BeforeClass
    public static void setUIp() {
        vm = VendingMachineInventory.createVendingMachine();
    }

    @AfterClass
    public static void tearDown() {
        vm = null;
    }

    @Test
    public void testBuyItemWithExactPrice() {
        //select item, price in cents
        long price = vm.chooseItemAndGetPrice(Item.COKE);
        //price should be Coke's price
        assertEquals(Item.COKE.getPrice(), price);
        //25 cents paid vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
        Item item = bucket.getFirst();
        assertEquals(Item.COKE, item);
        List<Coin> change = bucket.getSecond();
        //should be Coke
        assertEquals(Item.COKE, item);
        // there should not be any change
        assertTrue(change.isEmpty());
    }
    @Test
    public void testBuyItemWithMorePrice() {
        long price = vm.chooseItemAndGetPrice(Item.SODA);
        assertEquals(Item.SODA.getPrice(), price);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
        Item item = bucket.getFirst();
        List<Coin> change = bucket.getSecond();
        //should be soda
        assertEquals(Item.SODA, item);
        // there should  change
        assertTrue(!change.isEmpty());
        assertEquals(50 - Item.SODA.getPrice(), getTotal(change));


    }
    @Test public void testRefund(){
        long price = vm.chooseItemAndGetPrice(Item.PEPSI);
        assertEquals(Item.PEPSI.getPrice(), price);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKLE);
        vm.insertCoin(Coin.PENNY);
        vm.insertCoin(Coin.QUARTER);
        assertEquals(41, getTotal(vm.refund()));

     }

    @Test
      public void testNotSufficientChangeException(){
        for (int i = 0; i < 5; i++) {
            vm.chooseItemAndGetPrice(Item.SODA);
            vm.insertCoin(Coin.QUARTER);
            vm.insertCoin(Coin.QUARTER);
            vm.collectItemAndChange();
            vm.chooseItemAndGetPrice(Item.PEPSI);
            vm.insertCoin(Coin.QUARTER);
            vm.insertCoin(Coin.QUARTER);
            vm.collectItemAndChange();
        }
    }

    private long getTotal(List<Coin> change){
        long total = 0;
        for(Coin c : change){
            total = total + c.getDenomination();
        }
        return total;
    }








    }

