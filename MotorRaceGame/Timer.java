
public class Timer implements java.lang.Runnable{
	
	
	public void run() {
	        this.Timer();
	    }

	    public void Timer(){
	        int i = 60;
	         while (true){
	          System.out.println("Remaining: "+i+" seconds");
	          try {
	            i--;
	            Thread.sleep(10);    // 1000L = 1000ms = 1 second
	           }
	           catch (InterruptedException e) {
	               //I don't think you need to do anything for your particular problem
	           }
	         }
	    }
}