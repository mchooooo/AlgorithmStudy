package study_210703;

import java.util.Base64;

public class BinarySearchTest {
    public static void main(String[] args) {

        int[] arr = {1,1,2,2,2,3,3,3,5,5,5,7};
//        lowerBound(arr, 2);
//        upperBound(arr,2);
//        test(arr,2);
        String str = "TGlm";

        String s = Integer.toBinaryString(19);
        s+= Integer.toBinaryString(6);
        s+= Integer.toBinaryString(37);
        s+= Integer.toBinaryString(38);
        System.out.println(s);

        System.out.println();
    }

    public static void lowerBound(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target <= arr[mid]){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left+" / "+right);
    }

    public static void upperBound(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target >= arr[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(left+" / "+right);
    }

    public static void test(int[] arr, int score){
        int start = 0;
        int end = arr.length-1;
        while(start<=end) {

            int mid =(start+end)/2;
            if(arr[mid] <score) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        System.out.println(start+" / " + end);
    }

}
