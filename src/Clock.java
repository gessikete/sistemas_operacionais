
public class Clock extends Thread {
	private static int clock = 0;
	
	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep(1000);
				clock++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static int getClock(){
		return clock;
	}
}
