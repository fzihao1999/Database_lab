package fuck;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import configReader.Configreader;
import connector.Connector;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddandDelete {

  public JFrame frame;
  private JTextField textField_courseid;
  private JTextField textField_semester;
  private JTextField textField_studentid;
  private JTextField textField_teacher;
  private JTextField textField_score;
  private JTextField textField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AddandDelete window = new AddandDelete();
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
  public AddandDelete() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    
    frame = new JFrame();
    frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 18));
    frame.setBounds(100, 100, 408, 495);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setTitle("添加与删除成绩");
    
    JLabel lblid = new JLabel("学号：");
    lblid.setFont(new Font("Dialog", Font.PLAIN, 18));
    lblid.setBounds(74, 30, 135, 26);
    frame.getContentPane().add(lblid);
    
    JLabel label_3 = new JLabel("学期：");
    label_3.setFont(new Font("Dialog", Font.PLAIN, 18));
    label_3.setBounds(74, 75, 135, 26);
    frame.getContentPane().add(label_3);
    
    JLabel lblid_1 = new JLabel("课程编号：");
    lblid_1.setFont(new Font("Dialog", Font.PLAIN, 18));
    lblid_1.setBounds(74, 120, 135, 26);
    frame.getContentPane().add(lblid_1);
    
    JLabel label_5 = new JLabel("教师编号");
    label_5.setFont(new Font("Dialog", Font.PLAIN, 18));
    label_5.setBounds(74, 165, 135, 26);
    frame.getContentPane().add(label_5);
    
    JLabel label_6 = new JLabel("成绩：");
    label_6.setFont(new Font("Dialog", Font.PLAIN, 18));
    label_6.setBounds(74, 210, 135, 26);
    frame.getContentPane().add(label_6);
    
    textField_courseid = new JTextField();
    textField_courseid.setColumns(10);
    textField_courseid.setBounds(201, 120, 103, 26);
    frame.getContentPane().add(textField_courseid);
    
    textField_semester = new JTextField();
    textField_semester.setColumns(10);
    textField_semester.setBounds(201, 75, 103, 26);
    frame.getContentPane().add(textField_semester);
    
    textField_studentid = new JTextField();
    textField_studentid.setColumns(10);
    textField_studentid.setBounds(201, 30, 103, 26);
    frame.getContentPane().add(textField_studentid);
    
    textField_teacher = new JTextField();
    textField_teacher.setColumns(10);
    textField_teacher.setBounds(201, 165, 103, 26);
    frame.getContentPane().add(textField_teacher);
    
    textField_score = new JTextField();
    textField_score.setColumns(10);
    textField_score.setBounds(201, 210, 103, 26);
    frame.getContentPane().add(textField_score);
    
    JButton btnNewButton = new JButton("添加");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String studentid = textField_studentid.getText();
          String semester = textField_semester.getText();
          String courseid = textField_courseid.getText();
          String teacherid = textField_teacher.getText();
          String score = textField_score.getText();
          Configreader reader = Configreader.reader("config.txt");
          String tablename = reader.readItem("scores");
          String scores_studentid = reader.readItem("scores_studentid");
          String scores_semester = reader.readItem("scores_semester");
          String scores_courseid = reader.readItem("scores_courseid");
          String scores_teacherid = reader.readItem("scores_teacherid");
          String sql = "insert into " + tablename + " values (" + studentid + "," + 
              semester + "," + courseid + "," + score + "," + teacherid + ")";
          String check_sql = "select * from " + tablename + " where " + 
              scores_studentid + "=" + studentid + " and " +
              scores_semester + "=" + semester + " and " + 
              scores_courseid + "=" + courseid + " and " + 
              scores_teacherid + "=" + teacherid;
         
          Connection conn = Connector.getConnection();
          PreparedStatement psmt_check = conn.prepareStatement(check_sql);
          ResultSet rs = psmt_check.executeQuery();
          if(rs.next()) {
            textField.setText("The score is exist");
          } else {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.executeUpdate();
            textField.setText("Success!");
          }
        } catch (Exception exception) {
          exception.printStackTrace();
        }
      }
    });
    btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    btnNewButton.setBounds(66, 267, 103, 52);
    frame.getContentPane().add(btnNewButton);
    
    JButton button = new JButton("删除\r\n");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String studentid = textField_studentid.getText();
          String semester = textField_semester.getText();
          String courseid = textField_courseid.getText();
          String teacherid = textField_teacher.getText();
          Configreader reader = Configreader.reader("config.txt");
          String tablename = reader.readItem("scores");
          String scores_studentid = reader.readItem("scores_studentid");
          String scores_semester = reader.readItem("scores_semester");
          String scores_courseid = reader.readItem("scores_courseid");
          String scores_teacherid = reader.readItem("scores_teacherid");
          String sql = "delete from " + tablename + " where " + 
              scores_studentid + "=" + studentid + " and " +
              scores_semester + "=" + semester + " and " + 
              scores_courseid + "=" + courseid + " and " + 
              scores_teacherid + "=" + teacherid;
          String check_sql = "select * from " + tablename + " where " + 
              scores_studentid + "=" + studentid + " and " +
              scores_semester + "=" + semester + " and " + 
              scores_courseid + "=" + courseid + " and " + 
              scores_teacherid + "=" + teacherid;
          
          Connection conn = Connector.getConnection();
          PreparedStatement psmt_check = conn.prepareStatement(check_sql);
          ResultSet rs = psmt_check.executeQuery();
          if(rs.next()) {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.executeUpdate();
            textField.setText("Success!");
          } else {
            textField.setText("The score is not exist");
          }
        } catch (Exception exception) {
          exception.printStackTrace();
        }
      }
    });
    button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    button.setBounds(211, 267, 103, 52);
    frame.getContentPane().add(button);
    
    textField = new JTextField();
    textField.setBounds(18, 343, 350, 84);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
  }
}
