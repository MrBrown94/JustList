package justList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Search extends Thread {

	private TableRowSorter<TableModel> rowSorter; 
    private JTextField txt = null;
    
    public Search(JTable tb, JTextField txt) {
    	
    	this.txt = txt;
    	
    	rowSorter = new TableRowSorter<>(tb.getModel());
    	tb.setRowSorter(rowSorter);
    }
    
    public void run() {
    
    //public void searchUpdate() {
   	
    	txt.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
            	
                String text = txt.getText();

                if(!text.equals("Ricerca") && !(rowSorter.getViewRowCount() == 0)) {
                	
	                if (text.trim().length() == 0) {
	                    rowSorter.setRowFilter(null);
	                } else {
	                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	                }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	
            	String text = txt.getText();
		
	            if (text.trim().length() == 0) {
	                rowSorter.setRowFilter(null);
	            } else {
	                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	            }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Non supportato.");
            }
        });
    }
}