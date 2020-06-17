package window;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import configReader.Configreader;
import connector.Connector;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddStudent {

  public JFrame frame;
  private JTextField textField_age;
  private JTextField textField_sex;
  private JTextField textField_stuname;
  private JTextField textField_adderss;
  private JTextField textField_major;
  private JTextField textField_time;
  private JLabel label_1;
  private JLabel label_2;
  private JTextField textField_class;
  private JTextField textField_id;
  private JTextField textField_1;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AddStudent window = new AddStudent();
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
  public AddStudent() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 18));
    frame.setBounds(100, 100, 570, 600);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setTitle("添加学生");
    
    JLabel lblid = new JLabel("姓名：");
    lblid.setFont(new Font("Dialog", Font.PLAIN, 18));
    lblid.setBounds(101, 59, 135, 26);
    frame.getContentPane().add(lblid);
    
    JLabel label_3 = new JLabel("性别：");
    label_3.setFont(new Font("Dialog", Font.PLAIN, 18));
    label_3.setBounds(101, 104, 135, 26);
    frame.getContentPane().add(label_3);
    
    JLabel lblid_1 = new JLabel("年龄：");
    lblid_1.setFont(new Font("Dialog", Font.PLAIN, 18));
    lblid_1.setBounds(101, 149, 135, 26);
    frame.getContentPane().add(lblid_1);
    
    JLabel label_5 = new JLabel("生源所在地：");
    label_5.setFont(new Font("Dialog", Font.PLAIN, 18));
    label_5.setBounds(101, 194, 135, 26);
    frame.getContentPane().add(label_5);
    
    JLabel label_6 = new JLabel("专业：");
    label_6.setFont(new Font("Dialog", Font.PLAIN, 18));
    label_6.setBounds(101, 239, 135, 26);
    frame.getContentPane().add(label_6);
    
    textField_age = new JTextField();
    textField_age.setColumns(10);
    textField_age.setBounds(228, 149, 103, 26);
    frame.getContentPane().add(textField_age);
    
    textField_sex = new JTextField();
    textField_sex.setColumns(10);
    textField_sex.setBounds(228, 104, 103, 26);
    frame.getContentPane().add(textField_sex);
    
    textField_stuname = new JTextField();
    textField_stuname.setColumns(10);
    textField_stuname.setBounds(228, 59, 103, 26);
    frame.getContentPane().add(textField_stuname);
    
    textField_adderss = new JTextField();
    textField_adderss.setColumns(10);
    textField_adderss.setBounds(228, 194, 103, 26);
    frame.getContentPane().add(textField_adderss);
    
    textField_major = new JTextField();
    textField_major.setColumns(10);
    textField_major.setBounds(228, 239, 103, 26);
    frame.getContentPane().add(textField_major);
    
    textField_time = new JTextField();
    textField_time.setColumns(10);
    textField_time.setBounds(228, 329, 103, 26);
    frame.getContentPane().add(textField_time);
    
    label_1 = new JLabel("入学时间：");
    label_1.setFont(new Font("Dialog", Font.PLAIN, 18));
    label_1.setBounds(101, 329, 135, 26);
    frame.getContentPane().add(label_1);
    
    label_2 = new JLabel("班级编号：");
    label_2.setFont(new Font("Dialog", Font.PLAIN, 18));
    label_2.setBounds(101, 284, 135, 26);
    frame.getContentPane().add(label_2);
    
    textField_class = new JTextField();
    textField_class.setColumns(10);
    textField_class.setBounds(228, 284, 103, 26);
    frame.getContentPane().add(textField_class);
    
    JButton btnNewButton = new JButton("添加");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
        String name = textField_stuname.getText();
        String sex = textField_sex.getText();
        String age = textField_age.getText();
        String address = textField_adderss.getText();
        String major = textField_major.getText();
        String classid = textField_class.getText();
        String time = textField_time.getText();
        Configreader reader = Configreader.reader("config.txt");
        String tablename = reader.readItem("students");
        String sql = "insert into " + tablename + " values ('" + name + "','" + sex + "'," + age +
            ",'" + address + "',0,'" + major + "'," + classid + ",'" + time + "')";
        
        Connection conn = Connector.getConnection();
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.executeUpdate();
        textField_1.setText("Success!");
        } catch (Exception exception) {
          exception.printStackTrace();
        }
      }
    });
    btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    btnNewButton.setBounds(411, 164, 83, 84);
    frame.getContentPane().add(btnNewButton);
    
    JLabel label = new JLabel("学号：");
    label.setFont(new Font("Dialog", Font.PLAIN, 18));
    label.setBounds(101, 406, 135, 26);
    frame.getContentPane().add(label);
    
    textField_id = new JTextField();
    textField_id.setColumns(10);
    textField_id.setBounds(228, 406, 103, 26);
    frame.getContentPane().add(textField_id);
    
    JLabel label_4 = new JLabel("添加学生：");
    label_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_4.setBounds(21, 23, 115, 26);
    frame.getContentPane().add(label_4);
    
    JLabel label_7 = new JLabel("删除学生：");
    label_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_7.setBounds(21, 370, 115, 26);
    frame.getContentPane().add(label_7);
    
    JButton button = new JButton("删除");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String studentid = textField_id.getText();
          Configreader reader = Configreader.reader("config.txt");
          String tablename = reader.readItem("students");
          String table_id = reader.readItem("students_id");
          String sql = "delete from " + tablename + " where " + table_id + " = " + studentid;
          String sql_check = "select * from " + tablename + " where " + table_id + " = " + studentid;
          
          Connection conn = Connector.getConnection();
          PreparedStatement psmt_check = conn.prepareStatement(sql_check);
          ResultSet rs = psmt_check.executeQuery();
          if(rs.next()) {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.executeUpdate();
            textField_1.setText("Success!");
          } else {
            textField_1.setText("We don't have this student");
          }
        } catch (Exception exception) {
          exception.printStackTrace();
        }
      }
    });
    button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    button.setBounds(411, 393, 83, 51);
    frame.getContentPane().add(button);
    
    textField_1 = new JTextField();
    textField_1.setBounds(21, 461, 511, 84);
    frame.getContentPane().add(textField_1);
    textField_1.setColumns(10);
  }
}
