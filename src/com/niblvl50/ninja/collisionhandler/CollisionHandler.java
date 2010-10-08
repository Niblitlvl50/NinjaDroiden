package com.niblvl50.ninja.collisionhandler;

import java.util.ArrayList;
import org.anddev.andengine.engine.handler.IUpdateHandler;

public class CollisionHandler implements IUpdateHandler
{
	private static CollisionHandler instance = null;
	private ArrayList<ICollidable> collidableObjects = new ArrayList<ICollidable>();
	private ArrayList<ICollidable> removeObjects = new ArrayList<ICollidable>();
	
	public static CollisionHandler instance()
	{
		if(instance == null)
			instance = new CollisionHandler();
		
		return instance;
	}

	public void register(ICollidable object)
	{
		collidableObjects.add(object);
	}
	
	public void unregister(ICollidable object)
	{
		removeObjects.add(object);
	}
	
	// brute force collision detection...
	private void checkCollisions()
	{
		CollisionDetector detector = new CollisionDetector();
		
		for(int a = 0; a < collidableObjects.size(); ++a)
		{
			detector.setObject(collidableObjects.get(a));

			for(int b = 0; b < collidableObjects.size(); ++b)
			{
				if(a == b)
					continue;
				
				// Do check now
				ICollidable apa = collidableObjects.get(b);
				apa.AcceptCollision(detector);
			}
		}
		
	}

	private void removeObjects()
	{
		collidableObjects.removeAll(removeObjects);
	}

	@Override
	public void onUpdate(float delta)
	{
		this.checkCollisions();
		this.removeObjects();
	}

	@Override
	public void reset()
	{
		// TODO Auto-generated method stub
	}

}
