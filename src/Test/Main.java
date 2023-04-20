package Test;

import javax.swing.UIManager;

import View.NotepadView;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new NotepadView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
