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

	Player() {
		initGraphics();
		canJump = true;
	}

	public void jump() {
		vy += 30;
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
//		sprite.setPosition(200, 200);


	}
	
	public void update(){
		int gravity = 3;
		
		x += vx;
		y += vy;
		
		sprite.setPosition(x, y);
		
		if (y > 0){
			vy -= gravity;
		} else {
			y = 0;
			vy = 0;
			canJump = true;
		}
		
		System.out.println(x+","+y);
		
	}

	public void render(SpriteBatch batch) {
		
		sprite.draw(batch);

	}

}
