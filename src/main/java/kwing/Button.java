package kwing;

/**
 * ボタン
 * 
 * 
 */
public abstract class Button extends Widget {

	/**
	 * 文字列を設定する
	 * 
	 * @param text
	 * 			文字列
	 */
	public abstract void setText(String text);

	/**
	 * 設定された文字列を返す
	 * 
	 * @return 設定された文字列
	 */
	public abstract String getText();

	/**
	 * ボタンの選択権(選択可能かどうか)を設定する
	 * 
	 * @param isEnabled
	 * 			ボタンの選択権（true 選択可能, false 選択不能）
	 */
	public abstract void setEnabled(boolean isEnabled);

	/**
	 * アクションリスナーを追加する
	 * 
	 * @param listener
	 * 			アクションリスナー
	 */
	public abstract void addActionListener(Object listener);

}
