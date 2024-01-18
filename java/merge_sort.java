import java.util.*;
public class merge_sort {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter size of array ");
        int length=sc.nextInt();
        System.out.println("enter "+length+" elements ");
        int arr[]=new int[length];
        for(int i=0;i<length;i++){
            arr[i]=sc.nextInt();//storing elements of array 
        }
        merge_sort obj=new merge_sort();//making an object of class merge_sort so that we can call function form main
        obj.divide(arr,0,length-1);//calling divide function 
        System.out.println("sorted elements are: ");//printing sorted array
        for(int i=0;i<length;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();//closing scanner class to prevent memory leak 
    }
    void divide(int arr[],int l,int h){ //this function continouslsy divide the array in half
        if(l<h){// l= lower index of array, h= upper index of array
            int mid=(l+h)/2;//mid is the middle index of array
            divide(arr, l, mid);//calling the same function again but with different values of arguments
            divide(arr, mid+1, h);
            conquer(arr,l,mid,h);//calling another function which merge the array
        }
    }
    void conquer(int arr[],int l,int mid,int h){//function to sort and merge the array
        int l_len=mid-l+1;//length of left sub array
        int r_len=h-mid;//lenght of right sub array
        int left_arr[]=new int[l_len];//left sub array
        int right_arr[]=new int[r_len];//right sub array
        for(int i=0;i<l_len;i++){
            left_arr[i]=arr[i+l];//storing values in left sub array fromm original array
        }
        for(int i=0;i<r_len;i++){
            right_arr[i]=arr[mid+i+1];//storing values in right sub array fromm original array
        }
        int i=0,j=0,k=l;//taking counters variable to keep a check on index of left, right and original array
        while(i<l_len&&j<r_len){
            if(left_arr[i]<=right_arr[j]){//comparing the smallest element from both array
                arr[k]=left_arr[i];//and storing it in original array
                i++;
            }
            else if(left_arr[i]>right_arr[j]){
                arr[k]=right_arr[j];
                j++;
            }
            k++;
        }
        while(i<l_len){
            arr[k]=left_arr[i];//if any element is left in left sub array it will be stored using this loop
            i++;k++;
        }
        while(j<r_len){
            arr[k]=right_arr[j];//if any element is left in right sub array it will be stored using this loop
            j++;k++;
        }
    }
}
