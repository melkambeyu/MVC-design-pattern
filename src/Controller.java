
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Engineer Melkam Beyu
 */
public class Controller {
    
    
    private javax.swing.JButton delet;
    private javax.swing.JTextField dp_txt;
    private javax.swing.JButton edit;
    private javax.swing.JTextField fn_txt;
    private javax.swing.JTextField id_txt;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ln_txt;
    private javax.swing.JTable table_display;
    
     public Connection getConnection(){
        Connection con;
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost/mysql?useSSL=false","root","");
            return con;
            
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
                    
        }
        
    }
     public ArrayList<User> getUsersList(){
        ArrayList<User> usersList=new ArrayList<User>();
        Connection connection =getConnection();
        
        String query ="SELECT * FROM `users`";
        Statement st;
        ResultSet rs;
        try{
            st=connection.createStatement();
            rs=st.executeQuery(query);
            User user;
            while(rs.next()){
                user=new User(rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getString("department"));
                usersList.add(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return usersList;
    }
    
      public void Show_Users_In_Table(){
        ArrayList<User> list =getUsersList();
        DefaultTableModel model=(DefaultTableModel)table_display.getModel();
        Object[]row =new Object[4];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getfirstname();
            row[2]=list.get(i).getlastname();
            row[3]=list.get(i).getdepa();
            model.addRow(row); 
        }
    }
      
      public void executeSQLQuery(String query,String message){
        Connection con =getConnection();
        Statement st;
        try{
            st=con.createStatement();
            if(st.executeUpdate(query) ==1){
                DefaultTableModel model=(DefaultTableModel)table_display.getModel();
                model.setRowCount(0);
                Show_Users_In_Table();
                JOptionPane.showMessageDialog(null,"Data"+message+"Susseccfully");
            }else{
                JOptionPane.showMessageDialog(null,"Data not"+message);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
      
      public void insert(){
           String query="INSERT INTO `users`(`id`, `fname`, `lname`, `department`) VALUES ('"+id_txt.getText()+"','"+fn_txt.getText()+"','"+ln_txt.getText()+"','"+dp_txt.getText()+"')";
        executeSQLQuery(query,"Inserted");
      }
      
      public void edit(){
          String query ="UPDATE `users` SET `id`='"+id_txt.getText()+"',`fname`='"+fn_txt.getText()+"',`lname`='"+ln_txt.getText()+"',`department`='"+dp_txt.getText()+"' WHERE `id` ="+id_txt.getText(); 
        executeSQLQuery(query,"Updated");
      }
      
      public void delete(){
           String query="DELETE FROM `users` WHERE id ="+id_txt.getText();
        executeSQLQuery(query,"Deleted");
          
      }
      
      public void tableDisplay(){
          int i =table_display.getSelectedRow();
        TableModel model=table_display.getModel();
        id_txt.setText(model.getValueAt(i,0).toString());
        fn_txt.setText(model.getValueAt(i,1).toString());
        ln_txt.setText(model.getValueAt(i,2).toString());
        dp_txt.setText(model.getValueAt(i,3).toString());
      }
      
      
      
    
}
