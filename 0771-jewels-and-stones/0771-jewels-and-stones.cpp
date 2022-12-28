class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int arr[256]={0};
        int i,c=0;
        for(i=0;i<J.length();i++){
            arr[J[i]]=1;
        }
        for(i=0;i<S.length();i++){
            if(arr[S[i]]){
                c++;
            }
        }
        return c;
    }
};