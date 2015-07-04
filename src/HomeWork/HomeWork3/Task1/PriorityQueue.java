package HomeWork.HomeWork3.Task1;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<Task> {

    private BinaryHeap heap = new BinaryHeap();

    public PriorityQueue() {
    }

    public void add(int priority, Task value) {
        heap.add(priority, value);
    }

    public void printQueue() {
        for (Entity entity : heap.list) {
            System.out.println(entity.task.toString());
        }
    }

    public Task getMax() {
        return heap.getMax();
    }

    public Task extractMax() {
        return heap.extractMax();
    }

    class Entity {
        private int priority;
        private Task task;

        public Entity(int priority, Task task) {
            this.priority = priority;
            this.task = task;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public Task getTask() {
            return task;
        }

        public void setTask(Task task) {
            this.task = task;
        }

    }

    class BinaryHeap {
        private List<Entity> list = new ArrayList<>();

        public int heapSize() {
            return this.list.size();
        }

        public void add(int priority, Task value) {

            list.add(new Entity(priority, value));
            int i = heapSize() - 1;
            int parent = (i - 1) / 2;

            while (i > 0 && list.get(parent).getPriority() < list.get(i).getPriority()) {
                Entity temp = list.get(i);
                list.set(i, list.get(parent));
                list.set(parent, temp);
                i = parent;
                parent = (i - 1) / 2;
            }
        }

        public void heapify(int i) {
            int leftChild;
            int rightChild;
            int largestChild;

            for (; ; ) {
                leftChild = 2 * i + 1;
                rightChild = 2 * i + 2;
                largestChild = i;

                if (leftChild < heapSize() && list.get(leftChild).getPriority() > list.get(largestChild).getPriority()) {

                    largestChild = leftChild;
                }

                if (rightChild < heapSize() && list.get(rightChild).getPriority() > list.get(largestChild).getPriority()) {
                    largestChild = rightChild;
                }

                if (largestChild == i) {
                    break;
                }

                Entity temp = list.get(i);
                list.set(i, list.get(largestChild));
                list.set(largestChild, temp);
                i = largestChild;
            }
        }

        public Task extractMax() {
            Entity result = list.get(0);
            list.set(0, list.get(heapSize() - 1));
            list.remove(heapSize() - 1);
            heapify(0);
            return result.getTask();
        }

        public Task getMax() {
            return list.get(0).getTask();
        }
    }
}
