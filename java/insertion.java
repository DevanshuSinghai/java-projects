import java.util.*; // Import the scanner class
public class insertion{
    public static void main(String [] args){
        int a[],n;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of array");
        n=sc.nextInt();
        a=new int[n];
        int key,temp;//key= to store element which is to be compared from previous elements
        System.out.println("enter "+n+" elemments in the array");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();    
        }
        System.out.println("\nnow doing insertion sort\n");
        for(int i=1;i<n;i++){
            key=a[i];
            temp =i-1;//to keep record of the previous element which are to be compared with key
            while(temp>=0 && key<a[temp]){
                a[temp+1]=a[temp];
                temp=temp-1; //decreasing index of temp b/c we are traversing from key to 0th index
            }a[temp+1]=key;//now storing the smallest element at temp+1 i.e where it belongs acc. to its magnitude
        }
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        sc.close();
    }
}
