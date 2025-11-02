package com.zaund.entity;

/**
 * Interface for entities that can move in the game world.
 * Provides methods for directional movement.
 */
public interface Movable {
    /**
     * Moves the entity one position up (decreases X coordinate).
     */
    void moveUp();
    
    /**
     * Moves the entity one position down (increases X coordinate).
     */
    void moveDown();
    
    /**
     * Moves the entity one position to the right (increases Y coordinate).
     */
    void moveRight();
    
    /**
     * Moves the entity one position to the left (decreases Y coordinate).
     */
    void moveLeft();
}
