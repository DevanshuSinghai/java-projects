import java.util.*;

public class all_numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n=sc.nextInt();
        System.out.print("enter choice :");
        all_numbers obj = new all_numbers();
        int i=sc.nextInt();
        switch (i) {
            case 1:
                if(obj.automorphic(n))
                    System.out.print("number is automorphic");
                else System.out.println("not automorphic");
                break;
            case 2:
                if(obj.palindrome(n))
                    System.out.println("number is palindrome ");
                else System.out.println("Number is not palindrome ");
                break;
            case 3:
                if(obj.armstrong(n))
                    System.out.println("number is armstrong ");
                else System.out.println("Number is not armstrong ");
                break;
            case 4:
                if(obj.peterson(n))
                    System.out.println("number is peterson ");
                else System.out.println("Number is not peterson ");
                break;
            case 5:
                if(obj.tech(n))
                    System.out.println("number is tech ");
                else System.out.println("Number is not tech ");
                break;        
            default:
                System.out.println("enter correct number");
                break;
        }
        sc.close();
    }
    int find_length(int n){
        int i=0;
        while (n>0) {
            n/=10;
            i++;
        }
        return i;
    }
    int factorial(int n){
        if(n==1||n==0)
            return 1;
        else return n*factorial(n-1);
    }
    boolean automorphic(int n){
        int length=find_length(n);
        int sq_n=(int)Math.pow(n, 2);
        int temp_sq=0;
        for(int i=0;i<length;i++){
            temp_sq+=sq_n%(int)Math.pow(10, length--);
            sq_n=sq_n/10;
        }
        if(temp_sq==n)
            return true;
        return false;
    }    
    boolean palindrome(int n){
        String s= Integer.toString(n);
        StringBuffer sb =new StringBuffer(s);
        if(s.equals(sb.reverse().toString()))
            return true;
        return false;
    }
    boolean armstrong(int n){
        int sum=0,temp=n,digit=0;
        while(temp>0){
            digit=temp%10;
            sum+=Math.pow(digit, find_length(n));
            temp/=10;
        }
        if(n==sum)
            return true;
        return false;
    }
    boolean peterson(int n){
        int temp=n,sum=0;
        while (temp>0) {
            sum+= factorial((temp%10));
            temp/=10;
        }
        if(n==sum)
            return true;
        return false;
    }
    boolean tech(int n){
        int len=find_length(n);
        if(len%2!=0)
            return false;
        int left_half =n/((int)Math.pow(10,len/2)),right_half=n%((int)Math.pow(10,len/2));
        int sum_sq= (left_half+right_half)*(left_half+right_half);
        if(sum_sq==n)
            return true;
        return false;
    } 
}

