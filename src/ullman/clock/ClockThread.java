package ullman.clock;

public class ClockThread extends Thread {

	private final ClockComponent comp;

	public ClockThread(ClockComponent comp) {
		this.comp = comp;
	}

	@Override
	public void run() {
		for (;;) {
			comp.updateTime();
			comp.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
