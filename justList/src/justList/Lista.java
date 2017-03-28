package justList;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.UIManager;
import java.awt.Font;

public class Lista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField formRicerca;
	private JPanel lyTab;
	private JTable tbIngrosso;
	
	Object elements[][];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista frame = new Lista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Lista() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(963, 473);
		Toolkit tk = getToolkit();
	    Dimension dim = tk.getScreenSize();
	    int x = (int) (dim.getWidth() - getWidth()) / 2;
	    int y = (int) (dim.getHeight() - getHeight()) / 2;
	    setLocation(x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{84, 741, 84, 0};
		gbl_contentPane.rowHeights = new int[]{73, 308, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 40.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		formRicerca = new JTextField();
		formRicerca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		formRicerca.setToolTipText("Ricerca");
		formRicerca.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if(formRicerca.getText().equals("")) {
					
					formRicerca.setText("Ricerca");
					formRicerca.setFocusable(false);
				}
			}
		});
		formRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				formRicerca.setFocusable(true);
				formRicerca.requestFocus();
				
				if(formRicerca.getText().equals("Ricerca")) {
					
					formRicerca.setText("");
				}
			}
		});
		formRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(!(formRicerca.getText().equals("Ricerca") || formRicerca.getText().equals(""))){
					
					//Search search = new Search(tbIngrosso, formRicerca);
				}
			}
		});
		formRicerca.setText("Ricerca");
		formRicerca.setHorizontalAlignment(SwingConstants.LEFT);
		formRicerca.setColumns(30);
		GridBagConstraints gbc_formRicerca = new GridBagConstraints();
		gbc_formRicerca.anchor = GridBagConstraints.WEST;
		gbc_formRicerca.insets = new Insets(0, 0, 5, 5);
		gbc_formRicerca.gridx = 1;
		gbc_formRicerca.gridy = 0;
		contentPane.add(formRicerca, gbc_formRicerca);
		
		lyTab = new JPanel();
		GridBagConstraints gbc_lyTab = new GridBagConstraints();
		gbc_lyTab.insets = new Insets(0, 0, 0, 5);
		gbc_lyTab.fill = GridBagConstraints.BOTH;
		gbc_lyTab.gridx = 1;
		gbc_lyTab.gridy = 1;
		contentPane.add(lyTab, gbc_lyTab);
		GridBagLayout gbl_lyTab = new GridBagLayout();
		gbl_lyTab.columnWidths = new int[]{657, 0};
		gbl_lyTab.rowHeights = new int[]{33, 270, 0};
		gbl_lyTab.columnWeights = new double[]{5.0, Double.MIN_VALUE};
		gbl_lyTab.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		lyTab.setLayout(gbl_lyTab);
		
		tbIngrosso = new JTable();
		tbIngrosso.setFont(new Font("Tahoma", Font.PLAIN, 23));
		tbIngrosso.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 30 ));
		tbIngrosso.setForeground(UIManager.getColor("Button.disabled"));
		tbIngrosso.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	        
	        }
	    });
		tbIngrosso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//tbIngrosso.setBounds(0, 0, 610, 326);
		GridBagConstraints gbc_tbIngrosso = new GridBagConstraints();
		gbc_tbIngrosso.fill = GridBagConstraints.BOTH;
		gbc_tbIngrosso.gridx = 0;
		gbc_tbIngrosso.gridy = 1;
		lyTab.add(tbIngrosso, gbc_tbIngrosso);
		
		JScrollPane tbIngrossoHead  = new JScrollPane(tbIngrosso);
		tbIngrossoHead.setEnabled(false);
		tbIngrossoHead.setBounds(10, 0, 612, 352);
		GridBagConstraints gbc_tbIngrossoHead = new GridBagConstraints();
		gbc_tbIngrossoHead.gridheight = 2;
		gbc_tbIngrossoHead.insets = new Insets(0, 0, 5, 0);
		gbc_tbIngrossoHead.fill = GridBagConstraints.BOTH;
		gbc_tbIngrossoHead.gridx = 0;
		gbc_tbIngrossoHead.gridy = 0;
		lyTab.add(tbIngrossoHead, gbc_tbIngrossoHead);
		
		tableSettings();
		formRicerca.setFocusable(false);
		tbIngrosso.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

	}
	
	
	public void tableSettings() {
		
		tbIngrosso.setAutoResizeMode(5);
		
		tbIngrosso.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrizione", "Capacità", "Prezzo"
			}
		));
		tbIngrosso.getColumnModel().getColumn(0).setPreferredWidth(700);
		
	}
}

