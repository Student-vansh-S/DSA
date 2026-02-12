public class ReverseWordsInStringIII {
    public static String reverseWords(String s) {
        char arr[] =s.toCharArray();
        int left=0, right=0;
        while(right < arr.length){
            if(arr[right] ==' '){
                reverse(arr,left,right-1);
                left = right+1;
            }
            right++;
        }
        reverse(arr,left,right-1);
        return new String(arr);
    }
    public static void reverse(char[] arr,int left, int right){
        while(left < right){
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
    public static void main(String[] args) {
        String s="sky blue";
        System.out.println(reverseWords(s));
    }
}
