package javabasic.week2.project;

public class BoardLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBoard board = new MyBoard();
		board.setTitle("DashBoard");
		board.genUser();
		board.genBoard();
		board.start();
	}

}
