import java.util.*;
public class Csp {
    static long card_number;
    static int arr[]=new int[16];
    public static void main(String[] args) {
        System.out.println("enter card number ");
        Scanner sc = new Scanner(System.in);
        card_number= sc.nextLong();
        for(int i=15;i>=0;i--){
            arr[i]=(int)card_number%10;
            card_number/=10;
        }
        Card card = new Card();
        Card.Visa visa= card.new Visa();
        visa.check();
        Card.Master master = card.new Master();
        master.check();
        Card.Rupay rupay = card.new Rupay();
        rupay.check(); 
        Card.Amex amex = card.new Amex();
        amex.check();
        sc.close();
    }
}

class Card extends Csp{
    
    class Visa{
        int sum1=0;
        int sum2 =0;
        void check(){
        for(int i=0;i<8;i++){
            sum1+=arr[i];
            sum2+=arr[i+8];
        }
        float rem1=sum1/(arr[14]*10 +arr[15]);
        float rem2=sum2/(arr[12]*10 +arr[13]);
        if(rem1<50&&rem2<50)
            System.out.println("card number is of visa");
}}
    class Master{
        int sum1=0;
        int sum2 =0,sum3=0,sum4=0;
        public float rem1;
        public float rem2;
        void check(){
            for(int i=0;i<4;i++){
                sum1+=arr[i];
                sum2+=arr[i+4];
                sum3+=arr[i+8];
                sum4+=arr[i+12];
            }
            long prod1=sum1*sum2;
            long prod2=sum3*sum4;
            rem1= (float)(prod1/(arr[4]*10 +arr[5]));
            rem2 =(float)(prod1/(arr[4]*10 +arr[5]));
            if((prod1/(arr[4]*10 +arr[5]))>20 && (prod1/(arr[4]*10 +arr[5]))<40 && (prod2/(arr[8]*10 +arr[9]))<40)
                System.out.println("Master Card");
            else System.out.println("card is not master ");
}}
    class Rupay{
        void check(){
        Master a=new Master();
        float ans= a.rem1/a.rem2;
        if(ans>10 && ans <20)
            System.out.println("card is rupay");
        else System.out.println("card is not rupay");
        }
    }
    class Amex{
        void check(){
        Master a=new Master();
        float ans= a.rem2/a.rem1;
        if(ans>20 && ans <50)
            System.out.println("card is Amex");
        else System.out.println("card is not Amex");
        }
    }
}
