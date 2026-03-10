package kwing.swing;

import java.awt.event.ActionListener;

import kwing.Timer;

/**
 * Swingバージョンのタイマー
 * 
 * 
 */
public class SWTimer extends Timer {
	javax.swing.Timer timer;

	public SWTimer(int time, ActionListener listener) {
		timer = new javax.swing.Timer(time, listener);
	}

	@Override
	public void start() {
		timer.start();
	}

	@Override
	public void stop() {
		timer.stop();
	}

	@Override
	public Object getWidget() {
		return timer;
	}

}
