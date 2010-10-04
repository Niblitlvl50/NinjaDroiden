package com.niblvl50.ninja.entities;

public class AnimationSequence
{
	public int mStart = 0;
	public int mEnd = 0;
	public long[] mDuration = { 100 };
	
	public AnimationSequence(int start, int end, long[] duration)
	{
		this.mStart = start;
		this.mEnd = end;
		this.mDuration = duration;
	}
}
