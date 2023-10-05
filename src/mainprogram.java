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
        determinan dt = new determinan();
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
                            gauss gs = new gauss();
                   
                            Matriks mainmatrix = new Matriks(row,col);
                            mainmatrix.readMatrix();
                            mainmatrix.displayMatrix();
                            double[] hasil = new double[mainmatrix.nCols-1];
                            hasil = gs.splgaus(mainmatrix,false);
                            mainmatrix.displayMatrix();

                            System.out.println("Do you want to save it in txt file?");
                            System.out.println("1) Yes");
                            System.out.println("2) No");
                            int opt = 0;
                            
                            while (true) {
                                System.out.print("--> ");
                                if (in.hasNextInt()) {
                                    opt = in.nextInt();
                                    break; // Exit the loop when valid input is received
                                } else {
                                    // Handle the case where the input is not an integer
                                    System.out.println("Invalid input. Please enter an integer.");
                                    in.nextLine(); // Consume the invalid input
                                }
                            }
                            // Handle the error or exit the program gracefully
                             Matriks ms = new Matriks(mainmatrix.nRows, mainmatrix.nCols-1);
                            for(i=0;i<mainmatrix.nRows;i++){
                                for(int j=0;j<mainmatrix.nCols-1;j++){
                                    ms.mat[i][j] = mainmatrix.mat[i][j];
                                }
                            }
                            determinan dter = new determinan();
                            if (opt == 1) {
                                if(dter.detgaus(ms)!=0){
                                System.out.print("Enter the file name in test folder without '.txt': ");
                                String name = in.next();
                                mainmatrix.simpanSPL3(name, hasil);
                                }
                                else{
                                gs.splgaus(mainmatrix,true);
                                }
                            }
                            safeinput1=true;
                            
                            
                        }
                        else if (userInput==2){ // FILE
                            Matriks mAwal = new Matriks(0,0);
                            System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                            String name = sc.next();
                            mAwal.openMatrix(name);
                            mAwal.displayMatrix();
                            gauss gs = new gauss();
                            double[] hasil = new double[mAwal.nCols-1];
                            hasil = gs.splgaus(mAwal,false);
                            System.out.println("Do you want to save it in txt file?");
                            System.out.println("1) Yes");
                            System.out.println("2) No");
                            in.nextLine();
                            int opt = 0;
                            
                            while (true) {
                                System.out.print("--> ");
                                if (in.hasNextInt()) {
                                    opt = in.nextInt();
                                    break; // Exit the loop when valid input is received
                                } else {
                                    // Handle the case where the input is not an integer
                                    System.out.println("Invalid input. Please enter an integer.");
                                    in.nextLine(); // Consume the invalid input
                                }
                            }
                                // Handle the error or exit the program gracefully
                             Matriks ms = new Matriks(mAwal.nRows, mAwal.nCols-1);
                            for(i=0;i<mAwal.nRows;i++){
                                for(int j=0;j<mAwal.nCols-1;j++){
                                    ms.mat[i][j] = mAwal.mat[i][j];
                                }
                            }
                            determinan dter = new determinan();
                            if (opt == 1) {
                                if(dter.detgaus(ms)!=0){
                                System.out.print("Enter the file name in test folder without '.txt': ");
                                name = in.next();
                                mAwal.simpanSPL3(name, hasil);
                                }
                                else{
                                gs.splgaus(mAwal,true);
                                }
                            }

                            safeinput1=true;
                        
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
                        Scanner sc = new Scanner(System.in);
                        if (userInput==1){  // KEYBOARD
                            safeinput1=true;
                            //Take input from user keyboard
                            System.out.println("Berapa ukuran baris dan kolom matriks?");
                            System.out.print("Row: ");
                            int row = sc.nextInt();
                            System.out.print("Col: ");
                            int col = sc.nextInt();
                            GaussJordan gsj = new GaussJordan();
                   
                            Matriks mainmatrix = new Matriks(row,col);
                            mainmatrix.readMatrix();
                            mainmatrix.displayMatrix();
                            double[] hasil = new double[mainmatrix.nCols-1];
                            hasil = gsj.splgaussjordan(mainmatrix,false);
                            mainmatrix.displayMatrix();

                            System.out.println("Do you want to save it in txt file?");
                            System.out.println("1) Yes");
                            System.out.println("2) No");
                            int opt = 0;
                            
                            while (true) {
                                System.out.print("--> ");
                                if (in.hasNextInt()) {
                                    opt = in.nextInt();
                                    break; // Exit the loop when valid input is received
                                } else {
                                    // Handle the case where the input is not an integer
                                    System.out.println("Invalid input. Please enter an integer.");
                                    in.nextLine(); // Consume the invalid input
                                }
                            }
                             Matriks ms = new Matriks(mainmatrix.nRows, mainmatrix.nCols-1);
                            for(i=0;i<mainmatrix.nRows;i++){
                                for(int j=0;j<mainmatrix.nCols-1;j++){
                                    ms.mat[i][j] = mainmatrix.mat[i][j];
                                }
                            }
                            determinan dter = new determinan();
                            if (opt == 1) {
                                if(dter.detgaus(ms)!=0){
                                System.out.print("Enter the file name in test folder without '.txt': ");
                                String name = in.next();
                                mainmatrix.simpanSPL3(name, hasil);
                                }
                                else{
                                gsj.splgaussjordan(mainmatrix,true);
                                }
                            }

                            safeinput1=true;
                            
                            
                        }
                        else if (userInput==2){ // FILE
                            Matriks mAwal = new Matriks(0,0);
                            System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                            String name = sc.next();
                            mAwal.openMatrix(name);
                            mAwal.displayMatrix();
                            GaussJordan gsj = new GaussJordan();
                            double[] hasil = new double[mAwal.nCols-1];
                            hasil = gsj.splgaussjordan(mAwal,false);
                            System.out.println("Do you want to save it in txt file?");
                            System.out.println("1) Yes");
                            System.out.println("2) No");
                            in.nextLine();
                            int opt = 0;
                            
                            while (true) {
                                System.out.print("--> ");
                                if (in.hasNextInt()) {
                                    opt = in.nextInt();
                                    break; // Exit the loop when valid input is received
                                } else {
                                    // Handle the case where the input is not an integer
                                    System.out.println("Invalid input. Please enter an integer.");
                                    in.nextLine(); // Consume the invalid input
                                }
                            }
                                // Handle the error or exit the program gracefully
                            Matriks ms = new Matriks(mAwal.nRows, mAwal.nCols-1);
                            for(i=0;i<mAwal.nRows;i++){
                                for(int j=0;j<mAwal.nCols-1;j++){
                                    ms.mat[i][j] = mAwal.mat[i][j];
                                }
                            }
                            determinan dter = new determinan();
                            if (opt == 1) {
                                if(dter.detgaus(ms)!=0){
                                System.out.print("Enter the file name in test folder without '.txt': ");
                                name = in.next();
                                mAwal.simpanSPL3(name, hasil);
                                }
                                else{
                                gsj.splgaussjordan(mAwal,true);
                                }
                            }

                            safeinput1=true;
                        
                    }
                    }
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
                            Matriks mainmatrix2 = new Matriks(mainmatrix.getLastIdxRow()+1,mainmatrix.getLastIdxCol());
                            for (i=0;i<mainmatrix.getLastIdxRow()+1;i++){
                                for (int j = 0;j<mainmatrix.getLastIdxCol();j++){
                                    mainmatrix2.mat[i][j] = mainmatrix.mat[i][j];
                                }
                            }

                            //Verify first if it's a square matrix
                            if (row != col-1){
                                System.out.println("Tidak bisa diselesaikan dengan Invers, bukan matriks persegi");
                                break;
                            }
                            else if(dt.detgaus(mainmatrix2)==0){
                                System.out.println("Tidak bisa diselesaikan dengan Invers");
                                break;
                            }
                            else{
                                Matriks hasil = new Matriks(1, 1);
                                splinvers spl = new splinvers();
                                hasil = spl.hasilsplinvers(mainmatrix);
                                System.out.println("Do you want to save it in txt file?");
                                System.out.println("1) Yes");
                                System.out.println("2) No");
                                int opt = 0;
                                
                                while (true) {
                                    System.out.print("--> ");
                                    if (in.hasNextInt()) {
                                        opt = in.nextInt();
                                        break; // Exit the loop when valid input is received
                                    } else {
                                        // Handle the case where the input is not an integer
                                        System.out.println("Invalid input. Please enter an integer.");
                                        in.nextLine(); // Consume the invalid input
                                    }
                                }
                                    // Handle the error or exit the program gracefully
                                if (opt == 1) {
                                System.out.print("Enter the file name in test folder without '.txt': ");
                                String name = in.next();
                                hasil.simpanSPL(name, hasil);
                                }
    
                                safeinput1=true;
                            }
                            
                        }
                        else if (userInput==2){ // FILE
                            Matriks mAwal = new Matriks(0,0);
                            System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                            String name = sc.next();
                            mAwal.openMatrix(name);
                            System.out.print("berhasil");
                            mAwal.displayMatrix();
                            Matriks mainmatrix = new Matriks(mAwal.getLastIdxRow()+1,mAwal.getLastIdxCol());
                            for (i=0;i<mAwal.getLastIdxRow()+1;i++){
                                for (int j = 0;j<mAwal.getLastIdxCol();j++){
                                    mainmatrix.mat[i][j] = mAwal.mat[i][j];
                                }
                            }
                            if( mainmatrix.nCols != mainmatrix.nRows||dt.detgaus(mainmatrix)==0){
                                System.out.println("Tidak bisa diselesaikan dengan Invers");
                                break;
                            }
                            else{
                            splinvers spl = new splinvers();
                            Matriks hasil = new Matriks(1, 1);
                            hasil = spl.hasilsplinvers(mAwal);
                            System.out.println("Do you want to save it in txt file?");
                            System.out.println("1) Yes");
                            System.out.println("2) No");
                            in.nextLine();
                            int opt = 0;
                            
                            while (true) {
                                System.out.print("--> ");
                                if (in.hasNextInt()) {
                                    opt = in.nextInt();
                                    break; // Exit the loop when valid input is received
                                } else {
                                    // Handle the case where the input is not an integer
                                    System.out.println("Invalid input. Please enter an integer.");
                                    in.nextLine(); // Consume the invalid input
                                }
                            }
                                // Handle the error or exit the program gracefully
                            if (opt == 1) {
                                System.out.print("Enter the file name in test folder without '.txt': ");
                                name = in.next();
                                hasil.simpanSPL(name, hasil);
                            }

                            safeinput1=true;
                        }
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
                            Matriks mainmatrix2 = new Matriks(mainmatrix.getLastIdxRow()+1,mainmatrix.getLastIdxCol());
                            for (i=0;i<mainmatrix.getLastIdxRow()+1;i++){
                                for (int j = 0;j<mainmatrix.getLastIdxCol();j++){
                                    mainmatrix2.mat[i][j] = mainmatrix.mat[i][j];
                                }
                            }

                            //Verify first if it's a square matrix
                            if (row != col-1){
                                System.out.println("Tidak bisa diselesaikan dengan Cramer, bukan matriks persegi");
                                break;
                            }
                            else if(dt.detgaus(mainmatrix2)==0){
                                System.out.println("Tidak bisa diselesaikan dengan Cramer");
                                break;
                            }
                            else{
                                //Read the cramer function
                                float[] hasil = new float[col-1];
                                testCramer tes = new testCramer();
                                hasil= tes.testcramer(mainmatrix);
                                System.out.println("Do you want to save it in txt file?");
                                System.out.println("1) Yes");
                                System.out.println("2) No");
                                int opt = 0;
                                
                                while (true) {
                                    System.out.print("--> ");
                                    if (in.hasNextInt()) {
                                        opt = in.nextInt();
                                        break; // Exit the loop when valid input is received
                                    } else {
                                        // Handle the case where the input is not an integer
                                        System.out.println("Invalid input. Please enter an integer.");
                                        in.nextLine(); // Consume the invalid input
                                    }
                                }
                                    // Handle the error or exit the program gracefully
                                if (opt == 1) {
                                System.out.print("Enter the file name in test folder without '.txt': ");
                                String name = in.next();
                                mainmatrix.simpanSPL2(name, hasil);
                                }
    
                                safeinput1=true;
                            }
                            
                        }
                        else if (userInput==2){ // FILE
                            Scanner sc = new Scanner(System.in);
                            Matriks mAwal = new Matriks(0,0);
                            System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                            String name = sc.next();
                            mAwal.openMatrix(name);
                            mAwal.displayMatrix();
                            Matriks mainmatrix = new Matriks(mAwal.getLastIdxRow()+1,mAwal.getLastIdxCol());
                            for (i=0;i<mAwal.getLastIdxRow()+1;i++){
                                for (int j = 0;j<mAwal.getLastIdxCol();j++){
                                    mainmatrix.mat[i][j] = mAwal.mat[i][j];
                                }
                            }
                            if( mainmatrix.nCols != mainmatrix.nRows||dt.detgaus(mainmatrix)==0){
                                System.out.println("Tidak bisa diselesaikan dengan Cramer");
                                break;
                            }
                            else{
                            testCramer tes = new testCramer();
                            float[] hasil = new float[mAwal.nCols-1];
                            hasil= tes.testcramer(mAwal);
                            System.out.println("Do you want to save it in txt file?");
                            System.out.println("1) Yes");
                            System.out.println("2) No");
                            in.nextLine();
                            int opt = 0;
                            
                            while (true) {
                                System.out.print("--> ");
                                if (in.hasNextInt()) {
                                    opt = in.nextInt();
                                    break; // Exit the loop when valid input is received
                                } else {
                                    // Handle the case where the input is not an integer
                                    System.out.println("Invalid input. Please enter an integer.");
                                    in.nextLine(); // Consume the invalid input
                                }
                            }
                                // Handle the error or exit the program gracefully
                            if (opt == 1) {
                                System.out.print("Enter the file name in test folder without '.txt': ");
                                name = in.next();
                                mAwal.simpanSPL2(name, hasil);
                            }

                            safeinput1=true;
                        }
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
                                System.out.println("Do you want to save it in txt file?");
                                System.out.println("1) Yes");
                                System.out.println("2) No");
                                int opt = 0;
                                
                                while (true) {
                                    System.out.print("--> ");
                                    if (in.hasNextInt()) {
                                        opt = in.nextInt();
                                        break; // Exit the loop when valid input is received
                                    } else {
                                        // Handle the case where the input is not an integer
                                        System.out.println("Invalid input. Please enter an integer.");
                                        in.nextLine(); // Consume the invalid input
                                    }
                                }
                                    // Handle the error or exit the program gracefully
                                if (opt == 1) {
                                System.out.print("Enter the file name in test folder without '.txt': ");
                                String name = in.next();
                                mainmatrix.simpanDeter(name, det);
                                }
    
                                safeinput1=true;
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
                            System.out.println("Do you want to save it in txt file?");
                            System.out.println("1) Yes");
                            System.out.println("2) No");
                            int opt = 0;
                            
                            while (true) {
                                System.out.print("--> ");
                                if (in.hasNextInt()) {
                                    opt = in.nextInt();
                                    break; // Exit the loop when valid input is received
                                } else {
                                    // Handle the case where the input is not an integer
                                    System.out.println("Invalid input. Please enter an integer.");
                                    in.nextLine(); // Consume the invalid input
                                }
                            }
                                // Handle the error or exit the program gracefully
                            if (opt == 1) {
                            System.out.print("Enter the file name in test folder without '.txt': ");
                            name = in.next();
                            mAwal.simpanDeter(name, det);
                            }

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
                                System.out.println("Do you want to save it in txt file?");
                                System.out.println("1) Yes");
                                System.out.println("2) No");
                                int opt = 0;
                                
                                while (true) {
                                    System.out.print("--> ");
                                    if (in.hasNextInt()) {
                                        opt = in.nextInt();
                                        break; // Exit the loop when valid input is received
                                    } else {
                                        // Handle the case where the input is not an integer
                                        System.out.println("Invalid input. Please enter an integer.");
                                        in.nextLine(); // Consume the invalid input
                                    }
                                }
                                    // Handle the error or exit the program gracefully
                                if (opt == 1) {
                                System.out.print("Enter the file name in test folder without '.txt': ");
                                String name = in.next();
                                mainmatrix.simpanDeter(name, det);
                                }
    
                                safeinput1=true;
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
                            System.out.println("Do you want to save it in txt file?");
                                System.out.println("1) Yes");
                                System.out.println("2) No");
                                int opt = 0;
                                
                                while (true) {
                                    System.out.print("--> ");
                                    if (in.hasNextInt()) {
                                        opt = in.nextInt();
                                        break; // Exit the loop when valid input is received
                                    } else {
                                        // Handle the case where the input is not an integer
                                        System.out.println("Invalid input. Please enter an integer.");
                                        in.nextLine(); // Consume the invalid input
                                    }
                                }
                                    // Handle the error or exit the program gracefully
                                if (opt == 1) {
                                System.out.print("Enter the file name in test folder without '.txt': ");
                                 name = in.next();
                                mAwal.simpanDeter(name, det);
                                }
    
                                safeinput1=true;
                            }
                        else{   // user enters other inputs
                            System.out.println("False input code, please try again.");
                        }
                            }
                            safeinput=true;
                        }
                safeinput = false;
            }
            else if (mainmenu==3){ // INVERS
                System.out.println("Choose method:");
                System.out.println("---------------------------");
                System.out.println("1) Metode Matriks Balikan");
                System.out.println("2) Metode Adjoint");
                System.out.print("--> ");
                userInput = in.nextInt();
                if (userInput==1){ //Invers matriks balikan
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
                            testInversGauss invi = new testInversGauss();
                            mainmatrix= invi.invergauss(mainmatrix);
                            System.out.println("Do you want to save it in txt file?");
                            System.out.println("1) Yes");
                            System.out.println("2) No");
                            int opt = 0;
                            
                            while (true) {
                                System.out.print("--> ");
                                if (in.hasNextInt()) {
                                    opt = in.nextInt();
                                    break; // Exit the loop when valid input is received
                                } else {
                                    // Handle the case where the input is not an integer
                                    System.out.println("Invalid input. Please enter an integer.");
                                    in.nextLine(); // Consume the invalid input
                                }
                            }
                                // Handle the error or exit the program gracefully
                            if (opt == 1) {
                            System.out.print("Enter the file name in test folder without '.txt': ");
                            String name = in.next();
                            mainmatrix.simpanMatrix(name, mainmatrix);
                            }

                            safeinput1=true;
                            
                        }
                    }
                    else if (userInput==2){ // FILE
                        Scanner sc = new Scanner(System.in);
                        Matriks mAwal = new Matriks(0,0);
                        System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                        String name = sc.next();
                        mAwal.openMatrix(name);
                        mAwal.displayMatrix();
                        testInversGauss invi = new testInversGauss();
                        mAwal= invi.invergauss(mAwal);
                        System.out.println("Do you want to save it in txt file?");
                        System.out.println("1) Yes");
                        System.out.println("2) No");
                        int opt = 0;
                        while (true) {
                            System.out.print("--> ");
                            if (in.hasNextInt()) {
                                opt = in.nextInt();
                                break; // Exit the loop when valid input is received
                            } else {
                                // Handle the case where the input is not an integer
                                System.out.println("Invalid input. Please enter an integer.");
                                in.nextLine(); // Consume the invalid input
                            }
                        }
                            // Handle the error or exit the program gracefully
                        if (opt == 1) {
                        System.out.print("Enter the file name in test folder without '.txt': ");
                        name = in.next();
                        mAwal.simpanMatrix(name, mAwal);
                        }
                        safeinput1=true;
                    }
                    else{   // user enters other inputs
                        System.out.println("False input code, please try again.");
                    }
                        }
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
                            System.out.println("Matriks Invers: ");
                            mainmatrix.displayMatrix();
                            System.out.println("Do you want to save it in txt file?");
                            System.out.println("1) Yes");
                            System.out.println("2) No");
                            int opt = 0;
                            
                            while (true) {
                                System.out.print("--> ");
                                if (in.hasNextInt()) {
                                    opt = in.nextInt();
                                    break; // Exit the loop when valid input is received
                                } else {
                                    // Handle the case where the input is not an integer
                                    System.out.println("Invalid input. Please enter an integer.");
                                    in.nextLine(); // Consume the invalid input
                                }
                            }
                                // Handle the error or exit the program gracefully
                            if (opt == 1) {
                            System.out.print("Enter the file name in test folder without '.txt': ");
                            String name = in.next();
                            mainmatrix.simpanMatrix(name, mainmatrix);
                            }

                            safeinput1=true;
                            
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
                        System.out.println("Matriks Invers: ");
                        mAwal.displayMatrix();
                        System.out.println("Do you want to save it in txt file?");
                        System.out.println("1) Yes");
                        System.out.println("2) No");
                        int opt = 0;
                        while (true) {
                            System.out.print("--> ");
                            if (in.hasNextInt()) {
                                opt = in.nextInt();
                                break; // Exit the loop when valid input is received
                            } else {
                                // Handle the case where the input is not an integer
                                System.out.println("Invalid input. Please enter an integer.");
                                in.nextLine(); // Consume the invalid input
                            }
                        }
                            // Handle the error or exit the program gracefully
                        if (opt == 1) {
                        System.out.print("Enter the file name in test folder without '.txt': ");
                        name = in.next();
                        mAwal.simpanMatrix(name, mAwal);
                        }
                        safeinput1=true;
                    }
                    else{   // user enters other inputs
                        System.out.println("False input code, please try again.");
                    }
                        }
                        safeinput=true;
                    }
                    safeinput = false;
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
                                    mainmatrix.mat[i][kolom] = res;
                                }
                                else{   // is the b column
                                    mainmatrix.mat[i][kolom] = y;
                                }
                            }
                        }
                        System.out.println("");
                        System.out.println("Nilai inputan X?");
                        System.out.print("--> ");
                        double X = in.nextDouble();

                        //Read the interpolasipolinomial funtion
                        InterpolasiPolinomial tes = new InterpolasiPolinomial();
                        tes.interpolasipolinomial(mainmatrix,X,false);

                        // save to txt file
                        System.out.println("Do you want to save it in txt file?");
                        System.out.println("1) Yes");
                        System.out.println("2) No");
                        int opt = 0;
                        
                        while (true) {
                            System.out.print("--> ");
                            if (in.hasNextInt()) {
                                opt = in.nextInt();
                                break; // Exit the loop when valid input is received
                            } else {
                                // Handle the case where the input is not an integer
                                System.out.println("Invalid input. Please enter an integer.");
                                in.nextLine(); // Consume the invalid input
                            }
                        }
                    
                        if (opt == 1) {
                        tes.interpolasipolinomial(mainmatrix,X,true);
                        }
                        
                    }
                    else if (userInput==2){ // FILE
                        Scanner sc = new Scanner(System.in);
                        Matriks mainmatriks = new Matriks(0,0);
                        double[] var = new double[1];
                        System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                        String name = sc.next();
                        var = mainmatriks.openMatrix3(name,1);
                        mainmatriks.displayMatrix();
                        Matriks mainmatrix = new Matriks(mainmatriks.nRows,mainmatriks.nRows+1);
                        for (i=0;i<mainmatriks.nRows;i++){
                            for ( kolom = 0;kolom<mainmatriks.nRows+1;kolom++){
                                if (kolom!=mainmatriks.nRows){  //those Ax columns
                                    double res = Math.pow(mainmatriks.mat[i][0],kolom);
                                    mainmatrix.mat[i][kolom] = res;
                                }
                                else{   // is the b column
                                    mainmatrix.mat[i][kolom] = mainmatriks.mat[i][1];
                                }
                            }
                        }
                        //Read the interpolasipolinomial funtion
                        InterpolasiPolinomial tes = new InterpolasiPolinomial();
                        tes.interpolasipolinomial(mainmatrix,var[0],false);

                        // save to txt file
                        System.out.println("Do you want to save it in txt file?");
                        System.out.println("1) Yes");
                        System.out.println("2) No");
                        int opt = 0;
                        
                        while (true) {
                            System.out.print("--> ");
                            if (in.hasNextInt()) {
                                opt = in.nextInt();
                                break; // Exit the loop when valid input is received
                            } else {
                                // Handle the case where the input is not an integer
                                System.out.println("Invalid input. Please enter an integer.");
                                in.nextLine(); // Consume the invalid input
                            }
                        }
                           
                        if (opt == 1) {
                        tes.interpolasipolinomial(mainmatrix,var[0],true);
                        }

                        safeinput1=true;
                    }
                    else{   // user enters other inputs
                        System.out.println("False input code, please try again.");
                    }
                }
                safeinput=false;

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
                        bi.hasilbicubic(main,x,y,false);
                        // save to txt file
                        System.out.println("Do you want to save it in txt file?");
                        System.out.println("1) Yes");
                        System.out.println("2) No");
                        int opt = 0;
                        
                        while (true) {
                            System.out.print("--> ");
                            if (in.hasNextInt()) {
                                opt = in.nextInt();
                                break; // Exit the loop when valid input is received
                            } else {
                                // Handle the case where the input is not an integer
                                System.out.println("Invalid input. Please enter an integer.");
                                in.nextLine(); // Consume the invalid input
                            }
                        }
                            
                        if (opt == 1) {
                            bi.hasilbicubic(main,x,y,true);
                        }

                    }
                    else if (userInput==2){ // FILE
                        Scanner sc = new Scanner(System.in);
                        Matriks mAwal = new Matriks(0,0);
                        double[] var = new double[2];
                        System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                        String name = sc.next();
                        var = mAwal.openMatrix2(name,2);
                        mAwal.displayMatrix();
                        bi.hasilbicubic(mAwal,var[0],var[1],false);
                        // save to txt file
                        System.out.println("Do you want to save it in txt file?");
                        System.out.println("1) Yes");
                        System.out.println("2) No");
                        int opt = 0;
                        
                        while (true) {
                            System.out.print("--> ");
                            if (in.hasNextInt()) {
                                opt = in.nextInt();
                                break; // Exit the loop when valid input is received
                            } else {
                                // Handle the case where the input is not an integer
                                System.out.println("Invalid input. Please enter an integer.");
                                in.nextLine(); // Consume the invalid input
                            }
                        }
                            
                        if (opt == 1) {
                            bi.hasilbicubic(mAwal,var[0],var[1],true);
                        }
                        safeinput1=true;
                    }
                    else{   // user enters other inputs
                        System.out.println("False input code, please try again.");
                    }
                }
                    safeinput=false;
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
                        
                        //input datamain
                        System.out.println("Input matrix:");
                        System.out.println("*Input format x1 | x2 | x.. | y ");
                        Matriks datamain = new Matriks(sampel, var);
                        datamain.readMatrix();
                        
                        //taking input X
                        System.out.println("");
                        System.out.println("Nilai inputan X?");
                        double[] X = new double[var-1];
                        for (i=0;i<var-1;i++){
                            System.out.print("Nilai X" + i + ": ");
                            X[i] = in.nextDouble();
                        }
                        System.out.println("");
                        
                        Regresi tes = new Regresi();
                        tes.regresi(datamain,sampel,var,X,false);
                        // save to txt file
                        System.out.println(" ");
                        System.out.println("Do you want to save it in txt file?");
                        System.out.println("1) Yes");
                        System.out.println("2) No");
                        int opt = 0;
                        
                        while (true) {
                            System.out.print("--> ");
                            if (in.hasNextInt()) {
                                opt = in.nextInt();
                                break; // Exit the loop when valid input is received
                            } else {
                                // Handle the case where the input is not an integer
                                System.out.println("Invalid input. Please enter an integer.");
                                in.nextLine(); // Consume the invalid input
                            }
                        }
                        
                        if (opt == 1) {
                            tes.regresi(datamain,sampel,var,X,true);
                        }
                        
                        
                    }
                    else if (userInput==2){ //FILE
                        safeinput1=true;
                        Scanner sc = new Scanner(System.in);
                        Matriks datamain = new Matriks(0,0);
                        System.out.print("Masukkan nama file pada folder test tanpa '.txt': ");
                        String name = sc.next();
                        datamain.openMatrix4(name);
                        datamain.displayMatrix();
                        
                        //BACA NILAI MASUKAN
                        Matriks datamain2 = new Matriks(datamain.nRows-1,datamain.nCols);
                        for (i=0;i<datamain.nRows-1;i++){
                            for (int j=0; j<datamain.nCols;j++){
                                datamain2.mat[i][j] = datamain.mat[i][j];
                            }
                        }
                        double[] X = new double[datamain.getLastIdxCol()];
                        for (i=0;i<datamain.getLastIdxCol();i++){
                            X[i] = datamain.mat[datamain.nRows-1][i];
                        }
                        Regresi tes = new Regresi();
                        tes.regresi(datamain2,datamain.getLastIdxRow(),datamain.getLastIdxCol()+1,X,false);
                        // save to txt file
                        System.out.println(" ");
                        System.out.println("Do you want to save it in txt file?");
                        System.out.println("1) Yes");
                        System.out.println("2) No");
                        int opt = 0;
                        
                        while (true) {
                            System.out.print("--> ");
                            if (in.hasNextInt()) {
                                opt = in.nextInt();
                                break; // Exit the loop when valid input is received
                            } else {
                                // Handle the case where the input is not an integer
                                System.out.println("Invalid input. Please enter an integer.");
                                in.nextLine(); // Consume the invalid input
                            }
                        }
                    
                        if (opt == 1) {
                            tes.regresi(datamain2,datamain.getLastIdxRow(),datamain.getLastIdxCol()+1,X,true);
                        }
                        System.out.println("done");
                        

                    }
                    else{   // user enters other inputs
                        System.out.println("False input code, please try again.");
                    }
                }

                safeinput=false;
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
