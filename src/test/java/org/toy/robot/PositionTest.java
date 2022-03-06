package org.toy.robot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = Position.getPosition("PLACE 0,0,NORTH");
    }

    @Test
    void getPositionReturnNotNullTest() {
        assertNotNull(position);
    }

    @Test
    void changePosition() {
        position.changePosition("MOVE");
        assertEquals(Facing.NORTH, position.getFacing());
        assertEquals(0, position.getDimensionX());
        assertEquals(1, position.getDimensionY());
    }

    @Test
    void getDimensionX() {
        assertEquals(0, position.getDimensionX());
    }

    @Test
    void setDimensionX() {
        position.setDimensionX(3);
        assertEquals(3, position.getDimensionX());
    }

    @Test
    void getDimensionY() {
        assertEquals(0, position.getDimensionY());
    }

    @Test
    void setDimensionY() {
        position.setDimensionY(1);
        assertEquals(1, position.getDimensionY());
    }

    @Test
    void getFacing() {
        assertEquals(Facing.NORTH, position.getFacing());
    }

    @Test
    void setFacing() {
        position.setFacing("WEST");
        assertEquals(Facing.WEST, position.getFacing());
    }
}