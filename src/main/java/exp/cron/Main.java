package exp.cron;

import exp.cron.ui.CronUI;
import exp.libs.warp.ui.BeautyEyeUtils;

public class Main {

	public static void main(String[] args) {
		BeautyEyeUtils.init();
		new CronUI();
	}
}
