package fuck;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Change_Teacher {

  private JFrame frame;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private JTextField textField_3;
  private JLabel label_2;
  private JTextField textField_4;

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
    frame.setTitle("修改成绩");
    
    textField = new JTextField();
    textField.setBounds(200, 40, 108, 32);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("课程编号：");
    lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    lblNewLabel.setBounds(76, 40, 115, 32);
    frame.getContentPane().add(lblNewLabel);
    
    JLabel label = new JLabel("教师编号：");
    label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label.setBounds(78, 90, 115, 32);
    frame.getContentPane().add(label);
    
    textField_1 = new JTextField();
    textField_1.setColumns(10);
    textField_1.setBounds(200, 90, 108, 32);
    frame.getContentPane().add(textField_1);
    
    JLabel label_1 = new JLabel("开课学期：\r\n");
    label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_1.setBounds(79, 140, 115, 32);
    frame.getContentPane().add(label_1);
    
    textField_2 = new JTextField();
    textField_2.setColumns(10);
    textField_2.setBounds(200, 140, 108, 32);
    frame.getContentPane().add(textField_2);
    
    JButton button = new JButton("确认修改");
    button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    button.setBounds(20, 250, 107, 75);
    frame.getContentPane().add(button);
    
    textField_3 = new JTextField();
    textField_3.setBounds(141, 250, 250, 75);
    frame.getContentPane().add(textField_3);
    textField_3.setColumns(10);
    
    label_2 = new JLabel("修改后成绩：");
    label_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_2.setBounds(79, 190, 115, 32);
    frame.getContentPane().add(label_2);
    
    textField_4 = new JTextField();
    textField_4.setColumns(10);
    textField_4.setBounds(200, 190, 108, 32);
    frame.getContentPane().add(textField_4);
  }
}
