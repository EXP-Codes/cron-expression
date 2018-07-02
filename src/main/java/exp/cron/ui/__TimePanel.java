package exp.cron.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import exp.libs.utils.other.StrUtils;
import exp.libs.warp.ui.SwingUtils;
import exp.libs.warp.ui.cpt.cbg.CheckBoxGroup;

abstract class __TimePanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 1950899137550339477L;
	
	protected String name;
	
	protected __TimePanel(String name, int seqRow) {
		super(new BorderLayout());
		
		this.name = name;
		this.add(init(name, seqRow), BorderLayout.CENTER);
	}
	
	private JPanel init(String name, int seqRow) {
		JRadioButton everyBtn = new JRadioButton(StrUtils.concat("每", name, "触发 (*)"));
		JRadioButton rangeBtn = new JRadioButton("范围触发 (x-y)");
		JRadioButton stepBtn = new JRadioButton("周期触发 (x/y)");
		JRadioButton seqBtn = new JRadioButton("定点触发 (a,b,c,...)");
		ButtonGroup bg = new ButtonGroup();
		bg.add(everyBtn);
		bg.add(rangeBtn);
		bg.add(stepBtn);
		bg.add(seqBtn);
		
		CheckBoxGroup<String> seqCBG = initSequence();
		return SwingUtils.getVFlowPanel(
				everyBtn,  
				
				SwingUtils.getPairsPanel(rangeBtn, 
						SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
							new JLabel(" ：在第 "), new JTextField(5), 
							new JLabel(StrUtils.concat(" ", name, "到 ")), 
							new JTextField(5), new JLabel((StrUtils.concat(" ", name, "之间触发")))
						)
				), 
				
				SwingUtils.getPairsPanel(stepBtn, 
						SwingUtils.getHFlowPanel(FlowLayout.LEFT, 
							new JLabel(" ：从第 "), new JTextField(5), 
							new JLabel(StrUtils.concat(" ", name, "开始, 每隔 ")), 
							new JTextField(5), new JLabel((StrUtils.concat(" ", name, "触发")))
						)
				), 
				
				SwingUtils.getPairsPanel(seqBtn, new JLabel(StrUtils.concat(" , 在以下指定的若干", name, "触发 ： "))),
				SwingUtils.addBorder(seqCBG.toGridPanel(seqRow), StrUtils.concat("[", name, "] 列表"))
		);
	}
	
	protected abstract CheckBoxGroup<String> initSequence();
	
}
