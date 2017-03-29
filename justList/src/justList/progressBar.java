package justList;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Toolkit;

public class progressBar extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar;

	public progressBar(int max) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setAlwaysOnTop(true);
		setTitle("Carico...");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(max);
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		progressBar.setStringPainted(true);
		contentPane.add(progressBar, BorderLayout.CENTER);
	}
	
	public void prog(int n) {
		
		progressBar.setValue(n);
	}

}
