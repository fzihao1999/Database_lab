package fuck;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
    comboBox.addItem("修改任课教师");
    

    comboBox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent arg0) {
        if(arg0.getStateChange() == ItemEvent.SELECTED){ 
          if(comboBox.getSelectedIndex() == 0) {
            txtTest_student.removeAll();  
            txtTest_student.addFocusListener(new JTextFieldHintListener(txtTest_student, "学号"));
            textField_course.removeAll();  
            textField_course.addFocusListener(new JTextFieldHintListener(textField_course, "学期"));
            textField_class.removeAll();  
            textField_class.addFocusListener(new JTextFieldHintListener(textField_class, "课程编号"));
            textField_teacher.removeAll();  
            textField_teacher.addFocusListener(new JTextFieldHintListener(textField_teacher, "教师编号"));
            String[] fields = {txtTest_student.getText(), textField_course.getText(), textField_class.getText(), textField_teacher.getText()};
            String[] commands = {reader.readItem("scores_studentid"), reader.readItem("scores_semester"), reader.readItem("scores_courseid"), reader.readItem("scores_teacherid")}
            //boolean[] 
          }
        }
      }
    });

    txtTest_student = new JTextField();
    txtTest_student.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
    txtTest_student.addFocusListener(new JTextFieldHintListener(txtTest_student, "学号"));
    menuBar.add(txtTest_student);
    txtTest_student.setColumns(10);

    textField_course = new JTextField();
    textField_course.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
    textField_course.addFocusListener(new JTextFieldHintListener(textField_course, "学期"));
    menuBar.add(textField_course);
    textField_course.setColumns(10);

    textField_class = new JTextField();
    textField_class.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
    textField_class.addFocusListener(new JTextFieldHintListener(textField_class, "课程编号"));
    menuBar.add(textField_class);
    textField_class.setColumns(10);

    textField_teacher = new JTextField();
    textField_teacher.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
    textField_teacher.addFocusListener(new JTextFieldHintListener(textField_teacher, "教师编号"));
    menuBar.add(textField_teacher);
    textField_teacher.setColumns(10);

    button = new JButton("查询");
    button.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
    menuBar.add(button);

    JScrollPane scrollPane = new JScrollPane();
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
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
  
  private String getSql(String sql, String[] fields, String[] commands, boolean[] isVarchar) {
    boolean flag = false;
    int len = fields.length;
    for(int i = 0; i < len; i++) {
      if(!fields.equals("")) {
        sql += add(flag);
        if(!isVarchar[i])
          sql += commands[i] + " \"" + fields[i]+ "\" ";
        else {
          sql += commands[i] + " " + fields[i]+ " ";
        }
      }
    }
    return sql;
  }

}
