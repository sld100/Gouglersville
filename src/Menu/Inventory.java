/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import static Menu.Reports.intKEYCOLUMN;
import static java.awt.event.PaintEvent.UPDATE;
import static java.lang.reflect.Array.set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.accessibility.AccessibleTableModelChange.UPDATE;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import static javax.swing.event.TableModelEvent.UPDATE;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author levat_000
 */
public class Inventory extends javax.swing.JFrame 
{

    Connection inputInventoryConnect = null;
Statement inputInventoryStatement = null;
ListSelectionListener listSelectionListener;
ResultSet inputInventoryRS; 
DefaultListModel tableNames = new DefaultListModel();
public static final int intKEYCOLUMN = 0;
String inputDate;
private Object dataDate;

     
     

public Inventory(Connection inConnect) 
{
initComponents();
inputInventoryConnect = inConnect;

    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inputInventoryTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        inputInventoryDate = new javax.swing.JFormattedTextField();
        inventoryReturnToMain = new javax.swing.JButton();
        inputInventory = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(965, 543, 543, 543));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        inputInventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inputInventoryTable.setOpaque(false);
        jScrollPane1.setViewportView(inputInventoryTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Date ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Truck In ");

        inputInventoryDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        inputInventoryDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputInventoryDateActionPerformed(evt);
            }
        });

        inventoryReturnToMain.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        inventoryReturnToMain.setText("Return to Main ");
        inventoryReturnToMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryReturnToMainActionPerformed(evt);
            }
        });

        inputInventory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inputInventory.setText("Open Truck Report ");
        inputInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputInventoryActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Reconcile Inventory");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputInventoryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(inputInventory)))
                .addGap(391, 391, 391))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(inventoryReturnToMain, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(429, 429, 429)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputInventoryDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(76, 76, 76)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(inventoryReturnToMain, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inventoryReturnToMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryReturnToMainActionPerformed
         MainFrame MF = new MainFrame();
          MF.main(null);
          this.dispose();
    }//GEN-LAST:event_inventoryReturnToMainActionPerformed

 private void createNewTableModel() 
 {
    inputInventoryTable.setModel(DbUtils.resultSetToTableModel(inputInventoryRS));
  
 }

    public void valueChanged(ListSelectionEvent e)
    {
        if (e.getValueIsAdjusting())
        {
           inputInventoryTable.getModel().addTableModelListener((TableModelListener) this); 
           
            
            
        }// end if 
        }// end method value cahnged 
     // end list listners  
     // end method to fill and start jlist 
    
  public void fillInputTable ()
 {
     try
     {
    inputInventoryStatement = inputInventoryConnect.createStatement();
           inputInventoryRS = inputInventoryStatement.executeQuery("Select * from Truck_In");
                              
             inputInventoryTable.setModel(DbUtils.resultSetToTableModel(inputInventoryRS));
          inputInventoryTable.getModel().addTableModelListener((TableModelListener) this); 
          
              
          
                                            
         } 
     catch (SQLException ex) 
     {
             Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
         }
   
 }
  public void runCurrentDate()
{
DateTimeFormatter defaultDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate localDate = LocalDate.now();
System.out.println(defaultDate.format(localDate));
inputInventoryDate.setText(localDate.toString());

}
    private void inputInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputInventoryActionPerformed
     

        try {
            inputDate = inputInventoryDate.getText();
            
            if (inputInventoryDate.getText().equals("") )
            {
                runCurrentDate();
                
            }
            
            
            
            inputInventoryStatement = inputInventoryConnect.createStatement();
            inputInventoryRS = inputInventoryStatement.executeQuery("SELECT Product_No, Product_Desc, ' ' AS Cases, ' ' AS Items_Per_Case, ' ' AS Total_Items_Recieved FROM Truck_In");
            inputInventoryTable.setModel(DbUtils.resultSetToTableModel(inputInventoryRS));
           
            inputInventoryTable.getModel().addTableModelListener(new TableModelListener()
             
            {
                @Override
                public void tableChanged(TableModelEvent e)
                {
                    int it = -1;
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    TableModel model = (TableModel)e.getSource();
                   Object iKey = model.getValueAt(row, intKEYCOLUMN);
                    Object data = model.getValueAt(row, column);
                    System.out.println("key = " + iKey + "   data = " + data);
                    boolean rowColored = true;
                    dataDate=inputInventoryDate.getText();
                    Object dataColumn = model.getColumnName(column);
                    try
                    {
                        String strSQL = "UPDATE Truck_In SET " + dataColumn + " = " + data + ", DATE =" + dataDate  + " WHERE Product_No ='"+ iKey + "';";
                        System.out.println("strSQL = " + strSQL);
                        it = inputInventoryStatement.executeUpdate(strSQL);
                    }
                    catch (SQLException ex)
                    {
                        Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(it + " rows updated");
                }
            });     } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_inputInventoryActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

try {   
    System.out.println(dataDate);
int it =inputInventoryStatement.executeUpdate("UPDATE Truck_In set Total_Items_Recieved = Cases * Items_Per_Case Where Date ="+ dataDate +";");

it =inputInventoryStatement.executeUpdate("UPDATE Truck_In set OnHand = OnHand + (select Total_Items_Recieved Where Date ="+ dataDate + ");");

ResultSet rs = inputInventoryStatement.executeQuery("SELECT *FROM Truck_In");
//TableModel inventory = new inventoryTableModel(); 
        inputInventoryTable.setModel(DbUtils.resultSetToTableModel(inputInventoryRS));
inputInventoryTable.getColumn("Date").setMaxWidth(0);
        inputInventoryTable.getColumn("Date").setMinWidth(0);
        inputInventoryTable.getColumn("Date").setMaxWidth(0);
        inputInventoryTable.getColumn("Date").setWidth(0);
} catch (SQLException ex) {
Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
}

// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    private void inputInventoryDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputInventoryDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputInventoryDateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {

        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>
            
            /* Create and display the form */
            
            String DataBase = "org.sqlite.JDBC";
            String JDBCThinger = "jdbc:sqlite:";
            String DBName = "F:\\Gouglersville (Unzipped Files)\\Gouglersville\\src\\Menu\\GouglersvilleMenu.db";
            Class.forName(DataBase);
            Connection connect = DriverManager.getConnection(JDBCThinger + DBName);
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Inventory(connect).setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inputInventory;
    private javax.swing.JFormattedTextField inputInventoryDate;
    private javax.swing.JTable inputInventoryTable;
    private javax.swing.JButton inventoryReturnToMain;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

    
        
