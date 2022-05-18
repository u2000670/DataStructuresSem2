package com.company.Week8Lab2;

public class Test {

    public static void main(String[] args) {

        //Part A
        Stack raw = new Stack("Raw list");

        raw.push("ali", 32, "m", "doctor");
        raw.push("lisa", 29, "f", "nurse");
        raw.push("tanaka", 41);
        raw.push("ahmad", 18, "m", "developer");
        raw.push("maria", 20, "f", "accountant");
        raw.push("chong", 70, "m", "lawyer");
        raw.push("raju", 55, "m", "police");
        raw.push("alex", 16, "f", "business man ");
        Person katie = new Person("katie", 36, "f", "teacher");
        raw.push(katie);
        raw.displayStack();

        //Part B
        Stack frontliners = new Stack("Frontliner list");
        Stack others = new Stack("Others list");

        int f = -1, nfl = -1;
        for (int i = raw.getSize() - 1; i >= 0; i--) {

            if (raw.peek().getFrontliner()) {
                frontliners.push(raw.pop());
                f++;
            } else {
                others.push(raw.pop());
                nfl++;
            }
        }

        raw.displayStack();
        frontliners.displayStack();
        others.displayStack();


        //Part C
        Stack priority = new Stack("Vaccine Priority List");

        //my initial idea : turn stack into array -> sort array -> push array elems into priority stack

        /*Person[] frontlinersArr= stackToArray(frontliners);
        Person[] othersArr = stackToArray(others);
        sortAge(frontlinersArr);
        sortAge(othersArr);

        *//*System.out.println("frontlinersArr");
        for (int i = 0; i < frontlinersArr.length; i++) {
            System.out.println(frontlinersArr[i]);
        }
        System.out.println("others");
        for (int i = 0; i < othersArr.length; i++) {
            System.out.println(othersArr[i]);
        }*//*


        for (int i = 0; i < othersArr.length; i++) {
            priority.push(othersArr[i]);
        }
        for (int i = 0; i < frontlinersArr.length; i++) {
            priority.push(frontlinersArr[i]);
        }*/


        frontliners = sortStack(frontliners);
        others = sortStack(others);
        //sorts so that oldest person at the bottom of stack

        int combinedStackSize = frontliners.getSize()+ others.getSize();
        for (int i = 0; i < combinedStackSize; i++) {
            if(!others.isEmpty())
                priority.push(others.pop());
            else
                priority.push(frontliners.pop());
        }

        frontliners.displayStack();
        others.displayStack();
        priority.displayStack();
    }
    
    public static Stack sortStack(Stack inputStack){
        Stack tempStack = new Stack("temp Stack");
        while(!inputStack.isEmpty()){
            Person temp = inputStack.pop();
            while(!tempStack.isEmpty() && tempStack.peek().getAge() < temp.getAge()){
                inputStack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
//        inputStack = tempStack; //?
        return tempStack;
    }

    public static Person[] stackToArray(Stack stack){
        Person[] personArr = new Person[stack.getSize()];

        for (int i = 0; i < personArr.length; i++) {
            personArr[i] = stack.pop();
        }
        return personArr;
    }


    public static void sortAge(Person[] pList){
        Person temp;
        for (int j = 0; j < pList.length-1 ; j++) {
            for (int i = 0; i < pList.length-1; i++) {
                if(pList[i].getAge() > pList[i+1].getAge()) {
                    temp = pList[i+1];
                    pList[i+1] = pList[i];
                    pList[i] = temp;
                }
            }
        }


    }


}
