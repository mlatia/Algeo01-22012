import java.util.*;
import java.io.*;

public class mainprogram {
    public static void main(String[] args){
        //KAMUS GLOBAL
        int baris,i;
        boolean safeinput;
        int userInput;

        //ALGORITMA
        Scanner in = new Scanner(System.in);
        System.out.println("                            WELCOME!");
        System.out.println(" ");
        System.out.println("*Please keep in mind to only type the number when choosing a menu.");
        System.out.println("-------------------------------------------------------------------");
        safeinput = false;
        while (safeinput==false){
            System.out.println(" ");
            System.out.println("MAIN MENU");
            System.out.println("---------------------------");
            System.out.println("1) Sistem Persamaaan Linier");
            System.out.println("2) Determinan");
            System.out.println("3) Matriks balikan");
            System.out.println("4) Interpolasi Polinom");
            System.out.println("5) Interpolasi Bicubic Spline");
            System.out.println("6) Regresi Linear Berganda");
            System.out.println("7) Keluar");
            System.out.print("--> ");
            userInput = in.nextInt();

            if (userInput==1){  // SPL
                System.out.println("Choose method:");
                System.out.println("---------------------------");
                System.out.println("1) Metode Eliminasi Gauss");
                System.out.println("2) Metode Eliminasi Gauss-Jordan");
                System.out.println("3) Metode Matriks Balikan/Invers");
                System.out.println("4) Kaidah Cramer");
                System.out.print("--> ");
                userInput = in.nextInt();

                if (userInput==1){
                    safeinput=true;
                }
                else if (userInput==2){
                    safeinput=true;
                }
                else if (userInput==3){
                    safeinput=true;
                    
                }
                else if (userInput==4){
                    System.out.println("Choose input method:");
                    System.out.println("---------------------------");
                    System.out.println("1) Keyboard");
                    System.out.println("2) Read Text File");
                    safeinput = false;
                    while (safeinput==false){
                        System.out.print("--> ");
                        userInput = in.nextInt();
                        
                        if (userInput==1){  // KEYBOARD
                            safeinput=true;
                            //Take input from user keyboard
                            System.out.println("Berapa ukuran baris dan kolom matriks?");
                            System.out.print("Row: ");
                            int row = in.nextInt();
                            System.out.print("Col: ");
                            int col = in.nextInt();
                            // in.close();
                            //main matrix (from user input)
                            Matriks mainmatrix = new Matriks(row,col);
                            mainmatrix.readMatrix();
            
                        }
                        else if (userInput==2){ // FILE
    
                            safeinput=true;
                        }
                        else{   // user enters other inputs
                            System.out.println("False input code, please try again.");
                        }
                    }
                    safeinput=true;
                }
                else{
                    System.out.println("False input code, please try again.");
                }
                safeinput = false;
                while (safeinput==false){
                    
                }
                
            }
            else if (userInput==2){ // DETERMINAN
                safeinput=true;
            }
            else if (userInput==3){
                safeinput=true;
            }
            else if (userInput==4){
                safeinput=true;
            }
            else if (userInput==5){
                safeinput=true;
            }
            else if (userInput==6){
                safeinput=true;
            }
            else if (userInput==7){
                break;
            }
            else {
                System.out.println("False input code, please try again.");
            }
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Thank You for Trying Our Program :)");
        System.out.println("Have a nice day!");
    }
}
