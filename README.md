# module1

High-level Design

    - Main interface, classes and Exceptions
          - VendingMachineDesign - an interface which defines public API of VendingMachine
          - DesignImplementation - a general purpose implementation of VendingMachine interface
          - CashInventory - A type-safe inventory for holding objects.
          - Item - type-safe Enum to represent items supported by vending machine.
          - Coin - type-safe Enum to represent coins, which is acceptable by vending machine.
          - Bucket - A Holder class for holding two types together.
          - NotSufficientChangeException - thrown when Vending machine doesn't have enough change to support the current transaction.

          - NotFullPaidException - thrown when the user tries to collect an item,without paying the full amount.
     
    - Data structures used
          - Map data structure is used to implement cash  inventory.
          - The List is used to returning change because it can contain duplicates,i.e. multiple coins of the same denomination.

   
    

 Low Level Design
    - Methods
          -  The getChange() :  to find out whether we have sufficient coins to support an amount.
          .
          -  The updateCashInventory() : to deduct cash from inventory according to the change given.
          -  The collectItem() : to dispense selected product and handle exception change not sufficient and amount not fully paid.
          -  The collectChange() : to calculate change amount.
          -  The isFullPaid() : to check and return boolean value if amount for product selected is paid in full or not.
          -  The hasSufficcientChange() : to check and return boolean value if inventory has sufficient cash for change.


    - Initialization
          - When Vending Machine will be created, it's initialized with default cash.Currently with quantity 10 for each coin.
          - The initialize() : to initialize vending machine with 10 coins of each denominations     



 Testing Strategy
         - Three primary test cases to testWithExactPrice(), testWithMorePrice() and testRefund() to cover general usecase.
         - Negative test cases testing  NotSufficientChangeException 


Running instructions: Clone project from git hub and then with the help of command mvn test, one can build the module and run tests.
   





