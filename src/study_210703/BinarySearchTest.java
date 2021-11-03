package study_210703;

public class BinarySearchTest {
    public static void main(String[] args) {

        int[] arr = {1,1,1,2,2,2,2,3,3,3,5,5};
        lowerBound(arr, 2);
        upperBound(arr,2);
    }

    public static void lowerBound(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(target <= arr[mid]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left+" / "+right);
    }

    public static void upperBound(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(target >= arr[mid]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        System.out.println(left+" / "+right);
    }

}
