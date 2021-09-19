# ToyRobot
Another ToyRobot

The application is a simulation of a toy robot moving on a square table top, of dimensions 5 units x 5 units. There are no
other obstructions on the table surface. The robot is free to roam around the surface of the table, but must be prevented
from falling to destruction. Any movement that would result in the robot falling from the table must be prevented,
however further valid movement commands must still be allowed.
A console application can read in commands of the following form:

```
PLACE X,Y,F
MOVE
LEFT
RIGHT
REPORT
```
PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0)
can be considered to be the SOUTH WEST most corner. It is required that the first command to the robot is a PLACE
command, after that, any sequence of commands may be issued, in any order, including another PLACE command. The
application should discard all commands in the sequence until a valid PLACE command has been executed.
MOVE will move the toy robot one unit forward in the direction it is currently facing.
LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot.
REPORT will announce the X,Y and F of the robot. 
A robot that is not on the table can choose to ignore the MOVE, LEFT, RIGHT and REPORT commands.

### Environment
This application requires Maven and Java 11.

### Example Input and Output:

#### Example a

    PLACE 0,0,NORTH
    MOVE
    REPORT

Expected output:

    0,1,NORTH

#### Example b

    PLACE 0,0,NORTH
    LEFT
    REPORT

Expected output:

    0,0,WEST

#### Example c

    PLACE 1,2,EAST
    MOVE
    MOVE
    LEFT
    MOVE
    REPORT

Expected output

    3,3,NORTH

## Setup

1. Make sure you have Java 11, Maven and git installed on your machine. 
If you need help installing Java, take a look at the [official installation guide](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/windows-7-install.html).
If you need help installing Maven, take a look at the [official installation guide](https://maven.apache.org/install.html).
If you need help installing git, take a look at the [official installation guide](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git).
2. Clone this repo with git.
```
git clone github.com/matveeve/ToyRobot.git
```
3. Go to the app directory:

   ```cd ToyRobot```
4. Build the project:

 ```mvn package```
5. Execute the app in the command line:

```java -jar target/ToyRobot-1.0-SNAPSHOT.jar```
