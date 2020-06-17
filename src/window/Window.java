package window;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import configReader.Configreader;
import connector.Connector;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window {

  private JFrame frame;
  private JTextField txtTest_student;
  private JTextField textField_teacher;
  private JTextField textField_course;
  private JTextField textField_class;
  private JButton button;


  private JTextFieldHintListener id;
  private JTextFieldHintListener sem;
  private JTextFieldHintListener course;
  private JTextFieldHintListener teacher;

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
   * @throws FileNotFoundException 
   */
  public Window() throws FileNotFoundException {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   * @throws FileNotFoundException 
   */
  private void initialize() throws FileNotFoundException {
    Configreader reader = Configreader.reader("config.txt");
    frame = new JFrame();
    frame.setTitle("本科生教学管理系统");
    frame.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
    frame.setBounds(100, 100, 1280, 720);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);

    JComboBox comboBox = new JComboBox();
    comboBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
    menuBar.add(comboBox);
    comboBox.addItem("学生成绩查询"); // 所有score的所有主键
    comboBox.addItem("每门课程平均成绩查询"); // 按学期查询
    comboBox.addItem("学生选课情况");  // 输出指定学生选课及学分
    comboBox.addItem("学生学分统计");  //  输出学生已经获得学分
    comboBox.addItem("教师任课查询");  // 指定教师的开课情况
    comboBox.addItem("班级课程开设查询"); // 班级开课情况
    comboBox.addItem("添加、删除成绩");
    comboBox.addItem("修改成绩");
    comboBox.addItem("修改教师信息");
    comboBox.addItem("添加、删除学生");

    JScrollPane scrollPane = new JScrollPane();
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

    txtTest_student = new JTextField();
    txtTest_student.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
    txtTest_student.addFocusListener(id);
    menuBar.add(txtTest_student);
    txtTest_student.setColumns(10);

    textField_course = new JTextField();
    textField_course.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
    textField_course.addFocusListener(sem);
    menuBar.add(textField_course);
    textField_course.setColumns(10);

    textField_class = new JTextField();
    textField_class.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
    textField_class.addFocusListener(course);
    menuBar.add(textField_class);
    textField_class.setColumns(10);

    textField_teacher = new JTextField();
    textField_teacher.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
    textField_teacher.addFocusListener(teacher);
    menuBar.add(textField_teacher);
    textField_teacher.setColumns(10);
    
    id = new JTextFieldHintListener(txtTest_student, "学号");
    sem = new JTextFieldHintListener(textField_course, "学期");
    course = new JTextFieldHintListener(textField_class, "课程编号");
    teacher = new JTextFieldHintListener(textField_teacher, "教师编号");

    comboBox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        if(arg0.getStateChange() == ItemEvent.SELECTED){ 
          if(comboBox.getSelectedIndex() == 0) {
            button.setText("查询");
            txtTest_student.setEditable(true);  
            textField_course.setEditable(true);  
            textField_class.setEditable(true);  
            textField_teacher.setEditable(true);  
            txtTest_student.removeFocusListener(id);  
            textField_course.removeFocusListener(sem);  
            textField_class.removeFocusListener(course);  
            textField_teacher.removeFocusListener(teacher);  

            id = new JTextFieldHintListener(txtTest_student, "学号");
            sem = new JTextFieldHintListener(textField_course, "学期");
            course = new JTextFieldHintListener(textField_class, "课程编号");
            teacher = new JTextFieldHintListener(textField_teacher, "教师编号");
            txtTest_student.addFocusListener(id);
            textField_course.addFocusListener(sem);
            textField_class.addFocusListener(course);
            textField_teacher.addFocusListener(teacher);
          }else if (comboBox.getSelectedIndex() == 1) {
            button.setText("查询");
            txtTest_student.setEditable(false);  
            textField_course.setEditable(false);  
            textField_class.setEditable(false);  
            textField_teacher.setEditable(false);  
            txtTest_student.removeFocusListener(id);  
            textField_course.removeFocusListener(sem);  
            textField_class.removeFocusListener(course);  
            textField_teacher.removeFocusListener(teacher); 
          }else if (comboBox.getSelectedIndex() == 2) {
            button.setText("查询");
            txtTest_student.setEditable(true);  
            textField_course.setEditable(false);  
            textField_class.setEditable(false);  
            textField_teacher.setEditable(false);  
            txtTest_student.removeFocusListener(id);  
            textField_course.removeFocusListener(sem);  
            textField_class.removeFocusListener(course);  
            textField_teacher.removeFocusListener(teacher); 
            
            id = new JTextFieldHintListener(txtTest_student, "学号");
            txtTest_student.addFocusListener(id);
          }else if (comboBox.getSelectedIndex() == 3) {
            button.setText("查询");
            txtTest_student.setEditable(false);  
            textField_course.setEditable(false);  
            textField_class.setEditable(false);  
            textField_teacher.setEditable(false); 
            txtTest_student.removeFocusListener(id);  
            textField_course.removeFocusListener(sem);  
            textField_class.removeFocusListener(course);  
            textField_teacher.removeFocusListener(teacher);
          }else if (comboBox.getSelectedIndex() == 4) {
            button.setText("查询");
            txtTest_student.setEditable(false);  
            textField_course.setEditable(false);  
            textField_class.setEditable(false);  
            textField_teacher.setEditable(true);  
            txtTest_student.removeFocusListener(id);  
            textField_course.removeFocusListener(sem);  
            textField_class.removeFocusListener(course);  
            textField_teacher.removeFocusListener(teacher); 
            teacher = new JTextFieldHintListener(textField_teacher, "教师编号");
            textField_teacher.addFocusListener(teacher); 
          }else if (comboBox.getSelectedIndex() == 5) {
            button.setText("查询");
            txtTest_student.setEditable(true);  
            textField_course.setEditable(false);  
            textField_class.setEditable(false);  
            textField_teacher.setEditable(false);  
            txtTest_student.removeFocusListener(id);  
            textField_course.removeFocusListener(sem);  
            textField_class.removeFocusListener(course);  
            textField_teacher.removeFocusListener(teacher);  
            id = new JTextFieldHintListener(txtTest_student, "班级编号");
            txtTest_student.addFocusListener(id);
          }else{
            button.setText("修改");
            txtTest_student.setEditable(false);  
            textField_course.setEditable(false);  
            textField_class.setEditable(false);  
            textField_teacher.setEditable(false);  
            txtTest_student.removeFocusListener(id);  
            textField_course.removeFocusListener(sem);  
            textField_class.removeFocusListener(course);  
            textField_teacher.removeFocusListener(teacher);
          }
        }
      }
    });

    button = new JButton("查询");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        String sql = "";
        List<String> head = new ArrayList<String>();
        List<String> header = new ArrayList<String>();
        if(comboBox.getSelectedIndex() == 0) {
          String[] fields = {txtTest_student.getText(), textField_course.getText(), textField_class.getText(), textField_teacher.getText()};
          String[] commands = {reader.readItem("scores_studentid"), reader.readItem("scores_semester"), reader.readItem("scores_courseid"), reader.readItem("scores_teacherid")};
          boolean[] isVarchar = {false, true, false, false};
          String[] hints = {"学号", "学期", "课程编号", "教师编号"};
          sql = "SELECT * FROM " + reader.readItem("scores") + " ";
          head = Arrays.asList("序号", "学号", "学期", "课程编号", "教师编号", "分数");
          header = Arrays.asList(reader.readItem("scores_studentid"), reader.readItem("scores_semester"), reader.readItem("scores_courseid"), reader.readItem("scores_teacherid"), reader.readItem("scores_score"));
          sql = getSql(sql, fields, commands, isVarchar, hints);
          sql += " ORDER BY " + reader.readItem("scores_score") +" DESC";

        }else if (comboBox.getSelectedIndex() == 1) {
          sql = "exec Get_Ave_course";
          head = Arrays.asList("序号", "课程名称", "学期", "课程编号", "教师编号", "平均分");
          header = Arrays.asList(reader.readItem("score_coursename"), reader.readItem("scores_semester"), reader.readItem("scores_courseid"), reader.readItem("scores_teacherid"), reader.readItem("score_avg"));
        }else if(comboBox.getSelectedIndex() == 2) {
            sql = "exec Get_courses " + txtTest_student.getText();
            head = Arrays.asList("序号", "学号", "姓名", "课程名", "教师编号", "学期", "学分");
            header = Arrays.asList(reader.readItem("credit_id"), reader.readItem("credit_name"), reader.readItem("credit_coursename"), reader.readItem("courses_teacherid"), reader.readItem("courses_semester"), reader.readItem("courses_credit"));
        }else if(comboBox.getSelectedIndex() == 3) {
            sql = "select * from student_credits";
            head = Arrays.asList("序号", "学号", "姓名", "专业", "已经获得学分");
            header = Arrays.asList(reader.readItem("students_id"), reader.readItem("students_name"), reader.readItem("students_major"), reader.readItem("students_credit"));
        }else if(comboBox.getSelectedIndex() == 4) {
          sql = "exec Get_Teacher_Course " + textField_teacher.getText();
          head = Arrays.asList("序号", "课程编号", "课程名", "学期", "课时", "是否为选修课", "学分");
          header = Arrays.asList(reader.readItem("courses_id"), reader.readItem("courses_name"), reader.readItem("courses_semester"), reader.readItem("courses_period"), reader.readItem("courses_type"), reader.readItem("courses_credit"));
        }else if(comboBox.getSelectedIndex() == 5) {
          sql = "exec Get_classCourse " + txtTest_student.getText();
          head = Arrays.asList("序号", "课程编号", "课程名", "学期", "教师编号", "是否为选修课", "学分");
          header = Arrays.asList(reader.readItem("courses_id"), reader.readItem("courses_name"), reader.readItem("courses_semester"), reader.readItem("courses_teacherid"), reader.readItem("courses_type"), reader.readItem("courses_credit"));
        }else if(comboBox.getSelectedIndex() == 6) {
          try {
            AddandDelete window = new AddandDelete();
            window.frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }else if(comboBox.getSelectedIndex() == 7) {
          try {
            Change_Score window = new Change_Score();
            window.frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }else if(comboBox.getSelectedIndex() == 8) {
          try {
            Change_Teacher window = new Change_Teacher();
            window.frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }else if(comboBox.getSelectedIndex() == 9) {
          try {
            AddStudent window = new AddStudent();
            window.frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
        if(comboBox.getSelectedIndex() <= 5) {
          try {
            System.out.println(sql);
            Connection con = Connector.getConnection();
            PreparedStatement psmt = con.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            List<List<String>> sample = new ArrayList<>();
            sample.add(head);
            while(rs.next()) {
              List<String> row = new ArrayList<String>();
              for(String h: header) {
                row.add(rs.getString(h));
              }
              sample.add(row);
            }
            scrollPane.setViewportView(setTable(sample));
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
      }
    });
    button.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
    menuBar.add(button);

  }

  private JTable setTable(List<List<String>> tokens) {
    DefaultTableModel model = getTable(tokens);
    JTable table = new JTable(model);
    table.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 单元格渲染器
    tcr.setHorizontalAlignment(JLabel.CENTER);// 居中显示
    tcr.setVerticalAlignment(JLabel.CENTER);
    table.setDefaultRenderer(Object.class, tcr);// 设置渲染器
    table.setRowHeight(40);
    table.setRowSelectionAllowed(false);
    table.setCellSelectionEnabled(true);
    return table;
  }

  public void resizeColumnWidth(JTable table) {
    table.setRowSelectionAllowed(true);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
      int width = 50; // Min width
      for (int row = 0; row < table.getRowCount(); row++) {
        TableCellRenderer renderer = table.getCellRenderer(row, column);
        Component comp = table.prepareRenderer(renderer, row, column);
        width = Math.max(comp.getPreferredSize().width + 1, width);
      }
      // if(width > 3000)
      // width=300;
      columnModel.getColumn(column).setPreferredWidth(width);
    }
  }


  private DefaultTableModel getTable(List<List<String>> tokens) {
    DefaultTableModel model = new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int row, int column) {
        // all cells false
        return false;
      }
    };
    Vector<String> header = new Vector<String>();
    for (String string : tokens.get(0)) {
      header.add(string);
    }
    Vector<Vector<String>> rows = new Vector<Vector<String>>();
    for (int j = 1; j < tokens.size(); j++) {
      Vector<String> row = new Vector<String>();
      row.add(String.valueOf((rows.size() + 1)));
      for (String string : tokens.get(j)) {
        row.add(string);
      }
      rows.add(row);
    }
    model.setDataVector(rows, header);
    return model;
  }
  
  private String add(boolean flag) {
    if(flag) return "and ";
    else return "where ";
  }
  
  private String getSql(String sql, String[] fields, String[] commands, boolean[] isVarchar, String[] hints) {
    boolean flag = false;
    int len = fields.length;
    for(int i = 0; i < len; i++) {
      if(!fields[i].equals("") && !fields[i].equals(hints[i])) {
        sql += add(flag);
        flag = true;
        if(isVarchar[i])
          sql += commands[i] + "= '" + fields[i]+ "' ";
        else {
          sql += commands[i] + "= " + fields[i]+ " ";
        }
      }
    }
    return sql;
  }

}
