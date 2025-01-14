import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Define an enum for intents
enum Intent {
  GREETING,
  TASK,
  GOODBYE,
  THANKS,
  UNKNOWN,
  OPEN,
  COURSE,
  SURE,
  DONE,
  CALCULATION,
  CONVERT;

}

public class assistant {
  private Map<Intent, String> responses;
  private Scanner scanner;

  public assistant() {
    responses = new HashMap<>();
    responses.put(Intent.GREETING, " HELLO !");
    responses.put(Intent.TASK,
        " ~Right now i can only perform task listed below~\n1. Create shapes \n2. Calculate tax \n3. open specific apps \n4. Navigate you to your course\n5. Basic Mathematicals Calculations\n6. Time and Date\n7. Currency Converter\n8. Password Generator");
    responses.put(Intent.GOODBYE, "Goodbye! It was nice chatting with you. ");
    responses.put(Intent.THANKS, "You're welcome!");
    responses.put(Intent.UNKNOWN, "I didn't understand that. Lets try again.");
    responses.put(Intent.OPEN, "sure i will try to open it .");
    responses.put(Intent.COURSE, "I can help you with that .");
    responses.put(Intent.SURE, "SURE i'll do it for you ");
    responses.put(Intent.DONE, " Anything else you would like me to do");
    responses.put(Intent.CALCULATION, "ADD, SUB, DIV, MULT");
    scanner = new Scanner(System.in);
  }

  // Method to identify intent from user input
  private Intent identifyIntent(String input) {
    input = input.toLowerCase();

    if (input.contains("help") || input.contains("what you can do ") || input.contains("show")) {
      return Intent.TASK;
    } else if (input.contains("bye") || input.contains("goodbye")) {
      return Intent.GOODBYE;
    } else if (input.contains("thanks") || input.contains("thank you")) {
      return Intent.THANKS;
    }

    // function to open a app on desktop

    else if (input.contains("apps") || input.contains("3")) {
      String[] apps = { "steam", "chrome" }; // add more apps as needed

      String[] appPaths = { "C:\\Program Files (x86)\\Steam\\steam.exe",
          "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"
      };
      System.out.println(" which application you would like to open \n1.STEAM\n2.CHROME");
      Scanner sc = new Scanner(System.in);

      int choice = sc.nextInt();
      if (choice == 1) {
        try {
          Desktop.getDesktop().open(new File("C:\\Program Files (x86)\\Steam\\steam.exe"));
        } catch (IOException e) {
          System.out.println("Failed to open application");
        }
      } else if (choice == 2) {
        try {
          Desktop.getDesktop().open(new File("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"));
        } catch (IOException e) {
          System.out.println("Failed to open application");
        }

      }
      return Intent.SURE;

      // calculating Tax

    } else if (input.contains("2") || input.contains("tax")) {
      System.out.println("sure sir\nplease enter your monthly income");
      Scanner sc = new Scanner(System.in);
      int monthlyincome = sc.nextInt();
      int income = (monthlyincome * 12);

      int tax;
      if (income <= 300000) {
        tax = 0;
      } else if (income >= 300000 && income <= 700000) {
        tax = (int) (income * 0.05);
      } else if (income >= 700000 && income <= 1000000) {
        tax = (int) (income * 0.10);
      } else if (income >= 1000000 && income <= 1200000) {
        tax = (int) (income * 0.15);
      } else if (income >= 1200001 && income <= 1500000) {
        tax = (int) (income * 0.20);
      } else {
        tax = (int) (income * 0.30);
      }
      System.out.println("According to your monthly Income Your Annual Income will be : " + income);

      System.out.println(" Then your tax will be :" + tax);

      return Intent.DONE;

      // function for performing mathematical calcualtions
    } else if (input.contains("calculation") || input.contains("5")) {
      System.out.println("choose an operation");
      System.out.println("1.ADDITION");
      System.out.println("2.SUBTRACTION");
      System.out.println("3.DIVISION");
      System.out.println("4.MULTIPLICATION");
      System.out.println("5.LARGEST");
      System.out.println("6.PALINDROME CHECK");
      System.out.println("7.IS EVEN OR ODD");
      System.out.println("8.IS PRIME");

      Scanner sc = new Scanner(System.in);
      int choice = sc.nextInt();

      if (choice == 1) {
        System.out.print("enter your first number: ");
        int num1 = sc.nextInt();
        System.out.print("enter your second number: ");
        int num2 = sc.nextInt();
        int SUM = num1 + num2;
        System.out.println("your answer is " + SUM);
        return Intent.DONE;

      } else if (choice == 2) {
        System.out.print("enter your first number: ");
        int num1 = sc.nextInt();
        System.out.print("enter your second number: ");
        int num2 = sc.nextInt();
        int SUB = num1 - num2;
        System.out.println("your answer is " + SUB);
        return Intent.DONE;

      } else if (choice == 3) {
        System.out.print("enter your first number: ");
        int num1 = sc.nextInt();
        System.out.print("enter your second number: ");
        int num2 = sc.nextInt();
        if (num2 == 0) {
          System.out.println("cannot divide by zero");
        }
        double DIV = num1 / num2;
        System.out.println("your answer is " + DIV);
        return Intent.DONE;

      } else if (choice == 4) {
        System.out.print("enter your first number: ");
        int num1 = sc.nextInt();
        System.out.print("enter your second number: ");
        int num2 = sc.nextInt();
        int MULT = num1 * num2;
        System.out.println("your answer is " + MULT);
        return Intent.DONE;
      } else if (choice == 5) {
        System.out.println("value");
        System.out.println("enter the value of a :");
        int a = sc.nextInt();
        System.out.println("enter the value of b :");
        int b = sc.nextInt();
        System.out.println("enter the value of c :");
        int c = sc.nextInt();
        if (a > b && a >= c) {
          System.out.println("A is the largest " + a);

        } else if (b >= c) {
          System.out.println("B is the greatest " + b);
        } else {
          System.out.println("C is the greatest " + c);
        }
        return Intent.DONE;
      } else if (choice == 6) {
        System.out.println("Enter the value you want to check");
        int number = sc.nextInt();
        int palindrome = number;
        int reverse = 0;
        while (palindrome != 0) {
          int remainder = palindrome % 10;
          reverse = reverse * 10 + remainder;
          palindrome = palindrome / 10;
          if (number == reverse) {
            System.out.println(number + "is palindrome");
          } else {
            System.out.println(number + "is not a palindrome");
          }
        }
        return Intent.DONE;
      } else if (choice == 7) {
        System.out.println("Sure\ntell me the number you want to check");
        int n = sc.nextInt();
        if (n % 2 == 0) {
          System.out.println(n + " is EVEN ");
        } else {
          System.out.println(n + " is ODD ");

        }
        return Intent.DONE;
      } else if (choice == 8) {
        System.out.println("sure \ntell me the number you want to check");
        int n = sc.nextInt();
        if (n == 2) {
          System.out.println(n + " is a prime number");
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
          if (n % i == 0) {
            System.out.println(n + " is not a prime number");
          }
        }
      } else {
        System.out.println("invalid choice");
      }

    }

    // PASSWORD Generator

    else if (input.contains("8") || input.contains("password")) {
      System.out.println("Enter desired Password length:");
      int length = scanner.nextInt();
      String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
      Random rnd = new Random();
      StringBuilder password = new StringBuilder();
      for (int i = 0; i < length; i++) {
        password.append(chars.charAt(rnd.nextInt(chars.length())));
      }
      System.out.println("Password: " + password.toString());

      return Intent.DONE;

    }

    // function for checking and printing current date and time

    else if (input.contains("time") || input.contains("6")) {

      LocalDateTime now = LocalDateTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy , hh:mm:ss a");

      String formattedDateTime = now.format(formatter);
      System.out.println("cuurent Date and Time is :" + formattedDateTime);
      return Intent.DONE;
    }
    // function for creating shapes

    else if (input.contains("shapes") || input.contains("1")) {
      System.out.println("Sure what shape do you want to create");
      System.out.println("1.Butterfly");
      System.out.println("2.Diamond");
      System.out.println("3.Hollow-Rhombus");
      System.out.println("4.Solid-Rhombus");
      System.out.println("5.Floyds-Triangle");
      System.out.println("6.Binary Triangle");
      System.out.println("7.Invert Pyramid using Star");
      System.out.println("8.Inverted Pyramid using number");
      System.out.println("9.Hollow-Rectangle");
      Scanner sc = new Scanner(System.in);
      int choice = sc.nextInt();

      // for creating a butterfly pattern

      if (choice == 1) {
        System.out.println("Sure, I am using the star method\n tell me the size of the butterfly");
        int n = sc.nextInt();
        System.out.println();
        // 1st halff
        for (int i = 1; i <= n; i++) {
          // stars -i
          for (int j = 1; j <= i; j++) {
            System.out.print("*");
          }
          // spaces -2 *(n-i)
          for (int j = 1; j <= 2 * (n - i); j++) {
            System.out.print(" ");
          }
          // stars -i
          for (int j = 1; j <= i; j++) {
            System.out.print("*");
          }
          System.out.println();
        }
        // 2nd half

        for (int i = n; i >= 1; i--) {
          for (int j = 1; j <= i; j++) {
            System.out.print("*");
          }
          // spaces -2 *(n-i)
          for (int j = 1; j <= 2 * (n - i); j++) {
            System.out.print(" ");
          }
          // stars -i
          for (int j = 1; j <= i; j++) {
            System.out.print("*");
          }
        }
        System.out.println();
      }

      // for creating a diamond pattern

      else if (choice == 2) {
        System.out.println("Sure, I am using the star method\n tell me the size of the Diamond");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
          // spaces(n-i)
          for (int j = 1; j <= (n - i); j++) {
            System.out.print(" ");
          }
          // stars
          for (int j = 1; j <= (2 * i) - 1; j++) {
            System.out.print("*");
          }
          System.out.println();
        }

        // 2nd half
        for (int i = n; i >= 1; i--) {
          // spaces(n-i)
          for (int j = 1; j <= (n - i); j++) {
            System.out.print(" ");
          }
          // stars
          for (int j = 1; j <= (2 * i) - 1; j++) {
            System.out.print("*");
          }
          System.out.println();
        }

      }

      // for creating a hollow rhombus shape

      else if (choice == 3) {
        System.out.println("Sure, I am using the diamond method\n tell me the size of the Hollow-Rhombus");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
          // spaces
          for (int j = 1; j <= (n - i); j++) {
            System.out.print(" ");
          }
          // hollow rhombus

          for (int j = 1; j <= n; j++)// for columns
          {
            if (i == 1 || i == n || j == 1 || j == n)// boundary check
            {
              System.out.print("*");
            } else {
              System.out.print(" ");
            }
          }
          System.out.println();
        }
      }

      // for creating a solid - rhombus shape

      else if (choice == 4) {
        System.out.println("Sure, I am using the Star method\n tell me the size of the Solid - Rhombus");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
          // spaces
          for (int j = 1; j <= (n - i); j++) {
            System.out.print(" ");
          }
          // stars
          for (int j = 1; j <= n; j++) {
            System.out.print("*");
          }

          System.out.println();
        }
      }

      // for creating a floyds - triangle

      else if (choice == 5) {
        System.out.println("Sure \n tell me the size of the Triangle");
        int n = sc.nextInt();
        int counter = 1;
        for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= i; j++) {
            System.out.print(counter + " ");
            counter++;
          }
          System.out.println();
        }
      }
      // for creating a binary - triangle

      else if (choice == 6) {
        System.out.println("Sure \n tell me the size of the Triangle");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= i; j++) {
            if ((i + j) % 2 == 0) { // for even
              System.out.print("1");
            } else {
              System.out.print("0");
            }

          }
          System.out.println();
        }
      }

      // for creating a inverted pyramid using star

      else if (choice == 7) {
        System.out.println("Sure  i will use the star print method\n tell me the size of the Pyramid");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= n - i; j++) { // for spaces
            System.out.print(" ");
          }
          for (int j = 1; j <= i; j++) { // for stars
            System.out.print("*");
          }

          System.out.println();
        }
      }

      // for creating a inverted pyramid using number

      else if (choice == 8) {
        System.out.println("Sure  i will use the binary number print method\n tell me the size of the Pyramid");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= n - i + 1; j++) { // for numbers
            System.out.print(j);
          }

          System.out.println();
        }
      }
      // To print a rectangle
      else if (choice == 9) {
        System.out.println("sure \n tell me the size of rectangle");
        System.out.println("no of columns: ");
        int totcols = sc.nextInt();
        System.out.println("no.of Rows");
        int totrows = sc.nextInt();
        for (int i = 1; i <= totrows; i++)// for rows
        { // inner loop
          for (int j = 1; j <= totcols; j++)// for columns
          {
            if (i == 1 || i == totrows || j == 1 || j == totcols)// boundary check
            {
              System.out.print("*");
            } else {
              System.out.print(" ");
            }
          }
          System.out.println();
        }
      }
      return Intent.DONE;
    }

    // currency converter
    else if (input.contains("7") || input.contains("convert")) {
      Scanner sc = new Scanner(System.in);
      // Currency Converter
      System.out.println("Welcome to the Currency Converter!");

      System.out.println("Choose the currency you want to convert from:");
      System.out.println("1. Indian Rupee (INR)");
      System.out.println("2. US Dollar (USD)");
      System.out.println("3. Euro (EUR)");
      System.out.println("4. British Pound (GBP)");
      int sourceCurrencyChoice = sc.nextInt();

      double amount;

      if (sourceCurrencyChoice == 1) {
        System.out.println("Please enter the amount in INR:");
        amount = sc.nextDouble();
      } else if (sourceCurrencyChoice == 2) {
        System.out.println("Please enter the amount in USD:");
        amount = sc.nextDouble();
      } else if (sourceCurrencyChoice == 3) {
        System.out.println("Please enter the amount in EUR:");
        amount = sc.nextDouble();
      } else if (sourceCurrencyChoice == 4) {
        System.out.println("Please enter the amount in GBP:");
        amount = sc.nextDouble();
      } else {
        System.out.println("Invalid source currency choice.");
        return Intent.DONE; // Exit if invalid choice
      }

      // Example conversion rates for INR (indian rupees) (You can modify these rates
      // as needed)
      double conversionRateINRtoUSD = 0.0118; // EXAMPLE: 1 INR = 0.0118 USD```java
      double conversionRateINRtoEUR = 0.0112; // Example: 1 INR = 0.112 EUR
      double conversionRateINRtoGBP = 0.0092; // Example: 1 INR = 0.0092 GBP

      // conversion rates for USD (United State dollar)
      double conversionRateUSDtoINR = 84.8095; // EXAMPLE: 1 USD =84.8095 INR
      double conversionRateUSDtoEUR = 0.9521; // Example: 1 USD = 0.9521 EUR
      double conversionRateUSDtoGBP = 0.7924; // EXAMPLE: 1 USD = 0.7924 GBP

      // conversion rates for EURO (Europian currency)
      double conversionRateEURtoINR = 89.0775; // EXAMPLE: 1 EUR = 89.0775 INR
      double conversionRateEURtoUSD = 1.0503; // EXAMPLE: 1 EUR =1.0523 USD
      double conversionRateEURtoGBP = 0.8323;// EXAMPLE: 1 EUR = 0.8323 GBP

      // conversion rates for GBP (British Pound)
      double conversionRateGBPtoINR = 107.026; // EXAMPLE: 1 GBP = 107.026 INR
      double conversionRateGBPtoUSD = 1.262;// EXAMPLE: 1 GBP = 1.262 USD
      double conversionRateGBPtoEUR = 1.2016;// EXAMPLE: 1 GBP = 1.2016 EURO

      System.out.println("Choose the currency to convert to:");
      System.out.println("1. Euro (EUR)");
      System.out.println("2. British Pound (GBP)");
      System.out.println("3. US Dollar (USD)");
      System.out.println("4. Indian rupees (INR)");

      int currencyChoice = sc.nextInt();

      if (sourceCurrencyChoice == 1) { // From INR
        if (currencyChoice == 1) {
          double convertedAmount = amount * conversionRateINRtoEUR;
          System.out.printf("Converted Amount: %.2f EUR%n", convertedAmount);
        } else if (currencyChoice == 2) {
          double convertedAmount = amount * conversionRateINRtoGBP;
          System.out.printf("Converted Amount: %.2f GBP%n", convertedAmount);
        } else if (currencyChoice == 3) {
          double convertedAmount = amount * conversionRateINRtoUSD;
          System.out.printf("Converted Amount: %.2f USD%n", convertedAmount);
        } else {
          System.out.println("Invalid target currency choice.");
        }
      }

      else if (sourceCurrencyChoice == 2) { // From USD
        if (currencyChoice == 1) {
          double convertedAmount = amount / conversionRateUSDtoEUR; // Assuming you have the rate for USD to INR
          System.out.printf("Converted Amount: %.2f EUR%n", convertedAmount);
        } else if (currencyChoice == 2) {
          double convertedAmount = amount * conversionRateUSDtoGBP;
          System.out.printf("Converted Amount: %.2f GBP%n", convertedAmount);
        } else if (currencyChoice == 4) {
          double convertedAmount = amount * conversionRateUSDtoINR;
          System.out.printf("Converted Amount: %.2f INR%n", convertedAmount);
        } else {
          System.out.println("Invalid target currency choice.");
        }
      }

      else if (sourceCurrencyChoice == 3) { // From EUR
        if (currencyChoice == 2) {
          double convertedAmount = amount / conversionRateEURtoGBP; // Assuming you have the rate for EUR to INR
          System.out.printf("Converted Amount: %.2f GBP%n", convertedAmount);
        } else if (currencyChoice == 3) {
          double convertedAmount = amount * conversionRateEURtoUSD;
          System.out.printf("Converted Amount: %.2f USD%n", convertedAmount);
        } else if (currencyChoice == 4) {
          double convertedAmount = amount * conversionRateEURtoINR;
          System.out.printf("Converted Amount: %.2f INR%n", convertedAmount);
        } else {
          System.out.println("Invalid target currency choice.");
        }
      }

      else if (sourceCurrencyChoice == 4) { // From GBP
        if (currencyChoice == 1) {
          double convertedAmount = amount / conversionRateGBPtoEUR; // Assuming you have the rate for GBP to INR
          System.out.printf("Converted Amount: %.2f EUR%n", convertedAmount);
        } else if (currencyChoice == 3) {
          double convertedAmount = amount * conversionRateGBPtoUSD;
          System.out.printf("Converted Amount: %.2f USD%n", convertedAmount);
        } else if (currencyChoice == 4) {
          double convertedAmount = amount * conversionRateGBPtoINR;
          System.out.printf("Converted Amount: %.2f INR%n", convertedAmount);
        } else {
          System.out.println("Invalid target currency choice.");
        }
      }

      else {
        System.out.println("Invalid source currency choice.");
      }
      return Intent.DONE; // Return after processing
    }

    else if (input.contains("Goodbye") || input.contains("clear") || input.contains("GOODBYE")) {
      return Intent.GOODBYE;
    }

    // function for opening course url in chrome or any other browser
    else if (input.contains("4") || input.contains(" course")) {

      String url = "https://www.apnacollege.in/path-player?courseid=alpha-plus-combo-1&unit=6571c324ccd5f955050cf015Unit";
      try {
        Desktop.getDesktop().browse(new URI(url));
      } catch (URISyntaxException e) {
        System.out.println("Invalid URL");
      } catch (IOException e) {
        System.out.println("Failed to open browser");
      }
      return Intent.COURSE;
    }

    return Intent.UNKNOWN;
  }

  // Method to generate response based on intent
  private String generateResponse(Intent intent) {
    return responses.get(intent);
  }

  // Method to start the conversation
  public void startConversation() {
    // Get the current time
    LocalTime currentTime = LocalTime.now();

    // Get the hour of the day
    int hour = currentTime.getHour();
    // Determine the greeting based on the hour
    String greeting;
    if (hour < 12) {
      greeting = (" Good morning!");
    } else if (hour < 17) {
      greeting = ("Good afternoon!");
    } else {
      greeting = ("Good evening!");
    }
    System.out.println("ALENA : HELLO  " + greeting + " How can i Assist you today?");

    while (true) {
      System.out.print("User: ");
      String input = scanner.nextLine();

      Intent intent = identifyIntent(input);
      String response = generateResponse(intent);

      System.out.println("ALENA : " + response);

      if (intent == Intent.UNKNOWN) {
        System.out.println("ALENA : HELLO How can i Assist you today?");
      }
      if (intent == Intent.GOODBYE) {
        break;
      }
    }
  }

  public static void main(String[] args) {
    assistant assistant = new assistant();
    assistant.startConversation();
  }
}