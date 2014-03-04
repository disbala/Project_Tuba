package com.me.projecttuba;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Cloud {
	
	// position
	float x;
	float y;

	// velocities
	float vx;
	float vy;
	
	static float w = 150;
	static float h = 150;

	// can't remember what these do really

	private Texture texture;
	private Sprite sprite;
	
	public Cloud(int x, int y){
		y = randomHeight();
		texture = new Texture(Gdx.files.internal("data/cloud.png"));
		TextureRegion region = new TextureRegion(texture, 0, 0, 50, 50);
		sprite = new Sprite(region);
		sprite.setSize(w, h);
		sprite.setPosition(x, y);
		this.x = x;
		this.y = y;
		vx = -3;
		
	}
	
	public int randomHeight(){
		int w = ((int)((28 - 1) * Math.random() + 1)) * 10;
		return w;
	}
	
	public void update(){
		x += vx;
		y += vy;
		sprite.setPosition(x, y);
		
	}
	
	public void render(SpriteBatch batch) {

		sprite.draw(batch);

	}

}
