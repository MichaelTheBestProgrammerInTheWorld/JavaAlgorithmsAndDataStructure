package search;

public class BinarySearch {

    //binary search works only with sorted array

    public void search(int[] arr, int key){
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] == key){
                System.out.println("value " + arr[mid] + " found at index " + mid);
                return;
            }
            if (arr[mid] > key){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("value " + key + " not found");
    }

    public int indexOf(int[] arr, int key){
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] == key){
                return mid;
            }
            if (arr[mid] > key){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /*
    Given a sorted array of distinct integers and a target value,
    return the index if the target is found. If not, return the
    index where it would be if it were inserted in order.
     */
    public int searchInsert(int[] arr, int key){
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = (low + high) / 2; //or low + (high - low) /2
            if (arr[mid] == key){
                return mid;
            }
            if (arr[mid] > key){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 10, 20, 47, 59, 65, 75, 88, 99};
        BinarySearch bs = new BinarySearch();
        bs.search(numbers, 65);
        bs.search(numbers, 100);
        System.out.println(bs.indexOf(numbers, 65));
        System.out.println(bs.indexOf(numbers, 100));
    }
}
