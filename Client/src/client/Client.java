/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author Mido
 */
import java.io.IOException;
import java.io.PrintStream;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;
import java.net.*;

public class Client implements Serializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //JFrame frame = new JFrame();
        //frame.setSize(202, 202);
        //frame.setLocation(120,120);
        //frame.add(new JLabel("Output"), BorderLayout.NORTH);

        //System.setOut( ps );
        //frame.setVisible( true );
        try (
                Socket socket = new Socket("localhost", 4444);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                //
                PrintStream out = new PrintStream(socket.getOutputStream(), true);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                DataInputStream z = new DataInputStream(
                        new BufferedInputStream(socket.getInputStream()));) {
            // selecting choice
            while (true) {
                
                System.out.println("1) FCFS");    
                System.out.println("2) SJF Preemptive");
                System.out.println("3) SJF Non-preemptive");
                System.out.println("4) Priority-based preemptive");
                System.out.println("5) Priority-based non-preemptive");
                System.out.println("6) Multilevel Queue (SJF preemptive - FCFS)");
                System.out.println("Select an algorithm:");
                int choice = s.nextInt();

                out.println(choice);
            // 1 fcfs
                // 2 sjf pre
                // 3 sjf non-pre
                // 4 prio pre
                // 5 prio non pre
                // 6 multi
                //out.println(2); //testing stream, sending a variable 
                System.out.println("Enter number of processes:");
                int processes;
                processes = s.nextInt();
                ArrayList<ArrayList<Integer>> mat = new ArrayList<>(processes);
                //Hashtable<Integer,ArrayList> mat2 = new Hashtable<Integer,ArrayList>();
                for (int i = 0; i < processes; i++) {
                    mat.add(new ArrayList<>());
                }
                for (int i = 0; i < processes; i++) {
                    //mat.clear();
                    System.out.println("P" + i);
                    System.out.println("Burst time: ");
                    mat.get(i).add(s.nextInt());
                    System.out.println("Arrival time: ");
                    mat.get(i).add(s.nextInt());
                //if (choice == 4 || choice == 5 || choice == 6)
                    //{
                    System.out.println("Priority: ");
                    mat.get(i).add(s.nextInt());
                    System.out.println("==========");
                //}
                    //else
                    // mat.get(i).add(0);
                }
                //int[][] array = (int[][])mat.toArray(new int[mat.size()][mat.get(0).size()]);
                System.out.println(mat);
            //System.out.println(array);

                oos.writeObject(mat);
            //oos.close();

                System.out.println("Client: Matrix serialized.");

            //String x;
                //while ((x = in.readLine()) != null)
                {
                    // System.out.println("Server: " + x);
                }
            //System.out.print(z.next());
                //System.out.print(z);
                String fromserver;

                while ((fromserver = z.readLine()) != null) {
                    System.out.println(fromserver);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know host");
        } catch (IOException e) {
            System.err.println("Couldn't get IO");
        }
    }
}
