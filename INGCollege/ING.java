import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class ING extends JFrame {

    private JPanel contentPane,academic_panel,non_academic_panel;
    private JRadioButton academic_radio,non_academic_radios;
    private JTextField tf_CourseID,tf_CourseID2;
    private JTextField tf_CourseName,tf_CourseName2;
    private JTextField tf_totalAssessment,tf_prerequisite;
    private JTextField tf_lecturerName,tf_instructorName;
    private JTextField tf_duration,tf_duration2;
    private JTextField tf_level;
    private JTextField tf_credit;
    private JTextField tf_courseLeader,tf_courseLeader2;
    private JTextField tf_startDate,tf_startDate2,tf_examDate;
    private JTextField tf_completionDate,tf_completionDate2;
    private JTextField tf_courseId,tf_courseId2;
    
    ArrayList<Course> courses = new ArrayList<Course>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ING frame = new ING();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ING() {
        setTitle("Courses");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 811, 666);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        ButtonGroup btngrp = new ButtonGroup();
        
        academic_panel = new JPanel();
        academic_panel.setBackground(SystemColor.GRAY);
        academic_panel.setBounds(10, 79, 777, 528);
        contentPane.add(academic_panel);
        academic_panel.setLayout(null);
        
        non_academic_panel = new JPanel();
        non_academic_panel.setBackground(SystemColor.GRAY);
        non_academic_panel.setBounds(10, 79, 777, 528);
        non_academic_panel.setLayout(null);
        
        tf_CourseID = new JTextField();
        tf_CourseID.setBounds(163, 29, 191, 28);
        academic_panel.add(tf_CourseID);
        tf_CourseID.setColumns(10);
        
          tf_CourseID2 = new JTextField();
        tf_CourseID2.setBounds(148, 30, 191, 28);
        non_academic_panel.add(tf_CourseID2);
        tf_CourseID2.setColumns(10);
        
        
        
        
        
        JLabel lblCourseId = new JLabel("Course ID:");
        lblCourseId.setFont(new Font("Cambria", Font.BOLD, 15));
        lblCourseId.setBounds(10, 31, 83, 22);
        academic_panel.add(lblCourseId);
        
        JLabel lblCourseId2 = new JLabel("Course ID:");
        lblCourseId2.setFont(new Font("Cambria", Font.BOLD, 15));
        lblCourseId2.setBounds(10, 31, 83, 22);
        non_academic_panel.add(lblCourseId2);
        
        
        
        JLabel lblCourseName = new JLabel("Course Name:");
        lblCourseName.setFont(new Font("Cambria", Font.BOLD, 15));
        lblCourseName.setBounds(409, 31, 136, 22);
        academic_panel.add(lblCourseName);
        
        JLabel lblCourseName2 = new JLabel("Course Name:");
        lblCourseName2.setFont(new Font("Cambria", Font.BOLD, 15));
        lblCourseName2.setBounds(409, 31, 109, 22);
        non_academic_panel.add(lblCourseName2);
        
        tf_CourseName = new JTextField();
        tf_CourseName.setBounds(553, 29, 191, 28);
        academic_panel.add(tf_CourseName);
        tf_CourseName.setColumns(10);
        
        tf_CourseName2 = new JTextField();
        tf_CourseName2.setBounds(528, 30, 191, 28);
        non_academic_panel.add(tf_CourseName2);
        tf_CourseName2.setColumns(10);
        
        JLabel prerequisite = new JLabel("Prerequisite:");
        prerequisite.setFont(new Font("Cambria", Font.BOLD, 15));
        prerequisite.setBounds(10, 75, 131, 22);
        non_academic_panel.add(prerequisite);
        
        tf_totalAssessment = new JTextField();
        tf_totalAssessment.setBounds(163, 69, 191, 28);
        academic_panel.add(tf_totalAssessment);
        tf_totalAssessment.setColumns(10);
        
        tf_prerequisite = new JTextField();
        tf_prerequisite.setBounds(148, 74, 191, 28);
        non_academic_panel.add(tf_prerequisite);
        tf_prerequisite.setColumns(10);
        
        
        JLabel totalAssessment = new JLabel("Total Assessment:");
        totalAssessment.setFont(new Font("Cambria", Font.BOLD, 15));
        totalAssessment.setBounds(10, 75, 155, 22);
        academic_panel.add(totalAssessment);
        
        
        
        
        JButton btnAddCourse = new JButton("ADD");
        btnAddCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String courseId = tf_CourseID.getText().toString();
                String courseName = tf_CourseName.getText().toString();
                int totalAssessment = Integer.parseInt(tf_totalAssessment.getText().toString());
                int duration = Integer.parseInt(tf_duration.getText().toString());
                String level = tf_level.getText().toString();
                String credit = tf_credit.getText().toString();
                Course co = registerAcademic(courseId);
                if (co!=null) {
                    JOptionPane.showMessageDialog(null, "Academic year could not be added! Existing course ID");
                    clear();
                }
                else {
                    Course c = new AcademicCourse(courseId, courseName, duration, level, credit, totalAssessment);
                    courses.add(c);
                    JOptionPane.showMessageDialog(null, "Academic Course Added Successfully!!!");
                }
                clear();
            }
        });
        btnAddCourse.setForeground(new Color(240, 248, 255));
        btnAddCourse.setBackground(new Color(150, 0, 0));
        btnAddCourse.setFont(new Font("Cambria", Font.BOLD, 15));
        btnAddCourse.setBounds(601, 173, 119, 37);
        academic_panel.add(btnAddCourse);
        
        JButton btnAddCourse2 = new JButton("ADD");
        btnAddCourse2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String courseId = tf_CourseID2.getText().toString();
                String courseName = tf_CourseName2.getText().toString();
                String prerequisite = tf_totalAssessment.getText().toString();
                int duration = Integer.parseInt(tf_duration2.getText().toString());
                Course co = registerNonAcademic(courseId);
                if (co!=null) {
                    JOptionPane.showMessageDialog(null, "The added non-academic course failed! I already have a course ID");
                    clear();
                }
                else {
                    Course c = new NonAcademicCourse(courseId, courseName, duration, prerequisite);
                    courses.add(c);
                    JOptionPane.showMessageDialog(null, "Non Academic Course Added Successfully!!!");
                }
                clear();
            }
        });
        btnAddCourse2.setForeground(new Color(240, 248, 255));
        btnAddCourse2.setBackground(new Color(150, 0, 0));
        btnAddCourse2.setFont(new Font("Cambria", Font.BOLD, 15));
        btnAddCourse2.setBounds(601, 173, 119, 37);
        non_academic_panel.add(btnAddCourse2);
        
        
       
    
        
        JLabel lblInstructorName = new JLabel("Instructor Name:");
        lblInstructorName.setFont(new Font("Cambria", Font.BOLD, 15));
        lblInstructorName.setBounds(10, 289, 119, 22);
        non_academic_panel.add(lblInstructorName);
        
        JLabel lblLecturerName = new JLabel("Lecturer Name:");
        lblLecturerName.setFont(new Font("Cambria", Font.BOLD, 15));
        lblLecturerName.setBounds(10, 289, 135, 22);
        academic_panel.add(lblLecturerName);
        
        tf_lecturerName = new JTextField();
        tf_lecturerName.setBounds(163, 287, 191, 28);
        academic_panel.add(tf_lecturerName);
        tf_lecturerName.setColumns(10);
        
        tf_instructorName = new JTextField();
        tf_instructorName.setBounds(148, 288, 191, 28);
        non_academic_panel.add(tf_instructorName);
        tf_instructorName.setColumns(10);
        
        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String courseId = tf_courseId.getText();
                String courseLeader = tf_courseLeader.getText();
                String lecturerName = tf_lecturerName.getText();
                String startDate = tf_startDate.getText();
                String completionDate = tf_completionDate.getText();
                Course c = registerAcademic(courseId);
                if (c!=null) {
                    AcademicCourse ac = (AcademicCourse)c;
                    ac.registerCourse(courseLeader, lecturerName, startDate, completionDate);
                    JOptionPane.showMessageDialog(null, "Academic Course registered Successfully! for course id: "+courseId);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Id not found! Enter correct course id");
                }
                clear();
            }
            
        });
        btnRegister.setFont(new Font("Cambria", Font.BOLD, 15));
        btnRegister.setBackground(new Color(0, 200, 0));  
        btnRegister.setForeground(Color.BLACK);
        btnRegister.setBounds(600, 396, 119, 35);
        academic_panel.add(btnRegister);
        
        JButton btnRegister2 = new JButton("Register");
        btnRegister2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String courseId = tf_courseId2.getText();
                String courseLeader = tf_courseLeader2.getText();
                String instructorName = tf_instructorName.getText();
                String startDate = tf_startDate2.getText();
                String completionDate = tf_completionDate2.getText();
                String examDate = tf_examDate.getText();
                Course c = registerNonAcademic(courseId);
                if (c!=null) {
                    NonAcademicCourse nac = (NonAcademicCourse)c;
                    nac.registerCourse(courseLeader, instructorName, startDate, completionDate,examDate);
                    JOptionPane.showMessageDialog(null, "Non Academic Course registered Successfully! for course id: "+courseId);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Id not found! Enter correct course id");
                }
                clear();
            }
            
        });
        btnRegister2.setFont(new Font("Cambria", Font.BOLD, 15));
        btnRegister2.setBackground(new Color(0, 200, 0));
        btnRegister2.setForeground(Color.BLACK);
        btnRegister2.setBounds(600, 396, 119, 35);
        non_academic_panel.add(btnRegister2);
        
        JLabel lblDuration = new JLabel("Duration:");
        lblDuration.setFont(new Font("Cambria", Font.BOLD, 15));
        lblDuration.setBounds(409, 80, 92, 13);
        academic_panel.add(lblDuration);
        
        JLabel lblDuration2 = new JLabel("Duration:");
        lblDuration2.setFont(new Font("Cambria", Font.BOLD, 15));
        lblDuration2.setBounds(409, 80, 92, 13);
        non_academic_panel.add(lblDuration2);
        
        tf_duration = new JTextField();
        tf_duration.setBounds(553, 69, 191, 28);
        academic_panel.add(tf_duration);
        tf_duration.setColumns(10);
        
        tf_duration2 = new JTextField();
        tf_duration2.setBounds(528, 76, 191, 28);
        non_academic_panel.add(tf_duration2);
        tf_duration2.setColumns(10);
        
       
        
        JLabel lbl_credit = new JLabel("Credit:");
        lbl_credit.setFont(new Font("Cambria", Font.BOLD, 15));
        lbl_credit.setBounds(409, 120, 70, 13);
        academic_panel.add(lbl_credit);
        
        tf_credit = new JTextField();
        tf_credit.setBounds(553, 109, 190, 28);
        academic_panel.add(tf_credit);
        tf_credit.setColumns(10);
        
        
         JLabel lblLevel = new JLabel("Level:");
        lblLevel.setFont(new Font("Cambria", Font.BOLD, 15));
        lblLevel.setBounds(10, 120, 83, 13);
        academic_panel.add(lblLevel);
        
        tf_level = new JTextField();
        tf_level.setBounds(163, 109, 191, 28);
        academic_panel.add(tf_level);
        tf_level.setColumns(10);
        
        JLabel lblCourseLeader = new JLabel("Course Leader:");
        lblCourseLeader.setFont(new Font("Cambria", Font.BOLD, 15));
        lblCourseLeader.setBounds(409, 242, 160, 25);
        academic_panel.add(lblCourseLeader);
        
        JLabel lblCourseLeader2 = new JLabel("Course Leader:");
        lblCourseLeader2.setFont(new Font("Cambria", Font.BOLD, 15));
        lblCourseLeader2.setBounds(409, 242, 160, 25);
        non_academic_panel.add(lblCourseLeader2);
        
        tf_courseLeader = new JTextField();
        tf_courseLeader.setBounds(553, 245, 191, 28);
        academic_panel.add(tf_courseLeader);
        tf_courseLeader.setColumns(10);
        
        tf_courseLeader2 = new JTextField();
        tf_courseLeader2.setBounds(528, 246, 191, 28);
        non_academic_panel.add(tf_courseLeader2);
        tf_courseLeader2.setColumns(10);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 220, 727, 16);
        academic_panel.add(separator);
        
        JSeparator separator2 = new JSeparator();
        separator2.setBounds(10, 220, 727, 16);
        non_academic_panel.add(separator2);
        
        JLabel lblStartDate = new JLabel("Start Date:");
        lblStartDate.setFont(new Font("Cambria", Font.BOLD, 15));
        lblStartDate.setBounds(411, 298, 107, 13);
        academic_panel.add(lblStartDate);
        
        
        
        JLabel lblStartDate2 = new JLabel("Start Date:");
        lblStartDate2.setFont(new Font("Cambria", Font.BOLD, 15));
        lblStartDate2.setBounds(411, 298, 107, 13);
        non_academic_panel.add(lblStartDate2);
        
        tf_startDate = new JTextField();
        tf_startDate.setBounds(553, 287, 191, 28);
        academic_panel.add(tf_startDate);
        tf_startDate.setColumns(10);
        
        tf_startDate2 = new JTextField();
        tf_startDate2.setBounds(528, 292, 191, 28);
        non_academic_panel.add(tf_startDate2);
        tf_startDate2.setColumns(10);
        
        JLabel lblCompletionDate = new JLabel("Completion Date:");
        lblCompletionDate.setFont(new Font("Cambria", Font.BOLD, 15));
        lblCompletionDate.setBounds(10, 341, 155, 13);
        academic_panel.add(lblCompletionDate);
        
        JLabel lblCompletionDate2 = new JLabel("Completion Date:");
        lblCompletionDate2.setFont(new Font("Cambria", Font.BOLD, 15));
        lblCompletionDate2.setBounds(10, 341, 131, 13);
        non_academic_panel.add(lblCompletionDate2);
        
        tf_completionDate = new JTextField();
        tf_completionDate.setBounds(159, 327, 191, 28);
        academic_panel.add(tf_completionDate);
        tf_completionDate.setColumns(10);
        
        tf_completionDate2 = new JTextField();
        tf_completionDate2.setBounds(148, 335, 191, 28);
        non_academic_panel.add(tf_completionDate2);
        tf_completionDate2.setColumns(10);
        
        JLabel lblExamDate = new JLabel("Exam Date:");
        lblExamDate.setFont(new Font("Cambria", Font.BOLD, 15));
        lblExamDate.setBounds(411, 341, 107, 13);
        non_academic_panel.add(lblExamDate);
        
        tf_examDate = new JTextField();
        tf_examDate.setBounds(528, 335, 191, 28);
        non_academic_panel.add(tf_examDate);
        tf_examDate.setColumns(10);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 441, 737, 12);
        academic_panel.add(separator_1);
        
        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBounds(10, 441, 737, 12);
        non_academic_panel.add(separator_1_2);
        
        
        
        JButton btnDisplay = new JButton("Display");
        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int count = 0;
                for (Course course : courses) {
                    if(course instanceof AcademicCourse) {
                        AcademicCourse ac = (AcademicCourse)course;
                        String result = ac.display();
                        JOptionPane.showMessageDialog(null, result);
                        count++;
                    }
                }
                if(count==0)JOptionPane.showMessageDialog(null, "No record found!");
            }
        });
        btnDisplay.setFont(new Font("Bell MT", Font.BOLD, 18));
            btnDisplay.setBackground(new Color(100, 100, 200));
        btnDisplay.setForeground(SystemColor.CYAN);
        btnDisplay.setBounds(568, 481, 169, 37);
        academic_panel.add(btnDisplay);
        
        JButton btnDisplay2 = new JButton("Display");
        btnDisplay2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int count = 0;
                for (Course course : courses) {
                    if(course instanceof NonAcademicCourse) {
                        NonAcademicCourse nac = (NonAcademicCourse)course;
                        String result = nac.display();
                        JOptionPane.showMessageDialog(null, result);
                        count++;
                    }
                }
                if(count==0)JOptionPane.showMessageDialog(null, "No record found!");
            }
        });
        btnDisplay2.setFont(new Font("Bell MT", Font.BOLD, 18));
        btnDisplay2.setBackground(new Color(100, 100, 200));
        btnDisplay2.setForeground(SystemColor.CYAN);
        btnDisplay2.setBounds(568, 481, 169, 37);
        non_academic_panel.add(btnDisplay2);
        
       
        
        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String courseId = (String)JOptionPane.showInputDialog("Enter Course Id :");
                Course c = registerNonAcademic(courseId);
                if (c!=null) {
                    NonAcademicCourse nac = (NonAcademicCourse)c;
                    courses.remove(nac);
                    nac.removeCourse();
                    JOptionPane.showMessageDialog(null, "Removed Successfully!!!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Did not find! Enter the correct course number");
                }
            }
            
        });
        btnRemove.setBackground(new Color(10, 50, 50));
        btnRemove.setForeground(Color.WHITE);
        btnRemove.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        btnRemove.setBounds(84, 481, 169, 37);
        non_academic_panel.add(btnRemove);
        
        
        
        JPanel top_panel = new JPanel();
        top_panel.setBackground(SystemColor.inactiveCaption);
        top_panel.setBounds(10, 10, 777, 59);
        contentPane.add(top_panel);
        top_panel.setLayout(null);
        
        academic_radio = new JRadioButton("Academic");
        academic_radio.setSelected(true);
        academic_radio.setBounds(16, 6, 379, 47);
        top_panel.add(academic_radio);
        academic_radio.setBackground(SystemColor.inactiveCaption);
        academic_radio.setFont(new Font("Calisto MT", Font.BOLD, 16));
        btngrp.add(academic_radio);
        
        non_academic_radios = new JRadioButton("Non Academic");
        non_academic_radios.setBounds(400, 6, 359, 47);
        top_panel.add(non_academic_radios);
        non_academic_radios.setBackground(SystemColor.inactiveCaption);
        non_academic_radios.setFont(new Font("Calisto MT", Font.BOLD, 16));
        btngrp.add(non_academic_radios);
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        btnClear.setFont(new Font("Bell MT", Font.BOLD, 19));
        btnClear.setBackground(Color.ORANGE);
        btnClear.setForeground(SystemColor.BLACK);
        btnClear.setBounds(332, 481, 169, 37);
        academic_panel.add(btnClear);
        
        JButton btnClear2 = new JButton("Clear");
        btnClear2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        btnClear2.setFont(new Font("Bell MT", Font.BOLD, 18));
        btnClear2.setBackground(Color.ORANGE);
        btnClear2.setForeground(SystemColor.black);
        btnClear2.setBounds(332, 481, 169, 37);
        non_academic_panel.add(btnClear2);
        
        non_academic_radios.addItemListener(new ItemListener() {
            
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem()==non_academic_radios) {
                    selectPanel();
                    
                }
                
            }
        });
        academic_radio.addItemListener(new ItemListener() {
            
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem()==academic_radio) {
                    selectPanel();
                    
                }
                
            }
        });
        
        
    }
    
    
    private Course registerAcademic(String courseId) {
        for (Course c : courses) {
            if(c instanceof AcademicCourse) {
                if(c.getCourseId().equalsIgnoreCase(courseId))return c;
            }
        }
        return null;
    }
    
    private Course registerNonAcademic(String courseId) {
        for (Course c : courses) {
            if(c instanceof NonAcademicCourse) {
                if(c.getCourseId().equalsIgnoreCase(courseId))return c;
            }
        }
        return null;
    }
    
    private void selectPanel() {
        if(academic_radio.isSelected()) {
            contentPane.add(academic_panel);
            non_academic_panel.setVisible(false);
            academic_panel.setVisible(true);
        }
        else {
            contentPane.add(non_academic_panel);
            academic_panel.setVisible(false);
            non_academic_panel.setVisible(true);
        }
        
    }
    
    private void clear() {
        tf_CourseID.setText("");
        tf_CourseID2.setText("");
        tf_courseId.setText("");
        tf_courseId2.setText("");
        tf_CourseName.setText("");
        tf_CourseName2.setText("");
        tf_courseLeader.setText("");
        tf_courseLeader2.setText("");
        tf_duration.setText("");
        tf_duration2.setText("");
        tf_startDate.setText("");
        tf_startDate2.setText("");
        tf_completionDate.setText("");
        tf_completionDate2.setText("");
        tf_lecturerName.setText("");
        tf_instructorName.setText("");
        tf_examDate.setText("");
        tf_credit.setText("");
        tf_level.setText("");
        tf_prerequisite.setText("");
        tf_totalAssessment.setText("");
    }
    
    private boolean validate(String str) {
        if(str.equalsIgnoreCase(null) || str.equalsIgnoreCase(""))return false;
        else return true;
    }
}
