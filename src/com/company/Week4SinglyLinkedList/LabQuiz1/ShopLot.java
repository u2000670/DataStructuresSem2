package com.company.Week4SinglyLinkedList.LabQuiz1;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class ShopLot {
    String shopName;
    Person contactPers;
    Person[] empDetails;

    public ShopLot(String shopName, Person contactPers, Person[] empDetails) {
        this.shopName = shopName;
        this.contactPers = contactPers;
        this.empDetails = empDetails;
    }
}

class Person {
    String empName;
    String contactNum; //should allow null values

    public Person(String empName, String contactNum) {
        this.empName = empName;
        this.contactNum = contactNum; //should allow null values
    }
}

class Item<E, F> {
    //        E item;
//    F price;
    Map<E, F> itemsList = new LinkedHashMap<>();


    public void addItem(E item, F price) {
//        itemsList.add(item)
        itemsList.put(item, price);
    }

    public Number getItemPrice(E item){
        F price =itemsList.get(item);
        if(price instanceof Number)
            return (Number) price;
        else if (price instanceof String)
            return Double.parseDouble(((String) price).substring(2));
        else
            return -1;

    }
}

class FoodStore extends ShopLot implements Comparable<FoodStore> {
    Item<String, String> menu = new Item<>();

    public FoodStore(String shopName, Person contactPers, Person[] empDetails) {
        super(shopName, contactPers, empDetails);
    }

    public void addMenu(String foodName, String foodPrice){
        menu.addItem(foodName, foodPrice);
    }

    @Override
    public int compareTo(FoodStore fs) {
        if (empDetails.length > fs.empDetails.length)
            return 1;
        else if (empDetails.length < fs.empDetails.length)
            return -1;
        else
            return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FoodStore))
            return false;
        FoodStore fs = (FoodStore) obj;
        return contactPers.equals(fs.contactPers);
    }
}

class FashionStore extends ShopLot implements Comparable<FashionStore> {
    Item<String, Double> clothes;

    public FashionStore(String shopName, Person contactPers, Person[] empDetails) {
        super(shopName, contactPers, empDetails);
    }

    @Override
    public int compareTo(FashionStore fs) {
        if (empDetails.length > fs.empDetails.length)
            return 1;
        else if (empDetails.length < fs.empDetails.length)
            return -1;
        else
            return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FoodStore))
            return false;
        FoodStore fs = (FoodStore) obj;
        return contactPers.equals(fs.contactPers);
    }
}


class ShoppingMall {

    public static void main(String[] args) {
        LinkedList<FoodStore> foodStores = new LinkedList<>();

        FoodStore MCD = new FoodStore("McDonalds", new Person("Mike", "0101122334"),
                new Person[]{new Person("Jack", null), new Person("Jane", null)});
        MCD.addMenu("Burger", "RM10");
        MCD.addMenu("Fried Chicken", "RM12");
        foodStores.add(MCD);
//        FoodStore fs = (FoodStore) foodStores.get(0);



        FoodStore SM = new FoodStore("Sushi Mentai", new Person("Max", "0112233445"),
                new Person[]{new Person("Adam", null), new Person("Alex", null), new Person("Drew", null)});
        SM.addMenu("Chicken Katsu Don", "RM15");
        SM.addMenu("Ramen", "RM12");
        foodStores.add(SM);

        FoodStore WP = new FoodStore("Warong Penyet", new Person("Mike", "0101122334"),
                new Person[]{new Person("Lex", null), new Person("Leon", null), new Person("Drew", null)});
        WP.addMenu("Ayam Penyet", "RM10");
        foodStores.add(WP);

        //get list of prices?
        for (int i = 0; i < foodStores.size(); i++) {
        }

    }

    public static <T extends Comparable<T>> T highestNumOfEmp(LinkedList<T> list){
        T maxElem = list.get(0); // initialize

        for (T currentElem : list) {
            if (currentElem.compareTo(maxElem) > 0)
                maxElem = currentElem;
        }
        return maxElem;
    }
    public static <T extends Comparable<T>> T mostExpensiveItem(LinkedList<T> list){
        T maxElem = list.get(0); // initialize


        for (int i = 0; i < list.size(); i++) {
//            mostExpensiveItem()
//            if (currentElem.compareTo(maxElem) > 0) maxElem = currentElem;
        }
        return maxElem;
    }



}
