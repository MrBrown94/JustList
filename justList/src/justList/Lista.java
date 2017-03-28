package justList;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

public class Lista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField formRicerca;
	private JPanel lyTab;
	private JTable tbIngrosso;
	private JPanel buttonsBar;
	private boolean selected = false;

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

	/**
	 * Create the frame.
	 */
	public Lista(boolean edit) {
		
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
		gbl_contentPane.rowHeights = new int[]{48, 42, 308, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 23.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		formRicerca = new JTextField();
		formRicerca.setHorizontalAlignment(SwingConstants.LEFT);
		formRicerca.setColumns(30);
		formRicerca.setToolTipText("Ricerca");
		formRicerca.setText("Ricerca");
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
		
		GridBagConstraints gbc_formRicerca = new GridBagConstraints();
		gbc_formRicerca.anchor = GridBagConstraints.SOUTH;
		gbc_formRicerca.insets = new Insets(0, 0, 5, 5);
		gbc_formRicerca.fill = GridBagConstraints.HORIZONTAL;
		gbc_formRicerca.gridx = 1;
		gbc_formRicerca.gridy = 0;
		contentPane.add(formRicerca, gbc_formRicerca);
		
		buttonsBar = new JPanel();
		buttonsBar.setLayout(null);
		GridBagConstraints gbc_buttonsBar = new GridBagConstraints();
		gbc_buttonsBar.insets = new Insets(0, 0, 5, 5);
		gbc_buttonsBar.fill = GridBagConstraints.BOTH;
		gbc_buttonsBar.gridx = 1;
		gbc_buttonsBar.gridy = 1;
		contentPane.add(buttonsBar, gbc_buttonsBar);
		
		JButton btnElimina = new JButton("Elimina");

		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
					if(!selected) {
						
						JOptionPane.showMessageDialog(contentPane,
						"Seleziona un elemento da eliminare.",
						"Inane warning",
						JOptionPane.WARNING_MESSAGE);
					}
			
					else{	
							int index = (int)tbIngrosso.convertRowIndexToModel(tbIngrosso.getSelectedRow());
							//xmlEditFile xmlEdit = new xmlEditFile();
							
							//xmlEdit.deleteElement(index);
							//formRicerca.setText("Ricerca");
							
					//refresh ad ogni eliminazione
							
						//ricarica nell'array i dati dall' xml
							//Splash.preeUpdate();
						//ricrea la tabella usando i nuovi array
							dettaglioSettings();
							selected = false;
						}
					
					tbIngrosso.getColumnModel().getColumn(0).setPreferredWidth(400);
					tbIngrosso.getColumnModel().getColumn(5).setPreferredWidth(10);
			}
		});
		btnElimina.setBounds(118, 5, 96, 25);
		buttonsBar.add(btnElimina);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!selected) {
							
							JOptionPane.showMessageDialog(contentPane,
							"Seleziona un elemento da modificare.",
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
						
					}
				
				else {
						int index = tbIngrosso.convertRowIndexToModel(tbIngrosso.getSelectedRow());
						
						//nuova instanza window1
						
						//Window1 window1Edit  = new Window1(index);
						//visualizzazione Window1Edit
						//window1Edit.setVisible(true);
						
						selected = false;
						
						dispose();
						tbIngrosso.getColumnModel().getColumn(0).setPreferredWidth(400);
						tbIngrosso.getColumnModel().getColumn(5).setPreferredWidth(10);
					 }
				}
		});
		btnModifica.setBounds(6, 5, 100, 25);
		buttonsBar.add(btnModifica);
		
		lyTab = new JPanel();
		GridBagConstraints gbc_lyTab = new GridBagConstraints();
		gbc_lyTab.insets = new Insets(0, 0, 0, 5);
		gbc_lyTab.fill = GridBagConstraints.BOTH;
		gbc_lyTab.gridx = 1;
		gbc_lyTab.gridy = 2;
		contentPane.add(lyTab, gbc_lyTab);
		GridBagLayout gbl_lyTab = new GridBagLayout();
		gbl_lyTab.columnWidths = new int[]{657, 0};
		gbl_lyTab.rowHeights = new int[]{33, 270, 0};
		gbl_lyTab.columnWeights = new double[]{5.0, Double.MIN_VALUE};
		gbl_lyTab.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		lyTab.setLayout(gbl_lyTab);
		
		tbIngrosso = new JTable();
		tbIngrosso.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	            selected = true;
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
		tbIngrossoHead.setBounds(10, 0, 612, 352);
		tbIngrossoHead.setEnabled(false);
		GridBagConstraints gbc_tbIngrossoHead = new GridBagConstraints();
		gbc_tbIngrossoHead.gridheight = 2;
		gbc_tbIngrossoHead.insets = new Insets(0, 0, 5, 0);
		gbc_tbIngrossoHead.fill = GridBagConstraints.BOTH;
		gbc_tbIngrossoHead.gridx = 0;
		gbc_tbIngrossoHead.gridy = 0;
		lyTab.add(tbIngrossoHead, gbc_tbIngrossoHead);
		
		dettaglioSettings();
		formRicerca.setFocusable(false);
		tbIngrosso.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		tbIngrosso.getColumnModel().getColumn(0).setPreferredWidth(400);
		tbIngrosso.getColumnModel().getColumn(5).setPreferredWidth(10);
	}
	
	public Lista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Lista.class.getResource("/icon.png")));
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
		gbl_contentPane.rowHeights = new int[]{48, 42, 308, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 26.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		formRicerca = new JTextField();
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
		gbc_formRicerca.fill = GridBagConstraints.HORIZONTAL;
		gbc_formRicerca.anchor = GridBagConstraints.SOUTH;
		gbc_formRicerca.insets = new Insets(0, 0, 5, 5);
		gbc_formRicerca.gridx = 1;
		gbc_formRicerca.gridy = 0;
		contentPane.add(formRicerca, gbc_formRicerca);
		
		buttonsBar = new JPanel();
		buttonsBar.setLayout(null);
		GridBagConstraints gbc_buttonsBar = new GridBagConstraints();
		gbc_buttonsBar.insets = new Insets(0, 0, 5, 5);
		gbc_buttonsBar.fill = GridBagConstraints.BOTH;
		gbc_buttonsBar.gridx = 1;
		gbc_buttonsBar.gridy = 1;
		contentPane.add(buttonsBar, gbc_buttonsBar);
		
		JButton btnIngrosso = new JButton("Ingrosso");
		JButton btnDettaglio = new JButton("Dettaglio");
		
		btnIngrosso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ingrossoSettings();
				tbIngrosso.getColumnModel().getColumn(0).setPreferredWidth(400);
				tbIngrosso.getColumnModel().getColumn(5).setPreferredWidth(10);
				
				formRicerca.setText("Ricerca");
				
				btnIngrosso.setEnabled(false);
				btnDettaglio.setEnabled(true);
			}
		});
		btnIngrosso.setBounds(8, 5, 96, 25);
		buttonsBar.add(btnIngrosso);
		
		btnDettaglio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dettaglioSettings();
				tbIngrosso.getColumnModel().getColumn(0).setPreferredWidth(400);
				tbIngrosso.getColumnModel().getColumn(5).setPreferredWidth(10);
				
				formRicerca.setText("Ricerca");
				
				btnDettaglio.setEnabled(false);
				btnIngrosso.setEnabled(true);
			}
		});
		btnDettaglio.setBounds(120, 5, 100, 25);
		buttonsBar.add(btnDettaglio);
		
		lyTab = new JPanel();
		GridBagConstraints gbc_lyTab = new GridBagConstraints();
		gbc_lyTab.insets = new Insets(0, 0, 0, 5);
		gbc_lyTab.fill = GridBagConstraints.BOTH;
		gbc_lyTab.gridx = 1;
		gbc_lyTab.gridy = 2;
		contentPane.add(lyTab, gbc_lyTab);
		GridBagLayout gbl_lyTab = new GridBagLayout();
		gbl_lyTab.columnWidths = new int[]{657, 0};
		gbl_lyTab.rowHeights = new int[]{33, 270, 0};
		gbl_lyTab.columnWeights = new double[]{5.0, Double.MIN_VALUE};
		gbl_lyTab.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		lyTab.setLayout(gbl_lyTab);
		
		tbIngrosso = new JTable();
		tbIngrosso.setForeground(UIManager.getColor("Button.disabled"));
		tbIngrosso.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	            selected = true;
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
		
		dettaglioSettings();
		btnDettaglio.setEnabled(false);
		formRicerca.setFocusable(false);
		tbIngrosso.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		tbIngrosso.getColumnModel().getColumn(0).setPreferredWidth(400);
		tbIngrosso.getColumnModel().getColumn(5).setPreferredWidth(10);
	}
	
	
	public void dettaglioSettings() {
		
		tbIngrosso.setAutoResizeMode(5);
		/*
		 * tbIngrosso.setModel(new DefaultTableModel(
		
		elements,
		new String[] {
			"Denominazione", "Colore", "Paese d'origine", "Capacit\u00E0", "Dettaglio", "Disponibile"
			}
		) {
		/**
			 * 
			 
			private static final long serialVersionUID = 1L;
		@SuppressWarnings("rawtypes")
		Class[] columnTypes = new Class[] {
			String.class, String.class, String.class, String.class, String.class, String.class
		};
		@SuppressWarnings("unchecked")
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
		public boolean isCellEditable(int row, int column) {       
		       return false;
		}
		});
		*/
		tbIngrosso.setAutoCreateRowSorter(true);
	}
	
	@SuppressWarnings("rawtypes")
	public void ingrossoSettings() {
		/*
		tbIngrosso.setModel(new DefaultTableModel(
		varie.Splash.NoDettaglio,
		new String[] {
			"Denominazione", "Colore", "Paese d'origine", "Capacit\u00E0", "Ingrosso", "Disponibile"
		}
		) {
		/**
		 * 
		
		private static final long serialVersionUID = 1L;
		
		Class[] columnTypes = new Class[] {
			String.class, String.class, String.class, String.class, String.class, String.class
		};
		@SuppressWarnings("unchecked")
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
		
		public boolean isCellEditable(int row, int column) {       
		       return false;
		}
		});
		*/
		tbIngrosso.setAutoCreateRowSorter(true);
	}
}

