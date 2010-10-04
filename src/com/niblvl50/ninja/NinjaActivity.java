package com.niblvl50.ninja;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import com.niblvl50.ninja.controller.NinjaController;
import com.niblvl50.ninja.eventbus.EventBus;
import com.niblvl50.ninja.eventbus.EventHandler;

public class NinjaActivity extends BaseGameActivity
{
	private static final int CAMERA_WIDTH = 400;
	private static final int CAMERA_HEIGHT = 240;
	
	@Override
	public Engine onLoadEngine()
	{
		EventBus.register(this);
		
		Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		EngineOptions options = new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
		return new Engine(options);
	}

	@Override
	public void onLoadResources()
	{
		Textures.load(this);
	}

	@Override
	public Scene onLoadScene()
	{
		return new NinjaScene();
	}
	
	@Override
	public void onLoadComplete()
	{ }
	
	@EventHandler
	public void registerAccelerometerListener(NinjaController controller)
	{
		this.enableAccelerometerSensor(controller);
	}

}

