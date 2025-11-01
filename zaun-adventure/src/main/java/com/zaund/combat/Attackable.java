package com.zaund.combat;

import com.zaund.entity.Damageable;

/**
 * Interface for entities that can perform attacks in combat.
 * Provides a contract for offensive capabilities.
 */
public interface Attackable {
    /**
     * Performs a basic attack on a target entity.
     * 
     * @param target The target entity that will receive the attack
     */
    void attack(Damageable target);
    
    /**
     * Gets the base attack power of this entity.
     * 
     * @return The attack power value
     */
    int getAttackPower();
}
