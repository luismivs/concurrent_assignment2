package concurrent_assignment2.A2;

import concurrent_assignment2.A_intro.Queue;

/**
 * Use the synchronized keyword and signals so that
 * you do not need to busy wait.
 * But of course you still need your variable to know
 * whose's turn it is.
 *
 */
 
class Signalled_Queue implements Queue{
	int n=0;
	boolean readerTurn=false;
	
	@Override
	synchronized public void read() {
		if(readerTurn==false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Reader: " + n + "\n");
		readerTurn=false;
		notifyAll();
	}

	@Override
	synchronized public void write(int x) {
		if(readerTurn==true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Writer");
		n = x;
		readerTurn=true;
		notifyAll();
	}

	@Override
	public void read(int ID) {
		// no need to implement this
		
	}
	
	
}


