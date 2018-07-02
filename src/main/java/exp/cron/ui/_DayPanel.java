package exp.cron.ui;

import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

public class _DayPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -9189511336082200258L;
	
	private final static int DAY = 31;
	
	protected _DayPanel(String name) {
		super(name, 4);
	}

	@Override
	protected CheckBoxGroup<String> initSequence() {
		String[] days = new String[DAY];
		for(int i = 0; i < days.length; i++) {
			days[i] = String.valueOf(i + 1);
		}
		return new CheckBoxGroup<String>(days);
	}

}
