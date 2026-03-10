package kwing.swing;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import kwing.Button;

/**
 * Swingバージョンのボタン
 * 
 * 
 */
public class SWButton extends Button {

	private JButton button;

	public SWButton() {
		button = new JButton();
	}

	@Override
	public void setText(String text) {
		button.setText(text);
	}

	@Override
	public String getText() {
		return button.getText();
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		button.setEnabled(isEnabled);
	}

	@Override
	public Object getWidget() {
		return button;
	}

	@Override
	public void addActionListener(Object listener) {
		button.addActionListener((ActionListener) listener);
	}
}