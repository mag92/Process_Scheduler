/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Mido
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here   
        try (
            ServerSocket serverSocket = new ServerSocket(4444);
            Socket clientSocket = serverSocket.accept();
                PrintStream out = new PrintStream(clientSocket.getOutputStream(), true);
                Scanner z = new Scanner(clientSocket.getInputStream());
                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
                BufferedOutputStream os = new BufferedOutputStream(clientSocket.getOutputStream(), 1024); // ...
                PrintStream ps = new PrintStream(os, true);
                
            )
        {
            //int choice = z.nextInt();
            //System.out.println(choice);
            System.out.println("Waiting for client...");
            System.setOut(out);
            while (true)
            {                
            
            int choice = z.nextInt();
            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            mat = (ArrayList)ois.readObject();
            
           
                out.println("Server: " + mat);
                System.out.println(mat);            
                
                //FCFS
                ArrayList<Process> p = new ArrayList();
                Process[] x = new Process[mat.size()];
                ProcessPrio[] y = new ProcessPrio[mat.size()];
                ProcessArriv[] pa = new ProcessArriv[mat.size()];
                int b, a, pr;
                for (int i = 0; i < mat.size(); i++)
                {
                    b = mat.get(i).get(0); // BURST
                    a = mat.get(i).get(1); //arrival
                    pr = mat.get(i).get(2); // priority
                    //p.add(new Process(b, a, pr));
                    x[i] = new Process(b, a, pr, i);
                    y[i] = new ProcessPrio(b, a, pr, i);
                    pa[i] = new ProcessArriv(b, a, pr, i);
                }
                // 1 fcfs
            // 2 sjf pre
            // 3 sjf non-pre
            // 4 prio pre
            // 5 prio non pre
            // 6 multi
                switch(choice)
                {
                    case 1:
                        FCFS fcfs = new FCFS(x);
                        //fcfs.print();
                        break;
                    case 2:
                        SJF_Pre sjfp = new SJF_Pre(x);
                        break;
                    case 3:
                        SJF_NonPre sjf = new SJF_NonPre(x);
                        break;
                    case 4:
                        Priority_Pre priopre = new Priority_Pre(x);
                        break;
                    case 5:
                        Priority_NonPre prionon = new Priority_NonPre(y);
                        break;
                    case 6:
                        MultilevelQ mq = new MultilevelQ(x);
                        break;
                }                                                                             
            }
        }
        
         catch (IOException e)
        {
                System.out.println("Error: ");
                System.out.println(e.getMessage());
        }

        
    }
    
}
