package ru.edu;

public class Helper {

    /**
     * Return Nth element FROM END of list.
     *
     * <p>
     * Example:
     * <p>
     * IN: list = 1 -> 2 -> 3 -> 4 -> 5
     * <p>
     * OUT:
     * findNthElement(list, 1) = 5
     * findNthElement(list, 2) = 4
     * findNthElement(list, 5) = 1
     * findNthElement(list, 6) = null
     *
     * @param list - list
     * @param n    - n
     */
    public static <T> T findNthElement(Node<T> list, int n) {
        if (list == null) {
            return null;
        }
        int length = sizeNode(list);
        if (length < n) {
            return null;
        } else {
            return moveTo(list, length - n + 1);
        }
    }

    private static <T> T moveTo(Node list, int pos) {
        if (list == null) {
            return null;
        }
        if (pos == 1) {
            return (T) list.value;
        } else {
            return moveTo(list.next, pos - 1);
        }
    }

    private static int sizeNode(Node list) {
        if (list == null) {
            return 0;
        }
        int count = 0;
        while (list != null) {
            count++;
            list = list.next;
        }
        return count;
    }
}
