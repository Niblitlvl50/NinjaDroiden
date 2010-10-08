package com.niblvl50.ninja.entities;

import android.util.Log;

import com.niblvl50.ninja.Textures;
import com.niblvl50.ninja.collisionhandler.CollisionHandler;
import com.niblvl50.ninja.collisionhandler.ICollidableVisitor;

public class BlackNinja extends GameObject
{

	public BlackNinja()
	{
		super(0, 0, 32, 32, Textures.ryu);
		CollisionHandler.instance().register(this);
	}

	@Override
	public void AcceptCollision(ICollidableVisitor visitor)
	{
		visitor.Visit(this);
	}
	
	@Override
	public void onCollideWith(GameObject object)
	{
		Log.d("BlackNinja", "Collide with GameObject");
	}

	@Override
	public void onCollideWith(RyuHayabusa object)
	{
		Log.d("BlackNinja", "Collide with RyuHayabusa");
	}

	@Override
	public void onCollideWith(NinjaTurtle object)
	{
		Log.d("BlackNinja", "Collide with NinjaTurtle");
	}

	@Override
	public void onCollideWith(BlackNinja object)
	{
		Log.d("BlackNinja", "Collide with BlackNinja");
	}

}
