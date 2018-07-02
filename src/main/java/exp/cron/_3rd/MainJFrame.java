package exp.cron._3rd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

public class MainJFrame extends JFrame
{
  static final Font fontPLAIN = new Font("Dialog", 0, 12);
  static final Font fontBOLD = new Font("Dialog", 3, 12);
  CheckBoxItemListener _checkBoxItemListener = new CheckBoxItemListener();
  MUItemListener _MUItemListener = new MUItemListener();
  HHItemListener _HHItemListener = new HHItemListener();
  DDItemListener _DDItemListener = new DDItemListener();
  MMItemListener _MMItemListener = new MMItemListener();
  WKItemListener _WKItemListener = new WKItemListener();
  SpinnerNumberModel sp_MU_From_Model = new SpinnerNumberModel(0, 0, 59, 1);
  SpinnerNumberModel sp_MU_Every_Model = new SpinnerNumberModel(5, 1, 50, 1);
  Map<Integer, JCheckBox> jCB_MU_Map = new TreeMap();
  Map<Integer, JCheckBox> jCB_HH_Map = new TreeMap();
  Map<Integer, JCheckBox> jCB_DD_Map = new TreeMap();
  Map<Integer, JCheckBox> jCB_MM_Map = new TreeMap();
  Map<Integer, JCheckBox> jCB_WK_Map = new TreeMap();
  private ButtonGroup buttonGroup1;
  private ButtonGroup buttonGroup2;
  private ButtonGroup buttonGroup3;
  private ButtonGroup buttonGroup4;
  private ButtonGroup buttonGroup5;
  private JButton jButton_Copy;
  private JButton jButton_Exit;
  private JButton jButton_Make;
  private JButton jButton_Parse;
  JCheckBox jCB_DD_1;
  JCheckBox jCB_DD_10;
  JCheckBox jCB_DD_11;
  JCheckBox jCB_DD_12;
  JCheckBox jCB_DD_13;
  JCheckBox jCB_DD_14;
  JCheckBox jCB_DD_15;
  JCheckBox jCB_DD_16;
  JCheckBox jCB_DD_17;
  JCheckBox jCB_DD_18;
  JCheckBox jCB_DD_19;
  JCheckBox jCB_DD_2;
  JCheckBox jCB_DD_20;
  JCheckBox jCB_DD_21;
  JCheckBox jCB_DD_22;
  JCheckBox jCB_DD_23;
  JCheckBox jCB_DD_24;
  JCheckBox jCB_DD_25;
  JCheckBox jCB_DD_26;
  JCheckBox jCB_DD_27;
  JCheckBox jCB_DD_28;
  JCheckBox jCB_DD_29;
  JCheckBox jCB_DD_3;
  JCheckBox jCB_DD_30;
  JCheckBox jCB_DD_31;
  JCheckBox jCB_DD_4;
  JCheckBox jCB_DD_5;
  JCheckBox jCB_DD_6;
  JCheckBox jCB_DD_7;
  JCheckBox jCB_DD_8;
  JCheckBox jCB_DD_9;
  JCheckBox jCB_HH_0;
  JCheckBox jCB_HH_1;
  JCheckBox jCB_HH_10;
  JCheckBox jCB_HH_11;
  JCheckBox jCB_HH_12;
  JCheckBox jCB_HH_13;
  JCheckBox jCB_HH_14;
  JCheckBox jCB_HH_15;
  JCheckBox jCB_HH_16;
  JCheckBox jCB_HH_17;
  JCheckBox jCB_HH_18;
  JCheckBox jCB_HH_19;
  JCheckBox jCB_HH_2;
  JCheckBox jCB_HH_20;
  JCheckBox jCB_HH_21;
  JCheckBox jCB_HH_22;
  JCheckBox jCB_HH_23;
  JCheckBox jCB_HH_3;
  JCheckBox jCB_HH_4;
  JCheckBox jCB_HH_5;
  JCheckBox jCB_HH_6;
  JCheckBox jCB_HH_7;
  JCheckBox jCB_HH_8;
  JCheckBox jCB_HH_9;
  JCheckBox jCB_MM_1;
  JCheckBox jCB_MM_10;
  JCheckBox jCB_MM_11;
  JCheckBox jCB_MM_12;
  JCheckBox jCB_MM_2;
  JCheckBox jCB_MM_3;
  JCheckBox jCB_MM_4;
  JCheckBox jCB_MM_5;
  JCheckBox jCB_MM_6;
  JCheckBox jCB_MM_7;
  JCheckBox jCB_MM_8;
  JCheckBox jCB_MM_9;
  private JCheckBox jCB_MU_0;
  private JCheckBox jCB_MU_1;
  private JCheckBox jCB_MU_10;
  private JCheckBox jCB_MU_11;
  private JCheckBox jCB_MU_12;
  private JCheckBox jCB_MU_13;
  private JCheckBox jCB_MU_14;
  private JCheckBox jCB_MU_15;
  private JCheckBox jCB_MU_16;
  private JCheckBox jCB_MU_17;
  private JCheckBox jCB_MU_18;
  private JCheckBox jCB_MU_19;
  private JCheckBox jCB_MU_2;
  private JCheckBox jCB_MU_20;
  private JCheckBox jCB_MU_21;
  private JCheckBox jCB_MU_22;
  private JCheckBox jCB_MU_23;
  private JCheckBox jCB_MU_24;
  private JCheckBox jCB_MU_25;
  private JCheckBox jCB_MU_26;
  private JCheckBox jCB_MU_27;
  private JCheckBox jCB_MU_28;
  private JCheckBox jCB_MU_29;
  private JCheckBox jCB_MU_3;
  private JCheckBox jCB_MU_30;
  private JCheckBox jCB_MU_31;
  private JCheckBox jCB_MU_32;
  private JCheckBox jCB_MU_33;
  private JCheckBox jCB_MU_34;
  private JCheckBox jCB_MU_35;
  private JCheckBox jCB_MU_36;
  private JCheckBox jCB_MU_37;
  private JCheckBox jCB_MU_38;
  private JCheckBox jCB_MU_39;
  private JCheckBox jCB_MU_4;
  private JCheckBox jCB_MU_40;
  private JCheckBox jCB_MU_41;
  private JCheckBox jCB_MU_42;
  private JCheckBox jCB_MU_43;
  private JCheckBox jCB_MU_44;
  private JCheckBox jCB_MU_45;
  private JCheckBox jCB_MU_46;
  private JCheckBox jCB_MU_47;
  private JCheckBox jCB_MU_48;
  private JCheckBox jCB_MU_49;
  private JCheckBox jCB_MU_5;
  private JCheckBox jCB_MU_50;
  private JCheckBox jCB_MU_51;
  private JCheckBox jCB_MU_52;
  private JCheckBox jCB_MU_53;
  private JCheckBox jCB_MU_54;
  private JCheckBox jCB_MU_55;
  private JCheckBox jCB_MU_56;
  private JCheckBox jCB_MU_57;
  private JCheckBox jCB_MU_58;
  private JCheckBox jCB_MU_59;
  private JCheckBox jCB_MU_6;
  private JCheckBox jCB_MU_7;
  private JCheckBox jCB_MU_8;
  private JCheckBox jCB_MU_9;
  JCheckBox jCB_WK_1;
  JCheckBox jCB_WK_2;
  JCheckBox jCB_WK_3;
  JCheckBox jCB_WK_4;
  JCheckBox jCB_WK_5;
  JCheckBox jCB_WK_6;
  JCheckBox jCB_WK_7;
  JCheckBox jCB_WK_Use;
  private JLabel jLabel1;
  private JLabel jLabel10;
  private JLabel jLabel12;
  private JLabel jLabel13;
  private JLabel jLabel14;
  private JLabel jLabel16;
  private JLabel jLabel17;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private JLabel jLabel6;
  private JLabel jLabel7;
  private JLabel jLabel8;
  private JLabel jLabel9;
  private JPanel jPanel10;
  private JPanel jPanel11;
  private JPanel jPanel12;
  private JPanel jPanel13;
  private JPanel jPanel1_WK;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JPanel jPanel4;
  private JPanel jPanel5;
  private JPanel jPanel6;
  private JPanel jPanel7;
  private JPanel jPanel8;
  private JPanel jPanel9;
  JRadioButton jRB_DD_Assign;
  JRadioButton jRB_DD_Every;
  JRadioButton jRB_HH_Assign;
  JRadioButton jRB_HH_Every;
  JRadioButton jRB_MM_Assign;
  JRadioButton jRB_MM_Every;
  private JRadioButton jRB_MU_Assign;
  private JRadioButton jRB_MU_Loop;
  private JRadioButton jRB_WK_Assign;
  private JRadioButton jRB_WK_Every;
  JSpinner jSP_MU_Every;
  JSpinner jSP_MU_From;
  private JScrollPane jScrollPane1;
  private JTextArea jTA_Schedule_Next;
  JTextField jTF_Cron_Day;
  private JTextField jTF_Cron_Exp;
  JTextField jTF_Cron_Hour;
  JTextField jTF_Cron_Minute;
  JTextField jTF_Cron_Month;
  JTextField jTF_Cron_Second;
  JTextField jTF_Cron_Week;
  private JTextField jTF_Schedule_Start;
  private JTabbedPane jTabbedPane1;

  public MainJFrame()
  {
    initComponents();
    postInitUI();
  }

  private void initComponents()
  {
    this.buttonGroup1 = new ButtonGroup();
    this.buttonGroup2 = new ButtonGroup();
    this.buttonGroup3 = new ButtonGroup();
    this.buttonGroup4 = new ButtonGroup();
    this.buttonGroup5 = new ButtonGroup();
    this.jTabbedPane1 = new JTabbedPane();
    this.jPanel4 = new JPanel();
    this.jLabel9 = new JLabel();
    this.jSP_MU_From = new JSpinner();
    this.jLabel10 = new JLabel();
    this.jSP_MU_Every = new JSpinner();
    this.jLabel12 = new JLabel();
    this.jRB_MU_Loop = new JRadioButton();
    this.jRB_MU_Assign = new JRadioButton();
    this.jPanel12 = new JPanel();
    this.jCB_MU_0 = new JCheckBox();
    this.jCB_MU_1 = new JCheckBox();
    this.jCB_MU_2 = new JCheckBox();
    this.jCB_MU_3 = new JCheckBox();
    this.jCB_MU_4 = new JCheckBox();
    this.jCB_MU_5 = new JCheckBox();
    this.jCB_MU_6 = new JCheckBox();
    this.jCB_MU_7 = new JCheckBox();
    this.jCB_MU_8 = new JCheckBox();
    this.jCB_MU_9 = new JCheckBox();
    this.jCB_MU_10 = new JCheckBox();
    this.jCB_MU_11 = new JCheckBox();
    this.jCB_MU_12 = new JCheckBox();
    this.jCB_MU_13 = new JCheckBox();
    this.jCB_MU_14 = new JCheckBox();
    this.jCB_MU_15 = new JCheckBox();
    this.jCB_MU_16 = new JCheckBox();
    this.jCB_MU_17 = new JCheckBox();
    this.jCB_MU_18 = new JCheckBox();
    this.jCB_MU_19 = new JCheckBox();
    this.jCB_MU_20 = new JCheckBox();
    this.jCB_MU_21 = new JCheckBox();
    this.jCB_MU_22 = new JCheckBox();
    this.jCB_MU_23 = new JCheckBox();
    this.jCB_MU_24 = new JCheckBox();
    this.jCB_MU_25 = new JCheckBox();
    this.jCB_MU_26 = new JCheckBox();
    this.jCB_MU_27 = new JCheckBox();
    this.jCB_MU_28 = new JCheckBox();
    this.jCB_MU_29 = new JCheckBox();
    this.jCB_MU_30 = new JCheckBox();
    this.jCB_MU_31 = new JCheckBox();
    this.jCB_MU_32 = new JCheckBox();
    this.jCB_MU_33 = new JCheckBox();
    this.jCB_MU_34 = new JCheckBox();
    this.jCB_MU_35 = new JCheckBox();
    this.jCB_MU_36 = new JCheckBox();
    this.jCB_MU_37 = new JCheckBox();
    this.jCB_MU_38 = new JCheckBox();
    this.jCB_MU_39 = new JCheckBox();
    this.jCB_MU_40 = new JCheckBox();
    this.jCB_MU_41 = new JCheckBox();
    this.jCB_MU_42 = new JCheckBox();
    this.jCB_MU_43 = new JCheckBox();
    this.jCB_MU_44 = new JCheckBox();
    this.jCB_MU_45 = new JCheckBox();
    this.jCB_MU_46 = new JCheckBox();
    this.jCB_MU_47 = new JCheckBox();
    this.jCB_MU_48 = new JCheckBox();
    this.jCB_MU_49 = new JCheckBox();
    this.jCB_MU_50 = new JCheckBox();
    this.jCB_MU_51 = new JCheckBox();
    this.jCB_MU_52 = new JCheckBox();
    this.jCB_MU_53 = new JCheckBox();
    this.jCB_MU_54 = new JCheckBox();
    this.jCB_MU_55 = new JCheckBox();
    this.jCB_MU_56 = new JCheckBox();
    this.jCB_MU_57 = new JCheckBox();
    this.jCB_MU_58 = new JCheckBox();
    this.jCB_MU_59 = new JCheckBox();
    this.jPanel5 = new JPanel();
    this.jRB_HH_Every = new JRadioButton();
    this.jRB_HH_Assign = new JRadioButton();
    this.jPanel9 = new JPanel();
    this.jCB_HH_0 = new JCheckBox();
    this.jCB_HH_1 = new JCheckBox();
    this.jCB_HH_2 = new JCheckBox();
    this.jCB_HH_3 = new JCheckBox();
    this.jCB_HH_4 = new JCheckBox();
    this.jCB_HH_5 = new JCheckBox();
    this.jCB_HH_6 = new JCheckBox();
    this.jCB_HH_7 = new JCheckBox();
    this.jCB_HH_8 = new JCheckBox();
    this.jCB_HH_9 = new JCheckBox();
    this.jCB_HH_10 = new JCheckBox();
    this.jCB_HH_11 = new JCheckBox();
    this.jCB_HH_12 = new JCheckBox();
    this.jCB_HH_13 = new JCheckBox();
    this.jCB_HH_14 = new JCheckBox();
    this.jCB_HH_15 = new JCheckBox();
    this.jCB_HH_16 = new JCheckBox();
    this.jCB_HH_17 = new JCheckBox();
    this.jCB_HH_18 = new JCheckBox();
    this.jCB_HH_19 = new JCheckBox();
    this.jCB_HH_20 = new JCheckBox();
    this.jCB_HH_21 = new JCheckBox();
    this.jCB_HH_22 = new JCheckBox();
    this.jCB_HH_23 = new JCheckBox();
    this.jLabel16 = new JLabel();
    this.jLabel17 = new JLabel();
    this.jPanel6 = new JPanel();
    this.jRB_DD_Every = new JRadioButton();
    this.jRB_DD_Assign = new JRadioButton();
    this.jPanel10 = new JPanel();
    this.jCB_DD_1 = new JCheckBox();
    this.jCB_DD_2 = new JCheckBox();
    this.jCB_DD_3 = new JCheckBox();
    this.jCB_DD_4 = new JCheckBox();
    this.jCB_DD_5 = new JCheckBox();
    this.jCB_DD_6 = new JCheckBox();
    this.jCB_DD_7 = new JCheckBox();
    this.jCB_DD_8 = new JCheckBox();
    this.jCB_DD_9 = new JCheckBox();
    this.jCB_DD_10 = new JCheckBox();
    this.jCB_DD_11 = new JCheckBox();
    this.jCB_DD_12 = new JCheckBox();
    this.jCB_DD_13 = new JCheckBox();
    this.jCB_DD_14 = new JCheckBox();
    this.jCB_DD_15 = new JCheckBox();
    this.jCB_DD_16 = new JCheckBox();
    this.jCB_DD_17 = new JCheckBox();
    this.jCB_DD_18 = new JCheckBox();
    this.jCB_DD_19 = new JCheckBox();
    this.jCB_DD_20 = new JCheckBox();
    this.jCB_DD_21 = new JCheckBox();
    this.jCB_DD_22 = new JCheckBox();
    this.jCB_DD_23 = new JCheckBox();
    this.jCB_DD_24 = new JCheckBox();
    this.jCB_DD_25 = new JCheckBox();
    this.jCB_DD_26 = new JCheckBox();
    this.jCB_DD_27 = new JCheckBox();
    this.jCB_DD_28 = new JCheckBox();
    this.jCB_DD_29 = new JCheckBox();
    this.jCB_DD_30 = new JCheckBox();
    this.jCB_DD_31 = new JCheckBox();
    this.jPanel7 = new JPanel();
    this.jRB_MM_Every = new JRadioButton();
    this.jRB_MM_Assign = new JRadioButton();
    this.jPanel11 = new JPanel();
    this.jCB_MM_1 = new JCheckBox();
    this.jCB_MM_2 = new JCheckBox();
    this.jCB_MM_3 = new JCheckBox();
    this.jCB_MM_4 = new JCheckBox();
    this.jCB_MM_5 = new JCheckBox();
    this.jCB_MM_6 = new JCheckBox();
    this.jCB_MM_7 = new JCheckBox();
    this.jCB_MM_8 = new JCheckBox();
    this.jCB_MM_9 = new JCheckBox();
    this.jCB_MM_10 = new JCheckBox();
    this.jCB_MM_11 = new JCheckBox();
    this.jCB_MM_12 = new JCheckBox();
    this.jPanel8 = new JPanel();
    this.jCB_WK_Use = new JCheckBox();
    this.jPanel1_WK = new JPanel();
    this.jCB_WK_1 = new JCheckBox();
    this.jCB_WK_2 = new JCheckBox();
    this.jCB_WK_3 = new JCheckBox();
    this.jCB_WK_4 = new JCheckBox();
    this.jCB_WK_5 = new JCheckBox();
    this.jCB_WK_6 = new JCheckBox();
    this.jCB_WK_7 = new JCheckBox();
    this.jRB_WK_Every = new JRadioButton();
    this.jRB_WK_Assign = new JRadioButton();
    this.jPanel2 = new JPanel();
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.jLabel3 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jLabel5 = new JLabel();
    this.jLabel6 = new JLabel();
    this.jLabel7 = new JLabel();
    this.jLabel8 = new JLabel();
    this.jTF_Cron_Second = new JTextField();
    this.jTF_Cron_Minute = new JTextField();
    this.jTF_Cron_Hour = new JTextField();
    this.jTF_Cron_Day = new JTextField();
    this.jTF_Cron_Month = new JTextField();
    this.jTF_Cron_Week = new JTextField();
    this.jTF_Cron_Exp = new JTextField();
    this.jButton_Parse = new JButton();
    this.jPanel13 = new JPanel();
    this.jLabel13 = new JLabel();
    this.jTF_Schedule_Start = new JTextField();
    this.jLabel14 = new JLabel();
    this.jScrollPane1 = new JScrollPane();
    this.jTA_Schedule_Next = new JTextArea();
    this.jPanel3 = new JPanel();
    this.jButton_Copy = new JButton();
    this.jButton_Exit = new JButton();
    this.jButton_Make = new JButton();

    setDefaultCloseOperation(3);
    setTitle("Quartz表达式生成器");
    setResizable(false);

    this.jTabbedPane1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "日期,时间"));

    this.jLabel9.setText("从");

    this.jSP_MU_From.setModel(this.sp_MU_From_Model);

    this.jLabel10.setText("分钟 开始,每");

    this.jSP_MU_Every.setModel(this.sp_MU_Every_Model);

    this.jLabel12.setText("分钟 执行");

    this.buttonGroup1.add(this.jRB_MU_Loop);
    this.jRB_MU_Loop.setSelected(true);
    this.jRB_MU_Loop.setLabel("周期:");

    this.buttonGroup1.add(this.jRB_MU_Assign);
    this.jRB_MU_Assign.setText("指定:");
    this.jRB_MU_Assign.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJFrame.this.jRB_MU_AssignActionPerformed(evt);
      }
    });
    this.jPanel12.setBorder(BorderFactory.createEtchedBorder());

    this.jCB_MU_0.setText("0");
    this.jCB_MU_0.setEnabled(false);

    this.jCB_MU_1.setText("1");
    this.jCB_MU_1.setEnabled(false);

    this.jCB_MU_2.setText("2");
    this.jCB_MU_2.setEnabled(false);

    this.jCB_MU_3.setText("3");
    this.jCB_MU_3.setEnabled(false);

    this.jCB_MU_4.setText("4");
    this.jCB_MU_4.setEnabled(false);

    this.jCB_MU_5.setText("5");
    this.jCB_MU_5.setEnabled(false);

    this.jCB_MU_6.setText("6");
    this.jCB_MU_6.setEnabled(false);

    this.jCB_MU_7.setText("7");
    this.jCB_MU_7.setEnabled(false);

    this.jCB_MU_8.setText("8");
    this.jCB_MU_8.setEnabled(false);

    this.jCB_MU_9.setText("9");
    this.jCB_MU_9.setEnabled(false);

    this.jCB_MU_10.setText("10");
    this.jCB_MU_10.setEnabled(false);

    this.jCB_MU_11.setText("11");
    this.jCB_MU_11.setEnabled(false);

    this.jCB_MU_12.setText("12");
    this.jCB_MU_12.setEnabled(false);

    this.jCB_MU_13.setText("13");
    this.jCB_MU_13.setEnabled(false);

    this.jCB_MU_14.setText("14");
    this.jCB_MU_14.setEnabled(false);

    this.jCB_MU_15.setText("15");
    this.jCB_MU_15.setEnabled(false);

    this.jCB_MU_16.setText("16");
    this.jCB_MU_16.setEnabled(false);

    this.jCB_MU_17.setText("17");
    this.jCB_MU_17.setEnabled(false);

    this.jCB_MU_18.setText("18");
    this.jCB_MU_18.setEnabled(false);

    this.jCB_MU_19.setText("19");
    this.jCB_MU_19.setEnabled(false);

    this.jCB_MU_20.setText("20");
    this.jCB_MU_20.setEnabled(false);

    this.jCB_MU_21.setText("21");
    this.jCB_MU_21.setEnabled(false);

    this.jCB_MU_22.setText("22");
    this.jCB_MU_22.setEnabled(false);

    this.jCB_MU_23.setText("23");
    this.jCB_MU_23.setEnabled(false);

    this.jCB_MU_24.setText("24");
    this.jCB_MU_24.setEnabled(false);

    this.jCB_MU_25.setText("25");
    this.jCB_MU_25.setEnabled(false);

    this.jCB_MU_26.setText("26");
    this.jCB_MU_26.setEnabled(false);

    this.jCB_MU_27.setText("27");
    this.jCB_MU_27.setEnabled(false);

    this.jCB_MU_28.setText("28");
    this.jCB_MU_28.setEnabled(false);

    this.jCB_MU_29.setText("29");
    this.jCB_MU_29.setEnabled(false);

    this.jCB_MU_30.setText("30");
    this.jCB_MU_30.setEnabled(false);

    this.jCB_MU_31.setText("31");
    this.jCB_MU_31.setEnabled(false);

    this.jCB_MU_32.setText("32");
    this.jCB_MU_32.setEnabled(false);

    this.jCB_MU_33.setText("33");
    this.jCB_MU_33.setEnabled(false);

    this.jCB_MU_34.setText("34");
    this.jCB_MU_34.setEnabled(false);

    this.jCB_MU_35.setText("35");
    this.jCB_MU_35.setEnabled(false);

    this.jCB_MU_36.setText("36");
    this.jCB_MU_36.setEnabled(false);

    this.jCB_MU_37.setText("37");
    this.jCB_MU_37.setEnabled(false);

    this.jCB_MU_38.setText("38");
    this.jCB_MU_38.setEnabled(false);

    this.jCB_MU_39.setText("39");
    this.jCB_MU_39.setEnabled(false);

    this.jCB_MU_40.setText("40");
    this.jCB_MU_40.setEnabled(false);

    this.jCB_MU_41.setText("41");
    this.jCB_MU_41.setEnabled(false);

    this.jCB_MU_42.setText("42");
    this.jCB_MU_42.setEnabled(false);

    this.jCB_MU_43.setText("43");
    this.jCB_MU_43.setEnabled(false);

    this.jCB_MU_44.setText("44");
    this.jCB_MU_44.setEnabled(false);

    this.jCB_MU_45.setText("45");
    this.jCB_MU_45.setEnabled(false);

    this.jCB_MU_46.setText("46");
    this.jCB_MU_46.setEnabled(false);

    this.jCB_MU_47.setText("47");
    this.jCB_MU_47.setEnabled(false);

    this.jCB_MU_48.setText("48");
    this.jCB_MU_48.setEnabled(false);

    this.jCB_MU_49.setText("49");
    this.jCB_MU_49.setEnabled(false);

    this.jCB_MU_50.setText("50");
    this.jCB_MU_50.setEnabled(false);

    this.jCB_MU_51.setText("51");
    this.jCB_MU_51.setEnabled(false);

    this.jCB_MU_52.setText("52");
    this.jCB_MU_52.setEnabled(false);

    this.jCB_MU_53.setText("53");
    this.jCB_MU_53.setEnabled(false);

    this.jCB_MU_54.setText("54");
    this.jCB_MU_54.setEnabled(false);

    this.jCB_MU_55.setText("55");
    this.jCB_MU_55.setEnabled(false);

    this.jCB_MU_56.setText("56");
    this.jCB_MU_56.setEnabled(false);

    this.jCB_MU_57.setText("57");
    this.jCB_MU_57.setEnabled(false);

    this.jCB_MU_58.setText("58");
    this.jCB_MU_58.setEnabled(false);

    this.jCB_MU_59.setText("59");
    this.jCB_MU_59.setEnabled(false);

    GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
    this.jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_0).addComponent(this.jCB_MU_15)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_16).addComponent(this.jCB_MU_1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_17).addComponent(this.jCB_MU_2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_18).addComponent(this.jCB_MU_3)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_4).addComponent(this.jCB_MU_19)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_20).addComponent(this.jCB_MU_5)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_6).addComponent(this.jCB_MU_21)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_22).addComponent(this.jCB_MU_7)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_8).addComponent(this.jCB_MU_23)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_24).addComponent(this.jCB_MU_9)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_25).addComponent(this.jCB_MU_10)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_26).addComponent(this.jCB_MU_11)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MU_27).addComponent(this.jCB_MU_12)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addComponent(this.jCB_MU_13).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_14)).addGroup(jPanel12Layout.createSequentialGroup().addComponent(this.jCB_MU_28).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_29)))).addGroup(jPanel12Layout.createSequentialGroup().addComponent(this.jCB_MU_45).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_46).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_47).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_48).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_49).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_50).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_51).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_52).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_53).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_54).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_55).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_56).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_57).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_58).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_59)).addGroup(jPanel12Layout.createSequentialGroup().addComponent(this.jCB_MU_30).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_31).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_32).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_33).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_34).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_35).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_36).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_37).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_38).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_39).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_40).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_41).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_MU_42).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_43).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_MU_44))).addContainerGap(-1, 32767)));

    jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_MU_0).addComponent(this.jCB_MU_1).addComponent(this.jCB_MU_2).addComponent(this.jCB_MU_3).addComponent(this.jCB_MU_4).addComponent(this.jCB_MU_5).addComponent(this.jCB_MU_6).addComponent(this.jCB_MU_7).addComponent(this.jCB_MU_8).addComponent(this.jCB_MU_9).addComponent(this.jCB_MU_10).addComponent(this.jCB_MU_11).addComponent(this.jCB_MU_12).addComponent(this.jCB_MU_13).addComponent(this.jCB_MU_14)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_MU_15).addComponent(this.jCB_MU_16).addComponent(this.jCB_MU_17).addComponent(this.jCB_MU_18).addComponent(this.jCB_MU_19).addComponent(this.jCB_MU_20).addComponent(this.jCB_MU_21).addComponent(this.jCB_MU_22).addComponent(this.jCB_MU_23).addComponent(this.jCB_MU_24).addComponent(this.jCB_MU_25).addComponent(this.jCB_MU_26).addComponent(this.jCB_MU_27).addComponent(this.jCB_MU_28).addComponent(this.jCB_MU_29)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_MU_30).addComponent(this.jCB_MU_31).addComponent(this.jCB_MU_32).addComponent(this.jCB_MU_33).addComponent(this.jCB_MU_34).addComponent(this.jCB_MU_35).addComponent(this.jCB_MU_36).addComponent(this.jCB_MU_37).addComponent(this.jCB_MU_38).addComponent(this.jCB_MU_39).addComponent(this.jCB_MU_40).addComponent(this.jCB_MU_41).addComponent(this.jCB_MU_42).addComponent(this.jCB_MU_43).addComponent(this.jCB_MU_44)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_MU_45).addComponent(this.jCB_MU_46).addComponent(this.jCB_MU_47).addComponent(this.jCB_MU_48).addComponent(this.jCB_MU_49).addComponent(this.jCB_MU_50).addComponent(this.jCB_MU_51).addComponent(this.jCB_MU_52).addComponent(this.jCB_MU_53).addComponent(this.jCB_MU_54).addComponent(this.jCB_MU_55).addComponent(this.jCB_MU_56).addComponent(this.jCB_MU_57).addComponent(this.jCB_MU_58).addComponent(this.jCB_MU_59)).addContainerGap(-1, 32767)));

    GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
    this.jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRB_MU_Assign).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jRB_MU_Loop).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSP_MU_From, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSP_MU_Every, -2, 60, -2).addGap(3, 3, 3).addComponent(this.jLabel12)).addGroup(jPanel4Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jPanel12, -2, -1, -2))).addContainerGap(117, 32767)));

    jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jRB_MU_Loop).addComponent(this.jLabel9).addComponent(this.jSP_MU_From, -2, -1, -2).addComponent(this.jLabel10).addComponent(this.jSP_MU_Every, -2, -1, -2).addComponent(this.jLabel12)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRB_MU_Assign).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel12, -2, -1, -2).addContainerGap(39, 32767)));

    this.jTabbedPane1.addTab("分钟", this.jPanel4);

    this.buttonGroup2.add(this.jRB_HH_Every);
    this.jRB_HH_Every.setSelected(true);
    this.jRB_HH_Every.setText("每小时");

    this.buttonGroup2.add(this.jRB_HH_Assign);
    this.jRB_HH_Assign.setText("指定:");
    this.jRB_HH_Assign.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJFrame.this.jRB_HH_AssignActionPerformed(evt);
      }
    });
    this.jPanel9.setBorder(BorderFactory.createEtchedBorder());

    this.jCB_HH_0.setText("0  ");
    this.jCB_HH_0.setEnabled(false);

    this.jCB_HH_1.setText("1  ");
    this.jCB_HH_1.setEnabled(false);

    this.jCB_HH_2.setText("2  ");
    this.jCB_HH_2.setEnabled(false);

    this.jCB_HH_3.setText("3  ");
    this.jCB_HH_3.setEnabled(false);

    this.jCB_HH_4.setText("4  ");
    this.jCB_HH_4.setEnabled(false);

    this.jCB_HH_5.setText("5  ");
    this.jCB_HH_5.setEnabled(false);

    this.jCB_HH_6.setText("6  ");
    this.jCB_HH_6.setEnabled(false);

    this.jCB_HH_7.setText("7  ");
    this.jCB_HH_7.setEnabled(false);

    this.jCB_HH_8.setText("8  ");
    this.jCB_HH_8.setEnabled(false);

    this.jCB_HH_9.setText("9  ");
    this.jCB_HH_9.setEnabled(false);

    this.jCB_HH_10.setText("10  ");
    this.jCB_HH_10.setEnabled(false);

    this.jCB_HH_11.setText("11  ");
    this.jCB_HH_11.setEnabled(false);

    this.jCB_HH_12.setText("12  ");
    this.jCB_HH_12.setEnabled(false);

    this.jCB_HH_13.setText("13  ");
    this.jCB_HH_13.setEnabled(false);

    this.jCB_HH_14.setText("14  ");
    this.jCB_HH_14.setEnabled(false);

    this.jCB_HH_15.setText("15  ");
    this.jCB_HH_15.setEnabled(false);

    this.jCB_HH_16.setText("16  ");
    this.jCB_HH_16.setEnabled(false);

    this.jCB_HH_17.setText("17  ");
    this.jCB_HH_17.setEnabled(false);

    this.jCB_HH_18.setText("18  ");
    this.jCB_HH_18.setEnabled(false);

    this.jCB_HH_19.setText("19  ");
    this.jCB_HH_19.setEnabled(false);

    this.jCB_HH_20.setText("20  ");
    this.jCB_HH_20.setEnabled(false);

    this.jCB_HH_21.setText("21  ");
    this.jCB_HH_21.setEnabled(false);

    this.jCB_HH_22.setText("22  ");
    this.jCB_HH_22.setEnabled(false);

    this.jCB_HH_23.setText("23  ");
    this.jCB_HH_23.setEnabled(false);

    this.jLabel16.setText("上午:");

    this.jLabel17.setText("下午:");

    GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
    this.jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel16).addComponent(this.jLabel17)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_HH_12).addComponent(this.jCB_HH_0)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_HH_1).addComponent(this.jCB_HH_13)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.jCB_HH_14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_HH_15)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.jCB_HH_2).addGap(8, 8, 8).addComponent(this.jCB_HH_3))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_HH_4).addComponent(this.jCB_HH_16)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_HH_5).addComponent(this.jCB_HH_17)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_HH_6).addComponent(this.jCB_HH_18)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_HH_7).addComponent(this.jCB_HH_19)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_HH_8).addComponent(this.jCB_HH_20)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_HH_9).addComponent(this.jCB_HH_21)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_HH_10, GroupLayout.Alignment.TRAILING).addComponent(this.jCB_HH_22)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_HH_11).addComponent(this.jCB_HH_23)).addContainerGap(-1, 32767)));

    jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_HH_11).addComponent(this.jCB_HH_10).addComponent(this.jCB_HH_9)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_HH_21).addComponent(this.jCB_HH_22).addComponent(this.jCB_HH_23))).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_HH_0).addComponent(this.jCB_HH_8).addComponent(this.jCB_HH_7).addComponent(this.jCB_HH_6).addComponent(this.jCB_HH_5).addComponent(this.jCB_HH_4).addComponent(this.jCB_HH_3).addComponent(this.jCB_HH_2).addComponent(this.jCB_HH_1).addComponent(this.jLabel16)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_HH_12).addComponent(this.jCB_HH_13).addComponent(this.jCB_HH_14).addComponent(this.jCB_HH_15).addComponent(this.jCB_HH_16).addComponent(this.jCB_HH_17).addComponent(this.jCB_HH_18).addComponent(this.jCB_HH_19).addComponent(this.jCB_HH_20).addComponent(this.jLabel17)))).addContainerGap(-1, 32767)));

    GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
    this.jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jPanel9, -2, -1, -2)).addComponent(this.jRB_HH_Assign).addComponent(this.jRB_HH_Every)).addContainerGap(64, 32767)));

    jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jRB_HH_Every).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRB_HH_Assign).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel9, -2, -1, -2).addContainerGap(88, 32767)));

    this.jTabbedPane1.addTab("小时", this.jPanel5);

    this.buttonGroup3.add(this.jRB_DD_Every);
    this.jRB_DD_Every.setSelected(true);
    this.jRB_DD_Every.setText("每天");
    this.jRB_DD_Every.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJFrame.this.jRB_DD_EveryActionPerformed(evt);
      }
    });
    this.buttonGroup3.add(this.jRB_DD_Assign);
    this.jRB_DD_Assign.setText("指定:");

    this.jPanel10.setBorder(BorderFactory.createEtchedBorder());

    this.jCB_DD_1.setText("1");
    this.jCB_DD_1.setEnabled(false);

    this.jCB_DD_2.setText("2");
    this.jCB_DD_2.setEnabled(false);

    this.jCB_DD_3.setText("3");
    this.jCB_DD_3.setEnabled(false);

    this.jCB_DD_4.setText("4");
    this.jCB_DD_4.setEnabled(false);

    this.jCB_DD_5.setText("5");
    this.jCB_DD_5.setEnabled(false);

    this.jCB_DD_6.setText("6");
    this.jCB_DD_6.setEnabled(false);

    this.jCB_DD_7.setText("7");
    this.jCB_DD_7.setEnabled(false);

    this.jCB_DD_8.setText("8");
    this.jCB_DD_8.setEnabled(false);

    this.jCB_DD_9.setText("9");
    this.jCB_DD_9.setEnabled(false);

    this.jCB_DD_10.setText("10");
    this.jCB_DD_10.setEnabled(false);

    this.jCB_DD_11.setText("11");
    this.jCB_DD_11.setEnabled(false);

    this.jCB_DD_12.setText("12");
    this.jCB_DD_12.setEnabled(false);

    this.jCB_DD_13.setText("13");
    this.jCB_DD_13.setEnabled(false);

    this.jCB_DD_14.setText("14");
    this.jCB_DD_14.setEnabled(false);

    this.jCB_DD_15.setText("15");
    this.jCB_DD_15.setEnabled(false);

    this.jCB_DD_16.setText("16");
    this.jCB_DD_16.setEnabled(false);

    this.jCB_DD_17.setText("17");
    this.jCB_DD_17.setEnabled(false);

    this.jCB_DD_18.setText("18");
    this.jCB_DD_18.setEnabled(false);

    this.jCB_DD_19.setText("19");
    this.jCB_DD_19.setEnabled(false);

    this.jCB_DD_20.setText("20");
    this.jCB_DD_20.setEnabled(false);

    this.jCB_DD_21.setText("21");
    this.jCB_DD_21.setEnabled(false);

    this.jCB_DD_22.setText("22");
    this.jCB_DD_22.setEnabled(false);

    this.jCB_DD_23.setText("23");
    this.jCB_DD_23.setEnabled(false);

    this.jCB_DD_24.setText("24");
    this.jCB_DD_24.setEnabled(false);

    this.jCB_DD_25.setText("25");
    this.jCB_DD_25.setEnabled(false);

    this.jCB_DD_26.setText("26");
    this.jCB_DD_26.setEnabled(false);

    this.jCB_DD_27.setText("27");
    this.jCB_DD_27.setEnabled(false);

    this.jCB_DD_28.setText("28");
    this.jCB_DD_28.setEnabled(false);

    this.jCB_DD_29.setText("29");
    this.jCB_DD_29.setEnabled(false);

    this.jCB_DD_30.setText("30");
    this.jCB_DD_30.setEnabled(false);

    this.jCB_DD_31.setText("31");
    this.jCB_DD_31.setEnabled(false);

    GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
    this.jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.jCB_DD_1).addGap(7, 7, 7).addComponent(this.jCB_DD_2)).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.jCB_DD_16).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_DD_17))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_DD_3).addComponent(this.jCB_DD_18)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_DD_19).addComponent(this.jCB_DD_4)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.jCB_DD_5).addGap(7, 7, 7).addComponent(this.jCB_DD_6).addGap(7, 7, 7).addComponent(this.jCB_DD_7)).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.jCB_DD_20).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_DD_21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCB_DD_22))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_DD_23).addComponent(this.jCB_DD_8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_DD_9).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.jCB_DD_24).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_DD_25))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_DD_26).addComponent(this.jCB_DD_11)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_DD_12).addComponent(this.jCB_DD_27)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_DD_28).addComponent(this.jCB_DD_13)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.jCB_DD_14).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_DD_15)).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.jCB_DD_29).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_DD_30)))).addGroup(jPanel10Layout.createSequentialGroup().addGap(367, 367, 367).addComponent(this.jCB_DD_10)).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.jCB_DD_31))).addContainerGap(-1, 32767)));

    jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_DD_1).addComponent(this.jCB_DD_2).addComponent(this.jCB_DD_3).addComponent(this.jCB_DD_4).addComponent(this.jCB_DD_5).addComponent(this.jCB_DD_6).addComponent(this.jCB_DD_7).addComponent(this.jCB_DD_8).addComponent(this.jCB_DD_9).addComponent(this.jCB_DD_10).addComponent(this.jCB_DD_11).addComponent(this.jCB_DD_12).addComponent(this.jCB_DD_13).addComponent(this.jCB_DD_14).addComponent(this.jCB_DD_15)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jCB_DD_20).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_DD_16).addComponent(this.jCB_DD_17).addComponent(this.jCB_DD_18).addComponent(this.jCB_DD_19)).addComponent(this.jCB_DD_30).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_DD_21).addComponent(this.jCB_DD_22).addComponent(this.jCB_DD_23).addComponent(this.jCB_DD_24).addComponent(this.jCB_DD_25).addComponent(this.jCB_DD_26).addComponent(this.jCB_DD_27).addComponent(this.jCB_DD_28).addComponent(this.jCB_DD_29))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_DD_31).addContainerGap(-1, 32767)));

    GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
    this.jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRB_DD_Assign).addComponent(this.jRB_DD_Every))).addGroup(jPanel6Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.jPanel10, -2, -1, -2))).addContainerGap(123, 32767)));

    jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jRB_DD_Every).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRB_DD_Assign).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel10, -2, -1, -2).addContainerGap(65, 32767)));

    this.jTabbedPane1.addTab("天", this.jPanel6);

    this.buttonGroup4.add(this.jRB_MM_Every);
    this.jRB_MM_Every.setSelected(true);
    this.jRB_MM_Every.setText("每月");
    this.jRB_MM_Every.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJFrame.this.jRB_MM_EveryActionPerformed(evt);
      }
    });
    this.buttonGroup4.add(this.jRB_MM_Assign);
    this.jRB_MM_Assign.setText("指定:");
    this.jRB_MM_Assign.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJFrame.this.jRB_MM_AssignActionPerformed(evt);
      }
    });
    this.jPanel11.setBorder(BorderFactory.createEtchedBorder());

    this.jCB_MM_1.setText("1  ");
    this.jCB_MM_1.setEnabled(false);

    this.jCB_MM_2.setText("2  ");
    this.jCB_MM_2.setEnabled(false);

    this.jCB_MM_3.setText("3  ");
    this.jCB_MM_3.setEnabled(false);

    this.jCB_MM_4.setText("4  ");
    this.jCB_MM_4.setEnabled(false);

    this.jCB_MM_5.setText("5  ");
    this.jCB_MM_5.setEnabled(false);

    this.jCB_MM_6.setText("6  ");
    this.jCB_MM_6.setEnabled(false);

    this.jCB_MM_7.setText("7  ");
    this.jCB_MM_7.setEnabled(false);

    this.jCB_MM_8.setText("8  ");
    this.jCB_MM_8.setEnabled(false);

    this.jCB_MM_9.setText("9  ");
    this.jCB_MM_9.setEnabled(false);

    this.jCB_MM_10.setText("10  ");
    this.jCB_MM_10.setEnabled(false);

    this.jCB_MM_11.setText("11  ");
    this.jCB_MM_11.setEnabled(false);

    this.jCB_MM_12.setText("12  ");
    this.jCB_MM_12.setEnabled(false);

    GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
    this.jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jCB_MM_1).addGap(7, 7, 7).addComponent(this.jCB_MM_2)).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jCB_MM_7).addGap(7, 7, 7).addComponent(this.jCB_MM_8))).addGap(11, 11, 11).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MM_3, GroupLayout.Alignment.TRAILING).addComponent(this.jCB_MM_9, GroupLayout.Alignment.TRAILING)).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.jCB_MM_4)).addGroup(jPanel11Layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.jCB_MM_10))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MM_5).addComponent(this.jCB_MM_11)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCB_MM_12).addComponent(this.jCB_MM_6)).addContainerGap(-1, 32767)));

    jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_MM_1).addComponent(this.jCB_MM_6).addComponent(this.jCB_MM_5).addComponent(this.jCB_MM_4).addComponent(this.jCB_MM_3).addComponent(this.jCB_MM_2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_MM_12).addComponent(this.jCB_MM_11).addComponent(this.jCB_MM_10)).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_MM_8).addComponent(this.jCB_MM_7).addComponent(this.jCB_MM_9))).addContainerGap(-1, 32767)));

    GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
    this.jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jPanel11, -2, -1, -2)).addComponent(this.jRB_MM_Assign).addComponent(this.jRB_MM_Every)).addContainerGap(381, 32767)));

    jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jRB_MM_Every).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRB_MM_Assign).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel11, -2, -1, -2).addContainerGap(90, 32767)));

    this.jTabbedPane1.addTab("月", this.jPanel7);

    this.jCB_WK_Use.setText("使用星期");
    this.jCB_WK_Use.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent evt) {
        MainJFrame.this.jCB_WK_UseItemStateChanged(evt);
      }
    });
    this.jCB_WK_Use.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJFrame.this.jCB_WK_UseActionPerformed(evt);
      }
    });
    this.jPanel1_WK.setBorder(BorderFactory.createEtchedBorder());

    this.jCB_WK_1.setText("星期日");
    this.jCB_WK_1.setEnabled(false);
    this.jCB_WK_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJFrame.this.jCB_WK_1ActionPerformed(evt);
      }
    });
    this.jCB_WK_2.setText("星期一");
    this.jCB_WK_2.setEnabled(false);

    this.jCB_WK_3.setText("星期二");
    this.jCB_WK_3.setEnabled(false);

    this.jCB_WK_4.setText("星期三");
    this.jCB_WK_4.setEnabled(false);

    this.jCB_WK_5.setText("星期四");
    this.jCB_WK_5.setEnabled(false);

    this.jCB_WK_6.setText("星期五");
    this.jCB_WK_6.setEnabled(false);

    this.jCB_WK_7.setText("星期六");
    this.jCB_WK_7.setEnabled(false);

    this.buttonGroup5.add(this.jRB_WK_Every);
    this.jRB_WK_Every.setSelected(true);
    this.jRB_WK_Every.setText("每星期");
    this.jRB_WK_Every.setEnabled(false);
    this.jRB_WK_Every.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJFrame.this.jRB_WK_EveryActionPerformed(evt);
      }
    });
    this.buttonGroup5.add(this.jRB_WK_Assign);
    this.jRB_WK_Assign.setText("指定:");
    this.jRB_WK_Assign.setEnabled(false);

    GroupLayout jPanel1_WKLayout = new GroupLayout(this.jPanel1_WK);
    this.jPanel1_WK.setLayout(jPanel1_WKLayout);
    jPanel1_WKLayout.setHorizontalGroup(jPanel1_WKLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1_WKLayout.createSequentialGroup().addContainerGap().addGroup(jPanel1_WKLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1_WKLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jCB_WK_1).addGap(11, 11, 11).addComponent(this.jCB_WK_2).addGap(8, 8, 8).addComponent(this.jCB_WK_3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCB_WK_4).addGap(7, 7, 7).addComponent(this.jCB_WK_5).addGap(7, 7, 7).addComponent(this.jCB_WK_6).addGap(7, 7, 7).addComponent(this.jCB_WK_7)).addComponent(this.jRB_WK_Every).addComponent(this.jRB_WK_Assign)).addContainerGap(35, 32767)));

    jPanel1_WKLayout.setVerticalGroup(jPanel1_WKLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1_WKLayout.createSequentialGroup().addContainerGap().addComponent(this.jRB_WK_Every).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRB_WK_Assign).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1_WKLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCB_WK_7).addComponent(this.jCB_WK_6).addComponent(this.jCB_WK_5).addComponent(this.jCB_WK_4).addComponent(this.jCB_WK_3).addComponent(this.jCB_WK_2).addComponent(this.jCB_WK_1)).addContainerGap(-1, 32767)));

    GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
    this.jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.jCB_WK_Use).addContainerGap(650, 32767)).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1_WK, -2, -1, -2).addContainerGap(184, 32767))));

    jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.jCB_WK_Use).addContainerGap(179, 32767)).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGap(39, 39, 39).addComponent(this.jPanel1_WK, -2, -1, -2).addContainerGap(80, 32767))));

    this.jTabbedPane1.addTab("星期", this.jPanel8);

    this.jPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "表达式"));
    this.jPanel2.setPreferredSize(new Dimension(661, 100));

    this.jLabel1.setText("表达式字段:");

    this.jLabel2.setText("秒");

    this.jLabel3.setText("分钟");

    this.jLabel4.setText("小时");

    this.jLabel5.setText("天");

    this.jLabel6.setText("月");

    this.jLabel7.setText("星期");

    this.jLabel8.setText("Cron表达式:");

    this.jTF_Cron_Second.setBackground(Color.orange);

    this.jTF_Cron_Minute.setBackground(Color.orange);

    this.jTF_Cron_Hour.setBackground(Color.orange);

    this.jTF_Cron_Day.setBackground(Color.orange);

    this.jTF_Cron_Month.setBackground(Color.orange);

    this.jTF_Cron_Week.setBackground(Color.orange);

    this.jButton_Parse.setText("解析到UI");
    this.jButton_Parse.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJFrame.this.jButton_ParseActionPerformed(evt);
      }
    });
    this.jPanel13.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "计划执行时间"));

    this.jLabel13.setText("开始时间:");

    this.jTF_Schedule_Start.setEditable(false);

    this.jLabel14.setText("执行时间:");

    this.jTA_Schedule_Next.setEditable(false);
    this.jTA_Schedule_Next.setBackground(UIManager.getDefaults().getColor("CheckBox.background"));
    this.jTA_Schedule_Next.setColumns(20);
    this.jTA_Schedule_Next.setRows(5);
    this.jScrollPane1.setViewportView(this.jTA_Schedule_Next);

    GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
    this.jPanel13.setLayout(jPanel13Layout);
    jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel14).addComponent(this.jLabel13)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTF_Schedule_Start, -1, 618, 32767).addComponent(this.jScrollPane1, -1, 618, 32767)).addContainerGap()));

    jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.jTF_Schedule_Start, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addComponent(this.jLabel14).addContainerGap(146, 32767)).addComponent(this.jScrollPane1, -1, 195, 32767))));

    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel13, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jTF_Cron_Second, -2, 80, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTF_Cron_Minute, -2, 80, -2).addComponent(this.jLabel3)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTF_Cron_Hour, -2, 80, -2).addComponent(this.jLabel4)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTF_Cron_Day, -2, 80, -2).addComponent(this.jLabel5)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTF_Cron_Month, -2, 80, -2).addComponent(this.jLabel6))).addComponent(this.jTF_Cron_Exp)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7).addComponent(this.jTF_Cron_Week, -2, 80, -2).addComponent(this.jButton_Parse)))).addContainerGap()));

    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5).addComponent(this.jLabel6).addComponent(this.jLabel7)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTF_Cron_Second, -2, -1, -2).addComponent(this.jTF_Cron_Minute, -2, -1, -2).addComponent(this.jTF_Cron_Hour, -2, -1, -2).addComponent(this.jTF_Cron_Day, -2, -1, -2).addComponent(this.jTF_Cron_Month, -2, -1, -2).addComponent(this.jTF_Cron_Week, -2, -1, -2).addComponent(this.jLabel1)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jLabel8)).addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTF_Cron_Exp, -2, -1, -2).addComponent(this.jButton_Parse)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel13, -1, -1, 32767)));

    this.jPanel3.setAlignmentX(0.0F);
    this.jPanel3.setAlignmentY(0.0F);

    this.jButton_Copy.setText("复制Cron表达式");
    this.jButton_Copy.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJFrame.this.jButton_CopyActionPerformed(evt);
      }
    });
    this.jButton_Exit.setText("退出");
    this.jButton_Exit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJFrame.this.jButton_ExitActionPerformed(evt);
      }
    });
    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jButton_Copy).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 286, 32767).addComponent(this.jButton_Exit, -2, 97, -2).addGap(261, 261, 261)));

    jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton_Copy).addComponent(this.jButton_Exit)));

    this.jButton_Make.setText("生成Cron表达式");
    this.jButton_Make.setAlignmentY(0.0F);
    this.jButton_Make.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJFrame.this.jButton_MakeActionPerformed(evt);
      }
    });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -2, 746, -2).addComponent(this.jTabbedPane1, -2, 746, -2).addGroup(layout.createSequentialGroup().addComponent(this.jButton_Make).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel3, -2, -1, -2))).addContainerGap(-1, 32767)));

    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jTabbedPane1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -1, 363, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -2, -1, -2).addComponent(this.jButton_Make)).addContainerGap()));

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width - 778) / 2, (screenSize.height - 696) / 2, 778, 696);
  }

  private void jButton_ExitActionPerformed(ActionEvent evt)
  {
    dispose();
    System.exit(0);
  }

  private void jButton_ParseActionPerformed(ActionEvent evt) {
    try {
      if (this.jTF_Cron_Exp.getText().trim().length() == 0) {
        return;
      }

      this.jTA_Schedule_Next.setText("");
      CronExpressionEx exp = new CronExpressionEx(this.jTF_Cron_Exp.getText().trim());
      Date dd = new Date();
      this.jTF_Schedule_Start.setText(DateFormatUtil.format("yyyy-MM-dd HH:mm:ss", dd));
      for (int i = 1; i <= 8; i++) {
        dd = exp.getNextValidTimeAfter(dd);
        this.jTA_Schedule_Next.append(i + ": " + DateFormatUtil.format("yyyy-MM-dd HH:mm:ss", dd) + "\n");
        dd = new Date(dd.getTime() + 1000L);
      }

      this.jTF_Cron_Second.setText(exp.getSecondsExp());
      this.jTF_Cron_Minute.setText(exp.getMinutesExp());
      this.jTF_Cron_Hour.setText(exp.getHoursExp());
      this.jTF_Cron_Day.setText(exp.getDaysOfMonthExp());
      this.jTF_Cron_Month.setText(exp.getMonthsExp());
      this.jTF_Cron_Week.setText(exp.getDaysOfWeekExp());

      for (JCheckBox cb : this.jCB_MU_Map.values()) {
        cb.setSelected(false);
      }
      Set set = exp.getMinutesSet();
      Iterator itr = set.iterator();
      if (set.contains(CronExpressionEx.ALL_SPEC)) {
        this.jRB_MU_Loop.setSelected(true);
        this.sp_MU_From_Model.setValue(Integer.valueOf(0));
        this.sp_MU_Every_Model.setValue(Integer.valueOf(1));
      }
      else if (this.jTF_Cron_Minute.getText().contains("/")) {
        this.jRB_MU_Loop.setSelected(true);

        Integer iFrom = (Integer)itr.next();
        Integer iTo = (Integer)itr.next();
        int interval = iTo.intValue() - iFrom.intValue();
        this.sp_MU_From_Model.setValue(iFrom);
        this.sp_MU_Every_Model.setValue(Integer.valueOf(interval));
      } else {
        this.jRB_MU_Assign.setSelected(true);
        while (itr.hasNext()) {
          Integer iVal = (Integer)itr.next();
          ((JCheckBox)this.jCB_MU_Map.get(iVal)).setSelected(true);
        }

      }

      for (JCheckBox cb : this.jCB_HH_Map.values()) {
        cb.setSelected(false);
      }
      set = exp.getHoursSet();
      itr = set.iterator();
      if (set.contains(CronExpressionEx.ALL_SPEC)) {
        this.jRB_HH_Every.setSelected(true);
      } else {
        this.jRB_HH_Assign.setSelected(true);

        while (itr.hasNext()) {
          Integer iVal = (Integer)itr.next();
          ((JCheckBox)this.jCB_HH_Map.get(iVal)).setSelected(true);
        }

      }

      for (JCheckBox cb : this.jCB_DD_Map.values()) {
        cb.setSelected(false);
      }
      set = exp.getDaysOfMonthSet();
      itr = set.iterator();
      if (!set.contains(Integer.valueOf(98)))
      {
        if (set.contains(CronExpressionEx.ALL_SPEC)) {
          this.jRB_DD_Every.setSelected(true);
        } else {
          this.jRB_DD_Assign.setSelected(true);

          while (itr.hasNext()) {
            Integer iVal = (Integer)itr.next();
            ((JCheckBox)this.jCB_DD_Map.get(iVal)).setSelected(true);
          }
        }
      }

      for (JCheckBox cb : this.jCB_MM_Map.values()) {
        cb.setSelected(false);
      }
      set = exp.getMonthsSet();
      itr = set.iterator();
      if (set.contains(CronExpressionEx.ALL_SPEC)) {
        this.jRB_MM_Every.setSelected(true);
      } else {
        this.jRB_MM_Assign.setSelected(true);

        while (itr.hasNext()) {
          Integer iVal = (Integer)itr.next();
          ((JCheckBox)this.jCB_MM_Map.get(iVal)).setSelected(true);
        }

      }

      for (JCheckBox cb : this.jCB_WK_Map.values()) {
        cb.setSelected(false);
      }
      this.jCB_WK_Use.setSelected(true);
      set = exp.getDaysOfWeekSet();
      itr = set.iterator();
      if (set.contains(Integer.valueOf(98))) {
        this.jCB_WK_Use.setSelected(false);
      } else if (set.contains(CronExpressionEx.ALL_SPEC)) {
        this.jCB_WK_Use.setSelected(true);
        this.jRB_WK_Every.setSelected(true);
      } else {
        this.jCB_WK_Use.setSelected(true);
        this.jRB_WK_Assign.setSelected(true);

        while (itr.hasNext()) {
          Integer iVal = (Integer)itr.next();
          ((JCheckBox)this.jCB_WK_Map.get(iVal)).setSelected(true);
        }
      }
    }
    catch (Throwable ex)
    {
      JOptionPane.showMessageDialog(this, "解析Cron表达式发生错误:" + ex);
    }
  }

  private void jButton_CopyActionPerformed(ActionEvent evt)
  {
    this.jTF_Cron_Exp.selectAll();
    this.jTF_Cron_Exp.copy();
  }

  private void jCB_WK_UseItemStateChanged(ItemEvent evt) {
    this.jRB_WK_Every.setEnabled(this.jCB_WK_Use.isSelected());
    this.jRB_WK_Assign.setEnabled(this.jCB_WK_Use.isSelected());

    for (JCheckBox cb : this.jCB_WK_Map.values())
      cb.setEnabled((this.jCB_WK_Use.isSelected()) && (this.jRB_WK_Assign.isSelected()));
  }

  private void jButton_MakeActionPerformed(ActionEvent evt)
  {
    try
    {
      this.jTF_Cron_Second.setText("0");

      if (this.jRB_MU_Loop.isSelected()) {
        this.jTF_Cron_Minute.setText(this.jSP_MU_From.getValue().toString() + "/" + this.jSP_MU_Every.getValue().toString());
      } else {
        StringBuilder buf = new StringBuilder();
        boolean first = true;
        for (Iterator i$ = this.jCB_MU_Map.keySet().iterator(); i$.hasNext(); ) { int key = ((Integer)i$.next()).intValue();
          JCheckBox cb = (JCheckBox)this.jCB_MU_Map.get(Integer.valueOf(key));
          if (cb.isSelected()) {
            if (!first) {
              buf.append(",");
            }
            buf.append(key);
            first = false;
          }
        }
        this.jTF_Cron_Minute.setText(buf.toString());
        if (this.jTF_Cron_Minute.getText().length() == 0) {
          throw new VerifyError("没有指定分钟!");
        }
      }

      if (this.jRB_HH_Every.isSelected()) {
        this.jTF_Cron_Hour.setText("*");
      } else {
        StringBuilder buf = new StringBuilder();
        boolean first = true;
        for (Iterator i$ = this.jCB_HH_Map.keySet().iterator(); i$.hasNext(); ) { int key = ((Integer)i$.next()).intValue();
          JCheckBox cb = (JCheckBox)this.jCB_HH_Map.get(Integer.valueOf(key));
          if (cb.isSelected()) {
            if (!first) {
              buf.append(",");
            }
            buf.append(key);
            first = false;
          }
        }
        this.jTF_Cron_Hour.setText(buf.toString());
        if (this.jTF_Cron_Hour.getText().length() == 0) {
          throw new VerifyError("没有指定小时!");
        }
      }

      if (this.jCB_WK_Use.isSelected()) {
        this.jTF_Cron_Day.setText("?");
        if (this.jRB_WK_Every.isSelected()) {
          this.jTF_Cron_Week.setText("*");
        } else {
          StringBuilder buf = new StringBuilder();
          boolean first = true;
          for (Iterator i$ = this.jCB_WK_Map.keySet().iterator(); i$.hasNext(); ) { int key = ((Integer)i$.next()).intValue();
            JCheckBox cb = (JCheckBox)this.jCB_WK_Map.get(Integer.valueOf(key));
            if (cb.isSelected()) {
              if (!first) {
                buf.append(",");
              }
              buf.append(key);
              first = false;
            }
          }
          this.jTF_Cron_Week.setText(buf.toString());
          if (this.jTF_Cron_Week.getText().length() == 0)
            throw new VerifyError("没有指定礼拜!");
        }
      }
      else
      {
        this.jTF_Cron_Week.setText("?");
        if (this.jRB_DD_Every.isSelected()) {
          this.jTF_Cron_Day.setText("*");
        } else {
          StringBuilder buf = new StringBuilder();
          boolean first = true;
          for (Iterator i$ = this.jCB_DD_Map.keySet().iterator(); i$.hasNext(); ) { int key = ((Integer)i$.next()).intValue();
            JCheckBox cb = (JCheckBox)this.jCB_DD_Map.get(Integer.valueOf(key));
            if (cb.isSelected()) {
              if (!first) {
                buf.append(",");
              }
              buf.append(key);
              first = false;
            }
          }
          this.jTF_Cron_Day.setText(buf.toString());
          if (this.jTF_Cron_Day.getText().length() == 0) {
            throw new VerifyError("没有指定天!");
          }
        }
      }

      if (this.jRB_MM_Every.isSelected()) {
        this.jTF_Cron_Month.setText("*");
      } else {
        StringBuilder buf = new StringBuilder();
        boolean first = true;
        for (Iterator i$ = this.jCB_MM_Map.keySet().iterator(); i$.hasNext(); ) { int key = ((Integer)i$.next()).intValue();
          JCheckBox cb = (JCheckBox)this.jCB_MM_Map.get(Integer.valueOf(key));
          if (cb.isSelected()) {
            if (!first) {
              buf.append(",");
            }
            buf.append(key);
            first = false;
          }
        }
        this.jTF_Cron_Month.setText(buf.toString());
        if (this.jTF_Cron_Month.getText().length() == 0) {
          throw new VerifyError("没有指定月份!");
        }
      }

      String cronStr = this.jTF_Cron_Second.getText() + " " + this.jTF_Cron_Minute.getText() + " " + this.jTF_Cron_Hour.getText() + " " + this.jTF_Cron_Day.getText() + " " + this.jTF_Cron_Month.getText() + " " + this.jTF_Cron_Week.getText();

      CronExpressionEx exp = new CronExpressionEx(cronStr);
      this.jTF_Cron_Exp.setText(exp.toString());

      this.jTA_Schedule_Next.setText("");
      Date dd = new Date();
      this.jTF_Schedule_Start.setText(DateFormatUtil.format("yyyy-MM-dd HH:mm:ss", dd));
      for (int i = 1; i <= 8; i++) {
        dd = exp.getNextValidTimeAfter(dd);
        this.jTA_Schedule_Next.append(i + ": " + DateFormatUtil.format("yyyy-MM-dd HH:mm:ss", dd) + "\n");
        dd = new Date(dd.getTime() + 1000L);
      }
    } catch (Throwable ex) {
      JOptionPane.showMessageDialog(this, "生成Cron表达式发生错误:" + ex);
    }
  }

  private void jRB_MU_AssignActionPerformed(ActionEvent evt)
  {
  }

  private void jRB_HH_AssignActionPerformed(ActionEvent evt)
  {
  }

  private void jRB_DD_EveryActionPerformed(ActionEvent evt)
  {
  }

  private void jRB_MM_EveryActionPerformed(ActionEvent evt)
  {
  }

  private void jRB_MM_AssignActionPerformed(ActionEvent evt)
  {
  }

  private void jCB_WK_UseActionPerformed(ActionEvent evt)
  {
  }

  private void jRB_WK_EveryActionPerformed(ActionEvent evt)
  {
  }

  private void jCB_WK_1ActionPerformed(ActionEvent evt)
  {
  }

  public void postInitUI()
  {
    this.jRB_MU_Loop.addItemListener(this._MUItemListener);
    this.jRB_MU_Assign.addItemListener(this._MUItemListener);

    this.jRB_HH_Every.addItemListener(this._HHItemListener);
    this.jRB_HH_Assign.addItemListener(this._HHItemListener);

    this.jRB_DD_Every.addItemListener(this._DDItemListener);
    this.jRB_DD_Assign.addItemListener(this._DDItemListener);

    this.jRB_MM_Every.addItemListener(this._MMItemListener);
    this.jRB_MM_Assign.addItemListener(this._MMItemListener);

    this.jRB_WK_Every.addItemListener(this._WKItemListener);
    this.jRB_WK_Assign.addItemListener(this._WKItemListener);

    this.jCB_MU_Map.put(Integer.valueOf(0), this.jCB_MU_0);
    this.jCB_MU_Map.put(Integer.valueOf(1), this.jCB_MU_1);
    this.jCB_MU_Map.put(Integer.valueOf(2), this.jCB_MU_2);
    this.jCB_MU_Map.put(Integer.valueOf(3), this.jCB_MU_3);
    this.jCB_MU_Map.put(Integer.valueOf(4), this.jCB_MU_4);
    this.jCB_MU_Map.put(Integer.valueOf(5), this.jCB_MU_5);
    this.jCB_MU_Map.put(Integer.valueOf(6), this.jCB_MU_6);
    this.jCB_MU_Map.put(Integer.valueOf(7), this.jCB_MU_7);
    this.jCB_MU_Map.put(Integer.valueOf(8), this.jCB_MU_8);
    this.jCB_MU_Map.put(Integer.valueOf(9), this.jCB_MU_9);
    this.jCB_MU_Map.put(Integer.valueOf(10), this.jCB_MU_10);
    this.jCB_MU_Map.put(Integer.valueOf(11), this.jCB_MU_11);
    this.jCB_MU_Map.put(Integer.valueOf(12), this.jCB_MU_12);
    this.jCB_MU_Map.put(Integer.valueOf(13), this.jCB_MU_13);
    this.jCB_MU_Map.put(Integer.valueOf(14), this.jCB_MU_14);
    this.jCB_MU_Map.put(Integer.valueOf(15), this.jCB_MU_15);
    this.jCB_MU_Map.put(Integer.valueOf(16), this.jCB_MU_16);
    this.jCB_MU_Map.put(Integer.valueOf(17), this.jCB_MU_17);
    this.jCB_MU_Map.put(Integer.valueOf(18), this.jCB_MU_18);
    this.jCB_MU_Map.put(Integer.valueOf(19), this.jCB_MU_19);
    this.jCB_MU_Map.put(Integer.valueOf(20), this.jCB_MU_20);
    this.jCB_MU_Map.put(Integer.valueOf(21), this.jCB_MU_21);
    this.jCB_MU_Map.put(Integer.valueOf(22), this.jCB_MU_22);
    this.jCB_MU_Map.put(Integer.valueOf(23), this.jCB_MU_23);
    this.jCB_MU_Map.put(Integer.valueOf(24), this.jCB_MU_24);
    this.jCB_MU_Map.put(Integer.valueOf(25), this.jCB_MU_25);
    this.jCB_MU_Map.put(Integer.valueOf(26), this.jCB_MU_26);
    this.jCB_MU_Map.put(Integer.valueOf(27), this.jCB_MU_27);
    this.jCB_MU_Map.put(Integer.valueOf(28), this.jCB_MU_28);
    this.jCB_MU_Map.put(Integer.valueOf(29), this.jCB_MU_29);
    this.jCB_MU_Map.put(Integer.valueOf(30), this.jCB_MU_30);
    this.jCB_MU_Map.put(Integer.valueOf(31), this.jCB_MU_31);
    this.jCB_MU_Map.put(Integer.valueOf(32), this.jCB_MU_32);
    this.jCB_MU_Map.put(Integer.valueOf(33), this.jCB_MU_33);
    this.jCB_MU_Map.put(Integer.valueOf(34), this.jCB_MU_34);
    this.jCB_MU_Map.put(Integer.valueOf(35), this.jCB_MU_35);
    this.jCB_MU_Map.put(Integer.valueOf(36), this.jCB_MU_36);
    this.jCB_MU_Map.put(Integer.valueOf(37), this.jCB_MU_37);
    this.jCB_MU_Map.put(Integer.valueOf(38), this.jCB_MU_38);
    this.jCB_MU_Map.put(Integer.valueOf(39), this.jCB_MU_39);
    this.jCB_MU_Map.put(Integer.valueOf(40), this.jCB_MU_40);
    this.jCB_MU_Map.put(Integer.valueOf(41), this.jCB_MU_41);
    this.jCB_MU_Map.put(Integer.valueOf(42), this.jCB_MU_42);
    this.jCB_MU_Map.put(Integer.valueOf(43), this.jCB_MU_43);
    this.jCB_MU_Map.put(Integer.valueOf(44), this.jCB_MU_44);
    this.jCB_MU_Map.put(Integer.valueOf(45), this.jCB_MU_45);
    this.jCB_MU_Map.put(Integer.valueOf(46), this.jCB_MU_46);
    this.jCB_MU_Map.put(Integer.valueOf(47), this.jCB_MU_47);
    this.jCB_MU_Map.put(Integer.valueOf(48), this.jCB_MU_48);
    this.jCB_MU_Map.put(Integer.valueOf(49), this.jCB_MU_49);
    this.jCB_MU_Map.put(Integer.valueOf(50), this.jCB_MU_50);
    this.jCB_MU_Map.put(Integer.valueOf(51), this.jCB_MU_51);
    this.jCB_MU_Map.put(Integer.valueOf(52), this.jCB_MU_52);
    this.jCB_MU_Map.put(Integer.valueOf(53), this.jCB_MU_53);
    this.jCB_MU_Map.put(Integer.valueOf(54), this.jCB_MU_54);
    this.jCB_MU_Map.put(Integer.valueOf(55), this.jCB_MU_55);
    this.jCB_MU_Map.put(Integer.valueOf(56), this.jCB_MU_56);
    this.jCB_MU_Map.put(Integer.valueOf(57), this.jCB_MU_57);
    this.jCB_MU_Map.put(Integer.valueOf(58), this.jCB_MU_58);
    this.jCB_MU_Map.put(Integer.valueOf(59), this.jCB_MU_59);
    for (JCheckBox cb : this.jCB_MU_Map.values()) {
      cb.addItemListener(this._checkBoxItemListener);
    }

    this.jCB_HH_Map.put(Integer.valueOf(0), this.jCB_HH_0);
    this.jCB_HH_Map.put(Integer.valueOf(1), this.jCB_HH_1);
    this.jCB_HH_Map.put(Integer.valueOf(2), this.jCB_HH_2);
    this.jCB_HH_Map.put(Integer.valueOf(3), this.jCB_HH_3);
    this.jCB_HH_Map.put(Integer.valueOf(4), this.jCB_HH_4);
    this.jCB_HH_Map.put(Integer.valueOf(5), this.jCB_HH_5);
    this.jCB_HH_Map.put(Integer.valueOf(6), this.jCB_HH_6);
    this.jCB_HH_Map.put(Integer.valueOf(7), this.jCB_HH_7);
    this.jCB_HH_Map.put(Integer.valueOf(8), this.jCB_HH_8);
    this.jCB_HH_Map.put(Integer.valueOf(9), this.jCB_HH_9);
    this.jCB_HH_Map.put(Integer.valueOf(10), this.jCB_HH_10);
    this.jCB_HH_Map.put(Integer.valueOf(11), this.jCB_HH_11);
    this.jCB_HH_Map.put(Integer.valueOf(12), this.jCB_HH_12);
    this.jCB_HH_Map.put(Integer.valueOf(13), this.jCB_HH_13);
    this.jCB_HH_Map.put(Integer.valueOf(14), this.jCB_HH_14);
    this.jCB_HH_Map.put(Integer.valueOf(15), this.jCB_HH_15);
    this.jCB_HH_Map.put(Integer.valueOf(16), this.jCB_HH_16);
    this.jCB_HH_Map.put(Integer.valueOf(17), this.jCB_HH_17);
    this.jCB_HH_Map.put(Integer.valueOf(18), this.jCB_HH_18);
    this.jCB_HH_Map.put(Integer.valueOf(19), this.jCB_HH_19);
    this.jCB_HH_Map.put(Integer.valueOf(20), this.jCB_HH_20);
    this.jCB_HH_Map.put(Integer.valueOf(21), this.jCB_HH_21);
    this.jCB_HH_Map.put(Integer.valueOf(22), this.jCB_HH_22);
    this.jCB_HH_Map.put(Integer.valueOf(23), this.jCB_HH_23);
    for (JCheckBox cb : this.jCB_HH_Map.values()) {
      cb.addItemListener(this._checkBoxItemListener);
    }

    this.jCB_DD_Map.put(Integer.valueOf(1), this.jCB_DD_1);
    this.jCB_DD_Map.put(Integer.valueOf(2), this.jCB_DD_2);
    this.jCB_DD_Map.put(Integer.valueOf(3), this.jCB_DD_3);
    this.jCB_DD_Map.put(Integer.valueOf(4), this.jCB_DD_4);
    this.jCB_DD_Map.put(Integer.valueOf(5), this.jCB_DD_5);
    this.jCB_DD_Map.put(Integer.valueOf(6), this.jCB_DD_6);
    this.jCB_DD_Map.put(Integer.valueOf(7), this.jCB_DD_7);
    this.jCB_DD_Map.put(Integer.valueOf(8), this.jCB_DD_8);
    this.jCB_DD_Map.put(Integer.valueOf(9), this.jCB_DD_9);
    this.jCB_DD_Map.put(Integer.valueOf(10), this.jCB_DD_10);
    this.jCB_DD_Map.put(Integer.valueOf(11), this.jCB_DD_11);
    this.jCB_DD_Map.put(Integer.valueOf(12), this.jCB_DD_12);
    this.jCB_DD_Map.put(Integer.valueOf(13), this.jCB_DD_13);
    this.jCB_DD_Map.put(Integer.valueOf(14), this.jCB_DD_14);
    this.jCB_DD_Map.put(Integer.valueOf(15), this.jCB_DD_15);
    this.jCB_DD_Map.put(Integer.valueOf(16), this.jCB_DD_16);
    this.jCB_DD_Map.put(Integer.valueOf(17), this.jCB_DD_17);
    this.jCB_DD_Map.put(Integer.valueOf(18), this.jCB_DD_18);
    this.jCB_DD_Map.put(Integer.valueOf(19), this.jCB_DD_19);
    this.jCB_DD_Map.put(Integer.valueOf(20), this.jCB_DD_20);
    this.jCB_DD_Map.put(Integer.valueOf(21), this.jCB_DD_21);
    this.jCB_DD_Map.put(Integer.valueOf(22), this.jCB_DD_22);
    this.jCB_DD_Map.put(Integer.valueOf(23), this.jCB_DD_23);
    this.jCB_DD_Map.put(Integer.valueOf(24), this.jCB_DD_24);
    this.jCB_DD_Map.put(Integer.valueOf(25), this.jCB_DD_25);
    this.jCB_DD_Map.put(Integer.valueOf(26), this.jCB_DD_26);
    this.jCB_DD_Map.put(Integer.valueOf(27), this.jCB_DD_27);
    this.jCB_DD_Map.put(Integer.valueOf(28), this.jCB_DD_28);
    this.jCB_DD_Map.put(Integer.valueOf(29), this.jCB_DD_29);
    this.jCB_DD_Map.put(Integer.valueOf(30), this.jCB_DD_30);
    this.jCB_DD_Map.put(Integer.valueOf(31), this.jCB_DD_31);
    for (JCheckBox cb : this.jCB_DD_Map.values()) {
      cb.addItemListener(this._checkBoxItemListener);
    }

    this.jCB_MM_Map.put(Integer.valueOf(1), this.jCB_MM_1);
    this.jCB_MM_Map.put(Integer.valueOf(2), this.jCB_MM_2);
    this.jCB_MM_Map.put(Integer.valueOf(3), this.jCB_MM_3);
    this.jCB_MM_Map.put(Integer.valueOf(4), this.jCB_MM_4);
    this.jCB_MM_Map.put(Integer.valueOf(5), this.jCB_MM_5);
    this.jCB_MM_Map.put(Integer.valueOf(6), this.jCB_MM_6);
    this.jCB_MM_Map.put(Integer.valueOf(7), this.jCB_MM_7);
    this.jCB_MM_Map.put(Integer.valueOf(8), this.jCB_MM_8);
    this.jCB_MM_Map.put(Integer.valueOf(9), this.jCB_MM_9);
    this.jCB_MM_Map.put(Integer.valueOf(10), this.jCB_MM_10);
    this.jCB_MM_Map.put(Integer.valueOf(11), this.jCB_MM_11);
    this.jCB_MM_Map.put(Integer.valueOf(12), this.jCB_MM_12);
    for (JCheckBox cb : this.jCB_MM_Map.values()) {
      cb.addItemListener(this._checkBoxItemListener);
    }

    this.jCB_WK_Map.put(Integer.valueOf(1), this.jCB_WK_1);
    this.jCB_WK_Map.put(Integer.valueOf(2), this.jCB_WK_2);
    this.jCB_WK_Map.put(Integer.valueOf(3), this.jCB_WK_3);
    this.jCB_WK_Map.put(Integer.valueOf(4), this.jCB_WK_4);
    this.jCB_WK_Map.put(Integer.valueOf(5), this.jCB_WK_5);
    this.jCB_WK_Map.put(Integer.valueOf(6), this.jCB_WK_6);
    this.jCB_WK_Map.put(Integer.valueOf(7), this.jCB_WK_7);
    for (JCheckBox cb : this.jCB_WK_Map.values())
      cb.addItemListener(this._checkBoxItemListener);
  }

  class CheckBoxItemListener
    implements ItemListener
  {
    CheckBoxItemListener()
    {
    }

    public void itemStateChanged(ItemEvent evt)
    {
      JCheckBox checkBox = (JCheckBox)evt.getSource();
      if (checkBox.isSelected()) {
        checkBox.setForeground(Color.blue);
        checkBox.setFont(MainJFrame.fontBOLD);
      } else {
        checkBox.setForeground(Color.black);
        checkBox.setFont(MainJFrame.fontPLAIN);
      }
    }
  }

  class WKItemListener
    implements ItemListener
  {
    WKItemListener()
    {
    }

    public void itemStateChanged(ItemEvent evt)
    {
      for (JCheckBox cb : MainJFrame.this.jCB_WK_Map.values())
        cb.setEnabled(!MainJFrame.this.jRB_WK_Every.isSelected());
    }
  }

  class MMItemListener
    implements ItemListener
  {
    MMItemListener()
    {
    }

    public void itemStateChanged(ItemEvent evt)
    {
      for (JCheckBox cb : MainJFrame.this.jCB_MM_Map.values())
        cb.setEnabled(!MainJFrame.this.jRB_MM_Every.isSelected());
    }
  }

  class DDItemListener
    implements ItemListener
  {
    DDItemListener()
    {
    }

    public void itemStateChanged(ItemEvent evt)
    {
      for (JCheckBox cb : MainJFrame.this.jCB_DD_Map.values())
        cb.setEnabled(!MainJFrame.this.jRB_DD_Every.isSelected());
    }
  }

  class HHItemListener
    implements ItemListener
  {
    HHItemListener()
    {
    }

    public void itemStateChanged(ItemEvent evt)
    {
      for (JCheckBox cb : MainJFrame.this.jCB_HH_Map.values())
        cb.setEnabled(!MainJFrame.this.jRB_HH_Every.isSelected());
    }
  }

  class MUItemListener
    implements ItemListener
  {
    MUItemListener()
    {
    }

    public void itemStateChanged(ItemEvent evt)
    {
      boolean selected = MainJFrame.this.jRB_MU_Loop.isSelected();
      MainJFrame.this.jSP_MU_From.setEnabled(selected);
      MainJFrame.this.jSP_MU_Every.setEnabled(selected);
      for (JCheckBox cb : MainJFrame.this.jCB_MU_Map.values())
        cb.setEnabled(!selected);
    }
  }
}
