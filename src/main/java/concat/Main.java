package concat;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter source directory");
//        String source = reader.nextLine();
        String source = "D:\\Development\\Java\\SoftwareDesign\\BigHomeworks\\concat\\example\\in";
        System.out.println("Enter target file");
//        String target = reader.nextLine();
        String target = "D:\\Development\\Java\\SoftwareDesign\\BigHomeworks\\concat\\example\\out\\result";
        try {
            new Concat(source, target).exec();
            System.out.println("Concatenation succeeded");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        } catch (InvalidAlgorithmParameterException e) {
            System.out.println(e.getMessage());
        }
    }
}