package exp.cron.ui;

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
import exp.libs.warp.task.cron.Cron;
import exp.libs.warp.task.cron._Day;
import exp.libs.warp.ui.SwingUtils;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

/**
 * <PRE>
 * cron表达式-天域界面
 * </PRE>
 * <br/><B>PROJECT : </B> cron-expression
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2017-10-30
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class _DayPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -9189511336082200258L;
	
	/** [天]上限值，用于生成[定点触发(a,b,c...)]模式的候选值列表 */
	private final static int DAY = 31;
	
	/** 触发模式按钮：[前导值触发(C)] */
	private JRadioButton leadBtn;
	
	/** 输入框：前导值 */
	private JTextField tfLead;
	
	/** 触发模式按钮：[工作日触发(W)] */
	private JRadioButton workBtn;
	
	/** 输入框：工作日 */
	private JTextField tfWork;
	
	/** 触发模式按钮：[月末触发(L)] */
	private JRadioButton lastBtn;
	
	/** 触发模式按钮：[月末工作日触发(L)] */
	private JRadioButton lastWorkBtn;
	
	/**
	 * 构造函数
	 * @param cron cron表达式对象
	 * @param name 子界面名称
	 */
	protected _DayPanel(Cron cron, String name) {
		super(cron, name, 4);
	}
	
	@Override
	protected void initComponents() {
		this.tfLead = new JTextField(5);
		this.leadBtn = new JRadioButton("前导值触发 (C)");
		btnGroup.add(leadBtn);
		setLeadBtnListener();
		
		
		this.tfWork = new JTextField(5);
		this.workBtn = new JRadioButton("工作日触发 (W)");
		btnGroup.add(workBtn);
		setWorkBtnListener();
		
		
		this.lastBtn = new JRadioButton("仅月末最后一天触发 (L)");
		btnGroup.add(lastBtn);
		setLastBtnListener();
		
		
		this.lastWorkBtn = new JRadioButton("仅当月最后一个工作日触发 (LW)");
		btnGroup.add(lastWorkBtn);
		setLastWorkBtnListener();
	}
	
	@Override
	protected void initTips() {
		setRangeTooltips(tfFrom, _Day.MIN, _Day.MAX);
		setRangeTooltips(tfTo, _Day.MIN, _Day.MAX);
		setRangeTooltips(tfBegin, _Day.MIN, _Day.MAX);
		setRangeTooltips(tfStep, STEP, -1);
		setRangeTooltips(tfWork, _Day.MIN, _Day.MAX);
		setRangeTooltips(tfLead, _Day.MIN, _Day.MAX);
	}

	@Override
	protected CheckBoxGroup<String> initSequence() {
		String[] days = new String[DAY];
		for(int i = 0; i < days.length; i++) {
			days[i] = String.valueOf(i + 1);
		}
		return new CheckBoxGroup<String>(days);
	}

	@Override
	protected JPanel getEveryPanel() {
		return SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
				everyBtn, lastBtn, lastWorkBtn);
	}
	
	@Override
	protected JPanel getRangePanel() {
		return SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
				super.getRangePanel(), new JLabel()		// 多一层面板的目的只是对齐组件
		);
	}
	
	@Override
	protected JPanel getStepPanel() {
		return SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
				super.getStepPanel(), new JLabel()		// 多一层面板的目的只是对齐组件
		);
	}
	
	@Override
	protected JPanel getExtPanel() {
		return SwingUtils.getVFlowPanel(
				
				SwingUtils.getPairsPanel(workBtn, 
					SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
							new JLabel("：离当月 "), tfWork, 
							new JLabel(StrUtils.concat(" ", name, "最近的工作日触发"))
					)
				), 
					
				SwingUtils.getPairsPanel(leadBtn, 
					SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
							new JLabel("：在当月 "), tfLead, 
							new JLabel(StrUtils.concat(" ", name, "后的第一天触发"))
					)
				)
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
		cron.Day().withEvery();
	}

	@Override
	protected void setRangeBtnListener() {
		if(StrUtils.isEmpty(tfFrom.getText())) {
			tfFrom.setText(String.valueOf(_Day.MIN));
		}
		
		if(StrUtils.isEmpty(tfTo.getText())) {
			tfTo.setText(String.valueOf(_Day.MAX));
		}
		
		int from = NumUtils.toInt(tfFrom.getText(), _Day.MIN);
		int to = NumUtils.toInt(tfTo.getText(), _Day.MAX);
		cron.Day().withRange(from, to);
	}

	@Override
	protected void setStepBtnListener() {
		if(StrUtils.isEmpty(tfBegin.getText())) {
			tfBegin.setText(String.valueOf(_Day.MIN));
		}
		
		if(StrUtils.isEmpty(tfStep.getText())) {
			tfStep.setText(String.valueOf(STEP));
		}
		
		int begin = NumUtils.toInt(tfBegin.getText(), _Day.MIN);
		int interval = NumUtils.toInt(tfStep.getText(), STEP);
		cron.Day().withStep(begin, interval);
	}

	@Override
	protected void setSeqBtnListener(List<JCheckBox> selecteds) {
		int[] seqs = new int[selecteds.size()];
		for(int i = 0; i < seqs.length; i++) {
			JCheckBox selected = selecteds.get(i);
			int val = NumUtils.toInt(selected.getText(), -1);
			if(val >= 0) {
				seqs[i] = val;
			}
		}
		cron.Day().withSequence(seqs);
	}
	
	private void setLeadBtnListener() {
		leadBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(StrUtils.isEmpty(tfLead.getText())) {
					tfLead.setText(String.valueOf(_Day.MIN));
				}
				
				int day = NumUtils.toInt(tfLead.getText(), _Day.MIN);
				cron.Day().withAfterDay(day);
				CronUI.getInstn().updateCron();
			}
		});
	}
	
	private void setWorkBtnListener() {
		workBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(StrUtils.isEmpty(tfWork.getText())) {
					tfWork.setText(String.valueOf(_Day.MIN));
				}
				
				int day = NumUtils.toInt(tfWork.getText(), _Day.MIN);
				cron.Day().withWorkday(day);
				CronUI.getInstn().updateCron();
			}
		});
	}
	
	private void setLastBtnListener() {
		lastBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cron.Day().withLastDay();
				CronUI.getInstn().updateCron();
			}
		});
	}
	
	private void setLastWorkBtnListener() {
		lastWorkBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cron.Day().withLastWorkday();
				CronUI.getInstn().updateCron();
			}
		});
	}
	
}
