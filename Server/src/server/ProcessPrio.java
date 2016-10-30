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
public class ProcessPrio implements Comparable<ProcessPrio>{
    public int burstTime;
    public int arrivalTime;
    public int Priority;
    public int waitingTime;
    public int originalOrder;
    
    public ProcessPrio(int burstTime, int arrivalTime, int Priority, int originalOrder)
    {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.Priority = Priority;
        this.originalOrder = originalOrder;
    }
    
    public int compareTo(ProcessPrio x)
    {
 // by bursttime
            int a = x.Priority;
            return this.Priority - a;
    }
}