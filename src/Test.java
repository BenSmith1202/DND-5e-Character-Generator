import java.io.FileNotFoundException;

public class Test {
    /**
     *  This class will now be our place to test random stuff
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

//        PlayerCharacter p1 = new PlayerCharacter("FileCharacter.txt");
//        p1.printSheet();
//
//        PlayerCharacter randy = new PlayerCharacter(1, "Random","Random","Random");
//        randy.printSheet();
//        randy.saveCharacter();
//
//        PlayerCharacter savedChar = new PlayerCharacter("output.txt");
//        savedChar.printSheet();

        for (int i = 0; i < 10; i++) {
            PlayerCharacter test = new PlayerCharacter(1, "Random","Random","Random");
            test.printSheet();
        }






    }
}
