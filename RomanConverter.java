import java.util.Scanner;

public class RomanConverter {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int option;
        int number = 0;
        String roman;
        RomanNumeral numeral;
        boolean foundException;

        option = 1;
        while (option == 1 || option == 2) {

            //  select option
            foundException = true;
            while (foundException) {
                try {
                    System.out.println("\n\nSelect option:");
                    System.out.println("1: Convert to Roman Numeral");
                    System.out.println("2: Convert to Arabic Numeral");
                    System.out.println("Enter any other number to quit");
                    option = scan.nextInt();
                    foundException = false;
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    scan.next();
                }
            }  //  end of option input

            if (option == 1) {
                //  input number
                foundException = true;
                while (foundException) {
                    try {
                        System.out.println("\nEnter a number (0 - 3999):");
                        number = scan.nextInt();
                        numeral = new RomanNumeral(number);

                        if (numeral.isValid) {
                            foundException = false;
                            System.out.println(number + " = " + numeral.romanNumeral);
                        } else {
                            System.out.println("Invalid input");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                        scan.next();
                    }
                }  //  end of while loop for number input

            }  //  end of option 1

            else if (option == 2) {
                //  input Roman numeral
                foundException = true;
                while (foundException) {
                    try {
                        System.out.println("\nEnter a Roman numeral:");
                        roman = scan.next();
                        numeral = new RomanNumeral(roman);

                        if (numeral.isValid) {
                            foundException = false;
                            System.out.println(roman + " = " + numeral.arabicNumeral);
                        } else {
                            System.out.println("Invalid input");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                        scan.next();
                    }
                }  //  end of while loop for number input

            }  //  end of option 1

        }  //  end of while loop for options

        System.out.println("\n\nGoodbye");

    }  // end of main

}  //  end of class
