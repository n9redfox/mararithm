class Solution {
    public int maximalSquare(char[][] matrix) {
        int rSize = matrix.length;
        if (rSize <= 0)
            return 0;
        
        int cSize = matrix[0].length;
        int max = 0;
        
        for (int i = 0; i < rSize; i++) {
            for (int j = 0; j < cSize; j++) {
                if (matrix[i][j] == '1') {
                    if (max == 0) 
                        max = 1;
                    int size = getSquareSize(matrix, i, j, rSize, cSize);
                    
                    max = max > size ? max : size;
                }
            }
        }
        
        return max*max;
    }
    
    public int getSquareSize(char[][] matrix, int r, int c, int rSize, int cSize) {    
        int size = 1;
        boolean isBreak = false;
        
        while (true) {
            if (r + size >= rSize || c + size >= cSize) 
                break;
            
            for (int i = r, j = c, k = 0; k <= size; k++, i++, j++) {
                if (matrix[r + size][j] == '0' || matrix[i][c + size] == '0') {
                    isBreak = true; 
                    break;
                }
            }
            
            if (isBreak) 
                break;
            ++size;
        }
        
        return size;
    }
}
