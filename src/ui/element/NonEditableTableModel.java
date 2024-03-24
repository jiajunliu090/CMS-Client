package ui.element;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class NonEditableTableModel extends DefaultTableModel {
    // Constructor
    public NonEditableTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    // Override the isCellEditable method to make all cells non-editable
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}