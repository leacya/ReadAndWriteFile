package oop.sd2.anneleacy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;


/*

Alternative structure to ReadWriteCatchFinallyV1 - see page 346 in book

 */
public class ReadWriteCatchFinallyV2
{
    public static void main(String[] args)  //  FileNotFoundException  caught by this application
    {
        // Prompt for the input and output file names

        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();
        System.out.print("Output file: ");
        String outputFileName = console.next();


        File inputFile = new File(inputFileName);
        try
        {
            Scanner in = new Scanner(inputFile);
            PrintWriter out = new PrintWriter(outputFileName);
            try
            {
                // Read the input and write the output
                double total = 0;

                while (in.hasNextDouble())
                {
                    double value = in.nextDouble();
                    int x = in.nextInt();
                    out.printf("%15.2f\n", value);
                    total = total + value;
                }

                out.printf("Total: %8.2f\n", total);
            } finally   // Always close the files - even if exception is caught
            {
                in.close();
                out.close();
            }

        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught." + exception);
            exception.printStackTrace();
        }
        catch (InputMismatchException exception)
        {
            System.out.println("InputMismatchexception caught." + exception);
        }

    }

}


// Check it works ok for numbers2.txt

