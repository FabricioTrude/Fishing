package com.fabricio.fishing.entity.components.MovementComponent;

import com.badlogic.gdx.math.Vector2;
import com.fabricio.fishing.entity.Entity;
import com.fabricio.fishing.entity.components.Component;

public class MovementComponent extends Component {
    private final Entity e;
    private float speed;
    private float speedModifier = 1;
    MovementBehavior type = new DirectMovement();

    private final Vector2 target = new Vector2(Float.NaN, Float.NaN);
    public float tX(){return target.x;}
    public float tY(){return target.y;}
    public float dX(){return target.x - e.getX();}
    public float dY(){return target.y - e.getY();}
    public final Vector2 dir = new Vector2();
    protected Vector2 velocity = new Vector2();

    public MovementComponent(Entity entity) {
        this.e = entity;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(Float.isNaN(target.x)) return;
        if(type != null) type.update(this, delta);
    }

    public boolean reachedTarget(float threshold) {
        return dX() * dX() + dY() * dY() <= threshold * threshold;
    }

    public void setTarget(float x, float y){
        target.set(x,y);
    }
    public void setTarget(Vector2 dir){
        target.set(target.x + dir.x, target.y + dir.y);
    }

    public float dist(){
        return (float)Math.sqrt(dX() * dX() + dY() * dY());
    }
    public float dist(float dX, float dY){
        return (float)Math.sqrt(dX * dX + dY * dY);
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeedModifier() {
        return speedModifier;
    }

    public void setSpeedModifier(float speedModifier) {
        this.speedModifier = speedModifier;
    }

    public void setType(MovementBehavior type){
        this.type = type;
    }
    public void setPos(float x, float y){
        e.setPos(x,y,e.getZ());
    }

    public float getEX(){return e.getX();}
    public float getEY(){return e.getY();}
}
