package exp.cron.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import exp.libs.utils.num.NumUtils;
import exp.libs.utils.other.StrUtils;
import exp.libs.utils.verify.RegexUtils;
import exp.libs.warp.task.cron.Cron;
import exp.libs.warp.task.cron._Week;
import exp.libs.warp.ui.SwingUtils;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

/**
 * <PRE>
 * cron表达式-周域界面
 * </PRE>
 * <br/><B>PROJECT : </B> cron-expression
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2017-10-30
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class _WeekPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -1330320169878793721L;

	/** 触发模式按钮：[索引触发(x#y)] */
	private JRadioButton orderBtn;
	
	/** 输入框：星期值 */
	private JTextField tfWeek;
	
	/** 输入框：索引值 */
	private JTextField tfIndex;
	
	/** 触发模式按钮：[前导值触发(C)] */
	private JRadioButton leadBtn;
	
	/** 输入框：前导值 */
	private JTextField tfLead;
	
	/** 触发模式按钮：[周末触发(L)]  （周末即周六） */
	private JRadioButton lastBtn;
	
	/**
	 * 构造函数
	 * @param cron cron表达式对象
	 * @param name 子界面名称
	 */
	protected _WeekPanel(Cron cron, String name) {
		super(cron, name, 1);
	}

	@Override
	protected void initComponents() {
		this.tfLead = new JTextField(5);
		this.leadBtn = new JRadioButton("前导值触发 (C)");
		btnGroup.add(leadBtn);
		setLeadBtnListener();
		
		
		this.tfWeek = new JTextField(5);
		this.tfIndex = new JTextField(5);
		this.orderBtn = new JRadioButton("索引触发 (x#y)");
		btnGroup.add(orderBtn);
		setOrderBtnListener();
		
		
		this.lastBtn = new JRadioButton("仅周六触发 (L)");
		btnGroup.add(lastBtn);
		setLastBtnListener();
	}
	
	@Override
	protected void initTips() {
		setRangeTooltips(tfFrom, _Week.MIN, _Week.MAX);
		setRangeTooltips(tfTo, _Week.MIN, _Week.MAX);
		setRangeTooltips(tfBegin, _Week.MIN, _Week.MAX);
		setRangeTooltips(tfStep, STEP, -1);
		setRangeTooltips(tfWeek, _Week.MIN, _Week.MAX);
		setRangeTooltips(tfIndex, STEP, -1);
		setRangeTooltips(tfLead, _Week.MIN, _Week.MAX);
	}
	
	@Override
	protected CheckBoxGroup<String> initSequence() {
		String[] months = new String[] {
				StrUtils.concat(_Week.SUN, " (", 1, ")"), 
				StrUtils.concat(_Week.MON, " (", 2, ")"), 
				StrUtils.concat(_Week.TUE, " (", 3, ")"), 
				StrUtils.concat(_Week.WED, " (", 4, ")"), 
				StrUtils.concat(_Week.THU, " (", 5, ")"), 
				StrUtils.concat(_Week.FRI, " (", 6, ")"), 
				StrUtils.concat(_Week.SAT, " (", 7, ")")
			};
			return new CheckBoxGroup<String>(months);
	}
	
	protected JPanel getEveryPanel() {
		JLabel tips = new JLabel("（注：星期1=周日、星期2=周一、星期3=周二、星期4=周三、星期5=周四、星期6=周五、星期7=周六）");
		tips.setForeground(Color.RED);
		return SwingUtils.getHFlowPanel(FlowLayout.LEFT, everyBtn, tips);
	}
	
	@Override
	protected JPanel getRangePanel() {
		return SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
				SwingUtils.getPairsPanel(rangeBtn, 
					SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
							new JLabel(StrUtils.concat(" ：在", name, " ")), tfFrom, 
							new JLabel(StrUtils.concat(" 到", name, " ")), 
							tfTo, new JLabel(" 之间触发")
					)
				), new JLabel()		// 多一层面板的目的只是对齐组件
		);
	}
	
	@Override
	protected JPanel getStepPanel() {
		return SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
				SwingUtils.getPairsPanel(stepBtn, 
					SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
							new JLabel(StrUtils.concat(" ：从", name, " ")), tfBegin, 
							new JLabel(StrUtils.concat(" 开始, 每隔 ")), 
							tfStep, new JLabel(" 周触发")
					)
				), new JLabel()		// 多一层面板的目的只是对齐组件
		);
	}

	@Override
	protected JPanel getExtPanel() {
		return SwingUtils.getVFlowPanel(
				SwingUtils.getPairsPanel(orderBtn, 
						SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
								new JLabel(StrUtils.concat("：在当月的第 ")), tfIndex, 
								new JLabel(StrUtils.concat(" 个", name, " ")), tfWeek, 
								new JLabel(" 触发")
						)
				), 
				
				SwingUtils.getPairsPanel(leadBtn, 
						SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
								new JLabel(StrUtils.concat("：在", name, " ")), tfLead, 
								new JLabel(" 后的第一天触发")
						)
				), 
				
				SwingUtils.addPanel(lastBtn)
		);
	}
	
	@Override
	protected JPanel getSequencePanel() {
		return SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
				super.getSequencePanel(), new JLabel()		// 多一层面板的目的只是对齐组件
		);
	}
	
	@Override
	protected void setEveryBtnListener() {
		cron.Week().withEvery();
	}
	
	@Override
	protected void setRangeBtnListener() {
		if(StrUtils.isEmpty(tfFrom.getText())) {
			tfFrom.setText(String.valueOf(_Week.MIN));
		}
		
		if(StrUtils.isEmpty(tfTo.getText())) {
			tfTo.setText(String.valueOf(_Week.MAX));
		}
		
		int from = NumUtils.toInt(tfFrom.getText(), _Week.MIN);
		int to = NumUtils.toInt(tfTo.getText(), _Week.MAX);
		cron.Week().withRange(from, to);
	}

	@Override
	protected void setStepBtnListener() {
		if(StrUtils.isEmpty(tfBegin.getText())) {
			tfBegin.setText(String.valueOf(_Week.MIN));
		}
		
		if(StrUtils.isEmpty(tfStep.getText())) {
			tfStep.setText(String.valueOf(STEP));
		}
		
		int begin = NumUtils.toInt(tfBegin.getText(), _Week.MIN);
		int interval = NumUtils.toInt(tfStep.getText(), STEP);
		cron.Week().withStep(begin, interval);
	}

	@Override
	protected void setSeqBtnListener(List<JCheckBox> selecteds) {
		int[] seqs = new int[selecteds.size()];
		for(int i = 0; i < seqs.length; i++) {
			JCheckBox selected = selecteds.get(i);
			int val = NumUtils.toInt(
					RegexUtils.findFirst(selected.getText(), "(\\d)"), -1);
			if(val >= 0) {
				seqs[i] = val;
			}
		}
		cron.Week().withSequence(seqs);
	}
	
	private void setLeadBtnListener() {
		leadBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(StrUtils.isEmpty(tfLead.getText())) {
					tfLead.setText(String.valueOf(_Week.MIN));
				}
				
				int week = NumUtils.toInt(tfLead.getText(), _Week.MIN);
				cron.Week().withAfterWeek(week);
				CronUI.getInstn().updateCron();
			}
		});
	}
	
	private void setOrderBtnListener() {
		orderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(StrUtils.isEmpty(tfWeek.getText())) {
					tfWeek.setText(String.valueOf(_Week.MIN));
				}
				
				if(StrUtils.isEmpty(tfIndex.getText())) {
					tfIndex.setText(String.valueOf(STEP));
				}
				
				int week = NumUtils.toInt(tfWeek.getText(), _Week.MIN);
				int index = NumUtils.toInt(tfIndex.getText(), STEP);
				cron.Week().withOrder(week, index);
				CronUI.getInstn().updateCron();
			}
		});
	}
	
	private void setLastBtnListener() {
		lastBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cron.Week().withLastDay();
				CronUI.getInstn().updateCron();
			}
		});
	}
	
}
