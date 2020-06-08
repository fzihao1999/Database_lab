package fuck;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Window {

  private JFrame frame;
  private JTextField txtTest_student;
  private JTextField textField_teacher;
  private JTextField textField_course;
  private JTextField textField_class;
  private JButton button;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Window window = new Window();
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
  public Window() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 1280, 720);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);
    
    JComboBox comboBox = new JComboBox();
    menuBar.add(comboBox);
    comboBox.addItem("学生成绩查询");
    comboBox.addItem("教师任课查询");
    comboBox.addItem("班级课程开设查询");
    comboBox.addItem("每门课程平均成绩查询");
    comboBox.addItem("学生查询");
    comboBox.addItem("添加、删除成绩");
    comboBox.addItem("修改成绩");
    comboBox.addItem("修改任课教师");
    
    
    txtTest_student = new JTextField();
    txtTest_student.addFocusListener(new JTextFieldHintListener(txtTest_student, "学号"));
    menuBar.add(txtTest_student);
    txtTest_student.setColumns(10);
    
    textField_course = new JTextField();
    textField_course.addFocusListener(new JTextFieldHintListener(textField_course, "课程编号"));
    menuBar.add(textField_course);
    textField_course.setColumns(10);
    
    textField_class = new JTextField();
    textField_class.addFocusListener(new JTextFieldHintListener(textField_class, "班级编号"));
    menuBar.add(textField_class);
    textField_class.setColumns(10);
    
    textField_teacher = new JTextField();
    textField_teacher.addFocusListener(new JTextFieldHintListener(textField_teacher, "教师编号"));
    menuBar.add(textField_teacher);
    textField_teacher.setColumns(10);
    
    button = new JButton("查询");
    menuBar.add(button);
    
    JScrollPane scrollPane = new JScrollPane();
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
  }

}
