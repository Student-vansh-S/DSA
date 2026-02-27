public class BinarySearch {
    static int Bsearch(int arr[], int key) {
        int start = arr[0];
        int last = arr.length - 1;
        int i = 0;
        while (start <= last) {
            int mid = (start + last) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                start = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 6, 8, 14, 23, 25, 32, 48 };
        int result;
        result = Bsearch(arr, 23);
        System.out.println(result == -1 ? "Key no found" : "Key found at " + (result + 1) + "Position");
    }
}
