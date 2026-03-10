package kwing;

/**
 * ラベル
 * 
 * 
 */
public abstract class Label extends Widget {

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
	 * @return 文字列
	 */
	public abstract String getText();

}
