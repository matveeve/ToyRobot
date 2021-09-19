public class Position {

    private static Position position;
    private int dimensionX;
    private int dimensionY;
    private Facing facing;

    private Position() {

    }

    private void setPosition(int dimensionX, int dimensionY, String facing) {
        setDimensionX(dimensionX);
        setDimensionY(dimensionY);
        setFacing(facing);
    }

    private static Position getPosition(int dimensionX, int dimensionY, String facing) {
        if (ValidationLogic.isValidPosition(dimensionX, dimensionY, facing)) {
            if (position == null) {
                position = new Position();
            }
            position.setPosition(dimensionX, dimensionY, facing);
        }
        return position;
    }

    public static Position getPosition(String string) {
        String[] commandArray = string.split(" ");

        if (ValidationLogic.isPlaceCommand(commandArray)) {
            String[] array = commandArray[1].split(",");
            if (array.length == 3) { // x,y,facing
                Integer dimensionX = Integer.parseInt(array[0]);
                Integer dimensionY = Integer.parseInt(array[1]);
                String facing = array[2];

                if (dimensionX != null && dimensionY != null && facing != null) {
                    position = Position.getPosition(dimensionX, dimensionY, facing);
                }
            }
        }
        return position;
    }

    public void changePosition(String strings) {
        CommandsLogic.changePosition(position, strings);
    }

    protected int getDimensionX() {
        return this.dimensionX;
    }

    protected void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    protected int getDimensionY() {
        return this.dimensionY;
    }

    protected void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }

    protected Facing getFacing() {
        return this.facing;
    }

    protected void setFacing(String facing) {
        this.facing = Facing.valueOf(facing);
    }
}
