package exp.cron.ui;

import java.util.List;

import javax.swing.JCheckBox;

import exp.libs.utils.num.NumUtils;
import exp.libs.utils.other.StrUtils;
import exp.libs.warp.task.cron.Cron;
import exp.libs.warp.task.cron._Second;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

/**
 * <PRE>
 * cron表达式-秒域界面
 * </PRE>
 * <br/><B>PROJECT : </B> cron-expression
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2017-10-30
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class _SecondPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -6898460450676540725L;

	/** [秒]上限值，用于生成[定点触发(a,b,c...)]模式的候选值列表 */
	private final static int SECOND = 60;
	
	/**
	 * 构造函数
	 * @param cron cron表达式对象
	 * @param name 子界面名称
	 */
	protected _SecondPanel(Cron cron, String name) {
		super(cron, name, 6);
	}

	@Override
	protected void initTips() {
		setRangeTooltips(tfFrom, _Second.MIN, _Second.MAX);
		setRangeTooltips(tfTo, _Second.MIN, _Second.MAX);
		setRangeTooltips(tfBegin, _Second.MIN, _Second.MAX);
		setRangeTooltips(tfStep, STEP, -1);
	}
	
	@Override
	protected CheckBoxGroup<String> initSequence() {
		String[] seconds = new String[SECOND];
		for(int i = 0; i < seconds.length; i++) {
			seconds[i] = String.valueOf(i);
		}
		return new CheckBoxGroup<String>(seconds);
	}

	@Override
	protected void setEveryBtnListener() {
		cron.Second().withEvery();
	}

	@Override
	protected void setRangeBtnListener() {
		if(StrUtils.isEmpty(tfFrom.getText())) {
			tfFrom.setText(String.valueOf(_Second.MIN));
		}
		
		if(StrUtils.isEmpty(tfTo.getText())) {
			tfTo.setText(String.valueOf(_Second.MAX));
		}
		
		int from = NumUtils.toInt(tfFrom.getText(), _Second.MIN);
		int to = NumUtils.toInt(tfTo.getText(), _Second.MAX);
		cron.Second().withRange(from, to);
	}

	@Override
	protected void setStepBtnListener() {
		if(StrUtils.isEmpty(tfBegin.getText())) {
			tfBegin.setText(String.valueOf(_Second.MIN));
		}
		
		if(StrUtils.isEmpty(tfStep.getText())) {
			tfStep.setText(String.valueOf(STEP));
		}
		
		int begin = NumUtils.toInt(tfBegin.getText(), _Second.MIN);
		int interval = NumUtils.toInt(tfStep.getText(), STEP);
		cron.Second().withStep(begin, interval);
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
		cron.Second().withSequence(seqs);
	}

}
