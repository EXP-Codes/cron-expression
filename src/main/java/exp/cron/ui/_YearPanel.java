package exp.cron.ui;

import exp.libs.utils.time.TimeUtils;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

public class _YearPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 6055405583848024179L;

	private final static int YEAR = 40;	// 最多显示往后40年（理论cron最大的年份是2099年）
	
	protected _YearPanel(String name) {
		super(name, 4);
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

}
