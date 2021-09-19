package org.toy.robot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.toy.robot.CommandsLogic;
import org.toy.robot.Facing;
import org.toy.robot.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandsLogicTest {

    private Position position;

    @BeforeEach
    void setUp() {
        position = Position.getPosition("PLACE 0,0,NORTH");
    }

    @Test
    void changePositionTest() {
        CommandsLogic.changePosition(position, "MOVE");
        assertEquals(Facing.NORTH, position.getFacing());
        assertEquals(0, position.getDimensionX());
        assertEquals(1, position.getDimensionY());
    }

    @Test
    void changePositionWithPlaceCommandTest() {
        CommandsLogic.changePosition(position, "PLACE 1,1,SOUTH");
        assertEquals(Facing.NORTH, position.getFacing());
        assertEquals(0, position.getDimensionX());
        assertEquals(0, position.getDimensionY());
    }

    @Test
    void changePositionWithNullCommandTest() {
        CommandsLogic.changePosition(position, null);
        assertEquals(Facing.NORTH, position.getFacing());
        assertEquals(0, position.getDimensionX());
        assertEquals(0, position.getDimensionY());
    }

    @Test
    void changePositionWithNullPositionTest() {
        CommandsLogic.changePosition(null, "PLACE 1,1,SOUTH");
        assertEquals(Facing.NORTH, position.getFacing());
        assertEquals(0, position.getDimensionX());
        assertEquals(0, position.getDimensionY());
    }

    @Test
    void changePositionWithEmptyCommandTest() {
        CommandsLogic.changePosition(position, "");
        assertEquals(Facing.NORTH, position.getFacing());
        assertEquals(0, position.getDimensionX());
        assertEquals(0, position.getDimensionY());
    }

    @Test
    void moveTest() {
        CommandsLogic.move(position);
        assertEquals(Facing.NORTH, position.getFacing());
        assertEquals(0, position.getDimensionX());
        assertEquals(1, position.getDimensionY());
    }

    @Test
    void moveWithNullPositionTest() {
        CommandsLogic.move(null);
        assertEquals(Facing.NORTH, position.getFacing());
        assertEquals(0, position.getDimensionX());
        assertEquals(0, position.getDimensionY());
    }

    @Test
    void turnLeftTest() {
        CommandsLogic.turnLeft(position);
        assertEquals(Facing.WEST, position.getFacing());
        assertEquals(0, position.getDimensionX());
        assertEquals(0, position.getDimensionY());
    }

    @Test
    void turnRightTest() {
        CommandsLogic.turnRight(position);
        assertEquals(Facing.EAST, position.getFacing());
        assertEquals(0, position.getDimensionX());
        assertEquals(0, position.getDimensionY());
    }
}