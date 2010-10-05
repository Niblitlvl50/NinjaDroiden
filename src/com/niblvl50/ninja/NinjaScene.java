package com.niblvl50.ninja;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ParallaxBackground;
import org.anddev.andengine.entity.scene.background.ParallaxBackground.ParallaxEntity;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

import com.niblvl50.ninja.controller.NinjaController;
import com.niblvl50.ninja.entities.RyuHayabusa;
import com.niblvl50.ninja.eventbus.EventBus;

public class NinjaScene extends Scene
{
	private ParallaxBackground mBackground = null;
	private RyuHayabusa ninja = null;
	private float parallaxValue = 0.0f;
	
	public NinjaScene()
	{
		super(1);
		
		ninja = new RyuHayabusa();
		ninja.attachController(new NinjaController());
		ninja.setPosition(100, 170);
		this.getTopLayer().addEntity(ninja);
		
		mBackground = new ParallaxBackground(1.0f, 1.0f, 1.0f);
		mBackground.addParallaxEntity(new ParallaxEntity(0.0f, this.createParallaxSprite(0.0f, Textures.backgroundSky)));
		mBackground.addParallaxEntity(new ParallaxEntity(0.002f, this.createParallaxSprite(0.0f, Textures.backgroundCloud)));
		mBackground.addParallaxEntity(new ParallaxEntity(0.03f, this.createParallaxSprite(166.0f, Textures.backgroundGrass)));
		mBackground.addParallaxEntity(new ParallaxEntity(0.02f, this.createParallaxSprite(140.0f, Textures.backgroundBushes)));
		this.setBackground(mBackground);
	}
	
	@Override
	public void onManagedUpdate(float secondsElapsed)
	{
		super.onManagedUpdate(secondsElapsed);
		
		this.parallaxValue += ninja.getVelocityX();
		this.mBackground.setParallaxValue(-parallaxValue);
	}
	
	@Override
	public boolean onSceneTouchEvent(TouchEvent pSceneTouchEvent)
	{
		EventBus.dispatch(pSceneTouchEvent);		
		return true;
	}
	
	private Sprite createParallaxSprite(float y, TextureRegion texture)
	{
		return new Sprite(0, y, texture.getWidth(), texture.getHeight(), texture);
	}
}
