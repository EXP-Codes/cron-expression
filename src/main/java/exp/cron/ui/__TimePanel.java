package exp.cron.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import exp.libs.utils.other.StrUtils;
import exp.libs.warp.task.cron.Cron;
import exp.libs.warp.ui.SwingUtils;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

/**
 * <PRE>
 * cron表达式-时间域基础界面
 * </PRE>
 * <br/><B>PROJECT : </B> cron-expression
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2017-10-30
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
abstract class __TimePanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 1950899137550339477L;
	
	/** 默认步长值（用于周期触发模式） */
	protected final static int STEP = 1;
	
	/** cron表达式对象 */
	protected Cron cron;
	
	/** 子界面名称 */
	protected String name;
	
	/** 单选按钮组（用于切换当前cron时间域使用的触发模式） */
	protected ButtonGroup btnGroup;
	
	/** 触发模式按钮：[每触发(*)] */
	protected JRadioButton everyBtn;
	
	/** 触发模式按钮：[范围触发(x-y)] */
	protected JRadioButton rangeBtn;
	
	/** 输入框：范围触发起点 */
	protected JTextField tfFrom;
	
	/** 输入框：范围触发终点 */
	protected JTextField tfTo;
	
	/** 触发模式按钮：[周期触发(x/y)] */
	protected JRadioButton stepBtn;
	
	/** 输入框：周期触发起点 */
	protected JTextField tfBegin;
	
	/** 输入框：周期触发步长 */
	protected JTextField tfStep;
	
	/** 触发模式按钮：[定点触发(a,b,c,...)] */
	protected JRadioButton seqBtn;
	
	/** 复选框：定点触发列表 */
	private CheckBoxGroup<String> seqCBG;
	
	/**
	 * 构造函数
	 * @param cron cron表达式对象
	 * @param name 子界面名称
	 * @param seqRow 定点触发模式的列表行数
	 */
	protected __TimePanel(Cron cron, String name, int seqRow) {
		super(new BorderLayout());
		
		this.cron = cron;
		this.name = name;
		this.add(init(name, seqRow), BorderLayout.CENTER);
		setListener();
	}
	
	/**
	 * 初始化子面板
	 * @param name 子界面名称
	 * @param seqRow 定点触发模式的列表行数
	 * @return
	 */
	private JPanel init(String name, int seqRow) {
		this.tfFrom = new JTextField(5);
		this.tfTo = new JTextField(5);
		this.tfBegin = new JTextField(5);
		this.tfStep = new JTextField(5);
		
		this.everyBtn = new JRadioButton(StrUtils.concat("每", name, "触发 (*)"));
		this.rangeBtn = new JRadioButton("范围触发 (x-y)");
		this.stepBtn = new JRadioButton("周期触发 (x/y)");
		this.seqBtn = new JRadioButton("定点触发 (a,b,c,...)");
		this.btnGroup = new ButtonGroup();
		btnGroup.add(everyBtn);
		btnGroup.add(rangeBtn);
		btnGroup.add(stepBtn);
		btnGroup.add(seqBtn);
		
		initComponents();
		initTips();
		
		this.seqCBG = initSequence();
		return SwingUtils.getVFlowPanel(
				getEveryPanel(),  
				getRangePanel(), 
				getStepPanel(), 
				getExtPanel(),	// 扩展面板
				
				getSequencePanel(),
				SwingUtils.addBorder(
						seqCBG.toGridPanel(seqRow), 
						StrUtils.concat("[", name, "] 列表"))
		);
	}
	
	/**
	 * 初始化组件（供子类使用）
	 */
	protected void initComponents() {
		// Undo
	}
	
	/**
	 * 初始化输入框的提示（供子类使用）
	 */
	protected abstract void initTips();
	
	/**
	 * 设置输入框提示的取值范围
	 * @param inputField 输入框
	 * @param min 取值范围起点
	 * @param max 取值范围终点
	 */
	protected void setRangeTooltips(JTextField inputField, int min, int max) {
		if(min >= 0 && max >= 0) {
			inputField.setToolTipText(
					StrUtils.concat("取值范围: [", min, ",",  max, "]"));
			
		} else if(min >= 0) {
			inputField.setToolTipText(
					StrUtils.concat("取值范围: [", STEP, ",+∞)"));
		}
	}
	
	/**
	 * 生成 [每触发(*)] 模式按钮的面板
	 * @return 面板对象
	 */
	protected JPanel getEveryPanel() {
		return SwingUtils.addPanel(everyBtn);
	}
	
	/**
	 * 生成 [范围触发(x-y)] 模式按钮的面板
	 * @return 面板对象
	 */
	protected JPanel getRangePanel() {
		return SwingUtils.getPairsPanel(rangeBtn, 
				SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
						new JLabel(" ：在第 "), tfFrom, 
						new JLabel(StrUtils.concat(" ", name, "到 ")), 
						tfTo, new JLabel(StrUtils.concat(" ", name, "之间触发"))
				)
		);
	}
	
	/**
	 * 生成 [周期触发(x/y)] 模式按钮的面板
	 * @return 面板对象
	 */
	protected JPanel getStepPanel() {
		return SwingUtils.getPairsPanel(stepBtn, 
				SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
						new JLabel(" ：从第 "), tfBegin, 
						new JLabel(StrUtils.concat(" ", name, "开始, 每隔 ")), 
						tfStep, new JLabel(StrUtils.concat(" ", name, "触发"))
				)
		);
	}
	
	/**
	 * 扩展面板（供子类使用）
	 *  某些时间域存在多种特殊的触发模式，此面板用于扩展
	 * @return 面板对象
	 */
	protected JPanel getExtPanel() {
		return new JPanel();
	}
	
	/**
	 * 生成 [定点触发(a,b,c...)] 模式按钮的面板
	 * @return 面板对象
	 */
	protected JPanel getSequencePanel() {
		return SwingUtils.getPairsPanel(seqBtn, 
				new JLabel(StrUtils.concat(" , 在以下指定的若干", name, "触发 ： ")));
	}
	
	/**
	 * 仅[定点触发(a,b,c...)] 模式使用：根据不同的时间域生成对应的复选框列表
	 * @return 复选框对象
	 */
	protected abstract CheckBoxGroup<String> initSequence();
	
	/**
	 * 设置组件监听器
	 */
	private void setListener() {
		everyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setEveryBtnListener();
				CronUI.getInstn().updateCron();
			}
		});
		
		rangeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setRangeBtnListener();
				CronUI.getInstn().updateCron();
			}
		});

		stepBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setStepBtnListener();
				CronUI.getInstn().updateCron();
			}
		});

		seqBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<JCheckBox> selecteds = seqCBG.getCheckBoxs(true);	// 获取被选中的值列表
				if(selecteds.isEmpty()) {	// 未选中任何值时，默认选中第一个
					seqCBG.select(0);
				}
				selecteds = seqCBG.getCheckBoxs(true);
				
				setSeqBtnListener(selecteds);
				CronUI.getInstn().updateCron();
			}
		});
		
		setFieldListener(tfFrom);
		setFieldListener(tfTo);
		setFieldListener(tfBegin);
		setFieldListener(tfStep);
	}
	
	/**
	 * 生成 [每触发(*)] 模式按钮的监听器
	 */
	protected abstract void setEveryBtnListener();
	
	/**
	 * 生成 [范围触发(x-y)] 模式按钮的监听器
	 */
	protected abstract void setRangeBtnListener();
	
	/**
	 * 生成 [周期触发(x/y)] 模式按钮的监听器
	 */
	protected abstract void setStepBtnListener();
	
	/**
	 * 生成 [定点触发(a,b,c...)] 模式按钮的监听器
	 * @param selecteds 被选中的值列表
	 */
	protected abstract void setSeqBtnListener(List<JCheckBox> selecteds);
	
	/**
	 * 设置输入框监听器
	 * @param inputField
	 */
	private void setFieldListener(final JTextField inputField) {
		inputField.addKeyListener(new KeyListener() {

		    @Override
		    public void keyTyped(KeyEvent e) {
		        char ch = e.getKeyChar();   // 准备附加到输入框的字符
		        
		        // 限制不能输入非数字
		        if(!(ch >= '0' && ch <= '9')) {
		            e.consume();    // 销毁当前输入字符
		        }
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        // Undo
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		    	// Undo
		    }
		});
	}

}
