package oop.inheritance;

public class RatingStar implements IIncreaseRating, IReduceRating {

    @Override
    public int increaseRating() {
        return 1;
    }

    @Override
    public int reduceRating() {
        return -1;
    }
}
