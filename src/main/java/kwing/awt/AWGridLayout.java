package kwing.awt;

import kwing.GridLayout;

/**
 * AWTバージョンのグリッドレイアウト
 * 
 * 
 */
public class AWGridLayout extends GridLayout {
	private java.awt.GridLayout layout;

	@Override
	public Object getLayout() {
		return layout;
	}

	public AWGridLayout() {
		layout = new java.awt.GridLayout();
	}

	@Override
	public void setRows(int rows) {
		layout.setRows(rows);
	}

	@Override
	public void setColumns(int columns) {
		layout.setColumns(columns);
	}
}
