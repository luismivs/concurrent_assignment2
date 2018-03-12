package concurrent_assignment2.A3;

import concurrent_assignment2.A_intro.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Use the synchronized keyword and signals.
 * 
 * You cannot decide whose's turn it is based on 
 * a 2 states variables, so know use a variable which
 * allows for more values (you need 3 states, that is, 3 turns).
 * 
 * Output should be: writer prints, both readers read, and so on...
 *
 */
 
class Signalled_2Readers_Queue implements Queue{
	int n=0;
	int readerTurn=2;
	
	@Override
	synchronized public void read(int ID) {
                while(readerTurn != ID){
                        /*try {
                            Thread.sleep(600);
			} catch (InterruptedException e) {
                            e.printStackTrace();
			}*/
                        try {
                            wait();
                    } catch (InterruptedException ex) {
                            Logger.getLogger(Signalled_2Readers_Queue.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
		System.out.println("Reader "+ ID + ": " + n + "\n");
		readerTurn++;
		notifyAll();
		
	}
	

	@Override
	synchronized public void write(int x) {
		while(readerTurn < 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Writer");
		n = x;
		readerTurn=0;
		notifyAll();
	}
	
	@Override
	public void read() {
		// no need to implement this
		
	}

	
	
	
}


