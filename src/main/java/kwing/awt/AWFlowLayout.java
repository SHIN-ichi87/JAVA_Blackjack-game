package kwing.awt;

import kwing.FlowLayout;

/**
 * AWTバージョンのフローレイアウト
 * 
 * 
 */
public class AWFlowLayout extends FlowLayout {
	private java.awt.FlowLayout layout;

	@Override
	public Object getLayout() {
		return layout;
	}

	public AWFlowLayout() {
		layout = new java.awt.FlowLayout();
	}

}
