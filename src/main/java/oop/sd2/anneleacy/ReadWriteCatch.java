package oop.sd2.anneleacy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
        This program catches FileNotFoundException but generates InputMismatchException if data is invalid
 */

public class ReadWriteCatch
{


    public static void main(String[] args) //  FileNotFoundException  caught by this application
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

            double total = 0;

            while (in.hasNextDouble())
            {
                double value = in.nextDouble();

                out.printf("%15.2f\n", value);
                total = total + value;
            }

            out.printf("Total: %8.2f\n", total);

            in.close();
            out.close();

        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught." + exception);
            exception.printStackTrace();
        }


    }

}

// TODO : What happens if the file is not found?

// TODO Modify the code to use an input file with an additional integer on each line
//  that is not to be included in the total calculation   (numbers2.txt)
// e.g.
//  12.3 8
//  23.7 4

// TODO Determine what happens if the datafile contains invalid data
//  (e.g. a character instead of int) (numbers3.txt).

// Is there anything written to the output file?  Why/Why not?
