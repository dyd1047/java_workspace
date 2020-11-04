package day1103.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import common.image.ImageUtil;

//사실상 모든 게임의 그래픽처리는 패널이 담당하게 됨
public class GamePanel extends JPanel {
	Thread loopThread; // 게임 루프를 무한루프로 실행할 쓰레드
	Hero hero;
//	Bullet bullet;
	// 다수의 총알을 담기 위한 컬렉션 프레임웍 중 List를 이용해보자
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	ArrayList<Block> blockListX = new ArrayList<Block>();
	ArrayList<Hp> hpList = new ArrayList<Hp>();
	Background bg1, bg2;

	public static final int WIDTH = 1600;
	public static final int HEIGHT = 900;
	boolean flag = false; // 최초에는 게임이 멈춰있어야 하므로
	boolean stop = true;
	boolean over = false; //게임 오버 메세지 띄울지 여부
	int x, y;
	int score = 0;

	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		createBg(); // 배경생성
		createHero(); // 주인공 생성
		createEnemy(); // 적군 생성
		createBlock(); // 블럭 생성
		createHp(); //hp 생성

		loopThread = new Thread() {
			@Override
			public void run() {
				while (stop) {
					if (flag)
						gameLoop();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		loopThread.start();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g; // 2D에 더 적합한 그래픽스 객체로 형변환!

		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, WIDTH, HEIGHT); // 패널의 크기만큼 사각형이 채워진다.(화면을 깨끗이 닦는 효과)

		render(g2);
	}

	// 플랫폼 종속된 경로 : Toolkit
	// 클래스패스 : 클래스로더.getResources()
	public void createHero() {
		Image img = ImageUtil.getIcon(this.getClass(), "res/game/plane.png", 100, 65).getImage();
		hero = new Hero(this, img, 200, 200, 100, 65, 0, 0);
	}

	// 게임윈도우로 부터 어떤 방향키가 눌렸는지 전달받자
	public void moveKey(int key) {
		// 37부터 시계방향으로...
		switch (key) {
		case KeyEvent.VK_LEFT:
			hero.velX = -5;
			break;
		case KeyEvent.VK_RIGHT:
			hero.velX = 5;
			break;
		case KeyEvent.VK_UP:
			hero.velY = -5;
			break;
		case KeyEvent.VK_DOWN:
			hero.velY = 5;
			break;
		case KeyEvent.VK_SPACE:
			fire();
			break;
		}
	}

	public void stopKey(int key) {
		switch (key) {
		case KeyEvent.VK_LEFT:
			hero.velX = 0;
			break;
		case KeyEvent.VK_RIGHT:
			hero.velX = 0;
			break;
		case KeyEvent.VK_UP:
			hero.velY = 0;
			break;
		case KeyEvent.VK_DOWN:
			hero.velY = 0;
			break;
		}
	}

	// 총알 발사
	public void fire() {
		Image img = ImageUtil.getIcon(this.getClass(), "res/game/ball.png", 20, 20).getImage();
		Bullet bullet = new Bullet(this, img, (hero.x + hero.width), (hero.y + (hero.height / 2)), 20, 20, 10, 0);
		bulletList.add(bullet); // 생성된 총알을 bulletList에 담자

	}

	// 배경이미지 생성
	public void createBg() {
		Image img = ImageUtil.getIcon(this.getClass(), "res/game/bg.jpg", WIDTH, HEIGHT).getImage();

		// 생성된 이미지로 배경객체 2개를 생성하자!
		bg1 = new Background(img, 0, 0, WIDTH, HEIGHT, -4, 0);
		bg2 = new Background(img, WIDTH, 0, WIDTH, HEIGHT, -4, 0);
	}

	// 적군 생성
	public void createEnemy() {
		String[] path = { "e1.png", "e2.png", "e3.png", "e4.png", "e5.png" };
		for (int i = 0; i < path.length; i++) {
			double r =Math.random();
			int n = (int)(r * path.length);
//		System.out.println(n);
			
			Image img = ImageUtil.getIcon(this.getClass(), "res/game/" + path[n], 80, 60).getImage();
			Enemy enemy = new Enemy(img, WIDTH - 50, 50 + ((HEIGHT/path.length) * i), 80, 60, -2, 0);
			enemyList.add(enemy); // 적군 목록에 추가
		}

	}

	// 블락 생성
	public void createBlock() {
		for (int j = 0; j < 40; j++) {
			Image img = ImageUtil.getIcon(this.getClass(), "res/game/block.png", 60, 60).getImage();
			Block block = new Block(img, j * 60, 750, 60, 60, 0, 0);
			blockListX.add(block); // 블럭 목록에 추가
		}
	}
	
	//hp 생성
	public void createHp() {
		for (int i = 0; i < 4; i++) {
			Image img = ImageUtil.getIcon(this.getClass(), "res/game/heart.png", 30, 30).getImage();
			Hp hp = new Hp(img, 100+(i*32), 80, 30, 30, 0, 0);
			hpList.add(hp);
		}
	}

	// 게임의 상황, 정보 출력
	public void printData(Graphics2D g2) {
		g2.setFont(new Font("Arial Black", Font.BOLD, 25));

		StringBuffer sb = new StringBuffer();
		sb.append("Bullet : " + bulletList.size()+"  ");
		sb.append("Enemy : " + enemyList.size()+"  ");
		sb.append("Score : " + score+"  ");

		g2.drawString(sb.toString(), 100, 50);
		
		if(over)showGameOver(g2); //게임종료 메세지 띄우기
	}
	
	public void showGameOver(Graphics2D g2) {
		g2.setFont(new Font("Arial Black", Font.BOLD, 200));
		
		StringBuffer sb = new StringBuffer();
		sb.append("Game Over");
		
		g2.drawString(sb.toString(), 50, 400);		
	}

	// 물리량 변경
	public void tick() {
		// hero에 대한 tick()
		hero.tick();

		// 배경에 대한 tick()
		bg1.tick();
		bg2.tick();

		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			bullet.tick();
		}

		// 적군에 대한 tick()
		for (int i = 0; i < enemyList.size(); i++) {
			Enemy enemy = enemyList.get(i);
			enemy.tick();
		}

		// 블럭에 대한 tick()
		for (int i = 0; i < blockListX.size(); i++) {
			Block block = blockListX.get(i);
			block.tick();
		}
		
		for (int i = 0; i < hpList.size(); i++) {
			Hp hp = hpList.get(i);
			hp.tick();
		}
	}

	public void render(Graphics2D g2) {
		// 배경에 대한 render()
		bg1.render(g2);
		bg2.render(g2);

		hero.render(g2);

		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			bullet.render(g2);
		}

		for (int i = 0; i < enemyList.size(); i++) {
			Enemy enemy = enemyList.get(i);
			enemy.render(g2);
		}

		for (int i = 0; i < blockListX.size(); i++) {
			Block block = blockListX.get(i);
			block.render(g2);
		}
		
		for (int i = 0; i < hpList.size(); i++) {
			Hp hp = hpList.get(i);
			hp.render(g2);
		}

		printData(g2);
	}

	// 모든 게임의 tick(), render() 를 호출! 즉 게임엔진
	public void gameLoop() {
		tick();
		this.repaint();
//		System.out.println("gameLoop() called...");
	}
}
