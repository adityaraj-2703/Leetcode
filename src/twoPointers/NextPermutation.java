package twoPointers;

public class NextPermutation {
    public void nextPermutation(int[] arr) {
        //step1
        int n = arr.length;
        int ind = -1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i] < arr[i+1]){
                ind = i;
                break;
            }
        }
        if(ind==-1){
            reverse(arr,0,n-1);
            return;
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i] > arr[ind]){
                int temp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = temp;
                reverse(arr,ind+1,n-1);
                return;
            }
        }

    }
    static void reverse(int[] arr,int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
