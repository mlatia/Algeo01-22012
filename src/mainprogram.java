import java.util.*;
import java.io.*;

public class mainprogram {
    public static void main(String[] args){
        //KAMUS GLOBAL
        int baris,i,kolom;
        boolean safeinput,safeinput1,safeinput2;
        int userInput,mainmenu;

        //ALGORITMA
        Scanner in = new Scanner(System.in);
        System.out.println("                            WELCOME!");
        System.out.println(" ");
        System.out.println("*Please keep in mind to only type the number when choosing a menu.");
        System.out.println("-------------------------------------------------------------------");
        safeinput = false;
        safeinput1 = false;
        safeinput2 = false;
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
            mainmenu = in.nextInt();

            if (mainmenu==1){  // SPL
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
                    System.out.println("Choose input method:");
                    System.out.println("---------------------------");
                    System.out.println("1) Keyboard");
                    System.out.println("2) Read Text File");
                    safeinput1 = false;
                    while (safeinput1==false){
                        System.out.print("--> ");
                        userInput = in.nextInt();
                        if (userInput==1){  // KEYBOARD
                            safeinput1=true;
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

                            //Verify first if it's a square matrix
                            if (row != col-1){
                                System.out.println("Tidak bisa diselesaikan dengan Invers, bukan matriks persegi");
                            }
                            else{
                                splinvers spl = new splinvers();
                                spl.hasilsplinvers(mainmatrix);
                                System.out.println("done");
                            }
                        }
                        else if (userInput==2){ // FILE
    
                            safeinput1=true;
                        }
                    }
                    safeinput=true;
                    
                }
                else if (userInput==4){
                    System.out.println("Choose input method:");
                    System.out.println("---------------------------");
                    System.out.println("1) Keyboard");
                    System.out.println("2) Read Text File");
                    safeinput1 = false;
                    while (safeinput1==false){
                        System.out.print("--> ");
                        userInput = in.nextInt();
                        
                        if (userInput==1){  // KEYBOARD
                            safeinput1=true;
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

                            //Verify first if it's a square matrix
                            if (row != col-1){
                                System.out.println("Tidak bisa diselesaikan dengan Cramer, bukan matriks persegi");
                            }
                            else{
                                //Read the cramer funtion
                                testCramer tes = new testCramer();
                                tes.testcramer(mainmatrix);
                                System.out.println("done");
                            }
                        }
                        else if (userInput==2){ // FILE
    
                            safeinput1=true;
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
                
                
            }
            else if (mainmenu==2){ // DETERMINAN
                System.out.println("Choose method:");
                System.out.println("---------------------------");
                System.out.println("1) Metode Eliminasi Gauss");
                System.out.println("2) Metode Kofaktor");
                System.out.print("--> ");
                userInput = in.nextInt();
                if (userInput==1){
                    System.out.println("Choose input method:");
                    System.out.println("---------------------------");
                    System.out.println("1) Keyboard");
                    System.out.println("2) Read Text File");
                    safeinput1 = false;
                    while (safeinput1==false){
                        System.out.print("--> ");
                        userInput = in.nextInt();
                        
                        if (userInput==1){  // KEYBOARD
                            safeinput1=true;
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

                            //Verify first if it's a square matrix
                            if (row != col){
                                System.out.println("Tidak bisa diselesaikan, bukan matriks persegi");
                            }
                            else{
                                determinan deter = new determinan();
                                float det = deter.detgaus(mainmatrix);
                                System.out.println("Determinan: " + det);
                                System.out.println("done");
                            }
                        }
                        else if (userInput==2){ // FILE

                            safeinput1=true;
                        }
                        else{   // user enters other inputs
                            System.out.println("False input code, please try again.");
                        }
                    }
                        safeinput=true;
                }
                else if (userInput==2){
                    System.out.println("Choose input method:");
                    System.out.println("---------------------------");
                    System.out.println("1) Keyboard");
                    System.out.println("2) Read Text File");
                    safeinput1 = false;
                    while (safeinput1==false){
                        System.out.print("--> ");
                        userInput = in.nextInt();
                        
                        if (userInput==1){  // KEYBOARD
                            safeinput1=true;
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

                            //Verify first if it's a square matrix
                            if (row != col){
                                System.out.println("Tidak bisa diselesaikan, bukan matriks persegi");
                            }
                            else{
                                float det = mainmatrix.determinant();
                                System.out.println("Determinan: " + det);
                                System.out.println("done");
                            }
                        }
                        else if (userInput==2){ // FILE

                            safeinput1=true;
                        }
                        else{   // user enters other inputs
                            System.out.println("False input code, please try again.");
                        }
                            }
                            safeinput=true;
                        }
                
            }
            else if (mainmenu==3){ // INVERS
                System.out.println("Choose method:");
                System.out.println("---------------------------");
                System.out.println("1) Metode Matriks Balikan");
                System.out.println("2) Metode Adjoint");
                System.out.print("--> ");
                userInput = in.nextInt();
                if (userInput==1){
                    safeinput=true;
                }
                else if (userInput==2){
                System.out.println("Choose input method:");
                System.out.println("---------------------------");
                System.out.println("1) Keyboard");
                System.out.println("2) Read Text File");
                safeinput1 = false;
                while (safeinput1==false){
                    System.out.print("--> ");
                    userInput = in.nextInt();
                    
                    if (userInput==1){  // KEYBOARD
                        safeinput1=true;
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

                        //Verify first if it's a square matrix
                        if (row != col){
                            System.out.println("Tidak bisa diselesaikan, bukan matriks persegi");
                        }
                        else{
                            invers inv = new invers();
                            inv.inversadj(mainmatrix);
                            mainmatrix.displayMatrix();
                            System.out.println("done");
                        }
                    }
                    else if (userInput==2){ // FILE

                        safeinput1=true;
                    }
                    else{   // user enters other inputs
                        System.out.println("False input code, please try again.");
                    }
                        }
                        safeinput=true;
                    }
            }
            else if (mainmenu==4){ //INTERPOLASI POLINOM
                safeinput=true;
                System.out.println("Choose input method:");
                System.out.println("---------------------------");
                System.out.println("1) Keyboard");
                System.out.println("2) Read Text File");
                safeinput1 = false;
                while (safeinput1==false){
                    System.out.print("--> ");
                    userInput = in.nextInt();
                    
                    if (userInput==1){  // KEYBOARD
                        safeinput1=true;
                        //Take input from user keyboard
                        //read the sum of points
                        System.out.println("Jumlah titik inputan?");
                        System.out.print("--> ");
                        int titik = in.nextInt();
                        
                        //read the points while adjusting the matrix
                        Matriks mainmatrix = new Matriks(titik,titik+1);
                        System.out.println("Masukkan titik");
                        System.out.println("*Format masukan: x + 'space' + y");
                        System.out.println("---------------------------");
                        for (i=0;i<titik;i++){
                            System.out.print("Titik ke-" + (1+i) + ": ");
                            float x = in.nextFloat();
                            float y = in.nextFloat();
                            for (kolom = 0;kolom<titik+1;kolom++){
                                if (kolom!=titik){  //those Ax columns
                                    double res = Math.pow(x,kolom);
                                    mainmatrix.mat[i][kolom] = (float) res;
                                }
                                else{   // is the b column
                                    mainmatrix.mat[i][kolom] = y;
                                }
                            }
                        }

                        
                        //Read the interpolasipolinomial funtion
                        InterpolasiPolinomial tes = new InterpolasiPolinomial();
                        tes.interpolasipolinomial(mainmatrix);
                        
                    }
                    else if (userInput==2){ // FILE

                        safeinput1=true;
                    }
                    else{   // user enters other inputs
                        System.out.println("False input code, please try again.");
                    }
                }
                

            }
            else if (mainmenu==5){ // INTERPOLASI BICUBIC SPLINE
                System.out.println("Choose input method:");
                System.out.println("---------------------------");
                System.out.println("1) Keyboard");
                System.out.println("2) Read Text File");
                safeinput1 = false;
                while (safeinput1==false){
                    System.out.print("--> ");
                    userInput = in.nextInt();
                    
                    if (userInput==1){  // KEYBOARD
                        safeinput1=true;
                        Matriks m = new Matriks(4, 4);
                        m.readMatrix();
                        bicubic bi = new bicubic();
                        // Scanner sc = new Scanner(System.in);
                        double x = in.nextDouble();
                        double y = in.nextDouble();
                        bi.hasilbicubic(m,x,y)
;
                    }
                    else if (userInput==2){ // FILE

                        safeinput1=true;
                    }
                    else{   // user enters other inputs
                        System.out.println("False input code, please try again.");
                    }
                }

            }
            else if (mainmenu==6){ // REGRESI LINEAR GANDA
                safeinput=true;
                int var,sampel;
                System.out.println("Jumlah variable peubah x:");
                System.out.print("--> ");
                var = in.nextInt();
                System.out.println("Jumlah sampel:");
                System.out.print("--> ");
                sampel = in.nextInt();
                Matriks mainmatrix = new Matriks(sampel, var+1);
                for (baris=0;baris<sampel;baris++){
                    mainmatrix.mat[baris][0] = 1;
                }
                for (baris=0;baris<sampel;baris++){
                    for (kolom=1;kolom<var+1;kolom++){
                        double input = in.nextDouble();
                        
                        mainmatrix.mat[baris][kolom] = input;
                    }
                }


            }
            else if (mainmenu==7){ // EXIT PROGRAM
                break;
            }
            else {
                System.out.println("False input code, please try again.");
            }
        }
        //END OF PROGRAM
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Thank You for Trying Our Program :)");
        System.out.println("Have a nice day!");
    }
}
