package fuck;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import configReader.Configreader;
import connector.Connector;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Change_Score {

  public JFrame frame;
  private JTextField textField_studentid;
  private JTextField textField_semester;
  private JTextField textField_courseid;
  private JLabel label_2;
  private JTextField textField_teacherid;
  private JLabel label_3;
  private JTextField textField_score;
  private JButton button;
  private JTextField textField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Change_Score window = new Change_Score();
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
  public Change_Score() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 429, 421);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setTitle("修改成绩");
    
    textField_studentid = new JTextField();
    textField_studentid.setBounds(200, 40, 108, 32);
    frame.getContentPane().add(textField_studentid);
    textField_studentid.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("学号：");
    lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    lblNewLabel.setBounds(79, 40, 115, 32);
    frame.getContentPane().add(lblNewLabel);
    
    JLabel label = new JLabel("学期：");
    label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label.setBounds(79, 90, 115, 32);
    frame.getContentPane().add(label);
    
    textField_semester = new JTextField();
    textField_semester.setColumns(10);
    textField_semester.setBounds(200, 90, 108, 32);
    frame.getContentPane().add(textField_semester);
    
    JLabel label_1 = new JLabel("课程编号：");
    label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_1.setBounds(79, 140, 115, 32);
    frame.getContentPane().add(label_1);
    
    textField_courseid = new JTextField();
    textField_courseid.setColumns(10);
    textField_courseid.setBounds(200, 140, 108, 32);
    frame.getContentPane().add(textField_courseid);
    
    label_2 = new JLabel("教师编号：");
    label_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_2.setBounds(79, 190, 115, 32);
    frame.getContentPane().add(label_2);
    
    textField_teacherid = new JTextField();
    textField_teacherid.setColumns(10);
    textField_teacherid.setBounds(200, 190, 108, 32);
    frame.getContentPane().add(textField_teacherid);
    
    label_3 = new JLabel("修改后成绩：");
    label_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_3.setBounds(79, 240, 115, 32);
    frame.getContentPane().add(label_3);
    
    textField_score = new JTextField();
    textField_score.setColumns(10);
    textField_score.setBounds(200, 240, 108, 32);
    frame.getContentPane().add(textField_score);
    
    button = new JButton("确认修改");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String studentid = textField_studentid.getText();
          String semester = textField_semester.getText();
          String courseid = textField_courseid.getText();
          String teacherid = textField_teacherid.getText();
          String score = textField_score.getText();
          Configreader reader = Configreader.reader("config.txt");
          String tablename = reader.readItem("scores");
          String scores_studentid = reader.readItem("scores_studentid");
          String scores_semester = reader.readItem("scores_semester");
          String scores_courseid = reader.readItem("scores_courseid");
          String scores_teacherid = reader.readItem("scores_teacherid");
          String scores_score = reader.readItem("scores_score");
          String sql = "update " + tablename + " set " + scores_score + "=" + score + " where " + 
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
    button.setBounds(21, 289, 108, 74);
    frame.getContentPane().add(button);
    
    textField = new JTextField();
    textField.setBounds(140, 291, 248, 72);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
  }
}
