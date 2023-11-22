import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);


       while(true){
           System.out.println("Welcome to Priyanshu's game zone");
           System.out.println("press 1 for tic tac toe "+'\n'+" press 2 for stone paper scissor");
           int ok = choice.nextInt();
            if (ok == 1) {
                char[][] board = new char[3][3];

                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[row].length; col++) {
                        board[row][col] = ' ';
                    }
                }

                char player = 'X';
                Boolean gameover = false;
                Scanner scanner = new Scanner(System.in);

                while (!gameover) {
                    printBoard(board);
                    System.out.println("player" + player + "enter :");
                    int row = scanner.nextInt();
                    int col = scanner.nextInt();

                    if (board[row][col] == ' ') {
                        board[row][col] = player; //to place the element
                        gameover = havewon(board, player);
                        if (gameover) {
                            System.out.println("player " + player + " has won");

                        } else {
                            player = (player == 'X') ? 'O' : 'X';
                        }
                    }else {
                        System.out.println("invalid move");
                    }


                }


            } else if (ok == 2) {

                System.out.println("welcome to the game , rock , paper and scissors ");
                Scanner move = new Scanner(System.in);
                while (true) {
                    String[] rps = {"r", "p", "s"};
                    String comp_decision = rps[new Random().nextInt(rps.length)];

                    while (true) {
                        System.out.println("enter your move (r , p or s)");

                        String player_move = move.next();

                        if (player_move.equals(comp_decision)) {
                            System.out.println("the game is tie ");
                            break;
                        } else if (player_move.equals("r") && comp_decision.equals("p")) {
                            System.out.println("you lost the game" + '\n' + "computer choosed paper");
                            break;
                        } else if (player_move.equals("r") && comp_decision.equals("s")) {
                            System.out.println("you Won the game " + '\n' + "computer choosed Scissor");
                            break;
                        } else if (player_move.equals("p") && comp_decision.equals("r")) {
                            System.out.println("you Won the game " + '\n' + "computer choosed Rock");
                            break;
                        } else if (player_move.equals("p") && comp_decision.equals("s")) {
                            System.out.println("you lost the game " + '\n' + "computer choosed Scissor");
                            break;
                        } else if (player_move.equals("s") && comp_decision.equals("p")) {
                            System.out.println("you Won the game " + '\n' + "computer choosed paper");
                            break;
                        } else if (player_move.equals("s") && comp_decision.equals("r")) {
                            System.out.println("you lost the game " + '\n' + "computer choosed Rock");
                            break;
                        } else {
                            System.out.println(" invalid move! ( make sure that you have entered your choice in lowercase )");
                        }
                    }
                    System.out.println("do you want to play again? (y/n)");
                    Scanner again = new Scanner(System.in);
                    String exit = again.next();
                    if (exit.equals("n")) {
                        break;
                    }


                }
            } else {
                System.out.println("sorry ! currently i have only two games ");
            }
           System.out.println("Return to MENU ? (y/n) ");
           Scanner input = new Scanner(System.in);
           String exit = input.nextLine();
           if(input.equals("n")){
               break;
           }
        }
    }

    static Boolean havewon(char[][] board, char player){
        for (int row = 0; row < board.length; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player ){
                return true;
            }
        }
        for (int col = 0; col <board.length; col++) {
            if(board[0][col]== player && board[1][col]== player && board[2][col]== player){
                return true;
            }
        }


        if(board[0][0]== player && board[1][1]== player && board[2][2]== player){
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
return false;

    }
    static void printBoard(char [][]board){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + "|");
            }
            System.out.println();
        }

    }
}