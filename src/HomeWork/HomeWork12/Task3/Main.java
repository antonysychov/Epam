package HomeWork.HomeWork12.Task3;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static volatile MyQueue<Violin> violins = new MyQueue<Violin>(5) {{
        add(new Violin(1));
        add(new Violin(2));
        add(new Violin(3));
        add(new Violin(4));
        add(new Violin(5));
    }};
    private static volatile MyQueue<ViolinBow> bows = new MyQueue<ViolinBow>(5) {{
        add(new ViolinBow(1));
        add(new ViolinBow(2));
        add(new ViolinBow(3));
        add(new ViolinBow(4));
        add(new ViolinBow(5));
    }};
    private static volatile List<Violinist> violinists = new LinkedList<Violinist>() {{
        add(new Violinist(1));
        add(new Violinist(2));
        add(new Violinist(3));
        add(new Violinist(4));
        add(new Violinist(5));
        add(new Violinist(6));
        add(new Violinist(7));
        add(new Violinist(8));
        add(new Violinist(9));
        add(new Violinist(10));
    }};

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(violinists.size());
        violinists.forEach(service::submit);
    }

    public static class Violinist implements Runnable {
        private int number;
        private Violin violin;
        private ViolinBow violinBow;

        public Violinist(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (true) {
                if (violin == null) {
                    synchronized (violins) {
                        if (violins.getQ().size() != 0) {
                            takeViolin();
                        } else try {
                            violins.wait(1000);
                            if (violins.getQ().size() != 0) {
                                takeViolin();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (violinBow == null) {
                    synchronized (bows) {
                        if (bows.getQ().size() != 0) {
                            takeBow();
                        } else try {
                            bows.wait(1000);
                            if (bows.getQ().size() != 0) {
                                takeBow();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
                if (Objects.nonNull(violin) && Objects.nonNull(violinBow)) {
                    play();
                    returnAll();
                } else {
                    returnAll();
                }
            }
        }

        private void takeViolin() {
            violin = violins.remove();
            System.out.println(String.format("Violinist ¹ %d took violin", number));
        }

        private void returnViolin() {
            violins.add(violin);
            violin = null;
            System.out.println(String.format("Violinist ¹ %d returned violin", number));
        }

        private void takeBow() {
            violinBow = bows.remove();
            System.out.println(String.format("Violinist ¹ %d took bow", number));
        }

        private void returnBow() {
            bows.add(violinBow);
            violinBow = null;
            System.out.println(String.format("Violinist ¹ %d returned bow", number));
        }

        private void returnAll() {
            if (violin != null) returnViolin();
            if (violinBow != null) returnBow();
        }

        private void play() {
            System.out.println(String.format("Violinist ¹ %d is playing", number));
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Violin {
        private int number;

        public int getNumber() {
            return number;
        }

        public Violin(int number) {

            this.number = number;
        }
    }

    static class ViolinBow {
        private int number;

        public int getNumber() {
            return number;
        }

        public ViolinBow(int number) {

            this.number = number;
        }
    }
}



