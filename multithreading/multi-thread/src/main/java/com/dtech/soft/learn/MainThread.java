package com.dtech.soft.learn;

public class MainThread 
{
    public static void main( String[] args )
    {
        
    	//create threads
    	ProcessStatus processStatusVod = new ProcessStatus("vod instance");
    	ProcessStatus processStatusLinear = new ProcessStatus("linear instance");
    	
    	Thread vod = new Thread(processStatusVod);
    	Thread linear = new Thread(processStatusLinear);
    	
    	try {

        	vod.start();
        	
        	linear.start();
        	
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}
