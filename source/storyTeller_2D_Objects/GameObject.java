package storyTeller_2D_Objects;

import java.awt.Graphics;
import java.util.LinkedList;

public abstract class GameObject {

protected int x;
protected int y;
protected int velX = 0;
protected int velY = 0;
protected ObjectID id;

public GameObject (int x, int y, ObjectID id) {
	this.x = x; 
	this.y = y;
	this.id = id;

}

public abstract void tick (LinkedList <GameObject> objects);
public abstract void render (Graphics graphics);

public abstract int getX();
public abstract int getY();

public abstract void setX(int x);
public abstract void setY(int y);

public abstract int getvelX();
public abstract int getvelY();

public abstract void setvelX(int velX);
public abstract void setvelY(int velY);

public abstract ObjectID getID();

}


