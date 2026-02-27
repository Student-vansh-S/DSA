import java.util.Scanner;

public class Assingment {
    public static int checkVowels(StringBuilder str){
        int count=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter String :");
        StringBuilder str= new StringBuilder(sc.nextLine());
        System.out.println("Number of the Vowels are occurred :"+checkVowels(str));
        sc.close();
    }
    
}
