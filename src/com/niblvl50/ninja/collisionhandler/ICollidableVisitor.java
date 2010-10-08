package com.niblvl50.ninja.collisionhandler;

import com.niblvl50.ninja.entities.GameObject;
import com.niblvl50.ninja.entities.NinjaTurtle;
import com.niblvl50.ninja.entities.RyuHayabusa;

public interface ICollidableVisitor
{
	public void setObject(ICollidable object);
	
	public void Visit(GameObject gameObject);
	public void Visit(RyuHayabusa ryu);
	public void Visit(NinjaTurtle ninja);
}
