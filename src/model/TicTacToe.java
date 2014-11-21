package model;

public class TicTacToe {
	private static final int SIZE = 3;
	private static final char EMPTY_CELL = '_';
	private char [][] board =  new char[SIZE][SIZE];
	private int numberOfRows = SIZE;
	private int numberOfCols = SIZE;

	public TicTacToe(){
		resetBoard();
	}

	public void resetBoard(){
		for(int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				board[i][j]=EMPTY_CELL;
			}
		}
	}

	public boolean isValidRangeOfCells(int row, int col){
		return (row>=0 && row<this.numberOfRows && col>=0 && col<this.numberOfCols);
	}

	public boolean isEmptyCell(int row, int col){
		return this.board[row][col] == EMPTY_CELL;
	}
	
	public boolean containsValue(int row, int col,char value){
		if(isValidRangeOfCells(row, col)){
			return this.board[row][col]== value;
		}
		
		return Boolean.FALSE;
	}
	
	public boolean setValue(char currentPlayer, int row, int col){
		if(isValidRangeOfCells(row, col) && isEmptyCell(row, col)){
			this.board[row][col]= currentPlayer;
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public char [][]getBoard(){
		return this.board;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public int getNumberOfCols() {
		return numberOfCols;
	}

	public void setNumberOfCols(int numberOfCols) {
		this.numberOfCols = numberOfCols;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

}
