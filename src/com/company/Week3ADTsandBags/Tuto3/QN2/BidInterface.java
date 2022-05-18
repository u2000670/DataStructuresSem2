package com.company.Week3ADTsandBags.Tuto3.QN2;

//bid (name comp, unit desc, performance, unit cost, installation cost )
public interface BidInterface {

    /*Returns the name of the company making this bid*/
    public String getCompName();

    /*Returns the description of the air conditioner that this bid is for*/
    public String getDesc();

    /*Returns the capacity of this bid's AC in tons (1 ton = 12,000 BTU)*/
    public int getCapacity();

    /*Returns the seasonal efficiency of this bid's AC (SEER)*/
    public String getSeasonalEff();

    /*Returns the cost of this bid's AC*/
    public double getUnitCost();

    /*Returns the cost of installing this bid's AC*/
    public double getInstallCost();

    /*Returns the yearly cost of operating this bid's AC*/
    public double getYearlyCost();

}
