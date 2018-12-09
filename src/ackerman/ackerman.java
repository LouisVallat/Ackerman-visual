/*
    Licensed by Louis Vallat under the GNU General Public License v3.0
 */
package ackerman;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

/**
 * This is an exercise that I had to do. I had to debug manually the fucntion
 * and I was bored so I did this instead.
 *
 * @author LouisVallat
 */
public class ackerman {

    /**
     * Algo-prog exercise. Done better. Smarter. Faster. Javaier.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Show the menu
        printMenu();
        Scanner sc = new Scanner(System.in);
        try {
            //Ask user to input the m and n
            System.out.println("[?] Choose an m for A(m, n) : ");
            int m = sc.nextInt();
            System.out.println("[?] Choose a n for A(m, n) : ");
            int n = sc.nextInt();
            //Calculate the start date
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
            Calendar startTime = Calendar.getInstance();
            System.out.println("\nAckerman-visual : launching at " + format.format(new Date()));
            //Executing and printing the result
            System.out.println("|-----|-- Résults from the Ackerman function : A(" + m + "," + n + ") : "
                    + ackerTrace(m, n, 0));
            //Calculate the end date
            System.out.println("Ackerman-visual : end at " + format.format(new Date()));
            //Calculate the difference
            Calendar endTime = Calendar.getInstance();
            long diff = endTime.getTimeInMillis() - startTime.getTimeInMillis();
            System.out.println("Completed in : " + diff + " ms.");
            //Output the difference readable for the end user
            System.out.println("Completed in : " + formatMilli(diff));
        } catch (java.util.InputMismatchException e) {
            //Error catching
            System.out.println("\nYou can enter integers only.\nBye!");
        }
    }

    /**
     * The Ackerman's function improved for visual representation.
     *
     * @param m the m
     * @param n the n
     * @param level the deepness level
     * @return Ackerman's function result
     */
    static int ackerTrace(int m, int n, int level) {
        String indent = "|";
        String endTail = "|";
        for (int i = 0; i < level; i++) {
            indent += "     |";
            if (i != level - 2) {
                endTail += "     |";
            }
        }
        System.out.println(indent + "   Ackerman(" + m + "," + n + ")");
        System.out.println(indent + "   Deepness level : " + level);
        if (m == 0) {
            System.out.println(indent + "-- Results : " + (n + 1) + "\n" + endTail);
            return n + 1;
        } else if (n == 0) {
            System.out.println(indent + "-- else if" + "\n" + indent + "     |");
            return ackerTrace(m - 1, 1, level + 1);
        } else {
            System.out.println(indent + "-- else" + "\n" + indent + "     |");
            return ackerTrace(m - 1, ackerTrace(m, n - 1, level + 1), level + 1);
        }
    }

    /**
     * The Ackerman's function
     *
     * @param m the m
     * @param n the n
     * @return Ackerman's function result
     */
    static int acker(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (n == 0) {
            return acker(m - 1, 1);
        } else {
            return acker(m - 1, acker(m, n - 1));
        }
    }

    /**
     * Takes milliseconds and prints it usable and readable for the user.
     *
     * @param diff the difference in milliscond
     * @return formatted text
     */
    static String formatMilli(long diff) {
        Date date = new Date(diff);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }

    /**
     * Print the welcome message
     */
    static void printMenu() {
        String welcome = ""
                + "|=================|======================|==================|\n"
                + "|                 |      ACKERMAN        |                  |\n"
                + "|                 |------ VISUAL --------|                  |\n"
                + "|      a visual representation of the Ackerman function     |\n"
                + "|      ¤¤¤ Licensed under GNU License, Louis Vallat ¤¤¤     |\n"
                + "|===========================================================|\n";
        System.out.println(welcome);
    }
}
