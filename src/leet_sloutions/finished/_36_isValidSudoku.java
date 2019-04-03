package leet_sloutions.finished;

public class _36_isValidSudoku {
    /**
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效
     * 即可。
     *
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
\
     */
    public boolean isValidSudoku(char[][] board) {
        if(board.length!=9) {
            return false;
        }
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]=='.') {
                    continue;
                }
                for(int k=8;k>=0;k--) {
                    if(board[i][j]==board[i][k]) {
                        return false;
                    }
                }
                for(int k=8;k>=0;k--) {
                    if(board[i][j] == board[k][j]) {
                        return false;
                    }
                }
                for(int k=i+1;k%3!=0;k++) {
                    for(int h=j/3*3;h<j/3*3+3;h++) {
                        if(board[i][j]==board[k][h]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
