package HomeWork.HomeWork2.Task1;

public interface Container<DataType> {
    public DataType get(int index);

    public int getSize();

    public void add(DataType data);
}
