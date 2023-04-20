package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import View.NotepadView;

public class NotepadController implements ActionListener {
	private NotepadView notepadView;

	public NotepadController(NotepadView notepadView) {
		this.notepadView = notepadView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Exit")) {
			System.exit(0);
		} 
		else if (src.equals("Zoom In")) {
			this.notepadView.zoomIn();
		} 
		else if (src.equals("Zoom Out")) {
			this.notepadView.zoomOut();
		} 
		else if (src.equals("Restore Default Zoom")) {
			this.notepadView.restoreDefaultZoom();
		} 
		else if (src.equals("Times New Roman")) {
			this.notepadView.changeFontTimes();
		} 
		else if (src.equals("Arival")) {
			this.notepadView.changeFontArival();
		} 
		else if (src.equals("New")) {
			this.notepadView.repaintNew();
		} 
		else if (src.equals("Open\u2026")) {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(this.notepadView);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				if (file.getName().endsWith(".txt")) {
					this.notepadView.setTitleChooser(file.getName());
					this.notepadView.changeTitle();
					this.notepadView.setPathFile(file.getAbsolutePath());
					try {
						List<String> allText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
						String result = "";
						for (String line : allText) {
							result += line;
							result += "\n";
						}
						this.notepadView.setjTextAreaNote(result);
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(this.notepadView,
						    "Invalid file! Please select the file with the extension \".txt\".",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		} 
		else if (src.equals("Save")) {
			if (this.notepadView.getTitleChooser().equals("Unitled")) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(this.notepadView);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					this.notepadView.setTitleChooser(file.getName());
					this.notepadView.changeTitle();
					this.notepadView.setPathFile(file.getAbsolutePath());
					saveFile(this.notepadView.getPathFile());
				}
			}
			else {
				saveFile(this.notepadView.getPathFile());
			}
		} 
		else if (src.equals("Word Wrap")) {
			AbstractButton checkBox = (AbstractButton) e.getSource();
			boolean check = checkBox.getModel().isSelected();
			if (check) {
				this.notepadView.enableWordWrap();
			} 
			else {
				this.notepadView.disableWordWrap();
			}
		} 
		else if (src.equals("Status Bar")) {
			AbstractButton checkBox = (AbstractButton) e.getSource();
			boolean check = checkBox.getModel().isSelected();
			if (check) {
				this.notepadView.enableToolBar();
			} 
			else {
				this.notepadView.disableToolBar();
			}
		}
	}
	
	public void saveFile (String pathFile) {
		try {
			PrintWriter pw = new PrintWriter(pathFile, "UTF-8");
			String data = this.notepadView.getjTextAreaNote().getText();
			pw.print(data);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
