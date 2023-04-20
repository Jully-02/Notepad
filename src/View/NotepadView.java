package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

import Controller.NotepadController;

public class NotepadView extends JFrame{
	private String titleChooser;
	private JTextArea jTextAreaNote;
	private JMenuBar jMenuBar;
	private JScrollPane jScrollPaneText;
	private JLabel jLabelLnCol;

	private JLabel jLabelSize;
	private JLabel jLabelWindows;
	private JLabel jLabelType;
	private JPanel jPanelToolBar;

	private String pathFile;

	private int ln;
	private int col;
	
	
	
	public NotepadView() {
		this.ln = 1;
		this.col = 1;
		this.titleChooser = "Unitled";
		this.init();
		this.setVisible(true);
	}
	
	public void init() {
		this.setTitle(this.titleChooser + " - Notepad");
		this.setSize(500,500);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.jTextAreaNote = new JTextArea (100,100);
		
		Font fontText = new Font ("Arival", Font.PLAIN, 13);
		this.jTextAreaNote.setFont(fontText);
		jScrollPaneText = new JScrollPane (jTextAreaNote, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPaneText.setBorder(null);
		Font fontMenu = new Font ("Arival", Font.PLAIN, 13);
		
		ActionListener ac = new NotepadController (this);
		
		JMenu jMenuFile = new JMenu ("File");
		jMenuFile.setFont(fontMenu);
		JMenuItem jMenuItemNew = new JMenuItem ("New");
		jMenuItemNew.setFont(fontMenu);
		jMenuItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		jMenuItemNew.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(NotepadView.class.getResource("Icon New File.png"))));
		jMenuItemNew.addActionListener(ac);
		JMenuItem jMenuItemNewWindow = new JMenuItem ("New Window");
		jMenuItemNewWindow.setFont(fontMenu);
		jMenuItemNewWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.SHIFT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK));
		jMenuItemNewWindow.addActionListener(ac);
		JMenuItem jMenuItemOpen = new JMenuItem ("Open\u2026");
		jMenuItemOpen.setFont(fontMenu);
		jMenuItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		jMenuItemOpen.addActionListener(ac);
		JMenuItem jMenuItemSave = new JMenuItem ("Save");
		jMenuItemSave.setFont(fontMenu);
		jMenuItemSave.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(NotepadView.class.getResource("Icon Save.png"))));
		jMenuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		jMenuItemSave.addActionListener(ac);
		JMenuItem jMenuItemSaveAs = new JMenuItem ("Save As\u2026");
		jMenuItemSaveAs.setFont(fontMenu);
		jMenuItemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.SHIFT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK));
		jMenuItemSaveAs.addActionListener(ac);
		JMenuItem jMenuItemPageSetup = new JMenuItem ("Page Setup\u2026");
		jMenuItemPageSetup.setFont(fontMenu);
		JMenuItem jMenuItemPrint = new JMenuItem ("Print\u2026");
		jMenuItemPrint.setFont(fontMenu);
		jMenuItemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		jMenuItemPrint.addActionListener(ac);
		JMenuItem jMenuItemExit = new JMenuItem ("Exit");
		jMenuItemExit.setFont(fontMenu);
		jMenuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));
		jMenuItemExit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(NotepadView.class.getResource("Icon LogOut.png"))));
		jMenuItemExit.addActionListener(ac);
		// Add Menu Item Into Menu File
		jMenuFile.add(jMenuItemNew);
		jMenuFile.add(jMenuItemNewWindow);
		jMenuFile.add(jMenuItemOpen);
		jMenuFile.add(jMenuItemSave);
		jMenuFile.add(jMenuItemSaveAs);
		jMenuFile.addSeparator();
		jMenuFile.add(jMenuItemPageSetup);
		jMenuFile.add(jMenuItemPrint);
		jMenuFile.addSeparator();
		jMenuFile.add(jMenuItemExit);
		
		JMenu jMenuEdit = new JMenu ("Edit");
		jMenuEdit.setFont(fontMenu);
		JMenuItem jMenuItemUndo = new JMenuItem ("Undo");
		jMenuItemUndo.setFont(fontMenu);
		jMenuItemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
		jMenuItemUndo.addActionListener(ac);
		JMenuItem jMenuItemCut = new JMenuItem ("Cut");
		jMenuItemCut.setFont(fontMenu);
		jMenuItemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		jMenuItemCut.addActionListener(ac);
		JMenuItem jMenuItemCopy = new JMenuItem ("Copy");
		jMenuItemCopy.setFont(fontMenu);
		jMenuItemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		jMenuItemCopy.addActionListener(ac);
		JMenuItem jMenuItemPaste = new JMenuItem ("Paste");
		jMenuItemPaste.setFont(fontMenu);
		jMenuItemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		jMenuItemPaste.addActionListener(ac);
		JMenuItem jMenuItemDelete = new JMenuItem ("Delete");
		jMenuItemDelete.setFont(fontMenu);
		jMenuItemDelete.addActionListener(ac);
		JMenuItem jMenuItemSearchWithBing = new JMenuItem ("Search with Bing\u2026");
		jMenuItemSearchWithBing.setFont(fontMenu);
		jMenuItemSearchWithBing.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		jMenuItemSearchWithBing.addActionListener(ac);
		JMenuItem jMenuItemFind = new JMenuItem ("Find\u2026");
		jMenuItemFind.setFont(fontMenu);
		jMenuItemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
		jMenuItemFind.addActionListener(ac);
		JMenuItem jMenuItemFindNext = new JMenuItem ("Find Next");
		jMenuItemFindNext.setFont(fontMenu);
		jMenuItemFindNext.addActionListener(ac);
		JMenuItem jMenuItemFindPre = new JMenuItem ("Find Previous");
		jMenuItemFindPre.setFont(fontMenu);
		jMenuItemFindPre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.SHIFT_DOWN_MASK));
		jMenuItemFindPre.addActionListener(ac);
		JMenuItem jMenuItemReplace = new JMenuItem ("Replace\u2026");
		jMenuItemReplace.setFont(fontMenu);
		jMenuItemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		jMenuItemReplace.addActionListener(ac);
		JMenuItem jMenuItemGoto = new JMenuItem ("Go To\u2026");
		jMenuItemGoto.setFont(fontMenu);
		jMenuItemGoto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		jMenuItemGoto.addActionListener(ac);
		JMenuItem jMenuItemSellectAll = new JMenuItem ("Select All");
		jMenuItemSellectAll.setFont(fontMenu);
		jMenuItemSellectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		jMenuItemSellectAll.addActionListener(ac);
		JMenuItem jMenuItemTimeAndDate = new JMenuItem ("Time/Date");
		jMenuItemTimeAndDate.setFont(fontMenu);
		jMenuItemTimeAndDate.addActionListener(ac);
		// Add Menu Item Into Menu Edit
		jMenuEdit.add(jMenuItemUndo);
		jMenuEdit.addSeparator();
		jMenuEdit.add(jMenuItemCut);
		jMenuEdit.add(jMenuItemCopy);
		jMenuEdit.add(jMenuItemPaste);
		jMenuEdit.add(jMenuItemDelete);
		jMenuEdit.addSeparator();
		jMenuEdit.add(jMenuItemSearchWithBing);
		jMenuEdit.add(jMenuItemFind);
		jMenuEdit.add(jMenuItemFindNext);
		jMenuEdit.add(jMenuItemFindPre);
		jMenuEdit.add(jMenuItemReplace);
		jMenuEdit.add(jMenuItemGoto);
		jMenuEdit.addSeparator();
		jMenuEdit.add(jMenuItemSellectAll);
		jMenuEdit.add(jMenuItemTimeAndDate);
		
		
		JMenu jMenuFormat = new JMenu ("Format");
		jMenuFormat.setFont(fontMenu);
		
		// MenuItem Of Menu Format
		JCheckBoxMenuItem jCheckBoxMenuItemWordWrap = new JCheckBoxMenuItem ("Word Wrap");
		jCheckBoxMenuItemWordWrap.setFont(fontMenu);
		jCheckBoxMenuItemWordWrap.addActionListener(ac);
		JMenu jMenuFontOfFormat = new JMenu ("Font\u2026");
		jMenuFontOfFormat.setFont(fontMenu);
		JMenuItem jMenuItemFontTimes = new JMenuItem ("Times New Roman");
		jMenuItemFontTimes.setFont(fontMenu);
		jMenuItemFontTimes.addActionListener(ac);
		JMenuItem jMenuItemFontArival = new JMenuItem ("Arival");
		jMenuItemFontArival.setFont(fontMenu);
		jMenuItemFontArival.addActionListener(ac);
		jMenuFontOfFormat.add(jMenuItemFontTimes);
		jMenuFontOfFormat.add(jMenuItemFontArival);
		// Add Menu Item Into Menu Format
		jMenuFormat.add(jCheckBoxMenuItemWordWrap);
		jMenuFormat.add(jMenuFontOfFormat);
		
		
		JMenu jMenuView = new JMenu ("View");
		jMenuView.setFont(fontMenu);
		JMenu jMenuZoom = new JMenu ("Zoom");
		jMenuZoom.setFont(fontMenu);
		JMenuItem jMenuItemZoomIn = new JMenuItem ("Zoom In");
		jMenuItemZoomIn.setFont(fontMenu);
		jMenuItemZoomIn.addActionListener(ac);
		jMenuItemZoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jMenuItemZoomOut = new JMenuItem ("Zoom Out");
		jMenuItemZoomOut.setFont(fontMenu);
		jMenuItemZoomOut.addActionListener(ac);
		jMenuItemZoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jMenuItemRestoreDefaultZoom = new JMenuItem ("Restore Default Zoom");
		jMenuItemRestoreDefaultZoom.setFont(fontMenu);
		jMenuItemRestoreDefaultZoom.addActionListener(ac);
		jMenuItemRestoreDefaultZoom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		jMenuZoom.add(jMenuItemZoomIn);
		jMenuZoom.add(jMenuItemZoomOut);
		jMenuZoom.addSeparator();
		jMenuZoom.add(jMenuItemRestoreDefaultZoom);
		JCheckBoxMenuItem jCheckBoxMenuItemStatusBar = new JCheckBoxMenuItem ("Status Bar");
		jCheckBoxMenuItemStatusBar.setFont(fontMenu);
		jCheckBoxMenuItemStatusBar.addActionListener(ac);
		// Add Menu Item Into Menu View
		jMenuView.add(jMenuZoom);
		jMenuView.add(jCheckBoxMenuItemStatusBar);
		
		
		JMenu jMenuHelp = new JMenu ("Help");
		jMenuHelp.setFont(fontMenu);
		// Menu Item Of Menu Help
		JMenuItem jMenuItemViewHelp = new JMenuItem ("View Help");
		jMenuItemViewHelp.setFont(fontMenu);
		jMenuItemViewHelp.addActionListener(ac);
		JMenuItem jMenuItemSendFeedBack = new JMenuItem ("Send Feed Back");
		jMenuItemSendFeedBack.setFont(fontMenu);
		jMenuItemSendFeedBack.addActionListener(ac);
		JMenuItem jMenuItemAboutNotepad = new JMenuItem ("About Notepad");
		jMenuItemAboutNotepad.setFont(fontMenu);
		jMenuItemAboutNotepad.addActionListener(ac);
		// Add Menu Item Into Menu Help
		jMenuHelp.add(jMenuItemViewHelp);
		jMenuHelp.add(jMenuItemSendFeedBack);
		jMenuHelp.addSeparator();
		jMenuHelp.add(jMenuItemAboutNotepad);	
		
		this.jMenuBar = new JMenuBar ();
		
		jMenuBar.add(jMenuFile);
		jMenuBar.add(jMenuEdit);
		jMenuBar.add(jMenuFormat);
		jMenuBar.add(jMenuView);
		jMenuBar.add(jMenuHelp);
		
		// Set Icon -> JFrame
		URL urlIconNotepad = NotepadView.class.getResource("Icon Notepad.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);
		this.setIconImage(img);
		
		this.jPanelToolBar = new JPanel (new GridLayout(1,5));
		
		JLabel jLabelEmpty = new JLabel ();
		
		this.jLabelLnCol = new JLabel ("Ln " + this.ln + ", " + "Col " + this.col, JLabel.LEFT);
		jLabelLnCol.setFont(fontMenu);

		
		this.jLabelSize = new JLabel ("100%", JLabel.LEFT);
		jLabelSize.setFont(fontMenu);

		
		this.jLabelWindows = new JLabel ("Windows (CRLF)", JLabel.LEFT);
		jLabelWindows.setFont(fontMenu);
		
		this.jLabelType = new JLabel ("UTF-8", JLabel.RIGHT);
		jLabelType.setFont(fontMenu);

	
		
		jPanelToolBar.add(jLabelEmpty);
		jPanelToolBar.add(jLabelLnCol);
		jPanelToolBar.add(jLabelSize);
		jPanelToolBar.add(jLabelWindows);
		jPanelToolBar.add(jLabelType);
		
		this.setJMenuBar(jMenuBar);
		this.setLayout(new BorderLayout());
		this.add(jScrollPaneText, BorderLayout.CENTER);
	}
	
	public void zoomIn () {
		Font font = new Font (this.jTextAreaNote.getFont().getName(), Font.PLAIN, this.jTextAreaNote.getFont().getSize()+2);
		this.jTextAreaNote.setFont(font);
	}
	
	public void zoomOut () {
		Font font = new Font (this.jTextAreaNote.getFont().getName(), Font.PLAIN, this.jTextAreaNote.getFont().getSize()-2);
		this.jTextAreaNote.setFont(font);
	}
	
	public void restoreDefaultZoom () {
		Font fontText = new Font ("Arival", Font.PLAIN, 13);
		this.jTextAreaNote.setFont(fontText);
	}
	
	public void changeFontTimes () {
		Font fontText = new Font ("Times New Roman", Font.PLAIN, this.jTextAreaNote.getFont().getSize());
		this.jTextAreaNote.setFont(fontText);
	}
	
	public void changeFontArival () {
		Font fontText = new Font ("Arival", Font.PLAIN, this.jTextAreaNote.getFont().getSize());
		this.jTextAreaNote.setFont(fontText);
	}
	
	public void repaintNew () {
		this.repaint();
	}
	
	public void enableWordWrap () {
		this.jTextAreaNote.setLineWrap(true);
		this.jTextAreaNote.setWrapStyleWord(true);
		this.jTextAreaNote.setPreferredSize(this.getSize());
	}
	
	
	public String getTitleChooser() {
		return titleChooser;
	}

	public void setTitleChooser(String titleChooser) {
		this.titleChooser = titleChooser;
	}
	
	public void changeTitle () {
		this.setTitle(titleChooser + " - Notepad");
	}


	public void disableWordWrap () {
		this.jTextAreaNote.setLineWrap(false);
		this.jTextAreaNote.setWrapStyleWord(false);
	}
	
	public void enableToolBar () {
		this.add(jPanelToolBar, BorderLayout.SOUTH);
		this.repaint();
	}
	
	public void disableToolBar () {
		this.remove(jPanelToolBar);
		this.repaint();
	}
	
	public JTextArea getjTextAreaNote() {
		return jTextAreaNote;
	}

	public void setjTextAreaNote(String text) {
		this.jTextAreaNote.setText(text);
	}
	
	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

}
