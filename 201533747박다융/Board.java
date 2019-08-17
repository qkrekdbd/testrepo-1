package javabasic.week2.project;

public class Board {
	
	int postNum;
	String title;
	String writer;
	String content;
	
	public Board(int postnum, String title, String writer, String content) {
		this.postNum = postnum;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	public void printBoard() {
		System.out.printf("[%d] 게시글 제목: %s, 글쓴이: %s, 내용: %s",postNum,title,writer,content);
	}
	
}
