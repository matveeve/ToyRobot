public class ValidationLogic {

    static boolean isValidPosition(int dimensionX, int dimensionY, String facing) {
        return isValidFacing(facing) && isValidMoveNumber(dimensionX) && isValidMoveNumber(dimensionY);

    }

    protected static boolean isValidMoveNumber(int moveNumber) {
        return moveNumber >= 0 && moveNumber <= 4;
    }

    private static boolean isValidFacing(String facingString) {

        for (Facing facing : Facing.values()) {
            if (facing.name().equals(facingString)) {
                return true;
            }
        }

        return false;
    }

    static boolean isPlaceCommand(String[] commandArray){
        return Command.PLACE.name().equals(commandArray[0]) && commandArray.length == 2; // command && x,y,facing
    }
}
