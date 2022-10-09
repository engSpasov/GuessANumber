import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static int computerNumber;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        generateNumber();
        System.out.print("Guess a number (1-100) ([q]uit): ");
        String input=scanner.nextLine();

        int movesCounter=0;
        boolean isGuessed=false;

        while(!input.equalsIgnoreCase("q")){
            if(input.equalsIgnoreCase("quit")){
                break;
            }

            if(isValidInput(input)){
                int playersGuess=Integer.parseInt(input);
                if(isInRange(playersGuess)){
                    movesCounter++;
                    System.out.println(checkResult(playersGuess));
                    if(checkResult(playersGuess).equals("You guessed it")){
                        isGuessed=true;
                        break;
                    }
                } else {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }

            System.out.print("Guess a number (1-100) ([q]uit): ");
            input=scanner.nextLine();
        }

        printResults(isGuessed,movesCounter);
    }

    public static void generateNumber(){
        Random newRandomNumber=new Random();
        computerNumber= newRandomNumber.nextInt(100)+1;
    }

    public static String checkResult(int numb){
        if(numb>computerNumber){
            return "Too High";
        } else if (numb<computerNumber){
            return "Too Low";
        }
        return "You guessed it";
    }

    public static boolean isValidInput(String txt){
        for (int i = 0; i < txt.length(); i++) {
            if(txt.charAt(i)<'0' || txt.charAt(i)>'9'){
                return false;
            }
        }
        return true;
    }

    public static boolean isInRange(int n){
        return n>=0 && n<=100;
    }

    public static void printResults(boolean isGuessed, int movesCounter){
        if (isGuessed){
            if(movesCounter==1){
                System.out.printf("You have guessed the number %d after %d move.",computerNumber,movesCounter);
            } else {
                System.out.printf("You have guessed the number %d after %d moves.",computerNumber,movesCounter);
            }

        } else {
            if(movesCounter==0){
                System.out.println("You have quit without even try. You will never know the number!");
            } else if(movesCounter==1){
                System.out.printf("You have quit after %d move. You will never know the number!",movesCounter);
            } else {
                System.out.printf("You have quit after %d moves. You will never know the number!",movesCounter);
            }
        }
    }

}
