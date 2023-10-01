//import java.util.*;
//import java.io.*;
import java.util.*;

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
                        Scanner sc = new Scanner(System.in);
                        if (userInput==1){  // KEYBOARD
                            safeinput1=true;
                            //Take input from user keyboard
                            System.out.println("Berapa ukuran baris dan kolom matriks?");
                            System.out.print("Row: ");
                            int row = sc.nextInt();
                            System.out.print("Col: ");
                            int col = sc.nextInt();
                            //main matrix (from user input)
                            Matriks mainmatrix = new Matriks(row,col);
                            mainmatrix.readMatrix();


                            //Verify first if it's a square matrix
                            if (row != col-1){
                                System.out.println("Tidak bisa diselesaikan dengan Invers, bukan matriks persegi");
                            }
                            else{
                                Matriks hasil = new Matriks(1, 1);
                                splinvers spl = new splinvers();
                                spl.hasilsplinvers(mainmatrix);
                            }
                            
                        }
                        else if (userInput==2){ // FILE
                            Matriks mAwal = new Matriks(0,0);
                            System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                            String name = sc.next();
                            mAwal.openMatrix(name);
                            mAwal.displayMatrix();
                            splinvers spl = new splinvers();
                            spl.hasilsplinvers(mAwal);
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
                            }
                        }
                        else if (userInput==2){ // FILE
                            Scanner sc = new Scanner(System.in);
                            Matriks mAwal = new Matriks(0,0);
                            System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                            String name = sc.next();
                            mAwal.openMatrix(name);
                            mAwal.displayMatrix();
                            testCramer tes = new testCramer();
                            tes.testcramer(mAwal);
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
                            }
                        }

                        else if (userInput==2){ // FILE
                            safeinput1=true;
                            Scanner sc = new Scanner(System.in);
                            Matriks mAwal = new Matriks(0,0);
                            System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                            String name = sc.next();
                            mAwal.openMatrix(name);
                            mAwal.displayMatrix();
                            determinan deter = new determinan();
                            float det = deter.detgaus(mAwal);
                            System.out.println("Determinan: " + det);
                        
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
                            }
                        }
                        else if (userInput==2){ // FILE
                            safeinput1=true;
                            Scanner sc = new Scanner(System.in);
                            Matriks mAwal = new Matriks(0,0);
                            System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                            String name = sc.next();
                            mAwal.openMatrix(name);
                            mAwal.displayMatrix();
                            float det = mAwal.determinant();
                            System.out.println("Determinan: " + det);
                            
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
                if (userInput==1){ //Invers matriks balikan
                    
                    safeinput=true;
                }
                else if (userInput==2){ //Invers Adjoin
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
                            }
                    }
                    else if (userInput==2){ // FILE
                        Scanner sc = new Scanner(System.in);
                        Matriks mAwal = new Matriks(0,0);
                        System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                        String name = sc.next();
                        mAwal.openMatrix(name);
                        mAwal.displayMatrix();
                        invers inv = new invers();
                        inv.inversadj(mAwal);
                        System.out.print("Hasil Invers");
                        mAwal.displayMatrix();
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
                        Scanner sc = new Scanner(System.in);
                        Matriks B = new Matriks(20, 20);
                        Matriks mainmatrix = new Matriks(0,0);
                        System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                        String name = sc.next();
                        mainmatrix.openMatrix(name);
                        B.nRows = mainmatrix.nRows;
                        mainmatrix.displayMatrix();
                        
                        //Read the interpolasipolinomial funtion
                        InterpolasiPolinomial tes = new InterpolasiPolinomial();
                        tes.interpolasipolinomial(mainmatrix);
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
                    double[][] A = new double[4][4];
                    double x = 0;
                    double y = 0;
                    bicubic bi = new bicubic();
                    Matriks main = new Matriks(4, 4);
                    if (userInput==1){  // KEYBOARD
                        safeinput1=true;
                        System.out.println("Masukkan Matriks");
                        for (int m = 0; m < 4; m++) {
                            for (int n = 0; n < 4; n++) {
                                A[m][n] = in.nextDouble();
                            }
                        }
                        for (int m = 0; m < 4; m++) {
                            for (int n = 0; n < 4; n++) {
                                main.mat[m][n] =  A[m][n];
                            }
                        }
                        // Masukkan titik yang ingin dianalisis
                        System.out.println("Masukkan nilai x dan y");
                        x = in.nextDouble();
                        y = in.nextDouble();
                        bi.hasilbicubic(main,x,y);

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
            else if (mainmenu==6){ // REGRESI LINEAR GANDA
                System.out.println("Choose input method:");
                System.out.println("---------------------------");
                System.out.println("1) Keyboard");
                System.out.println("2) Read Text File");
                safeinput1 = false;
                while (safeinput1==false){
                    System.out.print("--> ");
                    userInput = in.nextInt();
                    int var,sampel;

                    if (userInput==1){ //KEYBOARD
                        safeinput1=true;
                        //input variables and samples
                        System.out.println("Jumlah variable peubah x dan hasil y:");
                        System.out.print("--> ");
                        var = in.nextInt();
                        System.out.println("Jumlah sampel:");
                        System.out.print("--> ");
                        sampel = in.nextInt();
                        
                        //taking input X
                        //placed it here bcs it won't let me input it down below:
                        System.out.println("");
                        System.out.println("Nilai inputan X?");
                        System.out.print("--> ");
                        double X;
                        X = in.nextDouble();

                        //input datamain
                        System.out.println("Input matrix:");
                        System.out.println("*Input format x1 | x2 | x.. | y ");
                        Matriks datamain = new Matriks(sampel, var);
                        datamain.readMatrix();
                        

                        Regresi tes = new Regresi();
                        tes.regresi(datamain,sampel,var,X);

                    }
                    else if (userInput==2){ //FILE
                        safeinput1=true;
                        Scanner sc = new Scanner(System.in);
                        Matriks B = new Matriks(20, 20);
                        Matriks datamain = new Matriks(0,0);
                        System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                        String name = sc.next();
                        datamain.openMatrix(name);
                        B.nRows = datamain.nRows;
                        datamain.displayMatrix();
                        
                        //taking input X
                        //placed it here bcs it won't let me input it down below:
                        System.out.println("");
                        System.out.println("Nilai inputan X?");
                        System.out.print("--> ");
                        double X;
                        X = in.nextDouble();
                        
                        Regresi tes = new Regresi();
                        tes.regresi(datamain,datamain.getLastIdxRow()+1,datamain.getLastIdxCol()+1,X);
                    }
                    else{   // user enters other inputs
                        System.out.println("False input code, please try again.");
                    }
                }

                safeinput=true;
            }
            else if (mainmenu==7){ // EXIT PROGRAM
                break;
            }
            else { //user enters other input
                System.out.println("False input code, please try again.");
            }
        }
        //END OF PROGRAM
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Thank You for Trying Our Program :)");
        System.out.println("Have a nice day!");
    }
}
