package HomeWork.HomeWork8.Task2.Observer;

public class Test {
    public static void main(String[] args) {
        PublishingHouse ph = new PublishingHouse();
        PostOffice office = new PostOffice();
        office.addSubscriber(new Subscriber("���� ������"));
        office.addSubscriber(new Subscriber("������� ������"));
        office.acceptNewItems(ph);
    }
}
