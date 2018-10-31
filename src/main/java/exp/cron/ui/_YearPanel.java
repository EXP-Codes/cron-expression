package exp.cron.ui;

import java.util.List;

import javax.swing.JCheckBox;

import exp.libs.utils.num.NumUtils;
import exp.libs.utils.other.StrUtils;
import exp.libs.utils.time.TimeUtils;
import exp.libs.warp.task.cron.Cron;
import exp.libs.warp.task.cron._Year;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

/**
 * <PRE>
 * cron表达式-年域界面
 * </PRE>
 * <br/><B>PROJECT : </B> cron-expression
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2017-10-30
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class _YearPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 6055405583848024179L;

	/**
	 * [年]上限值，用于生成[定点触发(a,b,c...)]模式的候选值列表.
	 * ----------------------------------------------
	 * 受限界面显示范围，最多显示从近年开始往后的76年（理论cron最大的年份是2099年）
	 */
	private final static int YEAR = 76;
	
	/**
	 * 构造函数
	 * @param cron cron表达式对象
	 * @param name 子界面名称
	 */
	protected _YearPanel(Cron cron, String name) {
		super(cron, name, 7);
	}
	
	@Override
	protected void initTips() {
		setRangeTooltips(tfFrom, _Year.MIN, _Year.MAX);
		setRangeTooltips(tfTo, _Year.MIN, _Year.MAX);
		setRangeTooltips(tfBegin, _Year.MIN, _Year.MAX);
		setRangeTooltips(tfStep, STEP, -1);
	}

	@Override
	protected CheckBoxGroup<String> initSequence() {
		int curYear = TimeUtils.getCurYear();
		String[] years = new String[YEAR + 1];
		for(int i = 0; i < years.length; i++) {
			years[i] = String.valueOf(i + curYear);
		}
		years[YEAR] = "...";
		return new CheckBoxGroup<String>(years);
	}

	@Override
	protected void setEveryBtnListener() {
		cron.Year().withEvery();
	}

	@Override
	protected void setRangeBtnListener() {
		if(StrUtils.isEmpty(tfFrom.getText())) {
			tfFrom.setText(String.valueOf(_Year.MIN));
		}
		
		if(StrUtils.isEmpty(tfTo.getText())) {
			tfTo.setText(String.valueOf(_Year.MAX));
		}
		
		int from = NumUtils.toInt(tfFrom.getText(), _Year.MIN);
		int to = NumUtils.toInt(tfTo.getText(), _Year.MAX);
		cron.Year().withRange(from, to);
	}

	@Override
	protected void setStepBtnListener() {
		if(StrUtils.isEmpty(tfBegin.getText())) {
			tfBegin.setText(String.valueOf(_Year.MIN));
		}
		
		if(StrUtils.isEmpty(tfStep.getText())) {
			tfStep.setText(String.valueOf(STEP));
		}
		
		int begin = NumUtils.toInt(tfBegin.getText(), _Year.MIN);
		int interval = NumUtils.toInt(tfStep.getText(), STEP);
		cron.Year().withStep(begin, interval);
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
		cron.Year().withSequence(seqs);
	}
	
}
