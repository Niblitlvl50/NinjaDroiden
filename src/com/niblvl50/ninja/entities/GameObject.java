package com.niblvl50.ninja.entities;

import java.util.HashMap;
import java.util.Map;

import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import com.niblvl50.ninja.controller.IController;


public class GameObject extends AnimatedSprite
{
	private Map<Integer, AnimationSequence> mSequences = new HashMap<Integer, AnimationSequence>();
	
	public GameObject(float x, float y, TiledTextureRegion texture)
	{
		super(x, y, texture.getWidth(), texture.getHeight(), texture);
	}
	
	public GameObject(float x, float y, int sizex, int sizey, TiledTextureRegion texture)
	{
		super(x, y, sizex, sizey, texture);
	}
	
	public void setAnimationSequence(int key)
	{
		AnimationSequence sequence = mSequences.get(key);
		if(sequence == null)
			return;
		
		if(sequence.mStart == sequence.mEnd)
			this.stopAnimation(sequence.mStart);
		else
			this.animate(sequence.mDuration, sequence.mStart, sequence.mEnd, true);
	}
	
	public void addAnimationSequence(int key, AnimationSequence sequence)
	{
		mSequences.put(key, sequence);
	}
	
	public void flipSprite(boolean flip)
	{
		this.getTextureRegion().setFlippedHorizontal(flip);
	}
	
	public void attachController(IController controller)
	{
		controller.registerGameObject(this);
	}

}
