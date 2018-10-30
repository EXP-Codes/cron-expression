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

public class _DayPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -9189511336082200258L;
	
	private final static int DAY = 31;
	
	private JRadioButton afterBtn;
	
	private JTextField tfAfter;
	
	private JRadioButton workBtn;
	
	private JTextField tfWork;
	
	private JRadioButton lastBtn;
	
	private JRadioButton lastWorkBtn;
	
	protected _DayPanel(Cron cron, String name) {
		super(cron, name, 4);
	}
	
	@Override
	protected void initComponents() {
		this.tfAfter = new JTextField(5);
		this.afterBtn = new JRadioButton("下一天触发 (C)");
		btnGroup.add(afterBtn);
		setAfterBtnListener();
		
		
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
		tfFrom.setToolTipText(StrUtils.concat(
				"取值范围: [", _Day.MIN, ",",  _Day.MAX, "]"));
		tfTo.setToolTipText(StrUtils.concat(
				"取值范围: [", _Day.MIN, ",",  _Day.MAX, "]"));
		tfBegin.setToolTipText(StrUtils.concat(
				"取值范围: [", _Day.MIN, ",",  _Day.MAX, "]"));
		tfStep.setToolTipText(StrUtils.concat("取值范围: [", STEP, ",+∞)"));
		
		tfWork.setToolTipText(StrUtils.concat(
				"取值范围: [", _Day.MIN, ",",  _Day.MAX, "]"));
		tfAfter.setToolTipText(StrUtils.concat(
				"取值范围: [", _Day.MIN, ",",  _Day.MAX, "]"));
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
	protected JPanel getExtPanel() {
		return SwingUtils.getVFlowPanel(
				
				SwingUtils.getPairsPanel(workBtn, 
					SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
							new JLabel("：离当月 "), tfWork, 
							new JLabel(StrUtils.concat(" ", name, "最近的工作日触发"))
					)
				), 
					
				SwingUtils.getPairsPanel(afterBtn, 
					SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
							new JLabel("：在当月 "), tfAfter, 
							new JLabel(StrUtils.concat(" ", name, "后的第一天触发"))
					)
				)
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
	
	private void setAfterBtnListener() {
		afterBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(StrUtils.isEmpty(tfAfter.getText())) {
					tfAfter.setText(String.valueOf(_Day.MIN));
				}
				
				int day = NumUtils.toInt(tfAfter.getText(), _Day.MIN);
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
