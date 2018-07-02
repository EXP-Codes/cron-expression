package exp.cron.ui;

import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

public class _SecondPanel extends __TimePanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -6898460450676540725L;

	private final static int SECOND = 60;
	
	protected _SecondPanel(String name) {
		super(name, 4);
	}

	@Override
	protected CheckBoxGroup<String> initSequence() {
		String[] seconds = new String[SECOND];
		for(int i = 0; i < seconds.length; i++) {
			seconds[i] = String.valueOf(i);
		}
		return new CheckBoxGroup<String>(seconds);
	}

}
