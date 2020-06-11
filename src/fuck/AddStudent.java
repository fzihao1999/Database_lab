package fuck;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddStudent {

  private JFrame frame;
  private JTextField textField_songid;
  private JTextField textField_disid;
  private JTextField textField_studentid;
  private JTextField textField_teacher;
  private JTextField textField_score;
  private JTextField textField_2;
  private JLabel label_1;
  private JLabel label_2;
  private JTextField textField_3;
  private JTextField textField;
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
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
    textField_songid = new JTextField();
    textField_songid.setColumns(10);
    textField_songid.setBounds(228, 149, 103, 26);
    frame.getContentPane().add(textField_songid);
    
    textField_disid = new JTextField();
    textField_disid.setColumns(10);
    textField_disid.setBounds(228, 104, 103, 26);
    frame.getContentPane().add(textField_disid);
    
    textField_studentid = new JTextField();
    textField_studentid.setColumns(10);
    textField_studentid.setBounds(228, 59, 103, 26);
    frame.getContentPane().add(textField_studentid);
    
    textField_teacher = new JTextField();
    textField_teacher.setColumns(10);
    textField_teacher.setBounds(228, 194, 103, 26);
    frame.getContentPane().add(textField_teacher);
    
    textField_score = new JTextField();
    textField_score.setColumns(10);
    textField_score.setBounds(228, 239, 103, 26);
    frame.getContentPane().add(textField_score);
    
    textField_2 = new JTextField();
    textField_2.setColumns(10);
    textField_2.setBounds(228, 329, 103, 26);
    frame.getContentPane().add(textField_2);
    
    label_1 = new JLabel("入学时间：");
    label_1.setFont(new Font("Dialog", Font.PLAIN, 18));
    label_1.setBounds(101, 329, 135, 26);
    frame.getContentPane().add(label_1);
    
    label_2 = new JLabel("班级编号：");
    label_2.setFont(new Font("Dialog", Font.PLAIN, 18));
    label_2.setBounds(101, 284, 135, 26);
    frame.getContentPane().add(label_2);
    
    textField_3 = new JTextField();
    textField_3.setColumns(10);
    textField_3.setBounds(228, 284, 103, 26);
    frame.getContentPane().add(textField_3);
    
    JButton btnNewButton = new JButton("添加");
    btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    btnNewButton.setBounds(411, 164, 83, 84);
    frame.getContentPane().add(btnNewButton);
    
    JLabel label = new JLabel("学号：");
    label.setFont(new Font("Dialog", Font.PLAIN, 18));
    label.setBounds(101, 406, 135, 26);
    frame.getContentPane().add(label);
    
    textField = new JTextField();
    textField.setColumns(10);
    textField.setBounds(228, 406, 103, 26);
    frame.getContentPane().add(textField);
    
    JLabel label_4 = new JLabel("添加学生：");
    label_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_4.setBounds(21, 23, 115, 26);
    frame.getContentPane().add(label_4);
    
    JLabel label_7 = new JLabel("删除学生：");
    label_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_7.setBounds(21, 370, 115, 26);
    frame.getContentPane().add(label_7);
    
    JButton button = new JButton("删除");
    button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    button.setBounds(411, 393, 83, 51);
    frame.getContentPane().add(button);
    
    textField_1 = new JTextField();
    textField_1.setBounds(21, 461, 511, 84);
    frame.getContentPane().add(textField_1);
    textField_1.setColumns(10);
  }
}
