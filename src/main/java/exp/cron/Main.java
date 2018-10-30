package exp.cron;

import exp.cron.ui.CronUI;
import exp.libs.warp.ui.BeautyEyeUtils;

/**
 * <PRE>
 * 程序入口
 * </PRE>
 * <br/><B>PROJECT : </B> cron-expression
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2017-10-30
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class Main {

	public static void main(String[] args) {
		BeautyEyeUtils.init();
		CronUI.getInstn();
	}
}
