import java.util.Scanner;

public class Palindrome {
    public static boolean checkPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.toLowerCase().charAt(i) != str.toLowerCase().charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name :");
        String str = new String("");
        str=sc.nextLine();
        if (checkPalindrome(str)) {
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("It is NOT a Palindrome");
        }
        sc.close();
    }
}