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
public class MultilevelQ {
    public MultilevelQ(Process[] p) {
        //int h = p.length/2; //splitting into 2 queues, according to priority
        int x = 0;
        for (int i = 0; i < p.length; i++)
            if (p[i].Priority > x)
                x = p[i].Priority; //finding maximum priority
        
        int y = 0;
        for (int i = 0; i < p.length; i++)
            if (p[i].Priority < y)
                y = p[i].Priority; //finding minimum priority
        int z = x+y/p.length; //roughly average priority
        // how many proc's have => average priority?
        int numbig = 0;
        for (int i = 0; i < p.length; i++)
        {
            if (p[i].Priority >= z)
                numbig++;
        }
        
        int numsmall = 0;
        for (int i = 0; i < p.length; i++)
        {
            if (p[i].Priority < z)
                numsmall++;
        }
        Process[] q1 = new Process[numbig]; // queue for highest priorities
        Process[] q2 = new Process[numsmall]; //queue for lower priorities
        //building 2 queues----
        for (int i = 0; i < numsmall; i++)
        {
            for (int j = i; j < p.length; j++)
                if(p[j].Priority < z)
                    q2[i] = p[i];
        }
        
        for (int i = 0; i < numbig; i++)
        {
            for (int j = i; j < p.length; j++)
                if(p[j].Priority >= z)
                    q1[i] = p[i];
        }
        //SJF Preemptive, first queue.
        System.out.println("=====Multilevel Queue=====");
        System.out.println("===SJF Preemptive for first queue===");
        SJF_Pre sjfm = new SJF_Pre(q1);
        System.out.println("===FCFS for second queue===");
        FCFS fcfsm = new FCFS (q2);
        System.out.println("=====Multilevel Queue=====");

    }
}
