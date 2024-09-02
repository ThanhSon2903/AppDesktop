package Test;

import javax.swing.UIManager;

import View.QLSVview;



public class test {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLSVview();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
