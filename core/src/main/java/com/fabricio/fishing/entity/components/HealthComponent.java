package com.fabricio.fishing.entity.components;

public class HealthComponent extends Component {
    private final float maxHp;
    private float hp;
    private float regen = 0;
    private float armor;

    public HealthComponent(float maxHp,float armor) {
        this.maxHp = maxHp;
        hp = maxHp;
        this.armor = armor;
    }
    public HealthComponent(float maxHp) {this(maxHp,0);}

    public void damage(float amount){
        if(amount < 0)
            throw new IllegalArgumentException("Damage cannot be negative.");
        hp -= Math.max(amount-armor,0);
        hp = Math.max(hp,0);
    }

    public void heal(float amount){
        hp = Math.min(hp + amount, maxHp);
    }
    public boolean isDead(){
        return hp <= 0;
    }
    public boolean isAlive(){
        return !isDead();
    }
    public float getMaxHp(){
        return maxHp;
    }
    public float getHp(){
        return hp;
    }
    public float getRegen() {
        return regen;
    }
    public void setRegen(float regen) {
        this.regen = regen;
    }
    public float getArmor() {
        return armor;
    }
    public void setArmor(float armor) {
        this.armor = armor;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(regen > 0) heal(regen*delta);
    }
}
