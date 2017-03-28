package justList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Search extends JPanel {

	private static final long serialVersionUID = 1L;
	
    private TableRowSorter<TableModel> rowSorter;

    public Search(JTable tb, JTextField txt) {
 
    	rowSorter = new TableRowSorter<>(tb.getModel());
    	
    	tb.setRowSorter(rowSorter);
    	txt.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
            	
                String text = txt.getText();

                if(!text.equals("Ricerca") || text.equals("")) {
                	
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
		
            	if(!text.equals("Ricerca") || text.equals("")) {
            		
		            if (text.trim().length() == 0) {
		                rowSorter.setRowFilter(null);
		            } else {
		                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		            }
            	}
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Non supportato.");
            }

        });
    }
}