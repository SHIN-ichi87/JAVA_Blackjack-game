package kwing.swing;

import kwing.FlowLayout;

/**
 * Swingバージョンのフローレイアウト
 * 
 * 
 */
public class SWFlowLayout extends FlowLayout {
	private java.awt.FlowLayout layout;

	public SWFlowLayout() {
		layout = new java.awt.FlowLayout();
	}

	@Override
	public Object getLayout() {
		return layout;
	}

}
