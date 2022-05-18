package com.company.Week3ADTsandBags.Tuto3.QN2;

public interface BidCollectionInterface<T> extends BidInterface {

    /*Adds a bid to this collection*/
    public void add(T bid);

    /*Returns the bid in this collection with the best yearly cost*/
    public T getBestYearlyCost();

    /*Returns the bid in this collection with the best initial cost.
    The initial cost will be defined as the unit cost plus the installation cost.*/
    public T getBestInitialCost();

    /*Clears all the items from this collection*/
    public void clear();

    /*Gets the number of items in this collection*/
    public int size();

    /*Sees whether this collection is empty*/
    public boolean isEmpty();


}
