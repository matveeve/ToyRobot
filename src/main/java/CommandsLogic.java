public class CommandsLogic {


    public static void changePosition(Position position, String strings) {

        String commandString = getCommandString(strings);

        if (commandString != null && ValidationLogic.isValidCommand(commandString)) {
            switch (Command.valueOf(commandString)) {
                case PLACE:
                    break;
                case MOVE:
                    CommandsLogic.move(position);
                    break;
                case LEFT:
                    CommandsLogic.turnLeft(position);
                    break;
                case RIGHT:
                    CommandsLogic.turnRight(position);
                    break;
                case REPORT:
                    printReport(position);
                    break;
            }
        }
    }

    private static String getCommandString(String strings){
        return strings == null ? null : strings.split(" ")[0];
    }

    private static void printReport(Position position) {
        StringBuilder strBuilder = new StringBuilder()
                .append("Output: ")
                .append(position.getDimensionX())
                .append(", ")
                .append(position.getDimensionY())
                .append(", ")
                .append(position.getFacing());
        System.out.print(strBuilder);
    }

    static void move(Position position) {

        if (position != null && position.getFacing() != null
        && ValidationLogic.isValidFacing(position.getFacing().name())) {

            int moveNumber;
            switch (position.getFacing()) {
                case NORTH:
                    moveNumber = position.getDimensionY() + 1;
                    if (ValidationLogic.isValidMoveNumber(moveNumber)) {
                        position.setDimensionY(moveNumber);
                    }
                    break;
                case SOUTH:
                    moveNumber = position.getDimensionY() - 1;
                    if (ValidationLogic.isValidMoveNumber(moveNumber)) {
                        position.setDimensionY(moveNumber);
                    }
                    break;
                case EAST:
                    moveNumber = position.getDimensionX() + 1;
                    if (ValidationLogic.isValidMoveNumber(moveNumber)) {
                        position.setDimensionX(moveNumber);
                    }
                    break;
                case WEST:
                    moveNumber = position.getDimensionX() - 1;
                    if (ValidationLogic.isValidMoveNumber(moveNumber)) {
                        position.setDimensionX(moveNumber);
                    }
                    break;
            }
        }
    }

    static void turnLeft(Position position) {
        switch (position.getFacing()) {
            case EAST:
                position.setFacing(Facing.NORTH.name());
                break;
            case WEST:
                position.setFacing(Facing.SOUTH.name());
                break;
            case NORTH:
                position.setFacing(Facing.WEST.name());
                break;
            case SOUTH:
                position.setFacing(Facing.EAST.name());
        }
    }

    static void turnRight(Position position) {
        switch (position.getFacing()) {
            case EAST:
                position.setFacing(Facing.SOUTH.name());
                break;
            case WEST:
                position.setFacing(Facing.NORTH.name());
                break;
            case NORTH:
                position.setFacing(Facing.EAST.name());
                break;
            case SOUTH:
                position.setFacing(Facing.WEST.name());
        }
    }
}
