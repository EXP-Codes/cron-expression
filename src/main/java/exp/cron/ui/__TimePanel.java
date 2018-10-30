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

abstract class __TimePanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 1950899137550339477L;
	
	/** 默认步长 */
	protected final static int STEP = 1;
	
	protected Cron cron;
	
	protected String name;
	
	protected JRadioButton everyBtn;
	
	protected JRadioButton rangeBtn;
	
	protected JTextField tfFrom;
	
	protected JTextField tfTo;
	
	protected JRadioButton stepBtn;
	
	protected JTextField tfBegin;
	
	protected JTextField tfStep;
	
	protected JRadioButton seqBtn;
	
	private CheckBoxGroup<String> seqCBG;
	
	protected __TimePanel(Cron cron, String name, int seqRow) {
		super(new BorderLayout());
		
		this.cron = cron;
		this.name = name;
		this.add(init(name, seqRow), BorderLayout.CENTER);
		setListener();
	}
	
	private JPanel init(String name, int seqRow) {
		this.tfFrom = new JTextField(5);
		this.tfTo = new JTextField(5);
		this.tfBegin = new JTextField(5);
		this.tfStep = new JTextField(5);
		initTips();
		
		this.everyBtn = new JRadioButton(StrUtils.concat("每", name, "触发 (*)"));
		this.rangeBtn = new JRadioButton("范围触发 (x-y)");
		this.stepBtn = new JRadioButton("周期触发 (x/y)");
		this.seqBtn = new JRadioButton("定点触发 (a,b,c,...)");
		ButtonGroup bg = new ButtonGroup();
		bg.add(everyBtn);
		bg.add(rangeBtn);
		bg.add(stepBtn);
		bg.add(seqBtn);
		
		this.seqCBG = initSequence();
		return SwingUtils.getVFlowPanel(
				getEveryPanel(),  
				getRangePanel(), 
				getStepPanel(), 
				getSequencePanel(),
				
				SwingUtils.addBorder(
						seqCBG.toGridPanel(seqRow), 
						StrUtils.concat("[", name, "] 列表"))
		);
	}
	
	protected abstract void initTips();

	protected JPanel getEveryPanel() {
		return SwingUtils.addPanel(everyBtn);
	}
	
	protected JPanel getRangePanel() {
		return SwingUtils.getPairsPanel(rangeBtn, 
				SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
						new JLabel(" ：在第 "), tfFrom, 
						new JLabel(StrUtils.concat(" ", name, "到 ")), 
						tfTo, new JLabel(StrUtils.concat(" ", name, "之间触发"))
				)
		);
	}
	
	protected JPanel getStepPanel() {
		return SwingUtils.getPairsPanel(stepBtn, 
				SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
						new JLabel(" ：从第 "), tfBegin, 
						new JLabel(StrUtils.concat(" ", name, "开始, 每隔 ")), 
						tfStep, new JLabel(StrUtils.concat(" ", name, "触发"))
				)
		);
	}
	
	protected JPanel getSequencePanel() {
		return SwingUtils.getPairsPanel(seqBtn, 
				new JLabel(StrUtils.concat(" , 在以下指定的若干", name, "触发 ： ")));
	}
	
	protected abstract CheckBoxGroup<String> initSequence();
	
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
	
	private void setFieldListener(final JTextField textField) {
		textField.addKeyListener(new KeyListener() {

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
		        // TODO Auto-generated method stub
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		        // TODO Auto-generated method stub
		    }
		});
	}

	protected abstract void setEveryBtnListener();
	
	protected abstract void setRangeBtnListener();
	
	protected abstract void setStepBtnListener();
	
	protected abstract void setSeqBtnListener(List<JCheckBox> selecteds);

}
