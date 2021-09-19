package org.toy.robot;

import org.junit.jupiter.api.Test;
import org.toy.robot.ValidationLogic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationLogicTest {

    @Test
    public void isValidPositionWithValidPositionTest() {
        assertTrue(ValidationLogic.isValidPosition(0, 0, "NORTH"));
    }

    @Test
    public void isValidPositionWithNullFacingTest() {
        assertFalse(ValidationLogic.isValidPosition(0, 0, null));
    }

    @Test
    public void isValidPositionWithInvalidNegativeDimensionXTest() {
        assertFalse(ValidationLogic.isValidPosition(-1, 0, "NORTH"));
    }

    @Test
    public void isValidPositionWithInvalidPositiveDimensionXTest() {
        assertFalse(ValidationLogic.isValidPosition(5, 0, "NORTH"));
    }

    @Test
    public void isValidPositionWithInvalidNegativeDimensionYTest() {
        assertFalse(ValidationLogic.isValidPosition(1, -2, "NORTH"));
    }

    @Test
    public void isValidPositionWithInvalidPositiveDimensionYTest() {
        assertFalse(ValidationLogic.isValidPosition(1, 6, "NORTH"));
    }

    @Test
    public void isValidPositionWithInvalidFacingTest() {
        assertFalse(ValidationLogic.isValidPosition(1, 1, "INVALID"));
    }

    @Test
    public void isPlaceCommandWithPlaceCommandTest() {
        assertTrue(ValidationLogic.isValidPlaceCommand("PLACE 1,1,SOUTH"));
    }

    @Test
    public void isPlaceCommandWithPlaceCommandAndNoPositionTest() {
        assertFalse(ValidationLogic.isValidPlaceCommand("PLACE"));
    }

    @Test
    public void isPlaceCommandWithNoCommandTest() {
        assertFalse(ValidationLogic.isValidPlaceCommand("1,1,SOUTH"));
    }

    @Test
    public void isPlaceCommandWithNoCommandAndNoPositionTest() {
        assertFalse(ValidationLogic.isValidPlaceCommand(""));
    }

    @Test
    public void isPlaceCommandWithEmptyArrayTest() {
        assertFalse(ValidationLogic.isValidPlaceCommand(""));
    }

    @Test
    public void isPlaceCommandWithNullTest() {
        assertFalse(ValidationLogic.isValidPlaceCommand(null));
    }

    @Test
    public void isPlaceCommandWithNoPlaceCommandTest() {
        assertFalse(ValidationLogic.isValidPlaceCommand("MOVE 1,1,SOUTH"));
    }

    @Test
    public void isPlaceCommandWithInvalidPositionTest() {
        assertFalse(ValidationLogic.isValidPlaceCommand("PLACE f,1,SOUTH"));
    }

    @Test
    public void isPlaceCommandWithInvalidCommandTest() {
        assertFalse(ValidationLogic.isValidPlaceCommand("INVALID 1,1,SOUTH"));
    }

    @Test
    public void isPlaceCommandWithInvalidSeparatorTest() {
        assertFalse(ValidationLogic.isValidPlaceCommand("PLACE 1.1.SOUTH"));
    }

    @Test
    public void isPlaceCommandWithInvalidCommandStringTest() {
        assertFalse(ValidationLogic.isValidPlaceCommand("PLACE1,1,SOUTH"));
    }

}