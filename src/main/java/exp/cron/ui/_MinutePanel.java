package exp.cron.ui;

import java.util.List;

import javax.swing.JCheckBox;

import exp.libs.utils.num.NumUtils;
import exp.libs.utils.other.StrUtils;
import exp.libs.warp.task.cron.Cron;
import exp.libs.warp.task.cron._Minute;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

/**
 * <PRE>
 * cron表达式-分域界面
 * </PRE>
 * <br/><B>PROJECT : </B> cron-expression
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2017-10-30
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class _MinutePanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -2246097300347014723L;

	/** [分]上限值，用于生成[定点触发(a,b,c...)]模式的候选值列表 */
	private final static int MINUTE = 60;
	
	/**
	 * 构造函数
	 * @param cron cron表达式对象
	 * @param name 子界面名称
	 */
	protected _MinutePanel(Cron cron, String name) {
		super(cron, name, 6);
	}
	
	@Override
	protected void initTips() {
		setRangeTooltips(tfFrom, _Minute.MIN, _Minute.MAX);
		setRangeTooltips(tfTo, _Minute.MIN, _Minute.MAX);
		setRangeTooltips(tfBegin, _Minute.MIN, _Minute.MAX);
		setRangeTooltips(tfStep, STEP, -1);
	}

	@Override
	protected CheckBoxGroup<String> initSequence() {
		String[] minutes = new String[MINUTE];
		for(int i = 0; i < minutes.length; i++) {
			minutes[i] = String.valueOf(i);
		}
		return new CheckBoxGroup<String>(minutes);
	}

	@Override
	protected void setEveryBtnListener() {
		cron.Minute().withEvery();
	}

	@Override
	protected void setRangeBtnListener() {
		if(StrUtils.isEmpty(tfFrom.getText())) {
			tfFrom.setText(String.valueOf(_Minute.MIN));
		}
		
		if(StrUtils.isEmpty(tfTo.getText())) {
			tfTo.setText(String.valueOf(_Minute.MAX));
		}
		
		int from = NumUtils.toInt(tfFrom.getText(), _Minute.MIN);
		int to = NumUtils.toInt(tfTo.getText(), _Minute.MAX);
		cron.Minute().withRange(from, to);
	}

	@Override
	protected void setStepBtnListener() {
		if(StrUtils.isEmpty(tfBegin.getText())) {
			tfBegin.setText(String.valueOf(_Minute.MIN));
		}
		
		if(StrUtils.isEmpty(tfStep.getText())) {
			tfStep.setText(String.valueOf(STEP));
		}
		
		int begin = NumUtils.toInt(tfBegin.getText(), _Minute.MIN);
		int interval = NumUtils.toInt(tfStep.getText(), STEP);
		cron.Minute().withStep(begin, interval);
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
		cron.Minute().withSequence(seqs);
	}
	
}
