package kwing.awt;

import java.awt.Label;

/**
 * AWTバージョンのラベル
 * 
 * 
 */
public class AWLabel extends kwing.Label {

	Label label;

	public AWLabel() {
		label = new Label();
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
