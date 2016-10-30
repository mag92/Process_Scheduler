/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.util.PriorityQueue;
/**
 *
 * @author Mido
 */
public class Priority_Pre {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    
        //nt totalWait = 0;
        private int totalw = 0;
    public Priority_Pre(Process[] p)
    {
        int n = p.length;
        int totalB = 0;
        
        // getting total burst times 
        for (int i = 0; i < n; i++)
            totalB += p[i].burstTime;
        int[] wait = new int[n];
               
        for (int i = 0; i < n; i++)
        {
            queue.add(p[i].burstTime);
            ex(1);
        }
        for (int i = 0; i < n; i++)
        {
            queue.add(p[i].Priority);
            ex(1);
        }
        
        System.out.println("====Priority Preemptive====");
        while (queue.size() > 1) {
            ex(1);
        }
        float average = totalw / n;
        System.out.println("Avg turnaround time: " + (totalw+totalB)/n);
        System.out.println("Avg waiting time: " + average);
        System.out.println("====SJF Preemptive====");
    }
    
    public void ex(int t) {
        int time = queue.poll();
        if (time <= t) {
            totalw = totalw + time * queue.size();
        } else {
            totalw = totalw + t * queue.size();
            time = time - t;
            queue.add(time);
        }
    }
}
