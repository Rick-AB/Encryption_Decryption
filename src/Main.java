import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int key = 0;
        String mode = "enc";
        String data = "";
        String in = "";
        String out = "";
        String alg = "";

        for (int i = 0; i<args.length; i++){
            try {
                switch (args[i]) {
                    case "-mode":
                        mode = args[i + 1];
                        break;
                    case "-key":
                        key = Integer.parseInt(args[i + 1]);
                        break;
                    case "-data":
                        data = args[i + 1];
                        break;
                    case "-in":
                        in = args[i + 1];
                        break;
                    case "-out":
                        out = args[i + 1];
                        break;
                    case "-alg":
                        alg = args[i + 1];
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Error");
            }
        }

        if (!in.isEmpty() && data.isEmpty()){
            data = readFile(in);
        }

        Default instance = Factory.newInstance(alg);
        instance.performAction(data,mode,key,out);

    }
    static String readFile(String fileName){
        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()){
                builder.append(scanner.nextLine()).append("\n");
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found: " + file.getName());
        }
        return builder.toString();
    }
}
