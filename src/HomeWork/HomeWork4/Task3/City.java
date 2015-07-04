package HomeWork.HomeWork4.Task3;

import java.util.LinkedList;
import java.util.List;

public class City {

    private List<Avenue> avenues = new LinkedList<Avenue>();
    private List<Street> streets = new LinkedList<Street>();
    private List<Square> squares = new LinkedList<Square>();

    class Avenue {
        private String name;
        private float length;

        public float getLength() {
            return length;
        }

        public void setLength(float length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Street {

        private String name;
        private float length;

        public float getLength() {
            return length;
        }

        public void setLength(float length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    class Square {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
