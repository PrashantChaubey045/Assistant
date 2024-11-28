import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.Desktop;
import java.util.*;
import java.util.Scanner;
import java.util.Random;
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
    CALCULATION;
   
}

public class assistant {
    private Map<Intent, String> responses;
    private Scanner scanner;
    
    public assistant() {
        responses = new HashMap<>();
        responses.put(Intent.GREETING, "Hello!");
        responses.put(Intent.TASK, "How can i Assist you today?\n ~Right now i can only perform task listed below~\n1. Create shapes \n2. Calculate tax \n3. open specific apps \n4. Navigate you to your course\n5. Basic Mathematicals Calculations\n6. Time and Date\n7. Check Typing Speed ");
        responses.put(Intent.GOODBYE, "Goodbye! It was nice chatting with you. ");
        responses.put(Intent.THANKS, "You're welcome!");
        responses.put(Intent.UNKNOWN, "I didn't understand that. Lets try again.");
        responses.put(Intent.OPEN, "sure i will try to open it .");
        responses.put(Intent.COURSE, "I can help you with that .");
        responses.put(Intent.SURE, "SURE i'll do it for you\nALENA : Anything else you would like me to do ");
        responses.put(Intent.DONE, "DONE  Anything else you would like me to do");
        responses.put(Intent.CALCULATION,"ADD, SUB, DIV, MULT");
                scanner = new Scanner(System.in);
    }

    // Method to identify intent from user input
    private Intent identifyIntent(String input) {
        input = input.toLowerCase();

        if (input.contains("hello") || input.contains("hi")) {
            return Intent.TASK;
        } else if (input.contains("bye") || input.contains("goodbye")) {
            return Intent.GOODBYE;
        } else if (input.contains("thanks") || input.contains("thank you")) {
            return Intent.THANKS;
        }
        
        else if (input.contains("apps") || input.contains("3")) {
            String[] apps = {"steam", "chrome"}; // add more apps as needed
            
        String[] appPaths = {"C:\\Program Files (x86)\\Steam\\steam.exe", 
                             "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe" 
                             }; 
      System.out.println(" which application you would like to open \n1.STEAM\n2.CHROME");
                    Scanner sc = new Scanner(System.in);
          int  choice= sc.nextInt();
         if (choice==1){
          try {
            Desktop.getDesktop().open(new File("C:\\Program Files (x86)\\Steam\\steam.exe"));
        } catch (IOException e) {
            System.out.println("Failed to open application");
        }
         }else if (choice ==2){
          try {    Desktop.getDesktop().open(new File("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"));
        } catch (IOException e) {
            System.out.println("Failed to open application");
        }

         }
             return Intent.SURE;                                                                       
        
          
    }else if (input.contains("2")|| input.contains("tax")){
        System.out.println("sure sir\nplease enter your monthly income");
        Scanner sc= new Scanner(System.in);
        int monthlyincome = sc.nextInt();
        int income = (monthlyincome*12);

            int tax;
            if (income<=300000){
           tax=0;
          }
          else if (income>=300000&& income<=700000) {
            tax = (int) (income * 0.05);
          }
          else if (income>=700000 && income <=1000000){
            tax = (int) (income * 0.10);
          }
          else if (income>=1000000 && income <=1200000)
          {
            tax = (int) (income * 0.15);
          }
          else if (income>=1200001 && income <=1500000)
          {
            tax = (int) (income * 0.20);
          }
            else{
            tax= (int)(income*0.30);
          }
           System.out.println("your tax is:"+ tax);
        
            
            return Intent.DONE;

    }
    else if (input.contains("calculation")||input.contains("5")){
         System.out.println("choose an operation");   
         System.out.println("1.ADDITION");
         System.out.println("2.SUBTRACTION");
         System.out.println("3.DIVISION");
         System.out.println("4.MULTIPLICATION");
         System.out.println("5.LARGEST");
         System.out.println("6.PALINDROME CHECK");
         System.out.println("7.IS EVEN OR ODD");
         System.out.println("8.IS PRIME");
        // System.out.println("9.FACTORISATION");
         
         Scanner sc = new Scanner(System.in);
           int choice= sc.nextInt();

            if(choice== 1){
            System.out.print("enter your first number: ");
            int num1 = sc.nextInt();
            System.out.print("enter your second number: ");
            int num2= sc.nextInt();
            int SUM = num1 + num2;
            System.out.println("your answer is "+ SUM);
            return Intent.DONE;

              }else if (choice== 2){
            System.out.print("enter your first number: ");
            int num1 = sc.nextInt();
            System.out.print("enter your second number: ");
            int num2= sc.nextInt();
            int SUB = num1 - num2;
            System.out.println("your answer is "+ SUB);
            return Intent.DONE;

              }else if (choice== 3){
            System.out.print("enter your first number: ");
            int num1 = sc.nextInt();
            System.out.print("enter your second number: ");
            int num2= sc.nextInt();
            if (num2 == 0){
              System.out.println("cannot divide by zero");
            }
            int DIV = num1 / num2;
            System.out.println("your answer is "+ DIV);
            return Intent.DONE;
  
              }else if (choice== 4){
            System.out.print("enter your first number: ");
            int num1 = sc.nextInt();
            System.out.print("enter your second number: ");
            int num2= sc.nextInt();
            int MULT = num1 * num2;
            System.out.println("your answer is "+ MULT);
            return Intent.DONE;
            }
            else if (choice ==5){
              System.out.println("value");
             System.out.println("enter the value of a :");
                int a = sc.nextInt();
                System.out.println("enter the value of b :");
                int b = sc.nextInt();
                System.out.println("enter the value of c :");
                int c = sc.nextInt();
                 if (a>b && a>=c){
                  System.out.println("A is the largest " +a);

                 }
                 else if (b>=c){
                  System.out.println("B is the greatest "+b);
                 }
                   else {
                    System.out.println("C is the greatest "+c);
                   }
                   return Intent.DONE;
                  }
                   else if (choice ==6){
                    int number=sc.nextInt();
                  int palindrome = number;
                    int reverse =0;
                    while (palindrome !=0){
                      int remainder = palindrome % 10;
                      reverse = reverse * 10 + remainder;
                      palindrome=palindrome/10;
                      if (number == reverse){
                        System.out.println(number+"is palindrome");
                      }else{
                        System.out.println(number+"is not a palindrome"); 
                      }
                      }
                      return Intent.DONE;
                    }
                    else if(choice==7){
                      System.out.println("Sure\ntell me the number you want to check");
                      int n = sc.nextInt();
                      if (n%2==0){
                        System.out.println(n+" is EVEN ");
                      }else{
                      System.out.println(n+" is ODD ");

                      }
                  
                return Intent.DONE;
                  }
                    else if(choice==8){
                      System.out.println("sure \ntell me the number you want to check");
                      int n = sc.nextInt();
                      if (n==2){
                        System.out.println(n+" is a prime number");
                      }
                         for (int i=2;i<=Math.sqrt(n);i++){
                          if (n%i==0){
                            System.out.println(n+" is not a prime number");
                          }
                            }
              }
             else{   
              System.out.println("invalid choice");
                                }  
              }
              else if (input.contains("time")|| input.contains("6")){
          
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy , hh:mm:ss a");

        String formattedDateTime = now.format(formatter);
        System.out.println("cuurent Date and Time is :"+formattedDateTime);
         return Intent.DONE;
              }

else if (input.contains("shapes")|| input.contains("1")){
            System.out.println("1.Butterfly");
            System.out.println("2.Diamond");
            System.out.println("3.Hollow-Rhombus");
            System.out.println("4.Solid-Rhombus");
            System.out.println("5.Floyds-Triangle");
            System.out.println("6.Binary Triangle");
            System.out.println("7.Invert Pyramid using Star");
            System.out.println("8.Inverted Pyramid using number");
            System.out.println("9.Hollow-Rectangle");
            Scanner sc = new Scanner (System.in);
       int choice= sc.nextInt();
      if (choice==1){
        System.out.println("Sure, I am using the star method\n tell me the size of the butterfly");
        int n = sc.nextInt();
        System.out.println();
         //1st halff
  for(int i =1;i<=n;i++){
    //stars -i
    for (int j =1;j<=i;j++){
      System.out.print("*");
    }
    // spaces -2 *(n-i)
for (int j =1; j<=2*(n-i);j++){
  System.out.print(" ");
}
    // stars -i
    for (int j =1;j<=i;j++){
      System.out.print("*");
    }
    System.out.println();
  }
   // 2nd half

   for(int i =n;i>=1;i--){for (int j =1;j<=i;j++){
    System.out.print("*");
  }
  // spaces -2 *(n-i)
for (int j =1; j<=2*(n-i);j++){
System.out.print(" ");
}
  // stars -i
  for (int j =1;j<=i;j++){
    System.out.print("*");
  }
   }
System.out.println();
    }
    else if(choice ==2){
      System.out.println("Sure, I am using the star method\n tell me the size of the Diamond");
      int n = sc.nextInt();
      for(int i =1;i<=n;i++){
        // spaces(n-i)
    for (int j =1; j<=(n-i);j++){
      System.out.print(" ");
    }
     // stars 
     for(int j=1;j<=(2*i)-1; j++){
      System.out.print("*");
     }
     System.out.println();
     }
    
    
      // 2nd half
      for(int i =n;i>=1;i--){
        // spaces(n-i)
    for (int j =1; j<=(n-i);j++){
      System.out.print(" ");
    }
     // stars 
     for(int j=1;j<=(2*i)-1; j++){
      System.out.print("*");
     }
     System.out.println();
     }
      
    }
    else if (choice ==3){
      System.out.println("Sure, I am using the diamond method\n tell me the size of the Hollow-Rhombus");
      int n =sc.nextInt();
      for(int i =1;i <=n;i++){
        // spaces
            for (int j =1; j<=(n-i);j++){
            System.out.print(" ");
             }
         // hollow rhombus
         
         for (int j =1; j<=n;j++)// for columns
         { 
           if (i==1||i==n||j==1||j==n)// boundary check
           {    
             System.out.print("*");
           }
           else{
             System.out.print(" ");
           }
         }
         System.out.println();
    }
  }
    else if (choice ==4){
      System.out.println("Sure, I am using the Star method\n tell me the size of the Solid - Rhombus");
      int n =sc.nextInt();
      for(int i =1;i <=n;i++){
        // spaces
        for (int j =1; j<=(n-i);j++){
          System.out.print(" ");
              }
        //stars
         for(int j =1; j<=n; j++){
          System.out.print("*");
         }
        
         System.out.println();
            }
    }
    else if (choice==5){
      System.out.println("Sure \n tell me the size of the Triangle");
      int n =sc.nextInt();
      int counter = 1;
            for(int i =1;i<=n;i++ ){
              for (int j= 1;j <=i;j++){
                System.out.print(counter+" ");
            counter ++;
            }
            System.out.println();
          }
    }
    else if (choice==6){
      System.out.println("Sure \n tell me the size of the Triangle");
      int n =sc.nextInt();
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
          if ((i+j)% 2==0){ // for even
            System.out.print("1");
          }
          else{
            System.out.print("0");
          }

    }
  System.out.println();
  }
    }
    else if(choice==7){
      System.out.println("Sure  i will use the star print method\n tell me the size of the Pyramid");
      int n =sc.nextInt();
      for (int i=1;i<=n;i++){
        for (int j=1;j<=n-i;j++){  // for spaces 
          System.out.print(" ");
                 }
                 for (int j=1;j<=i;j++){ // for stars 
                  System.out.print("*");
                 }
                 
        System.out.println();
                }
    }
    else if (choice==8){
      System.out.println("Sure  i will use the binary number print method\n tell me the size of the Pyramid");
      int n =sc.nextInt();
      for (int i=1;i<=n;i++){
        for (int j=1;j<=n-i+1;j++){  // for numbers
          System.out.print(j);
                 }
                 
        System.out.println();
                }
    }

    else if (choice==9){
      System.out.println("sure \n tell me the size of rectangle");
        System.out.println("no of columns: ");
        int totcols=sc.nextInt();
        System.out.println("no.of Rows");
        int totrows=sc.nextInt();
      for (int i=1;i <=totrows;i++)// for rows
          {   // inner loop
          for (int j =1; j<=totcols;j++)// for columns
          {
            if (i==1||i==totrows||j==1||j==totcols)// boundary check
            {    
              System.out.print("*");
            }
            else{
              System.out.print(" ");
            }
          }
          System.out.println();
        }
    }
        return Intent.DONE;
    }
         else if (input.contains("4")|| input.contains(" course")){

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
            greeting =(" Good morning!");
        } else if (hour < 17) {
           greeting =("Good afternoon!");
        } else {
           greeting =("Good evening!");
        }
        System.out.println("ALENA : HELLO  "+greeting);
      
        while (true) {
            System.out.print("User: ");
            String input = scanner.nextLine();

            Intent intent = identifyIntent(input);
            String response = generateResponse(intent);

            System.out.println("ALENA : " + response);
            
            if (intent== Intent.UNKNOWN){
              System.out.println("ALENA : HELLO  "+greeting);
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