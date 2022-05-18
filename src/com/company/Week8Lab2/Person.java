package com.company.Week8Lab2;

public class Person {

    private String name;
    private int age;
    private String gender;
    private String occupation;
    private static final String[] occupation_list = {"doctor", "nurse", "teacher", "police"};
    private boolean frontliner = false; //default value


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String gender, String occupation) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;

        setFrontliner();
    }

    //optional
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(frontliner)
        return name + " " + age + " " + gender + " Frontliner";
        else
            return name + " " + age + " " + gender + " Not frontliner";
    }

    public void setFrontliner() {
        //i=0 -> i = 3 / i=4 keluar
        for (int i = 0; i < occupation_list.length; i++) {

            if (occupation_list[i].equalsIgnoreCase(occupation)) {
                frontliner = true;
                break; //
            }
        }
    }
    public boolean getFrontliner(){
        return frontliner;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }
}





























