package com.niblvl50.ninja.entities;

import android.util.Log;

import com.niblvl50.ninja.NinjaActivity;
import com.niblvl50.ninja.Textures;
import com.niblvl50.ninja.collisionhandler.CollisionHandler;
import com.niblvl50.ninja.collisionhandler.ICollidableVisitor;

public class RyuHayabusa extends GameObject
{
	public static final int STOP = 0;
	public static final int RUNNING = 1;
	public static final int JUMPING = 2;
	public static final int KILLING = 3;
	
	public RyuHayabusa()
	{
		super(0, 0, 32, 32, Textures.ryu);
		
		CollisionHandler.instance().register(this);
		
		this.loadAnimationSequences();
		this.setAnimationSequence(RUNNING);
	}

	private void loadAnimationSequences()
	{
		final long[] runningDuration = { 100, 100, 100 };
		final long[] jumpingDuration = { 100, 100, 100, 100 };
		final long[] killingDuration = { 100, 100, 100, 100 };
		
		this.addAnimationSequence(STOP, new StopSequence(0));
		this.addAnimationSequence(RUNNING, new AnimationSequence(1, 3, runningDuration, true));
		this.addAnimationSequence(JUMPING, new AnimationSequence(4, 7, jumpingDuration, true));
		this.addAnimationSequence(KILLING, new AnimationSequence(8, 11, killingDuration, false));
	}
	
	@Override
	public void onPositionChanged()
	{
		super.onPositionChanged();
		
		if(this.mX + this.getWidth() < 0)
			this.mX = NinjaActivity.WORLD_WIDTH;
		else if(this.mX > NinjaActivity.WORLD_WIDTH)
			this.mX = 0 - this.getWidth();
	}

	@Override
	public void AcceptCollision(ICollidableVisitor visitor)
	{
		visitor.Visit(this);
	}

	@Override
	public void onCollideWith(GameObject object)
	{
		Log.d("RyuHayabusa", "Collision with GameObject");
	}

	@Override
	public void onCollideWith(RyuHayabusa object)
	{
		Log.d("RyuHayabusa", "Collision with RyuHayabusa");
	}

	@Override
	public void onCollideWith(NinjaTurtle object)
	{
		Log.d("RyuHayabusa", "Collision with NinjaTurtle");
	}

	@Override
	public void onCollideWith(BlackNinja object)
	{
		Log.d("RyuHayabusa", "Collision with BlackNinja");
	}

}
