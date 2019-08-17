package javabasic.week2.project;

import java.util.Scanner;

public class MyBoard implements IBoard {
	
	User[] users = new User[2];
	
	Board[] mainboard = new Board[20];
	
	Scanner scan = new Scanner(System.in);
	
	int selUser;
	int Num = 4;
	
	String title;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println(title+" : 메인화면 - 계정 선택");
		System.out.println("========================");
		int i=0;
		
		// 등록된 사용자 정보 출력
		for(User u : users) {
			System.out.printf("[%d]%s\n",i++,u.getName());
		}
		
		System.out.println("[x]종 료");
		System.out.print("선택 : ");
		String sel = scan.next();
		
		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "x":
				System.out.println("시스템을 종료합니다.");
				System.exit(0);break;
			default:
				selUser = Integer.parseInt(sel);
				if(selUser == 0) {
					System.out.println("## 박창신님 환영합니다. ##");
				System.out.println();
				}
				else if(selUser == 1) {
					System.out.println("## 최인규님 환영합니다. ##");
					System.out.println();
				}
				boardList();
				
		}
	}
	
	public void boardList() {
		System.out.println(title+" : 메뉴선택" +" ("+users[selUser].getName()+"님)");
		System.out.println("=========================");
			
		/*
		for(Board p : mainboard) {
			p.printBoard();
			System.out.println();
			i++;
		}
		*/
		System.out.println();
		System.out.println("[h]메인화면(계정 선택)");
		System.out.println("[c]게시글조회");
		System.out.println("[w]게시글작성");
		System.out.println("[e]게시글수정");
		System.out.println("[d]게시글삭제");
		System.out.println("[x]종료");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");
		System.out.println();

		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "h":start(); break;
			case "c":CheckPost();break;
			case "w":WritePost(selUser);break;
			case "e":EditPost();break;
			case "d":DeletePost();break;
			case "x":
				System.out.println("시스템을 종료합니다.");
				System.exit(0);break;
			default:
				break;
		}
	}
	
	// 게시글 조회
	public void CheckPost() {
		for(int i=0; i<Num; i++) {
			if(mainboard[i].title != "") {
				mainboard[i].printBoard();
				System.out.println();
				}
			}
		System.out.println();
		boardList();
	}
	
	// 게시글 작성
	public void WritePost(int seluser) {
		scan.nextLine();
		System.out.println("게시글 제목 입력: ");
		String title = scan.nextLine();
		System.out.println("게시글 내용 입력: ");
		String content = scan.nextLine();
		Board bd = new Board(Num,title,users[seluser].getName(),content);
		mainboard[Num] = bd;
		System.out.println();
		System.out.println("아래와 같이 게시글 작성이 완료되었습니다.");
		mainboard[Num].printBoard();
		Num++;
		System.out.println();
		boardList();
		System.out.println();
	}
	
	// 게시글 수정
	public void EditPost() {
		System.out.println("수정할 게시글 번호 선택: ");
		int editNum = scan.nextInt();
		scan.nextLine();
		if(users[selUser].getName() != mainboard[editNum].writer) {
			System.out.println("본인이 작성하지 않은 게시글은 수정이 불가합니다.");
			EditPost();
		}
		else {
			System.out.println("수정할 내용 입력: ");
			mainboard[editNum].content = scan.nextLine();
			System.out.println("["+editNum+"]"+"번 게시물 수정이 완료되었습니다.");
			mainboard[editNum].printBoard();
			System.out.println();
			boardList();
		}
	}
	
	// 게시글 삭제
	public void DeletePost() {
		System.out.println("삭제할 게시글 번호 선택: ");
		int delNum = scan.nextInt();
		if(users[selUser].getName() != mainboard[delNum].writer) {
			System.out.println("본인이 작성하지 않은 게시글은 삭제가 불가하여 메인화면으로 돌아갑니다.");
			start();  // 메인화면으로 다시 돌아감
		}
		else {
			mainboard[delNum].title = "";
			mainboard[delNum].writer = "";
			mainboard[delNum].content = "";
			System.out.println("["+delNum+"]"+"번 게시물 삭제가 완료되었습니다.");
			System.out.println();
			boardList();
		}
	}
	
	// 사용자 생성
	@Override
	public void genUser() {
		// TODO Auto-generated method stub
		User user = new User("박창신");
		users[0] = user;
		user = new User("최인규");
		users[1] = user;
	}
	
	// 게시판 생성
	public void genBoard() {
		Board bd = new Board(0,"HotSummer","박창신","I hate Summer");
		mainboard[0] = bd;
		bd = new Board(1,"Game","박창신","I like LoL");
		mainboard[1] = bd;
		bd = new Board(2,"Character","최인규","I like Lion");
		mainboard[2] = bd;
		bd = new Board(3,"Today","최인규","I want to go home early");
		mainboard[3] = bd;
	}

}
