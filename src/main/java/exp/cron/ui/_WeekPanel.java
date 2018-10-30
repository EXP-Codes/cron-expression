package exp.cron.ui;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import exp.libs.utils.num.NumUtils;
import exp.libs.utils.other.StrUtils;
import exp.libs.utils.verify.RegexUtils;
import exp.libs.warp.task.cron.Cron;
import exp.libs.warp.task.cron._Week;
import exp.libs.warp.ui.SwingUtils;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

public class _WeekPanel extends __TimePanel {

	// FIXME  L  W C
	
	/** serialVersionUID */
	private static final long serialVersionUID = -1330320169878793721L;

	protected _WeekPanel(Cron cron, String name) {
		super(cron, name, 1);
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
	
	@Override
	protected JPanel getRangePanel() {
		return SwingUtils.getPairsPanel(rangeBtn, 
				SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
						new JLabel(StrUtils.concat(" ：在", name, " ")), tfFrom, 
						new JLabel(StrUtils.concat(" 到", name, " ")), 
						tfTo, new JLabel(" 之间触发     （注：星期1=周日、星期2=周一、...、星期7=周六）")
				)
		);
	}
	
	@Override
	protected JPanel getStepPanel() {
		return SwingUtils.getPairsPanel(stepBtn, 
				SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
						new JLabel(StrUtils.concat(" ：从", name, " ")), tfBegin, 
						new JLabel(StrUtils.concat(" 开始, 每隔 ")), 
						tfStep, new JLabel(" 周触发   （注：星期1=周日、星期2=周一、...、星期7=周六）")
				)
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
	
}
