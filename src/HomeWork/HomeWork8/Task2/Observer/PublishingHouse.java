package HomeWork.HomeWork8.Task2.Observer;

import HomeWork.HomeWork8.Task2.Observer.Item.Item;
import HomeWork.HomeWork8.Task2.Observer.Item.Journal;
import HomeWork.HomeWork8.Task2.Observer.Item.Magazine;

import java.util.LinkedList;
import java.util.List;

public class PublishingHouse {
    List<Item> getNewItems() {
        List<Item> newItems = new LinkedList<>();
        newItems.add(new Journal("������ \"��������\" "));
        newItems.add(new Magazine("������ \"���������\" "));
        newItems.add(new Journal("������ \"�����\" "));
        newItems.add(new Magazine("������ \"�����\" "));
        return newItems;
    }
}
