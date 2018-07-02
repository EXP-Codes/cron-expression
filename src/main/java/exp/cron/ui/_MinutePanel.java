package exp.cron.ui;

import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

public class _MinutePanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -2246097300347014723L;

	private final static int MINUTE = 60;
	
	protected _MinutePanel(String name) {
		super(name, 4);
	}

	@Override
	protected CheckBoxGroup<String> initSequence() {
		String[] minutes = new String[MINUTE];
		for(int i = 0; i < minutes.length; i++) {
			minutes[i] = String.valueOf(i);
		}
		return new CheckBoxGroup<String>(minutes);
	}

}
