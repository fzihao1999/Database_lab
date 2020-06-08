package fuck;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddandDelete {

  private JFrame frame;
  private JTextField textField_songid;
  private JTextField textField_disid;
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
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
    textField_songid = new JTextField();
    textField_songid.setColumns(10);
    textField_songid.setBounds(201, 120, 103, 26);
    frame.getContentPane().add(textField_songid);
    
    textField_disid = new JTextField();
    textField_disid.setColumns(10);
    textField_disid.setBounds(201, 75, 103, 26);
    frame.getContentPane().add(textField_disid);
    
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
    btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    btnNewButton.setBounds(66, 267, 103, 52);
    frame.getContentPane().add(btnNewButton);
    
    JButton button = new JButton("删除\r\n");
    button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    button.setBounds(211, 267, 103, 52);
    frame.getContentPane().add(button);
    
    textField = new JTextField();
    textField.setBounds(18, 343, 350, 84);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
  }
}
