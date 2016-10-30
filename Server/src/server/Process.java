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
public class Process implements Comparable<Process>{
    public int burstTime;
    public int arrivalTime;
    public int Priority;
    public int waitingTime;
    public int originalOrder;
    
    public Process(int burstTime, int arrivalTime, int Priority, int originalOrder)
    {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.Priority = Priority;
        this.originalOrder = originalOrder;
    }
    
    public int compareTo(Process x)
    {
 // by bursttime
            int a = x.burstTime;
            return this.burstTime - a;
    }
}
