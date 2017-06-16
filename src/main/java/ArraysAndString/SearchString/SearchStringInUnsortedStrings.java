package ArraysAndString.SearchString;

import java.util.Arrays;

/**
 * Find a string in an unsorted array of strings.
 */
public class SearchStringInUnsortedStrings {

    //need to do a binary search.
    public static void main(String[] args) {
        String array[] ={"EWRSFSFSFSB","BB","AA","SDFSFJ","WRTG","FF","ERF","FED","TGH"};
        String search = "BB";

        Arrays.sort(array);

        int searchIndex = binarySearch(array,search);

        System.out.println(searchIndex != -1 ? array[searchIndex]+ " - Index is "+searchIndex : "Not found");
    }

    public static int binarySearch(String[] a, String x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
