package com.me.projecttuba;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

public class ProjectTuba implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;

	Player player;
	static ArrayList<Cloud> clouds;
	long lastCloudTime;

	@Override
	public void create() {

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		batch = new SpriteBatch();

		//		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		//		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//		
		//		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		//		
		//		sprite = new Sprite(region);
		//sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		//sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		//sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);

		player = new Player();

		clouds = new ArrayList<Cloud>();
//		clouds.add(new Cloud(400, 0));

	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		player.render(batch);
		
		for (Cloud c : clouds){
			c.render(batch);
			c.update();
		}
		
		batch.end();

		if (player.canJump && Gdx.input.justTouched()) {
			player.jump();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.moveLeft();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.moveRight();
		}

		player.update();
		createCloud();
		

	}

	public void createCloud() {
		if (TimeUtils.millis() - lastCloudTime > 1000) {
			clouds.add(new Cloud(1200, 0));
			System.out.println("new cloud!");
			lastCloudTime = TimeUtils.millis();
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
