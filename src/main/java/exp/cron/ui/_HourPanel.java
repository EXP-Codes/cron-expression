package exp.cron.ui;

import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

public class _HourPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 5080281179832801689L;

	private final static int HOUR = 24;
	
	protected _HourPanel(String name) {
		super(name, 4);
	}

	@Override
	protected CheckBoxGroup<String> initSequence() {
		String[] hours = new String[HOUR];
		for(int i = 0; i < hours.length; i++) {
			hours[i] = String.valueOf(i);
		}
		return new CheckBoxGroup<String>(hours);
	}

}
