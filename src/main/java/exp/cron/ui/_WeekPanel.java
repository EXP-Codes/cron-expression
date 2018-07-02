package exp.cron.ui;

import exp.libs.utils.other.StrUtils;
import exp.libs.warp.task.cron._Week;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

public class _WeekPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -1330320169878793721L;

	protected _WeekPanel(String name) {
		super(name, 1);
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

}
