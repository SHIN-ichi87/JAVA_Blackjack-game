package kwing.awt;

import java.awt.event.ActionListener;

import kwing.Timer;

/**
 * AWTバージョンのタイマー
 * 
 * 
 */
public class AWTimer extends Timer {
	javax.swing.Timer timer;

	public AWTimer(int time, ActionListener listener) {
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
