import java.util.Arrays; 
class CharMatrix {
  char[][] board = null;  
  
  public CharMatrix(int rows, int cols)
  { 
    char space = ' ';
    board = new char[rows][cols]; 
    for (int r = 0; r < rows; r++) { 
      for (int c = 0; c < cols; c++) { 
        board[r][c] = space; 
      } 
    }
  }

  public CharMatrix(int rows, int cols, char fill)
  { 
    board = new char[rows][cols];
    for (int r = 0; r < rows; r++) { 
      for (int c = 0; c < cols; c++) { 
        board[r][c] = fill; 
      } 
    }
  }

  public int numRows()
  {
    return board.length;
  }
  
  public int numCols()
  {
    return board[0].length;
  }
  
  public char charAt(int row, int col)
  {
    char[] intermediate = board[row];
    return intermediate[col];
  }

  public void setCharAt(int row, int col, char ch)
  {
    int rowNum = board.length; 
    int colNum = board[0].length;
    char[][] inter = new char[rowNum][colNum]; 
    for (int r = 0; r < rowNum; r++) { 
      for (int c = 0; c < colNum; c++) { 
        if (r == row && c == col) {
          inter[row][col] = ch; 
        } else { 
          inter[r][c] = board[r][c]; 
        } 
      } 
    } 
    board = inter;
  }

  public boolean isEmpty(int row, int col)
  {
    return board[row][col] == ' ';
  }

  /* Does first row count as 0 or 1? */
  public void fillRect(int row0, int col0, int row1, int col1, char fill)
  {
    int rows = numRows(); 
    int cols = numCols();
    char[][] intermediate = new char[rows][cols];
    for (int r = 0; r < rows; r++) { 
      for (int c = 0; c < cols; c++) { 
        if (r >= row0 && r <= row1 && c >= col0 && c <= col1) { 
          intermediate[r][c] = fill;  
        } else { 
          intermediate[r][c] = board[r][c]; 
        }
      } 
    }
    board = intermediate;
  }

  /* Does first row count as 0 or 1? */
  public void clearRect(int row0, int col0, int row1, int col1)
  { 
    fillRect(row0, col0, row1, col1, ' '); 
  }
  
  public int countInRow(int row)
  { 
    char[] intermediate = board[row]; 
    int result = 0; 
    for (int x = 0; x < intermediate.length; x++) { 
      if (intermediate[x] != ' ') { 
        result++; 
      } 
    }
    return result;
  }

  public int countInCol(int col)
  { 
    int result = 0; 
    for (int x = 0; x < board.length; x++) { 
      if (board[x][col] != ' ') { 
        result++; 
      } 
    }
    return result;
  }
  
  public static void main(String[] args) {
    System.out.println("Hello world!"); 
    CharMatrix x = new CharMatrix(5,7,' '); 
    x.setCharAt(1,1,'a');
    char y = x.charAt(1,1);
    System.out.println(y == 'a');
    System.out.println(Arrays.deepToString(x.board)); 
    System.out.println(x.isEmpty(1,1));
    System.out.println(x.isEmpty(4,3)); 
    x.fillRect(2, 2, 4, 6, 'b');
    System.out.println(Arrays.deepToString(x.board)); 
    x.clearRect(3, 5, 4, 6); 
    System.out.println(Arrays.deepToString(x.board)); 
    x.clearRect(0, 0, 4, 6); 
    System.out.println(Arrays.deepToString(x.board)); 
  }
}