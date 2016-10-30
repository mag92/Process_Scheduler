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
public class Priority_NonPre{

    public Priority_NonPre(ProcessPrio[] p) {
        int n = p.length;
        // p1, p2, p3, p4 for example
        
        //Arrays.sort(p);
        Arrays.sort(p);
        System.out.println("======Priority-Non-preemptive======");
        int[] turnAround = new int[n];
        int[] waitingTime = new int[n];
        waitingTime[0] = 0;
        turnAround[0] = p[0].burstTime;
        for (int i = 1; i < n; i++)
        {
            waitingTime[i] = p[i-1].burstTime + waitingTime[i-1];
            turnAround[i] = waitingTime[i] + p[i].burstTime;
        }

        for (int i = 0; i < n; i++)
            System.out.print("Waiting time for " + "p" + p[i].originalOrder + " is " + waitingTime[i] + "\n" );
        //for (int i = 0; i < p.length; i++)
            //System.out.println("Burst times ordered: " + p[i].burstTime);
        float totalw = 0;
        float totala = 0;
        for (int i = 0; i < n; i++)
        {
            totalw += waitingTime[i];
            totala += turnAround[i];
        }
        System.out.println("Average turnaround time: " + totala/n);
        System.out.println("Average waiting time: " + totalw/n);
        System.out.println("======Priority-Non-preemptive======");
    }
}
