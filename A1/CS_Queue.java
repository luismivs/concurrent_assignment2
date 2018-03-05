package concurrent_assignment2.A1;

import concurrent_assignment2.A_intro.Queue;

/**Use condition synchronization by means of busy wait.
 * 
 * What kind of variable do you need to implement busy
 * wait synchronization?
 * 
 * Set a meaningful name for such variable.
 * */
 
class CS_Queue implements Queue{
	int n=0;
	volatile boolean readerTurn=false;
	
	@Override
	public void read() {
		while(readerTurn==false);
		
			System.out.println("Reader: " + n + "\n");
			readerTurn=false;
		
		
	}

	@Override
	public void write(int x) {
		while(readerTurn==true);
			
			System.out.println("Writer");
			n = x;
			readerTurn=true;
		
	}

	@Override
	public void read(int ID) {
		// no need to implement this
		
	}
	
	
	
	
}


