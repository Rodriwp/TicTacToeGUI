package controller;

import model.TicTacToe;

/**
 * This class presents the classical Tic Tac Toe game using an object. Some functionalities must be complete. 
 * 
 * See FIXME comments to implement the missing functionality.
 * 
 * @author chema
 *
 */
public class TicTaeToeController {

	public static final char PLAYER_O = 'O';
	public static final char PLAYER_X = 'X';

	private TicTacToe ticTacToe;
	private int freePositions;
	private char currentPlayer;

	public TicTaeToeController(){
		this.ticTacToe = new TicTacToe();
		this.freePositions = this.ticTacToe.getNumberOfCols()*this.ticTacToe.getNumberOfRows();
		this.currentPlayer = PLAYER_X;
	}


	public int getFreePositions() {
		return freePositions;
	}

	public void setFreePositions(int freePositions) {
		this.freePositions = freePositions;
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(char currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void changePlayer(){
		if(this.currentPlayer==PLAYER_X){
			this.currentPlayer = PLAYER_O;
		}else{
			this.currentPlayer = PLAYER_X;
		}
	}
	//

	public boolean setPosition(int row, int col){
		boolean set = this.ticTacToe.setValue(this.currentPlayer, row, col);
		this.freePositions--;
		return set;
	}

	public boolean isCurrentPlayerWinnerSecondaryDiagonal() {
		//FIXME: Complete
		int numberOfRows = this.ticTacToe.getNumberOfRows();
		int numberOfCols = this.ticTacToe.getNumberOfCols();
		boolean winner = Boolean.FALSE;
		int matches = 0;
		for(int j = 0; j<numberOfCols; j++){
			if(this.ticTacToe.containsValue(numberOfRows-1-j, j, currentPlayer)){
				matches++;
			}
			winner = (matches == numberOfCols);
		}
		winner = (matches == numberOfCols);
		return winner;
	}
	public boolean isCurrentPlayerWinnerMainDiagonal() {
		//FIXME: Complete
		int numberOfRows = this.ticTacToe.getNumberOfRows();
		boolean winner = Boolean.FALSE;
		int matches = 0;
		for(int i = 0; i<numberOfRows; i++){
			if(this.ticTacToe.containsValue(i, i, currentPlayer)){
				matches++;
			}
			winner = (matches == numberOfRows);
		}
		winner = (matches == numberOfRows);
		return winner;
	}
	public boolean isCurrentPlayerWinnerInCols() {
		//FIXME: Complete
		int numberOfRows = this.ticTacToe.getNumberOfRows();
		int numberOfCols = this.ticTacToe.getNumberOfCols();
		boolean winner = Boolean.FALSE;
		//Check if currentPlayer is a winner in Cols
		int matches = 0;
		winner = Boolean.FALSE;
		for(int j=0;j<numberOfCols && !winner;j++){
			matches = 0;
			for(int i=0;i<numberOfRows && !winner;i++){
				if(this.ticTacToe.containsValue(i, j, currentPlayer)){
					matches++;
				}
				winner = (matches == numberOfRows);
			}

		}
		return winner;
	}
	public boolean isCurrentPlayerWinnerInRows() {
		int numberOfRows = this.ticTacToe.getNumberOfRows();
		int numberOfCols = this.ticTacToe.getNumberOfCols();
		boolean winner = Boolean.FALSE;
		//Check if currentPlayer is a winner in rows
		int matches = 0;
		winner = Boolean.FALSE;
		for(int i=0;i<numberOfRows && !winner;i++){
			matches = 0;
			for(int j=0;j<numberOfCols && !winner;j++){
				if(this.ticTacToe.containsValue(i, j, currentPlayer)){
					matches++;
				}
				winner = (matches == numberOfRows);
			}

		}
		return winner;
	}

	public boolean isCurrentPlayerWinner(){
		//FIXME: Which is the condition to be the winner?
		boolean winner = false; 
		//Check if one of the conditions is full fill. If one of the conditon is true, the if won't check the rest
		//of conditions
		if(this.isCurrentPlayerWinnerSecondaryDiagonal()||this.isCurrentPlayerWinnerMainDiagonal()||
				this.isCurrentPlayerWinnerInRows()||this.isCurrentPlayerWinnerInCols()){
			winner = true;
		}
		return winner; 	
	}


	public void reset() {
		this.ticTacToe.resetBoard();
		this.freePositions = this.ticTacToe.getNumberOfCols()*this.ticTacToe.getNumberOfRows();
		this.currentPlayer = PLAYER_X;

	}
}
