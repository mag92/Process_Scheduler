/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.util.Arrays;
import java.util.Comparator;
/**
 *
 * @author Mido
 */
public class SJF_NonPre{

    public SJF_NonPre(Process[] p) {
        int n = p.length;
        // p1, p2, p3, p4 for example
        
        Arrays.sort(p);
        System.out.println("======SJF-NPRE======");
        int[] waitingTime = new int[n];
        int[] turnAround = new int[n];
        waitingTime[0] = 0;
        turnAround[0] = p[0].burstTime;
        
        for (int i = 1; i < n; i++)
        {
            waitingTime[i] = p[i-1].burstTime + waitingTime[i-1];
            turnAround[i] = waitingTime[i] + p[i].burstTime;
        }

        for (int i = 0; i < n; i++)
        {
            System.out.print("Waiting time for " + "p" + p[i].originalOrder + " is " + waitingTime[i] + "\n" );
            System.out.print("Turnaround time for " + "p" + p[i].originalOrder + " is " + turnAround[i] + "\n" );
        }
        
        int totalW = 0;
        int totalT = 0;
        
        for (int i = 0; i < n; i++)
            //System.out.println("Burst times ordered: " + p[i].burstTime);
        {
            totalW += waitingTime[i];
            totalT += turnAround[i];
        }
        System.out.print("Average waiting time is " + totalW/n + "\n" );
        System.out.print("Turnaround time is " + totalT/n + "\n" );
    }
    
    
}
