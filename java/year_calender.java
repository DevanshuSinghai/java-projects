/*  in this we are using zeller's rule that states 
F=k+ [(13*m-1)/5] +D+ [D/4] +[C/4]-2*C where

k is  the day of the month.
m is the month number.
D is the last two digits of the year.
C is the first two digits of the year. 

The catch in this formula is that the month are started from march whose index is 1 and 
than go on till feb of next year whose index is 12, so for january and february we will find 
day of the corresponding date by subtracting 1 from year i.e we will calculate it for previous
year */

import java.util.*;
public class year_calender {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        year_calender obj =new year_calender();
        int a=0;
        System.out.println("enter year for which you want to get the calender");//asking the user that for which year he wants to print the calender
        int year=sc.nextInt();
        String week_days[]={"sun","mon","tue","wed","thur","fri","sat"};//array for printing day and its corresponding date
        
        String month_name[]={"MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER",
                            "DECEMBER","JANUARY","FEBRUARY"};//array to store name of month
        
        System.out.println();
        
        int num_days[]={31,30,31,30,31,31,30,31,30,31,31,28};//array in which we store days of month starting from march to feb
        
        if(year%4==0 && year%100!=0 || year%400==0)//checking if the year is leap or not
            num_days[11]=29;//if yes than change the value of days of feb month to 29
        
        for(int i=11;i<=12;i++){//loop only to print the days for jan and feb, just to maintain order, otherwise we can 
           
            System.out.println("\t\t "+month_name[i-1]);//also print it in the next loop which is doing same thing but starting from march
           
            for(int j=0;j<week_days.length;j++){//loop to print week days 
                System.out.print(week_days[j]+"\t");
            }
            System.out.println();
            
            int ans=0;//variable to store index of day of 1st date of month
            ans=obj.find_day(year-1, 1, i);
           
            for(int sp=0;sp<ans;sp++){
                System.out.print("\t");//loop to print spaces if the 1st date is not starting from sunday in the month
                a++;
            }
           
            for(int j=1;j<=num_days[i-1];j++){//loop to print dates of the month 
                if(a%7==0){
                    System.out.println();//condition that if we have exhausted all days of row i.e from sunday to saturday 
                    a=0;//we will than change line, like in a calender 
                }
                System.out.print(j+"\t");//printing the dates 
                a++;
            }
            ans=0;//giving ans and a equals 0 so that for every month we start from initial value 
            a=0;
            System.out.println("\n");
        }
       
        for(int i=1;i<=10;i++){//same loop as stated abvoe but doing stuff from march to december i.e working is same 
       
            System.out.println("\t\t "+month_name[i-1]);//also print it in the next loop which is doing same thing but starting from march
       
            for(int j=0;j<week_days.length;j++){//loop to print week days 
                System.out.print(week_days[j]+"\t");
            }
            System.out.println();
       
            int ans=0;
            ans=obj.find_day(year, 1, i);
           
            for(int sp=0;sp<ans;sp++){
                System.out.print("\t");
                a++;
            }
          
            for(int j=1;j<=num_days[i-1];j++){
                if(a%7==0){
                    System.out.println();
                    a=0;
                }
                System.out.print(j+"\t");
                a++;
            }
            ans=0;
            a=0;
            System.out.println("\n");
        }
        sc.close();
    }
    int find_day(int year,int date,int month){//function to find the day index using zeller's rule, day indexes are-- sun=0 ,sat=6
        int d=year%100;//to access last 2 didt of year
        int c=year/100;//to acces first two digit of year
        int f=date+((13*month -1)/5)+d+(d/4)+(c/4)-2*c;//zeller's rule
        
        if(f<0){//if zeller's rule gives -ve number than we have to find the multiple of 7 which is just smaller than f
            int temp=-1;//variable used to find the multiple of 7 which is just smaller than f
            while (temp>=f) {
                temp*=7;
            }
            f-=temp;//than subtracting that multiple from f, which will be our day index 
            return f;
        }
        if(f>7)//if f > 7 than we will return the remainder of f by 7
            return f%7;
        return f;//else simply return f
    }
}