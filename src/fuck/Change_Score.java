package fuck;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Change_Score {

  private JFrame frame;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private JLabel label_2;
  private JTextField textField_3;
  private JLabel label_3;
  private JTextField textField_4;
  private JButton button;

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
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setTitle("修改任课教师");
    
    textField = new JTextField();
    textField.setBounds(200, 40, 108, 32);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("学号：");
    lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    lblNewLabel.setBounds(76, 40, 115, 32);
    frame.getContentPane().add(lblNewLabel);
    
    JLabel label = new JLabel("学期：");
    label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label.setBounds(78, 90, 115, 32);
    frame.getContentPane().add(label);
    
    textField_1 = new JTextField();
    textField_1.setColumns(10);
    textField_1.setBounds(200, 90, 108, 32);
    frame.getContentPane().add(textField_1);
    
    JLabel label_1 = new JLabel("课程编号：");
    label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_1.setBounds(79, 140, 115, 32);
    frame.getContentPane().add(label_1);
    
    textField_2 = new JTextField();
    textField_2.setColumns(10);
    textField_2.setBounds(200, 140, 108, 32);
    frame.getContentPane().add(textField_2);
    
    label_2 = new JLabel("教师编号：");
    label_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_2.setBounds(79, 190, 115, 32);
    frame.getContentPane().add(label_2);
    
    textField_3 = new JTextField();
    textField_3.setColumns(10);
    textField_3.setBounds(200, 190, 108, 32);
    frame.getContentPane().add(textField_3);
    
    label_3 = new JLabel("修改后成绩：");
    label_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_3.setBounds(79, 240, 115, 32);
    frame.getContentPane().add(label_3);
    
    textField_4 = new JTextField();
    textField_4.setColumns(10);
    textField_4.setBounds(200, 240, 108, 32);
    frame.getContentPane().add(textField_4);
    
    button = new JButton("确认修改");
    button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    button.setBounds(21, 289, 108, 74);
    frame.getContentPane().add(button);
    
    JTextArea textArea = new JTextArea();
    textArea.setBounds(139, 289, 247, 74);
    frame.getContentPane().add(textArea);
  }
}
