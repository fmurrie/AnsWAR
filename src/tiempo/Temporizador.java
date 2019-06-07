package tiempo;

import java.util.Timer;
import java.util.TimerTask;

public class Temporizador
{
	private int hour = 0;
	private int minute = 1;
	private int second = 1;
	private Timer timer;
	private boolean isTimerRunning;
	private Display display;

	public Temporizador()
	{
		timer = new Timer();
		display = new Display();
	}

	TimerTask task = new TimerTask()
	{
		@Override
		public void run()
		{
			isTimerRunning = true;
			if(second > 0)
			{
				second--;
			}else
			{
				second = 59;
				if(minute > 0)
					minute--;
				else
				{
					minute = 59;
					if(hour > 0)
						hour--;
					// si segundo = 0, minuto = 0 y hora = 0,
					// cancelamos el timer
					else
					{
						isTimerRunning = false;
						timer.cancel();
						timer.purge();
					}
				}
			}
			if(isTimerRunning)
				display.printTime(hour,minute,second);
			else
				System.out.println("Se acabo el tiempo!"); // <---------------------pasar a string sacar print
		}
	}; // fin timertask

	public void start(int timeout, int interval)
	{
		timer.schedule(task,timeout,interval);
	}

}
