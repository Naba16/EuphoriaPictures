package euphoria;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import euphoria.pictures.chooseArea.ChooseArea;
import euphoria.pictures.commentArea.CommentArea;
import euphoria.pictures.doArea.DoArea;
import euphoria.setup.ProgramSet;

/**
 * メインフレームのクラス
 * @author Nanban
 */
public class MainFrame extends JFrame {

	// デフォルトウィンドウサイズ
	private int width;
	private int height;
	// 最小ウィンドウサイズ
	private int minWidth;
	private int minHeight;
	// ウィンドウのタイトル
	private String title;

	// レイアウト関連
	private GridBagLayout layout;
	private GridBagConstraints gbc;

	// 各コンポーネントの定義
	private ChooseArea choose;
	private CommentArea comment;
	private DoArea upload;

	// 初期化フィールド
	{
		width = 960;
		height = 720;
		minWidth = 640;
		minHeight = 480;
		title = "Euphoria Pictures";
	}

	/**
	 * コンストラクタ
	 */
	public MainFrame() {

		// メインフレーム設定
		ProgramSet.FrameSet(this, title, width, height, minWidth, minHeight, JFrame.EXIT_ON_CLOSE);
		startUp();

		// 各コンポーネントの定義
		choose = new ChooseArea();
		comment = new CommentArea();
		upload = new DoArea();

		// GridBagLayoutの設定
		gridSetUp();

		// TitledBorderの設定
		titledSetUp();

		// コンポーネントの組み込み
		Container contentPane = getContentPane();
		contentPane.add(choose);
		contentPane.add(comment);
		contentPane.add(upload);

	}

	/**
	 * ウィンドウの初期処理をしてくれるメソッド
	 */
	private void startUp() {
		// Gridの定義
		layout = new GridBagLayout();
		setLayout(layout);
		gbc = new GridBagConstraints();
	}

	private void gridSetUp() {
		gbc.fill = GridBagConstraints.BOTH;

		gbc.weightx = 1.0d;
		gbc.weighty = 1.0d;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10, 10, 10, 10);
		layout.addLayoutComponent(choose, gbc);

		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.weighty = 0.0d;
		gbc.insets = new Insets(0, 10, 10, 10);
		layout.addLayoutComponent(comment, gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.weightx = 0.0d;
		gbc.insets = new Insets(0, 0, 10, 10);
		layout.addLayoutComponent(upload, gbc);
	}

	private void titledSetUp() {
		// choose
		LineBorder chooseBorder = new LineBorder(Color.black, 1);
		TitledBorder chooseTitle = new TitledBorder(chooseBorder, "写真の選択");
		choose.setBorder(chooseTitle);

		// comment
		LineBorder commentBorder = new LineBorder(Color.black, 1);
		TitledBorder commentTitle = new TitledBorder(commentBorder, "写真の情報を入力");
		comment.setBorder(commentTitle);

		// upload
		LineBorder uploadBorder = new LineBorder(Color.black, 1);
		TitledBorder uploadTitle = new TitledBorder(uploadBorder, "各種操作");
		upload.setBorder(uploadTitle);
	}

}
