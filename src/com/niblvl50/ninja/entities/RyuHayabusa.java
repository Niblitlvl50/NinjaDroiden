package com.niblvl50.ninja.entities;

import com.niblvl50.ninja.Textures;

public class RyuHayabusa extends GameObject
{
	public static final int STOP = 0;
	public static final int RUNNING = 1;
	public static final int JUMPING = 2;
	public static final int KILLING = 3;
	
	public RyuHayabusa()
	{
		super(0, 0, 32, 32, Textures.ryu);
		
		this.loadAnimationSequences();
		this.setAnimationSequence(STOP);
	}

	private void loadAnimationSequences()
	{
		final long[] stopDuration = { 100 };
		final long[] runningDuration = { 100, 100, 100 };
		final long[] jumpingDuration = { 100, 100, 100, 100 };
		final long[] killingDuration = { 100, 100, 100, 100 };
		
		this.addAnimationSequence(STOP, new AnimationSequence(0, 0, stopDuration));
		this.addAnimationSequence(RUNNING, new AnimationSequence(1, 3, runningDuration));
		this.addAnimationSequence(JUMPING, new AnimationSequence(4, 7, jumpingDuration));
		this.addAnimationSequence(KILLING, new AnimationSequence(8, 11, killingDuration));
	}

}
