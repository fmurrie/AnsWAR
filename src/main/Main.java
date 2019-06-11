package main;

import java.awt.EventQueue;

import grafica.MarcoEjecutor;

public class Main
{

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MarcoEjecutor frame = new MarcoEjecutor();
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});

	}

}
