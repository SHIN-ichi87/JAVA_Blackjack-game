package kwing;

/**
 * グリッドレイアウト
 * 
 * 
 */
public abstract class GridLayout extends Layout {

	/**
	 * 行数を設定する
	 * 
	 * @param rows
	 * 			行数
	 */
	public abstract void setRows(int rows);

	/**
	 * 列数を設定する
	 * 
	 * @param columns
	 * 			列数
	 */
	public abstract void setColumns(int columns);
}
