//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> subsetSum = new ArrayList<>();
        int curSum = 0;
        helper(0, arr, curSum, subsetSum, N);
        return subsetSum;
    }
    static void helper(int i, ArrayList<Integer> arr, int curSum, ArrayList<Integer> subsetSum, int N) {
        if (i == N) {
            subsetSum.add(curSum);
            return;
        }
        curSum += arr.get(i);
        helper(i + 1, arr, curSum, subsetSum, N);   //TAKE
        curSum -= arr.get(i);
        helper(i + 1, arr, curSum, subsetSum, N);   //DON'T TAKE
    }
}