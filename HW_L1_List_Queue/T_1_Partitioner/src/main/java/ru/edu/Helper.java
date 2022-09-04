package ru.edu;

import java.util.Objects;
import java.util.function.Predicate;

public class Helper {

    /**
     * Partition list by predicate.
     * Returns position pos of first item where predicate is false.
     * For elements in (0, pos) predicate is true. For elements in [pos, end) predicate is false.
     * <p>
     * Example:
     * <p>
     * IN: list = 1 -> 2 -> 3 -> 4 -> 5
     * <p>
     * OUT: list = 2 -> 4 -> 1 -> 3 -> 5
     * POS = 2
     *
     * @param list - list
     * @param pred - predicate
     */
    public static <T> int partitionBy(Node<T> list, Predicate<T> pred) {
        int pos = 0;
        if (Objects.isNull(list)) {
            return pos;
        }
        Node<T> tmpNode = list;
        while (list != null) {
            tmpNode = list;
            if (pred.test(list.value)) {
                pos++;
            } else {
                if (list.next != null && pred.test(list.next.value)) pos++;
                swap(tmpNode);
                list = tmpNode;
            }

            list = list.next;
        }

        return pos;

    }

    private static <T> Node<T> swap(Node<T> tNode) {
        Node<T> nextNode = null;
        while (tNode != null) {
            nextNode = tNode.next;
            T notPredValue = tNode.value;
            if (nextNode == null) break;
            tNode.value = (T) nextNode.value;
            nextNode.value = notPredValue;
            tNode = tNode.next;
        }
        return tNode;
    }
}