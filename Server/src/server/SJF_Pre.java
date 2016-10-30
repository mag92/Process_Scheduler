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
public class SJF_Pre {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    
        //nt totalWait = 0;
        private int totalw = 0;
    public SJF_Pre(Process[] p)
    {
        int n = p.length;
        
        /*int time = 0;
        int current = 0;
        while (true)
        {
            for (int i = 0; i < n; i++)
            {
                if (p[i].arrivalTime == time)
                    //execute
                {
                    if (p[i].burstTime < p[current].burstTime)
                    {
                        p[i].burstTime--;
                        current = i;
                    }
                }
            }
            time++;
        }*/
        int totalB = 0;
        for (int i = 0; i < n; i++)
            totalB += p[i].burstTime;
        int[] wait = new int[n];
        for (int i = 0; i < n; i++)
        {
            queue.add(p[i].burstTime);
            ex(1);
        }
        
        System.out.println("====SJF Preemptive====");
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
