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
import exp.libs.utils.verify.RegexUtils;
import exp.libs.warp.task.cron.Cron;
import exp.libs.warp.task.cron._Week;
import exp.libs.warp.ui.SwingUtils;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

public class _WeekPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -1330320169878793721L;

	private JRadioButton orderBtn;
	
	private JTextField tfWeek;
	
	private JTextField tfIndex;
	
	private JRadioButton afterBtn;
	
	private JTextField tfAfter;
	
	private JRadioButton lastBtn;
	
	protected _WeekPanel(Cron cron, String name) {
		super(cron, name, 1);
	}

	@Override
	protected void initComponents() {
		this.tfWeek = new JTextField(5);
		this.tfIndex = new JTextField(5);
		this.orderBtn = new JRadioButton("索引触发 (x#y)");
		btnGroup.add(orderBtn);
		setOrderBtnListener();
		
		
		this.tfAfter = new JTextField(5);
		this.afterBtn = new JRadioButton("下一天触发 (C)");
		btnGroup.add(afterBtn);
		setAfterBtnListener();
		
		
		this.lastBtn = new JRadioButton("仅周六触发 (L)");
		btnGroup.add(lastBtn);
		setLastBtnListener();
	}
	
	@Override
	protected void initTips() {
		tfFrom.setToolTipText(StrUtils.concat(
				"取值范围: [", _Week.MIN, ",",  _Week.MAX, "]"));
		tfTo.setToolTipText(StrUtils.concat(
				"取值范围: [", _Week.MIN, ",",  _Week.MAX, "]"));
		tfBegin.setToolTipText(StrUtils.concat(
				"取值范围: [", _Week.MIN, ",",  _Week.MAX, "]"));
		tfStep.setToolTipText(StrUtils.concat("取值范围: [", STEP, ",+∞)"));
		
		
		tfWeek.setToolTipText(StrUtils.concat(
				"取值范围: [", _Week.MIN, ",",  _Week.MAX, "]"));
		tfIndex.setToolTipText(StrUtils.concat("取值范围: [", STEP, ",+∞)"));
		tfAfter.setToolTipText(StrUtils.concat(
				"取值范围: [", _Week.MIN, ",",  _Week.MAX, "]"));
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
		return SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
				everyBtn, 
				new JLabel("（注：星期1=周日、星期2=周一、星期3=周二、星期4=周三、星期5=周四、星期6=周五、星期7=周六）"));
	}
	
	@Override
	protected JPanel getRangePanel() {
		return SwingUtils.getPairsPanel(rangeBtn, 
				SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
						new JLabel(StrUtils.concat(" ：在", name, " ")), tfFrom, 
						new JLabel(StrUtils.concat(" 到", name, " ")), 
						tfTo, new JLabel(" 之间触发")
				)
		);
	}
	
	@Override
	protected JPanel getStepPanel() {
		return SwingUtils.getPairsPanel(stepBtn, 
				SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
						new JLabel(StrUtils.concat(" ：从", name, " ")), tfBegin, 
						new JLabel(StrUtils.concat(" 开始, 每隔 ")), 
						tfStep, new JLabel(" 周触发")
				)
		);
	}

	@Override
	protected JPanel getExtPanel() {
		return SwingUtils.getVFlowPanel(
				SwingUtils.getPairsPanel(afterBtn, 
						SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
								new JLabel(StrUtils.concat("：在", name, " ")), tfAfter, 
								new JLabel(" 后的第一天触发")
						)
				), 
				
				SwingUtils.getPairsPanel(orderBtn, 
						SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
								new JLabel(StrUtils.concat("：在当月的第 ")), tfIndex, 
								new JLabel(StrUtils.concat(" 个", name, " ")), tfWeek, 
								new JLabel(" 触发")
						)
				), 
				
				SwingUtils.addPanel(lastBtn)
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
	
	private void setAfterBtnListener() {
		afterBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(StrUtils.isEmpty(tfAfter.getText())) {
					tfAfter.setText(String.valueOf(_Week.MIN));
				}
				
				int week = NumUtils.toInt(tfAfter.getText(), _Week.MIN);
				cron.Week().withAfterWeek(week);
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
