package com.zaund.combat.arm;

/**
 * Interface for hextech weapons that use energy and can be recharged.
 * Similar to Reloadable but for energy-based systems.
 */
public interface Rechargeable {
    /**
     * Recharges the weapon to full energy capacity.
     */
    void recharge();
    
    /**
     * Checks if the weapon needs to be recharged.
     * 
     * @return true if energy is depleted or below threshold, false otherwise
     */
    boolean needsRecharge();
    
    /**
     * Gets the current amount of energy available.
     * 
     * @return The current energy count
     */
    int getEnergyCount();
    
    /**
     * Gets the maximum energy capacity of this weapon.
     * 
     * @return The maximum energy count
     */
    int getMaxEnergy();
}
