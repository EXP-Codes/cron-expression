package exp.cron.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI.NormalColor;

import exp.libs.utils.os.OSUtils;
import exp.libs.warp.task.cron.Cron;
import exp.libs.warp.ui.BeautyEyeUtils;
import exp.libs.warp.ui.SwingUtils;
import exp.libs.warp.ui.cpt.win.MainWindow;

public class CronUI extends MainWindow {

	/** serialVersionUID */
	private static final long serialVersionUID = 1881366271417634383L;

	protected final static String SECOND = "秒", MINUTE = "分", HOUR = "时", 
			DAY = "日期", MONTH = "月份", WEEK = "星期", YEAR = "年份";
	
	private final static int WIDTH = 800;
	
	private final static int HEIGHT = 680;
	
	private Cron cron;
	
	private JTextField tfExpression;
	
	private JTextField tfSecond;
	
	private JTextField tfMinute;
	
	private JTextField tfHour;
	
	private JTextField tfDay;
	
	private JTextField tfMonth;
	
	private JTextField tfWeek;
	
	private JTextField tfYear;
	
	private JButton copyBtn;
	
	private static volatile CronUI instance;
	
	private CronUI() {
		super("Cron表达式生成器", WIDTH, HEIGHT);
	}
	
	public static CronUI getInstn() {
		if(instance == null) {
			synchronized (CronUI.class) {
				if(instance == null) {
					instance = new CronUI();
					instance.setMini(TO_MINI);
				}
			}
		}
		return instance;
	}
	
	@Override
	protected void initComponents(Object... args) {
		this.cron = new Cron();
		
		this.tfExpression = new JTextField(cron.toExpression());
		this.tfSecond = new JTextField(cron.Second().getSubExpression());
		this.tfMinute = new JTextField(cron.Minute().getSubExpression());
		this.tfHour = new JTextField(cron.Hour().getSubExpression());
		this.tfDay = new JTextField(cron.Day().getSubExpression());
		this.tfMonth = new JTextField(cron.Month().getSubExpression());
		this.tfWeek = new JTextField(cron.Week().getSubExpression());
		this.tfYear = new JTextField(cron.Year().getSubExpression());
		
		tfExpression.setEditable(false);
		tfSecond.setEditable(false);
		tfMinute.setEditable(false);
		tfHour.setEditable(false);
		tfDay.setEditable(false);
		tfMonth.setEditable(false);
		tfWeek.setEditable(false);
		tfYear.setEditable(false);
		
		this.copyBtn = new JButton("复制");
		copyBtn.setForeground(Color.BLACK);
		BeautyEyeUtils.setButtonStyle(NormalColor.lightBlue, copyBtn);
	}

	@Override
	protected void setComponentsLayout(JPanel rootPanel) {
		rootPanel.add(toContralPanel(), BorderLayout.NORTH);
//		rootPanel.add(toSchedulePanel(), BorderLayout.CENTER);
//		rootPanel.add(createBtn, BorderLayout.SOUTH);
	}
	
	private JPanel toContralPanel() {
		JPanel panel = new JPanel(new BorderLayout()); {
			JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP); {
				tabbedPanel.add(new _SecondPanel(cron, "秒"), SECOND);
				tabbedPanel.add(new _MinutePanel(cron, "分钟"), MINUTE);
				tabbedPanel.add(new _HourPanel(cron, "小时"), HOUR);
				tabbedPanel.add(new _DayPanel(cron, "日"), DAY);
				tabbedPanel.add(new _MonthPanel(cron,"月"), MONTH);
				tabbedPanel.add(new _WeekPanel(cron, "星期"), WEEK);
				tabbedPanel.add(new _YearPanel(cron, "年"), YEAR);
			}
			SwingUtils.addBorder(tabbedPanel, "Contral");
			panel.add(tabbedPanel, BorderLayout.CENTER);
			
			panel.add(toExpressionPanel(), BorderLayout.SOUTH);
		}
		return panel;
	}
	
	private JPanel toExpressionPanel() {
		JPanel panel = new JPanel(new BorderLayout()); {
			panel.add(SwingUtils.getPairsPanel(
					SwingUtils.getVGridPanel(new JLabel(" "), new JLabel("表达式字段 ： ")),
					SwingUtils.getHGridPanel(
						SwingUtils.getVGridPanel(new JLabel(SECOND, JLabel.CENTER), tfSecond), 
						SwingUtils.getVGridPanel(new JLabel(MINUTE, JLabel.CENTER), tfMinute), 
						SwingUtils.getVGridPanel(new JLabel(HOUR, JLabel.CENTER), tfHour), 
						SwingUtils.getVGridPanel(new JLabel(DAY, JLabel.CENTER), tfDay), 
						SwingUtils.getVGridPanel(new JLabel(MONTH, JLabel.CENTER), tfMonth), 
						SwingUtils.getVGridPanel(new JLabel(WEEK, JLabel.CENTER), tfWeek), 
						SwingUtils.getVGridPanel(new JLabel(YEAR, JLabel.CENTER), tfYear)
					)
			), BorderLayout.NORTH);
			
			panel.add(new JLabel(" "), BorderLayout.CENTER);
			
			panel.add(SwingUtils.getWEBorderPanel(
					new JLabel("Cron表达式 ： "), tfExpression, copyBtn
			), BorderLayout.SOUTH);
		}
		SwingUtils.addBorder(panel, "Expression");
		return panel;
	}
	
	@Override
	protected void setComponentsListener(JPanel rootPanel) {
		copyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OSUtils.copyToClipboard(tfExpression.getText());
				SwingUtils.info("复制cron到剪贴板成功");
			}
		});
	}

	@Override
	protected void AfterView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void beforeHide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void beforeExit() {
		// TODO Auto-generated method stub
		
	}
	
	protected void updateCron() {
		this.tfExpression.setText(cron.toExpression());
		this.tfSecond.setText(cron.Second().getSubExpression());
		this.tfMinute.setText(cron.Minute().getSubExpression());
		this.tfHour.setText(cron.Hour().getSubExpression());
		this.tfDay.setText(cron.Day().getSubExpression());
		this.tfMonth.setText(cron.Month().getSubExpression());
		this.tfWeek.setText(cron.Week().getSubExpression());
		this.tfYear.setText(cron.Year().getSubExpression());
	}

}
