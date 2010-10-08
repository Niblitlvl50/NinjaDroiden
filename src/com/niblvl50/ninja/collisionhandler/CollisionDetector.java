package com.niblvl50.ninja.collisionhandler;

import org.anddev.andengine.entity.shape.IShape;

import com.niblvl50.ninja.entities.GameObject;
import com.niblvl50.ninja.entities.NinjaTurtle;
import com.niblvl50.ninja.entities.RyuHayabusa;

public class CollisionDetector implements ICollidableVisitor
{
	private ICollidable object = null;
	
	@Override
	public void Visit(GameObject gameObject)
	{
		if(gameObject.collidesWith((IShape) object))
			this.object.onCollideWith(gameObject);
	}

	@Override
	public void Visit(RyuHayabusa ryu)
	{
		if(ryu.collidesWith((IShape) object))
			this.object.onCollideWith(ryu);
	}

	@Override
	public void Visit(NinjaTurtle ninja)
	{
		if(ninja.collidesWith((IShape) object))
			this.object.onCollideWith(ninja);
	}

	@Override
	public void setObject(ICollidable object)
	{
		this.object = object;
	}
	
}
