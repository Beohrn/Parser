import java.io.*;

public class Main {

    private final  static String path = "C://Users//Alexander//IdeaProjects//Parser//map.svg";

    public static void main(String[] args) throws FileNotFoundException {

        new Parser(path).parse();
    }


}
