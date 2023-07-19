// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> ans = new ArrayList<>();
//         solve(0, ans);
//         return ans;
//     }
//     static void solve(int col, List<List<String>> ans) {
        
//         for (int row = 0; row < n; row++) {
            
//         }
//     }
// }
class Solution {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] matrix = new char[n][n];
        //initally fill all cells by empty charatcer
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = '.';
            }
        }
        //make back tracking function call
        func(matrix, 0);
        return list;
    }
    
    
    
    public void func(char[][] matrix, int x){
        //base case
        if(x == matrix.length){ 
            // when all queens are settled, save this matrix to final List
            ArrayList<String> ll = new ArrayList<>();
            for(int i=0;i<matrix.length;i++){
                String str = "";
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j] == 'Q'){
                        str+="Q";
                    }
                    else{
                        str+=".";
                    }
                }
                ll.add(str);
            }
            list.add(new ArrayList(ll));
            return;
        }
        
        //recursion call for all columns at a row
        for(int i=0;i<matrix[0].length;i++){
            if(isSafe(matrix, x, i)){    // check if possible to put queen
                matrix[x][i] = 'Q'; // put queen
                func(matrix, x+1);  //do for next row
                matrix[x][i] = '.'; // remove queen
            }
        }
        // matrix[x][j] = '*';
    }
    

    
    public boolean isSafe(char[][] matrix, int x,int y){
        //vertical
        for(int i=x-1;i>=0;i--){
            if(matrix[i][y] == 'Q'){
                return false;
            }
        }
        
        //left diagonal
        for(int i=x-1,j=y-1;i>=0 && j>=0 ; i--,j--){
            if(matrix[i][j] == 'Q'){
                return false;
            }
        }
        
        //right diagonal
        for(int i=x-1,j=y+1;i >=0 && j < matrix[0].length; i--, j++){
            if(matrix[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    
}