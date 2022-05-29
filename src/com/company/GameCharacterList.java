package com.company;

import com.company.Week4SinglyLinkedList.Tuto4.MyLinkedListT;
import com.company.Week4SinglyLinkedList.Tuto4.Node;

public class GameCharacterList extends MyLinkedListT<GameCharacter> {

    public GameCharacter binarySearch(int abilityValue) { //this only checks for strength atm
        GameCharacter start = head.elem;
        GameCharacter last = null;
        do {
            GameCharacter mid = getMiddle(start, last);
            Node<GameCharacter> midNode = getNode(mid);
            if (mid == null) return null;
            if (mid.getStrength() == abilityValue)return mid;
            else if (mid.getStrength() < abilityValue) { //this is just checking for strength
                start = midNode.next.elem; //start = mid.next
            } else
                last = mid;
        } while (last == null || last != start);
        return null;
    }

    public static void main(String[] args) {
        GameCharacter hz = new GameCharacter("Hange Zoe", 170, 60, 9, 9, 12, 7, 11);
        GameCharacter la = new GameCharacter("Levi Ackerman", 160, 65, 12, 12, 7, 8, 8);
        GameCharacter hr = new GameCharacter("Historia Reiss", 145, 42, 4, 8, 7, 6, 5);
        GameCharacter ey = new GameCharacter("Eren Yeager", 170, 63, 9, 10, 3, 5, 10);
        GameCharacter ma = new GameCharacter("Mikasa Ackerman", 170, 68, 10, 9, 8, 6, 7);
        GameCharacter cs = new GameCharacter("Connie Springer", 158, 58, 6, 7, 3, 7, 5);
        GameCharacter sb = new GameCharacter("Sasha Blouse", 165, 55, 6, 3, 5, 6, 7);

        GameCharacterList gcl = new GameCharacterList();
        gcl.addLast(hr);
        gcl.addLast(cs);
        gcl.addLast(sb);
        gcl.addLast(ey);
        gcl.addLast(hz);
        gcl.addLast(ma);
        gcl.addLast(la);

        System.out.println(gcl.binarySearch(6));

    }

}
