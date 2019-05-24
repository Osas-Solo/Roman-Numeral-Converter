public class RomanNumeral {

    String romanNumeral;
    int arabicNumeral;
    boolean isValid;

    public RomanNumeral(int arabicNumeral) {
        if (arabicNumeral < 1 || arabicNumeral > 3999) {
            this.isValid = false ;
        }
        else {
            this.isValid = true;
            this.romanNumeral = convertToRoman(arabicNumeral);
        }
    }

    public RomanNumeral(String romanNumeral) {
        this.arabicNumeral = convertToArabic(romanNumeral);

        if (this.arabicNumeral == -1) {
            this.isValid = false;
        }

        else {
            this.isValid = true;
        }
    }



    public String convertToRoman(int num) {
        String roman = "";
        String[] symbols = {"I", "V", "X", "L", "C", "D", "M"};
        int remainder;

        if (num < 10) {  //  case 1
            if (num <= 3) {
                for (int i = 1; i <= num; i++) {
                    roman += symbols[0];
                }
            }  //  end of num <= 3

            else if (num == 4) {
                roman += symbols[0] + symbols[1];
            }  //  end of num == 4

            else if (num == 5) {
                roman += symbols[1];
            }  //  end of num == 5

            else if (num <= 8) {
                remainder = num % 5;
                roman += symbols[1] + convertToRoman(remainder);
            }  //  end of num <= 8

            else if (num == 9) {
                roman += symbols[0] + symbols[2];
            }  //  end of num == 9
        }  //  end of case 1

        else if (num < 50) {  //  case 2
            if (num <= 39) {
                for (int i = 10; i <= num; i += 10) {
                    roman += symbols[2];
                }
                remainder = num % 10;
                if (remainder != 0) {
                    roman += convertToRoman(remainder);
                }
            }  //  end of num <= 39

            else if (num <= 49) {
                roman += symbols[2] + symbols[3];
                remainder = num % 10;
                if (remainder != 0) {
                    roman += convertToRoman(remainder);
                }
            }  //  end of num <= 59
        }  //  end of case 2

        else if (num < 100) {  //  case 3
            if (num <= 89) {
                roman += symbols[3];

                if (num <= 59) {
                    remainder = num % 10;
                    if (remainder != 0) {
                        roman += convertToRoman(remainder);
                    }
                }  //  end of num <= 59
                else {
                    for (int i = 60; i <= num; i += 10) {
                        roman += symbols[2];
                    }
                    remainder = num % 10;
                    if (remainder != 0) {
                        roman += convertToRoman(remainder);
                    }
                }  //  end of else
            }  //  end of num <= 89

            else if (num <= 99) {
                roman += symbols[2] + symbols[4];
                remainder = num % 10;
                if (remainder != 0) {
                    roman += convertToRoman(remainder);
                }
            }  //  end of num <= 99
        }  //  end of case 3

        else if (num < 500) {  //  case 4
            if (num <= 399) {
                for (int i = 100; i <= num; i += 100) {
                    roman += symbols[4];
                }
                remainder = num % 100;
                if (remainder != 0) {
                    roman += convertToRoman(remainder);
                }
            }  //  end of num <= 399

            else if (num <= 499) {
                roman += symbols[4] + symbols[5];
                remainder = num % 100;
                if (remainder != 0) {
                    roman += convertToRoman(remainder);
                }
            }  //  end of num <= 499
        }  //  end of case 4

        else if (num < 1000) {  //  case 5
            if (num <= 899) {
                roman += symbols[5];

                if (num <= 599) {
                    remainder = num % 100;
                    if (remainder != 0) {
                        roman += convertToRoman(remainder);
                    }
                }  //  end of num <= 599

                else {
                    for (int i = 600; i <= num; i += 100) {
                        roman += symbols[4];
                    }
                    remainder = num % 100;
                    if (remainder != 0) {
                        roman += convertToRoman(remainder);
                    }
                }  //  end of else
            }  //  end of num <= 899

            else if (num <= 999) {
                roman += symbols[4] + symbols[6];
                remainder = num % 100;
                if (remainder != 0) {
                    roman += convertToRoman(remainder);
                }
            }  //  end of num <= 999
        }  //  end of case 5

        else if (num <= 3999) {  //  case 6
            for (int i = 1000; i <= num; i += 1000) {
                roman += symbols[6];
            }
            remainder = num % 1000;
            if (remainder != 0) {
                roman += convertToRoman(remainder);
            }
        }  //  end of case 6


        return roman;
    }  //  end of convertToRoman()

    public int convertToArabic(String roman) {
        roman = roman.toUpperCase();
        for (int i = 1; i <= 3999; i++) {
            if (roman.equals(convertToRoman(i))) {
                return i;
            }
        }

        return -1;  //  indicates invalid Roman numeral
    }  //  end of convertToArabic()



}  //  end of class
