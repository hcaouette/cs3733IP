import puzzle.model.Model;

public class Main {

public static void main(String[] args) {
    Model gameMod = new Model();
    //initial configuration
    gameMod.addBlock(0,0, 0, 100, 0, 0, 200, 100, 200);
    gameMod.addBlock(1,100, 0, 300, 0, 100, 200, 300, 200);
    gameMod.addBlock(2,300, 0, 400, 0, 300, 200, 400, 200);
    gameMod.addBlock(3,0, 200, 100, 200, 0, 400, 100, 400);
    gameMod.addBlock(4,300, 200, 400, 200, 300, 400, 400, 400);
    gameMod.addBlock(5,100, 400, 300, 400, 100, 500, 300, 500);
    gameMod.addBlock(6,100, 200, 200, 200, 100, 300, 200, 300);
    gameMod.addBlock(7,200, 200, 300, 200, 200, 300, 300, 300);
    gameMod.addBlock(8,100, 300, 200, 300, 100, 400, 200, 400);
    gameMod.addBlock(9,200, 300, 300, 300, 200, 400, 300, 400);
}
}
