package co.com.thread;

import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor)appContext.getBean("taskExecutor");
		
		Task task1 = (Task)appContext.getBean("task");
		task1.setNameThread("Tarea 1 ");
		taskExecutor.execute(task1);
		
		Task task2 = (Task)appContext.getBean("task");
		task2.setNameThread("Tarea 2 ");
		taskExecutor.execute(task2);
		
		Task task3 = (Task)appContext.getBean("task");
		task3.setNameThread("Tarea 3 ");
		taskExecutor.execute(task3);
		
		Task task4 = (Task)appContext.getBean("task");
		task4.setNameThread("Tarea 4 ");
		taskExecutor.execute(task4);
		
		for (;;) {
			int count = taskExecutor.getActiveCount();
			System.out.println("Active Threads : " + count);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (count == 0) {
				taskExecutor.shutdown();
				break;
			}
		}
		
	
		
	}
}
