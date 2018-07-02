package exp.cron.ui;

import exp.libs.utils.other.StrUtils;
import exp.libs.warp.task.cron._Month;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

public class _MonthPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -7775377611552787648L;
	
	protected _MonthPanel(String name) {
		super(name, 2);
	}

	@Override
	protected CheckBoxGroup<String> initSequence() {
		String[] months = new String[] {
			StrUtils.concat(_Month.JAN, " (", 1, ")"), 
			StrUtils.concat(_Month.FEB, " (", 2, ")"), 
			StrUtils.concat(_Month.MAR, " (", 3, ")"), 
			StrUtils.concat(_Month.APR, " (", 4, ")"), 
			StrUtils.concat(_Month.MAY, " (", 5, ")"), 
			StrUtils.concat(_Month.JUN, " (", 6, ")"), 
			StrUtils.concat(_Month.JUL, " (", 7, ")"), 
			StrUtils.concat(_Month.AUG, " (", 8, ")"), 
			StrUtils.concat(_Month.SEP, " (", 9, ")"), 
			StrUtils.concat(_Month.OCT, " (", 10, ")"), 
			StrUtils.concat(_Month.NOV, " (", 11, ")"), 
			StrUtils.concat(_Month.DEC, " (", 12, ")")
		};
		return new CheckBoxGroup<String>(months);
	}

}
