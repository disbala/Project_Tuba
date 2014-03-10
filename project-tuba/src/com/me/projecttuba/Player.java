package com.me.projecttuba;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {

	// position
	float x;
	float y;

	// velocities
	float vx;
	float vy;

	// can't remember what these do really

	private Texture texture;
	private Sprite sprite;

	boolean canJump;
	float gravity;

	Player() {
		initGraphics();
		canJump = true;
		x = 300;
	}

	public void jump() {
		vy += 30;
		if (vy > 30){
			vy = 30;
		}
		canJump = false;
	}

	public void moveRight() {
		x += 10;
	}

	public void moveLeft() {
		x -= 10;
	}

	public void initGraphics() {
		texture = new Texture(Gdx.files.internal("data/player.png"));
		//		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		TextureRegion region = new TextureRegion(texture, 0, 0, 50, 100);

		sprite = new Sprite(region);
		sprite.setSize(50, 100);

	}

	public boolean stand(Cloud cloud){
		
		if (Math.abs((x+25) - (cloud.x+Cloud.w/2)) < (Cloud.w/2+25) && Math.abs(y - cloud.y) < 15){
			y = cloud.y;
			vy = 0;
			gravity = 0;
			canJump = true;
			return true;
		} else {
			gravity = 3;
			return false;
		}
		
	}
	
	public void update() {
		x += vx;
		y += vy;

		sprite.setPosition(x, y);

		if (y > 0) {
			vy -= gravity/4;
			y -= gravity*4;
		} else {
			y = 0;
			vy = 0;
			canJump = true;
		}
		
		for (Cloud c : ProjectTuba.clouds){
			stand(c);
		}
		
		//		System.out.println(x+","+y);
		//		System.out.println(TimeUtils.nanoTime());

	}
	
	public void render(SpriteBatch batch) {

		sprite.draw(batch);

	}

}
