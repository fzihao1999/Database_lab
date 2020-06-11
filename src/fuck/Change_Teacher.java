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
  private JTextField textField_courseid;
  private JTextField textField_classid;
  private JTextField textField_semester;
  private JTextField textField;
  private JLabel label_2;
  private JTextField textField_teacherid;

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
    frame.setBounds(100, 100, 429, 389);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setTitle("修改任课教师");
    
    textField_courseid = new JTextField();
    textField_courseid.setBounds(215, 40, 108, 32);
    frame.getContentPane().add(textField_courseid);
    textField_courseid.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("课程编号：");
    lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    lblNewLabel.setBounds(87, 40, 115, 32);
    frame.getContentPane().add(lblNewLabel);
    
    JLabel label = new JLabel("修改后班级编号：");
    label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label.setBounds(68, 90, 144, 32);
    frame.getContentPane().add(label);
    
    textField_classid = new JTextField();
    textField_classid.setColumns(10);
    textField_classid.setBounds(215, 90, 108, 32);
    frame.getContentPane().add(textField_classid);
    
    JLabel label_1 = new JLabel("修改后开课学期：\r\n");
    label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_1.setBounds(68, 140, 144, 32);
    frame.getContentPane().add(label_1);
    
    textField_semester = new JTextField();
    textField_semester.setColumns(10);
    textField_semester.setBounds(215, 140, 108, 32);
    frame.getContentPane().add(textField_semester);
    
    JButton button = new JButton("确认修改");
    button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String courseid = textField_courseid.getText();
          String classid = textField_classid.getText();
          String semester = textField_semester.getText();
          String teacherid = textField_teacherid.getText();
          Configreader reader = Configreader.reader("config.txt");
          String tablename = reader.readItem("classcourse");
          String classcourse_classid = reader.readItem("classcourse_classid");
          String classcourse_semester = reader.readItem("classcourse_semester");
          String classcourse_courseid = reader.readItem("classcourse_courseid");
          String classcourse_teacherid = reader.readItem("classcourse_teacherid");
          String sql = "update " + tablename + " set " + classcourse_classid + "=" + classid +
              ", " + classcourse_semester + "=" + semester + 
              ", " + classcourse_teacherid + "=" + teacherid +
              " where " + classcourse_courseid + "=" + courseid;
          String check_sql = "select * from " + tablename + " where " + classcourse_courseid + "=" + courseid;
          
          Connection conn = Connector.getConnection();
          PreparedStatement psmt_check = conn.prepareStatement(check_sql);
          ResultSet rs = psmt_check.executeQuery();
          if(rs.next()) {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.executeUpdate();
            textField.setText("Success!");
          } else {
            textField.setText("The course is not exist");
          }
        } catch (Exception exception){
          exception.printStackTrace();
        }
      }
    });
    button.setBounds(20, 250, 107, 75);
    frame.getContentPane().add(button);
    
    textField = new JTextField();
    textField.setBounds(141, 250, 250, 75);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
    
    label_2 = new JLabel("修改后教师编号：");
    label_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_2.setBounds(68, 190, 170, 32);
    frame.getContentPane().add(label_2);
    
    textField_teacherid = new JTextField();
    textField_teacherid.setColumns(10);
    textField_teacherid.setBounds(215, 190, 108, 32);
    frame.getContentPane().add(textField_teacherid);
  }
}
