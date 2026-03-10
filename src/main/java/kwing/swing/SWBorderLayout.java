package kwing.swing;

import kwing.BorderLayout;

/**
 * Swingバージョンのボーダーレイアウト
 * 
 * 
 */
public class SWBorderLayout extends BorderLayout {
	private java.awt.BorderLayout layout;

	@Override
	public Object getLayout() {
		return layout;
	}

	public SWBorderLayout() {
		layout = new java.awt.BorderLayout();
	}
}
