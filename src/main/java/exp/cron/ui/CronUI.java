package exp.cron.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import exp.libs.warp.task.cron.Cron;
import exp.libs.warp.ui.SwingUtils;
import exp.libs.warp.ui.cpt.win.MainWindow;

public class CronUI extends MainWindow {

	/** serialVersionUID */
	private static final long serialVersionUID = 1881366271417634383L;

	private final static int WIDTH = 800;
	
	private final static int HEIGHT = 750;
	
	private Cron cron;
	
	public CronUI() {
		super("Cron表达式生成器", WIDTH, HEIGHT);
	}
	
	@Override
	protected void initComponents(Object... args) {
		this.cron = new Cron();
	}

	@Override
	protected void setComponentsLayout(JPanel rootPanel) {
		rootPanel.add(toContralPanel(), BorderLayout.NORTH);
		rootPanel.add(toSchedulePanel(), BorderLayout.CENTER);
		rootPanel.add(new JButton("生成Cron表达式"), BorderLayout.SOUTH);
	}
	
	private JPanel toContralPanel() {
		JPanel panel = new JPanel(new BorderLayout()); {
			JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP); {
				tabbedPanel.add(new _SecondPanel("秒"), "秒");
				tabbedPanel.add(new _MinutePanel("分钟"), "分");
				tabbedPanel.add(new _HourPanel("小时"), "时");
				tabbedPanel.add(new _DayPanel("日"), "日期");
				tabbedPanel.add(new _MonthPanel("月"), "月份");
				tabbedPanel.add(new _WeekPanel("星期"), "星期");
				tabbedPanel.add(new _YearPanel("年"), "年份");
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
						SwingUtils.getVGridPanel(new JLabel("秒", JLabel.CENTER), new JTextField()), 
						SwingUtils.getVGridPanel(new JLabel("分", JLabel.CENTER), new JTextField()), 
						SwingUtils.getVGridPanel(new JLabel("时", JLabel.CENTER), new JTextField()), 
						SwingUtils.getVGridPanel(new JLabel("日期", JLabel.CENTER), new JTextField()), 
						SwingUtils.getVGridPanel(new JLabel("月份", JLabel.CENTER), new JTextField()), 
						SwingUtils.getVGridPanel(new JLabel("星期", JLabel.CENTER), new JTextField()), 
						SwingUtils.getVGridPanel(new JLabel("年份", JLabel.CENTER), new JTextField())
					)
			), BorderLayout.NORTH);
			
			panel.add(new JLabel(" "), BorderLayout.CENTER);
			
			panel.add(SwingUtils.getWEBorderPanel(
					new JLabel("Cron表达式 ： "), 
					new JTextField(cron.toExpression()), 
					new JButton("复制")
			), BorderLayout.SOUTH);
		}
		SwingUtils.addBorder(panel, "Expression");
		return panel;
	}
	
	private JPanel toSchedulePanel() {
		JPanel panel = new JPanel(new BorderLayout()); {
			panel.add(SwingUtils.getPairsPanel(
					new JLabel("开始时间 ： "), new JTextField()
			), BorderLayout.NORTH);
			
			panel.add(SwingUtils.getPairsPanel(
					SwingUtils.getNBorderPanel(new JLabel(""), new JLabel("执行时间 ： ")), 
					SwingUtils.addAutoScroll(new JTextArea())
			), BorderLayout.CENTER);
		}
		SwingUtils.addBorder(panel, "Schedule");
		return panel;
	}
	
	@Override
	protected void setComponentsListener(JPanel rootPanel) {
		// TODO Auto-generated method stub
		
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

}
