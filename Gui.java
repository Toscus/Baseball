import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Gui extends JPanel implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]){
    	//Creating the Frame
        JFrame frame = new JFrame("Baseball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        //JMenu m1 = new JMenu("FILE");
        //JMenu m2 = new JMenu("Help");
        //mb.add(m1);
        //mb.add(m2);
        //JMenuItem m11 = new JMenuItem("Open");
        //JMenuItem m22 = new JMenuItem("Save as");
        //m1.add(m11);
        //m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts up to 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);
        
        DefaultTableModel MyTablemodel = new DefaultTableModel();

        MyTablemodel.addColumn("Guess");
        MyTablemodel.addColumn("Strikes");
        MyTablemodel.addColumn("Balls");
        // Text Area at the Center
        JTextArea ta = new JTextArea();
        JTable hist = new JTable(MyTablemodel);
        JScrollPane MyScrollPane= new JScrollPane(hist);
        ta.setEditable(false);
        TableColumnModel columnModel = hist.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(0).setMaxWidth(80);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(1).setMaxWidth(50);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(2).setMaxWidth(50);

                
        final String newline = "\n";
        //String content = "";

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        //frame.getContentPane().add(BorderLayout.EAST, hist);
        frame.getContentPane().add(BorderLayout.EAST, MyScrollPane);
        MyScrollPane.setPreferredSize(new Dimension(180,600));
        frame.setVisible(true);
        
        send.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ae) {
        		String getValue = tf.getText();
        		ta.append(getValue + newline);
        		MyTablemodel.addRow(new Object[]{getValue, "Column 2", "Column 3"});
        		//hist.append(getValue + newline);
        		//content = content + getValue;
        	}
        });
        
        tf.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e){
        		String getValue = tf.getText();
         		ta.append(getValue + newline);
         		MyTablemodel.addRow(new Object[]{getValue, "Column 2", "Column 3"});
        	 }
        });
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
