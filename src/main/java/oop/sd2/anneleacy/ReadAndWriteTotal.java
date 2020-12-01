package oop.sd2.anneleacy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ReadAndWriteTotal
{

    public static void main(String[] args) throws FileNotFoundException  // Not caught by this application
    {
        // Prompt for the input and output file names

        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();
        System.out.print("Output file: ");
        String outputFileName = console.next();

        // Construct the Scanner and PrintWriter objects for reading and writing

        File inputFile = new File(inputFileName);
        Scanner in = new Scanner(inputFile);

//        Scanner in = new Scanner(new File(inputFileName));   //can replace above 2 lines

        PrintWriter out = new PrintWriter(outputFileName);

        // Read the input and write the output
        double total = 0;

        while (in.hasNextDouble())   // true *only* if next token can be
        {                           // interpreted as a double
            double value = in.nextDouble();

            out.printf("%15.2f\n", value);
            total = total + value;
        }

        out.printf("Total: %8.2f\n", total);

        in.close();
        out.close();
    }
}

// TODO : What happens if the file is not found?

// TODO Modify the code to use an input file with an additional integer on each line
//  that is not to be included in the total calculation   (numbers2.txt)
// e.g.
//  12.3 8
//  23.7 4

// TODO Determine what happens if the datafile contains invalid data
//  (e.g. a character instead of int) (numbers3.txt)