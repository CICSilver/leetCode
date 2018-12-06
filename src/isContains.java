import java.util.Arrays;

public class isContains {
        public int [ ] qsort(int[] items)
        {
            qs(items, 0, items.length - 1);
            return items;
        }

        private static void qs(int[] items, int left, int right)
        {
            int i, j;
            int pivot, temp;
            i = left;
            j = right;
            pivot = items [(left + right) / 2];
            do {
                while ((items [i] < pivot) && (i < right)) {
                    i++;
                }
                while ((pivot < items [j]) && (j > left)) {
                    j--;
                }
                if (i <= j) {
                    temp = items [i];
                    items [i] = items [j];
                    items [j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (left < j) {
                qs(items, left, j);
            }
            if (i < right) {
                qs(items, i, right);
            }
        }
        public static void main(String[] args) {
            int[] temp = {0, 5, 9, 8, 7, 4, 3, 5, 47, 41, 5, 23, 1, 5, 6, 2, 1, 56, 12, 3, 5, 46, 48, 9645, 32};
            isContains ic=new isContains();
            ic.qsort(temp);
            System.out.println(Arrays.toString(temp));
        }
}


