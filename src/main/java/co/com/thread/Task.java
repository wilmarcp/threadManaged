package co.com.thread;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Task implements Runnable{

	private String nameThread;
	
	public void setNameThread(String nameThread) {
		this.nameThread = nameThread;
	}
	
	@Override
	public void run() {
		System.out.println("El thread " + nameThread + " inicio");
		try {
			TimeUnit.SECONDS.sleep(10);
			System.out.println("El thread " + nameThread + " desperto");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
