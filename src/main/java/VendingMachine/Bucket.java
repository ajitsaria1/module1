package VendingMachine;


/**
 * A parameterized utility class to hold two different object.
 */

public class Bucket<O1,O2> {

    private O1 first;
    private O2 second;

    public Bucket(O1 first, O2 second){

        this.first = first;
        this.second = second;
    }

    public O1 getFirst() {
        return first;
    }

    public O2 getSecond() {
        return second;
    }
}
