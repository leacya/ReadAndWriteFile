package oop.sd2.anneleacy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
        This program catches FileNotFoundException & InputMismatchException if file contains invalid data
 */


public class ReadWriteCatchFinallyV1
{
    public static void main(String[] args)  //  FileNotFoundException  caught by this application
    {
        // Prompt for the input and output file names

        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();
        System.out.print("Output file: ");
        String outputFileName = console.next();

        Scanner in = null;
        PrintWriter out =null;

        File inputFile = new File(inputFileName);
        try
        {
             in = new Scanner(inputFile);
             out = new PrintWriter(outputFileName);

                double total = 0;

                while (in.hasNextDouble())
                {
                    double value = in.nextDouble();
                    int x = in.nextInt();
                    out.printf("%15.2f\n", value);
                    total = total + value;
                }

                out.printf("Total: %8.2f\n", total);


        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught." + exception);
            exception.printStackTrace();
        }
        catch (InputMismatchException exception)
        {
            System.out.println("InputMismatchexception caught." + exception);
        }
        finally
        {

            in.close();
            out.close();
        }

    }

}

// Check it works ok for numbers2.txt

// TODO Determine what happens if the datafile contains invalid data
//  (e.g. a character instead of int) (numbers3.txt).
// Is there anything written to the output file? Why/Why not?

