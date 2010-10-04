package com.niblvl50.ninja;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.input.touch.TouchEvent;

import com.niblvl50.ninja.controller.NinjaController;
import com.niblvl50.ninja.entities.RyuHayabusa;
import com.niblvl50.ninja.eventbus.EventBus;

public class NinjaScene extends Scene
{
	public NinjaScene()
	{
		super(1);
		
		RyuHayabusa ninja = new RyuHayabusa();
		ninja.attachController(new NinjaController());
		ninja.setPosition(100, 100);
		this.getTopLayer().addEntity(ninja);
	}
	
	@Override
	public boolean onSceneTouchEvent(TouchEvent pSceneTouchEvent)
	{
		EventBus.dispatch(pSceneTouchEvent);		
		return true;
	}
}
