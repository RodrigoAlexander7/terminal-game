package com.zaund.entity;

/**
 * Interface for entities that can be rendered on the game map.
 * Any object that has a visual representation should implement this interface.
 */
public interface Renderable {
    /**
     * Gets the symbol used to render this entity on the console.
     * 
     * @return A string representing the visual symbol of this entity
     */
    String getRenderSymbol();
}
