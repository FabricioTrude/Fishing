package com.fabricio.fishing.entity.components;

import com.badlogic.gdx.math.Vector2;
import com.fabricio.fishing.entity.MobileEntity;

public class MovementComponent extends Component {
    private final MobileEntity e;
    private float speed;
    private float speedModifier = 1;

    private final Vector2 target = new Vector2(Float.NaN, Float.NaN);
    public float tX(){return target.x;}
    public float tY(){return target.y;}
    public float dX(){return target.x - e.getX();}
    public float dY(){return target.y - e.getY();}
    public final Vector2 dir = new Vector2();
    protected Vector2 velocity = new Vector2();

    public MovementComponent(MobileEntity entity) {
        this.e = entity;
    }

    public enum ControlMode {TARGET,DIRECT}
    private ControlMode mode = ControlMode.TARGET;

    public void setMode(ControlMode mode) {
        this.mode = mode;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(mode == ControlMode.DIRECT){
            e.setPos(
                e.getX() + (dir.x * speed * delta * speedModifier),
                e.getY() + (dir.y * speed * delta * speedModifier),
                e.getZ());
            return;
        }
        if(Float.isNaN(target.x)) return;
        float dX = dX();
        float dY = dY();
        float dist = dist(dX,dY);
        if(dist < 0.0001f) return;
        dir.set(dX/dist, dY/dist);
        System.out.println(e.getX());
        e.setPos(
            e.getX() + (dir.x * speed * delta * speedModifier),
            e.getY() + (dir.y * speed * delta * speedModifier),
            e.getZ());
    }

    public boolean reachedTarget(float threshold) {
        return dX() * dX() + dY() * dY() <= threshold * threshold;
    }

    public void setTarget(float x, float y){
        target.set(x,y);
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

    public void setSpeedModifier(float speedModifier) {
        this.speedModifier = speedModifier;
    }
}
