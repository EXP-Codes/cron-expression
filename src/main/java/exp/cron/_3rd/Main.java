package exp.cron._3rd;

import java.awt.EventQueue;

import exp.libs.utils.other.LogUtils;


/**
 * <PRE>
 * 程序入口
 * </PRE>
 * <B>PROJECT：</B> xxxxxx
 * <B>SUPPORT：</B> xxxxxx
 * @version   xxxxxx
 * @author    xxxxxx
 * @since     jdk版本：jdk1.6
 */
public class Main {
	
	public static void main(String[] args) {
		LogUtils.loadLogBackConfig();
		
		AppUI.initCustomLAF();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainJFrame().setVisible(true);
			}
		});
	}
	
}
