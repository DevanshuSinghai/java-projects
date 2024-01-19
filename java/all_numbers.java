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
                    System.out.print("\nnumber is automorphic");
                else System.out.println("not automorphic");
                break;
        
            default:
                System.out.println("enter correct number");
                break;
        }
        sc.close();
    }
    boolean automorphic(int n){
        int length=0,temp=n;
        while (temp>0) {
            temp=temp/10;
            ++length;
        }
        int sq_n=(int)Math.pow(n, 2);
        int temp_sq=0;
        for(int i=0;i<length;i++){
            temp_sq+=sq_n%(int)Math.pow(10, length--);
            sq_n=sq_n/10;
        }
        if(temp_sq==n)
            return true;
        else return false;
    }    
}
