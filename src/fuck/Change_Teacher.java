package fuck;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import configReader.Configreader;
import connector.Connector;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Change_Teacher {

  private JFrame frame;
  private JTextField textField_id;
  private JTextField textField_position;
  private JTextField textField_tel;
  private JTextField textField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Change_Teacher window = new Change_Teacher();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Change_Teacher() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 429, 347);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setTitle("修改教师信息");
    
    textField_id = new JTextField();
    textField_id.setBounds(215, 40, 108, 32);
    frame.getContentPane().add(textField_id);
    textField_id.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("教师编号：");
    lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    lblNewLabel.setBounds(87, 40, 115, 32);
    frame.getContentPane().add(lblNewLabel);
    
    JLabel label = new JLabel("修改教师职称：");
    label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label.setBounds(78, 90, 144, 32);
    frame.getContentPane().add(label);
    
    textField_position = new JTextField();
    textField_position.setColumns(10);
    textField_position.setBounds(215, 90, 108, 32);
    frame.getContentPane().add(textField_position);
    
    JLabel label_1 = new JLabel("修改教师电话：");
    label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_1.setBounds(78, 137, 144, 32);
    frame.getContentPane().add(label_1);
    
    textField_tel = new JTextField();
    textField_tel.setColumns(10);
    textField_tel.setBounds(215, 140, 108, 32);
    frame.getContentPane().add(textField_tel);
    
    JButton button = new JButton("确认修改");
    button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String teacherid = textField_id.getText();
          String position = textField_position.getText();
          String tel = textField_tel.getText();
          Configreader reader = Configreader.reader("config.txt");
          String tablename = reader.readItem("teachers");
          String teachers_id = reader.readItem("teachers_id");
          String teachers_position = reader.readItem("teachers_position");
          String teachers_tel = reader.readItem("teachers_tel");
          String sql = "update " + tablename + " set ";
          boolean flag = false;
          if(!position.equals("")) {
            flag = true;
            sql += teachers_position + "='" + position + "'";
          }
          if(!tel.equals("")) {
            if(flag) {
              sql += ", ";
            }
            sql += teachers_tel + "='" + tel + "'";
          }
          sql += " where " + teachers_id + "=" + teacherid;
          System.out.println(sql);
          String check_sql = "select * from " + tablename + " where " + teachers_id + "=" + teacherid;
          
          Connection conn = Connector.getConnection();
          PreparedStatement psmt_check = conn.prepareStatement(check_sql);
          ResultSet rs = psmt_check.executeQuery();
          if(rs.next()) {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.executeUpdate();
            textField.setText("Success!");
          } else {
            textField.setText("The teacher is not exist");
          }
        } catch (Exception exception){
          exception.printStackTrace();
        }
      }
    });
    button.setBounds(20, 197, 107, 75);
    frame.getContentPane().add(button);
    
    textField = new JTextField();
    textField.setBounds(141, 197, 250, 75);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
    
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
  }
}
