package com.zaund.combat.arm;

/**
 * Interface for weapons that require ammunition and can be reloaded.
 * Typically implemented by ranged and hextech weapons.
 */
public interface Reloadable {
    /**
     * Reloads the weapon to full ammunition capacity.
     */
    void reload();
    
    /**
     * Checks if the weapon needs to be reloaded.
     * 
     * @return true if ammunition is empty or below threshold, false otherwise
     */
    boolean needsReload();
    
    /**
     * Gets the current amount of ammunition available.
     * 
     * @return The current ammo count
     */
    int getAmmoCount();
    
    /**
     * Gets the maximum ammunition capacity of this weapon.
     * 
     * @return The maximum ammo count
     */
    int getMaxAmmo();
}
