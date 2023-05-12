

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bai10_createMenu extends JFrame {
	MenuBar mb;
	Menu file,edit;
	public bai10_createMenu(String t) {
		super(t);
		GUI();
	}
	public void GUI() {
		setBounds(300,200,200,200);
		mb=new MenuBar();
		setMenuBar(mb);
		
		file=new Menu("File");
		file.add(new MenuItem("New"));
		file.add(new MenuItem("Open"));
		file.add(new MenuItem("Save"));
		file.add(new MenuItem("Exit"));
		mb.add(file);
		
		edit=new Menu("Edit");
		
		edit.add(new MenuItem("Copy"));
		edit.add(new MenuItem("Cut"));
		edit.add(new MenuItem("Paste"));
		
		
		Menu sub=new Menu("Option");
		sub.add(new MenuItem("First"));
		sub.add(new MenuItem("Second"));
		sub.add(new MenuItem("Third"));
		edit.add(sub);
		edit.add(new CheckboxMenuItem("Protected"));
		
		mb.add(edit);
		show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new bai10_createMenu("Menu");
	}

}
