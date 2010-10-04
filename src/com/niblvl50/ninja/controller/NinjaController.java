package com.niblvl50.ninja.controller;

import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.sensor.accelerometer.AccelerometerData;
import org.anddev.andengine.sensor.accelerometer.IAccelerometerListener;

import android.util.Log;

import com.niblvl50.ninja.entities.GameObject;
import com.niblvl50.ninja.eventbus.EventBus;
import com.niblvl50.ninja.eventbus.EventHandler;


public class NinjaController implements IController, IAccelerometerListener
{
	private GameObject object = null;
	private int animation = 0;
	private boolean spriteFlipped = false;
	
	@Override
	public void registerGameObject(GameObject object)
	{
		this.object = object;
		EventBus.register(this);
		EventBus.dispatch(this);
	}
	
	@EventHandler
	public void onTouchEvent(TouchEvent event)
	{
		if(event.getAction() == TouchEvent.ACTION_UP)
		{
			object.setAnimationSequence(animation);
			
			spriteFlipped = !spriteFlipped;
			object.flipSprite(spriteFlipped);

			++animation;
			if(animation > 3)
				animation = 0;
		}
	}

	@Override
	public void onAccelerometerChanged(AccelerometerData data)
	{
		Log.d("Accelerometer", String.valueOf(data.getX()));
	}

}
