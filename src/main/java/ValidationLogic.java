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

    static boolean isValidPlaceCommand(String commandString) {
        if (commandString != null) {

            String[] commandArray = commandString.split(" ");

            // command && position
            if(commandArray.length == 2 && Command.PLACE.name().equals(commandArray[0])) {

                String[] array = commandArray[1].split(",");
                // x,y,facing
                if (array.length == 3 && isNumeric(array[0]) && isNumeric(array[1])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int number = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
