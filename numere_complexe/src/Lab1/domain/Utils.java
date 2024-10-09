package Lab1.domain;

public class Utils {

    public enum Operation { ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION };

    public static class Pair {
        int first;
        int second;

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        // Constructor to initialize the values
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

}
