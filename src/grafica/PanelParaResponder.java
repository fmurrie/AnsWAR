package grafica;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PanelParaResponder extends SuperPanel
{
	private JTextField pregunta=new JTextField();
	private ButtonGroup grupoRdionBotomns=new ButtonGroup();
	private JToggleButton opcionA = new JToggleButton("A) ");
	private JToggleButton opcionB = new JToggleButton("B) ");
	private JToggleButton opcionC = new JToggleButton("C) ");
	private JToggleButton opcionD = new JToggleButton("D) ");

	/**
	 * Create the panel.
	 */
	public PanelParaResponder(JPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("src/imagenes/AnswarTituloMenuLogin.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
		
		pregunta.setEditable(false);
		pregunta.setForeground(Color.GREEN);
		pregunta.setBackground(Color.GRAY);
		pregunta.setFont(new Font("Stencil", Font.PLAIN, 18));
		pregunta.setHorizontalAlignment(SwingConstants.CENTER);
		add(pregunta);
		pregunta.setColumns(10);
		
		grupoRdionBotomns = new ButtonGroup();
		
		opcionA.setForeground(Color.WHITE);
		opcionA.setFont(new Font("Stencil", Font.PLAIN, 16));
		opcionA.setBackground(Color.BLACK);
		opcionA.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				opcionB.setEnabled(false);
				opcionC.setEnabled(false);
				opcionD.setEnabled(false);
			}
		});
		
		opcionB.setForeground(Color.WHITE);
		opcionB.setFont(new Font("Stencil", Font.PLAIN, 16));
		opcionB.setBackground(Color.BLACK);
		opcionB.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				opcionA.setEnabled(false);
				opcionC.setEnabled(false);
				opcionD.setEnabled(false);
			}
		});
		
		opcionC.setForeground(Color.WHITE);
		opcionC.setFont(new Font("Stencil", Font.PLAIN, 16));
		opcionC.setBackground(Color.BLACK);
		opcionC.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				opcionA.setEnabled(false);
				opcionB.setEnabled(false);
				opcionD.setEnabled(false);
			}
		});
		
		opcionD.setForeground(Color.WHITE);
		opcionD.setFont(new Font("Stencil", Font.PLAIN, 16));
		opcionD.setBackground(Color.BLACK);
		opcionD.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				opcionA.setEnabled(false);
				opcionB.setEnabled(false);
				opcionC.setEnabled(false);
			}
		});
		
		grupoRdionBotomns.add(opcionA);
		grupoRdionBotomns.add(opcionB);
		grupoRdionBotomns.add(opcionC);
		grupoRdionBotomns.add(opcionD);
		add(opcionA);
		add(opcionB);
		add(opcionC);
		add(opcionD);
		

	}

}
