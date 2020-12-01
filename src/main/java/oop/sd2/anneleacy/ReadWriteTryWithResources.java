package oop.sd2.anneleacy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This version uses the easier to read and safer try-with-resources
 *  Available from Java 7 onwards - it is the version that should be used
 */


public class ReadWriteTryWithResources
{

    public static void main(String[] args) // FileNotFoundException caught by this application
    {
        // Prompt for the input and output file names

        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();
        System.out.print("Output file: ");
        String outputFileName = console.next();

        /**
         * Try-with-Resources version (as opposed to "Try-catch-finally")
         * Resources must be AutoClosable (i.e. have implemented the
         * AutoClosable interface) Note, in this example, two resources are
         * opened in the try(....). No 'finally' block is required as the
         * resources are AutoClosable, and thus, are closed automatically.
         */

        // Construct the Scanner and PrintWriter objects for reading and writing

        File inputFile = new File(inputFileName);

        try (Scanner in = new Scanner(inputFile); // Try-with-Resources
             PrintWriter out = new PrintWriter(outputFileName))
        {
            double sum = 0;
            while (in.hasNextDouble())
            {
                double value = in.nextDouble();
                int x = in.nextInt();
                out.printf("%15.2f\n", value);
                sum = sum + value;
            }
            out.printf("Total: %8.2f\n", sum);

        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught." + exception);
        }
        catch (InputMismatchException exception)
        {
            System.out.println("InputMismatchexception caught." + exception);
        }
    }
}
