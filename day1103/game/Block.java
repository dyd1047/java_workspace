package day1103.game;

import java.awt.Graphics2D;
import java.awt.Image;

public class Block extends GameObject{

	public Block(Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);
	}

	@Override
	public void tick() {
		rect.x = x;
		rect.y = y;
	}

	@Override
	public void render(Graphics2D g2) {
		g2.drawImage(img, rect.x, rect.y, null);
	}

}
