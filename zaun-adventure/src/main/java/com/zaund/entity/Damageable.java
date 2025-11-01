package com.zaund.entity;

/**
 * Interface for entities that can receive damage in combat.
 * Represents any entity with health that can be reduced through attacks.
 */
public interface Damageable {
    /**
     * Applies damage to this entity, reducing its health.
     * 
     * @param damage The amount of damage to apply
     */
    void receiveAttack(int damage);
    
    /**
     * Checks if this entity is still alive.
     * 
     * @return true if the entity is alive, false otherwise
     */
    boolean isAlive();
}
