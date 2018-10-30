package exp.cron.ui;

import java.util.List;

import javax.swing.JCheckBox;

import exp.libs.utils.num.NumUtils;
import exp.libs.utils.other.StrUtils;
import exp.libs.warp.task.cron.Cron;
import exp.libs.warp.task.cron._Day;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

public class _DayPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -9189511336082200258L;
	
	private final static int DAY = 31;
	
	protected _DayPanel(Cron cron, String name) {
		super(cron, name, 4);
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
	
}
