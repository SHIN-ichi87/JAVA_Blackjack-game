package kwing.swing;

import javax.swing.JLabel;

import kwing.Label;

/**
 * Swingバージョンのラベル
 * 
 * 
 */
public class SWLabel extends Label {

	JLabel label;

	public SWLabel() {
		label = new JLabel();
	}

	@Override
	public void setText(String text) {
		label.setText(text);
	}

	@Override
	public String getText() {
		return label.getText();
	}

	@Override
	public Object getWidget() {
		return label;
	}
}
