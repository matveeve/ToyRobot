package org.toy.robot;
import java.util.Scanner;

public class ToyRobot {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            Position position = Position.getPosition(scan.nextLine());

            while (scan.hasNext()) {
                position.changePosition(scan.nextLine());
            }
        }
    }
}
