/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.Arrays;

/**
 *
 * @author Mido
 */
public class FCFS {
    int avgW = 0;
    int avgT = 0;
    public FCFS(Process[] p)
    {        
        Process temp;
        //Arrays.sort(p); //sorting according to arrival times!!! doesn't work, compareTo(..)
        //swapping p objects to rearrange processes
        for (int i = 0; i < p.length; i++)
        {
            for (int j = i; j < p.length-2; j++)
            {
                if (p[j].arrivalTime > p[j+1].arrivalTime)
                {
                    temp = p[j+1];
                    p[j+1] = p[j];
                    p[j] = temp;
                }
            }
        }
        int n = p.length;
        System.out.println("======FCFS======");
        int[] waitingTime = new int[n];
        int[] turnAround = new int[n];
        waitingTime[0] = 0;
        turnAround[0] = p[0].burstTime;
        for (int i = 1; i < n; i++)
        {
            waitingTime[i] = p[i-1].burstTime + waitingTime[i-1] - p[i].arrivalTime;
            turnAround[i] = waitingTime[i] + p[i].burstTime;
        }
        for (int i = 0; i < n; i++)
        {
            System.out.print("Waiting time for " + "p" + i + " is " + waitingTime[i] + "\n" );
            System.out.print("Turnaround time for " + "p" + i + " is " + turnAround[i] + "\n" );
        }
        int totalW = 0, totalT = 0;
        for (int i = 0; i < n; i++)
        {
            totalW += waitingTime[i];
            totalT += turnAround[i];
        }
        avgW = totalW/n;
        avgT = totalT/n;
        System.out.print("Average waiting time is " + totalW/n + "\n" );
        System.out.print("Average turnaround time is " + totalT/n + "\n" );
        System.out.println("======FCFS======");
    }
}
