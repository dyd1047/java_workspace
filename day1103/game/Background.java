package day1103.game;

import java.awt.Graphics2D;
import java.awt.Image;

public class Background extends GameObject{

	public Background(Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);
	}

	@Override
	public void tick() {
		this.x += this.velX;
		
		//배경을 다시 뒤로 돌려보낸다.
		if(this.x <= -GamePanel.WIDTH) {
			this.x = GamePanel.WIDTH;
		}
	}

	@Override
	public void render(Graphics2D g2) {
		g2.drawImage(img, x, y, null);
	}

}
