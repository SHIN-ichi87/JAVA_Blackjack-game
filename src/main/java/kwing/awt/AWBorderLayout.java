package kwing.awt;

import kwing.BorderLayout;

/**
 * AWTバージョンのボーダーレイアウト
 * 
 * 
 */
public class AWBorderLayout extends BorderLayout {
	private java.awt.BorderLayout layout;

	public AWBorderLayout() {
		layout = new java.awt.BorderLayout();
	}

	@Override
	public Object getLayout() {
		return layout;
	}
}
