public class Dispatcher extends Thread{
	
	@Override
	public void run() {
		while(true){
			try {
				System.out.println("Estou vivo");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}	
	
}
