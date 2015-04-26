package Threads;

class CalcPI2
{
   public static void main (String [] args)
   {
	   Thread [] threads = new Thread [4];
	   System.out.println("Thread array size "+threads.length );
	   int n = Thread.enumerate (threads);
	   System.out.println("Thread.enumerate (threads)  " + n);
	   System.out.println("Thread.activeCount ()  " + Thread.activeCount ());
	   
      MyThread1 mt = new MyThread1 ();
      mt.start ();
      //while (mt.isAlive ())
        try
        {
        	System.out.println("Main Thread stopped");
        	//Thread.sleep (10); // Sleep for 10 milliseconds
        	mt.join();
        	
        }
        catch (InterruptedException e)
        {
        }
      System.out.println ("pi = " + mt.pi);
   }
}
class MyThread1 extends Thread
{
   boolean negative = true;
   double pi; // Initializes to 0.0, by default
   public void run ()
   {
      for (int i = 3; i < 100000; i += 2)
      {
           if (negative)
               pi -= (1.0 / i);
           else
               pi += (1.0 / i);
           negative = !negative;
      }
      pi += 1.0;
      pi *= 4.0;
      System.out.println ("Finished calculating PI");
   }
}