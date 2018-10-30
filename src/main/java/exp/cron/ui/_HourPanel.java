package exp.cron.ui;

import java.util.List;

import javax.swing.JCheckBox;

import exp.libs.utils.num.NumUtils;
import exp.libs.utils.other.StrUtils;
import exp.libs.warp.task.cron.Cron;
import exp.libs.warp.task.cron._Hour;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

public class _HourPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 5080281179832801689L;

	private final static int HOUR = 24;
	
	protected _HourPanel(Cron cron, String name) {
		super(cron, name, 4);
	}

	@Override
	protected void initTips() {
		tfFrom.setToolTipText(StrUtils.concat(
				"取值范围: [", _Hour.MIN, ",",  _Hour.MAX, "]"));
		tfTo.setToolTipText(StrUtils.concat(
				"取值范围: [", _Hour.MIN, ",",  _Hour.MAX, "]"));
		tfBegin.setToolTipText(StrUtils.concat(
				"取值范围: [", _Hour.MIN, ",",  _Hour.MAX, "]"));
		tfStep.setToolTipText(StrUtils.concat("取值范围: [", STEP, ",+∞)"));
	}
	
	@Override
	protected CheckBoxGroup<String> initSequence() {
		String[] hours = new String[HOUR];
		for(int i = 0; i < hours.length; i++) {
			hours[i] = String.valueOf(i);
		}
		return new CheckBoxGroup<String>(hours);
	}

	@Override
	protected void setEveryBtnListener() {
		cron.Hour().withEvery();
	}

	@Override
	protected void setRangeBtnListener() {
		if(StrUtils.isEmpty(tfFrom.getText())) {
			tfFrom.setText(String.valueOf(_Hour.MIN));
		}
		
		if(StrUtils.isEmpty(tfTo.getText())) {
			tfTo.setText(String.valueOf(_Hour.MAX));
		}
		
		int from = NumUtils.toInt(tfFrom.getText(), _Hour.MIN);
		int to = NumUtils.toInt(tfTo.getText(), _Hour.MAX);
		cron.Hour().withRange(from, to);
	}

	@Override
	protected void setStepBtnListener() {
		if(StrUtils.isEmpty(tfBegin.getText())) {
			tfBegin.setText(String.valueOf(_Hour.MIN));
		}
		
		if(StrUtils.isEmpty(tfStep.getText())) {
			tfStep.setText(String.valueOf(STEP));
		}
		
		int begin = NumUtils.toInt(tfBegin.getText(), _Hour.MIN);
		int interval = NumUtils.toInt(tfStep.getText(), STEP);
		cron.Hour().withStep(begin, interval);
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
		cron.Hour().withSequence(seqs);
	}
	
}
