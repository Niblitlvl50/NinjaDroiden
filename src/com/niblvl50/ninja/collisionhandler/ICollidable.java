package com.niblvl50.ninja.collisionhandler;

import com.niblvl50.ninja.entities.BlackNinja;
import com.niblvl50.ninja.entities.GameObject;
import com.niblvl50.ninja.entities.NinjaTurtle;
import com.niblvl50.ninja.entities.RyuHayabusa;

public interface ICollidable
{
	public void AcceptCollision(ICollidableVisitor visitor);
	
	public void onCollideWith(GameObject object);
	public void onCollideWith(RyuHayabusa object);
	public void onCollideWith(NinjaTurtle object);
	public void onCollideWith(BlackNinja object);
}
