/**
 * 
 */
package taskscheduler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author walter.g.pedrozo
 *
 */
public class TaskScheduler {

    static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(9);

    private static volatile boolean task1Flag = false;
    private static volatile boolean task2Flag = false;
    private static volatile boolean task3Flag = false;
    private static volatile boolean task4Flag = false;
    private static volatile boolean task5Flag = false;
    private static volatile boolean task6Flag = false;
    private static volatile boolean task7Flag = false;
    private static volatile boolean task8Flag = false;
    private static volatile boolean task9Flag = false;

    static final String EMPTY = "";

    static String taskStatus1 = EMPTY;
    static String taskStatus2 = EMPTY;
    static String taskStatus3 = EMPTY;
    static String taskStatus4 = EMPTY;
    static String taskStatus5 = EMPTY;
    static String taskStatus6 = EMPTY;
    static String taskStatus7 = EMPTY;
    static String taskStatus8 = EMPTY;
    static String taskStatus9 = EMPTY;

    /**
     * @param args
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        LocalDateTime startDate1 = LocalDateTime.of(2020, 7, 15, 0, 0, 1);
        LocalDateTime endDate1 = LocalDateTime.of(2020, 7, 20, 0, 0, 1);

        LocalDateTime startDate2 = LocalDateTime.of(2020, 7, 20, 0, 0, 1);
        LocalDateTime endDate2 = LocalDateTime.of(2020, 7, 30, 0, 0, 1);

        LocalDateTime startDate3 = LocalDateTime.of(2020, 7, 30, 0, 0, 1);
        LocalDateTime endDate3 = LocalDateTime.of(2020, 8, 4, 0, 0, 1);

        LocalDateTime startDate4 = LocalDateTime.of(2020, 7, 30, 0, 0, 1);
        LocalDateTime endDate4 = LocalDateTime.of(2020, 8, 9, 0, 0, 1);

        LocalDateTime startDate5 = LocalDateTime.of(2020, 8, 9, 0, 0, 1);
        LocalDateTime endDate5 = LocalDateTime.of(2020, 8, 13, 0, 0, 1);

        LocalDateTime startDate6 = LocalDateTime.of(2020, 8, 9, 0, 0, 1);
        LocalDateTime endDate6 = LocalDateTime.of(2020, 9, 8, 0, 0, 1);

        LocalDateTime startDate7 = LocalDateTime.of(2020, 9, 8, 0, 0, 1);
        LocalDateTime endDate7 = LocalDateTime.of(2020, 9, 16, 0, 0, 1);

        LocalDateTime startDate8 = LocalDateTime.of(2020, 9, 16, 0, 0, 1);
        LocalDateTime endDate8 = LocalDateTime.of(2020, 9, 22, 0, 0, 1);

        LocalDateTime startDate9 = LocalDateTime.of(2020, 9, 22, 0, 0, 1);
        LocalDateTime endDate9 = LocalDateTime.of(2020, 9, 25, 0, 0, 1);

        LocalDateTime afterOneMinute = startDate1.plusMinutes(1);
        Duration duration = Duration.between(startDate1, endDate1);
        long delay = Math.abs(duration.toMillis());
        System.out.println("Project Initiation scheduled at : " + startDate1);
        ScheduledFuture<?> resultTask1 = executorService.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    task1Flag = true;
                } catch (Exception e) {
                    task1Flag = false;
                }
            }
        }, delay, TimeUnit.MILLISECONDS);
        System.out.println(resultTask1.get());

        afterOneMinute = startDate2.plusMinutes(1);
        duration = Duration.between(startDate2, endDate2);
        delay = Math.abs(duration.toMillis());
        System.out.println("Analysis & Requirements scheduled at : " + startDate2);
        ScheduledFuture<?> resultTask2 = executorService.schedule(new Runnable() {
            @Override
            public void run() {
                if (task1Flag) {
                    try {
                        task2Flag = true;
                    } catch (Exception e) {
                        task2Flag = false;
                    }
                } else {
                    task2Flag = false;
                    System.out.println(
                        "Analysis & Requirements scannot be started because dependency task/s is/are not done");
                }
            }
        }, delay, TimeUnit.MILLISECONDS);
        System.out.println(resultTask2.get());

        afterOneMinute = startDate3.plusMinutes(1);
        duration = Duration.between(startDate3, endDate3);
        delay = Math.abs(duration.toMillis());
        System.out.println("Prepare Test Scripts scheduled at : " + startDate3);
        ScheduledFuture<?> resultTask3 = executorService.schedule(new Runnable() {
            @Override
            public void run() {
                if (task1Flag && task2Flag) {
                    try {
                        task3Flag = true;
                    } catch (Exception e) {
                        task3Flag = false;
                    }
                } else {
                    task3Flag = false;
                    System.out
                        .println("Prepare Test Scripts scannot be started because dependency task/s is/are not done");
                }
            }
        }, delay, TimeUnit.MILLISECONDS);
        System.out.println(resultTask3.get());

        afterOneMinute = startDate4.plusMinutes(1);
        duration = Duration.between(startDate4, endDate4);
        delay = Math.abs(duration.toMillis());
        System.out.println("Design  scheduled at : " + startDate4);
        ScheduledFuture<?> resultTask4 = executorService.schedule(new Runnable() {
            @Override
            public void run() {
                if (task1Flag && task2Flag) {
                    try {
                        task4Flag = true;
                    } catch (Exception e) {
                        task4Flag = false;
                    }
                } else {
                    task4Flag = false;
                    System.out.println("Design scannot be started because dependency task/s is/are not done");
                }
            }
        }, delay, TimeUnit.MILLISECONDS);
        System.out.println(resultTask4.get());

        afterOneMinute = startDate5.plusMinutes(1);
        duration = Duration.between(startDate5, endDate5);
        delay = Math.abs(duration.toMillis());
        System.out.println("Infra Setup scheduled at : " + startDate5);
        ScheduledFuture<?> resultTask5 = executorService.schedule(new Runnable() {
            @Override
            public void run() {
                if (task1Flag && task2Flag && task4Flag) {
                    try {
                        task5Flag = true;
                    } catch (Exception e) {
                        task5Flag = false;
                    }
                } else {
                    task5Flag = false;
                    System.out.println("Infra Setup scannot be started because dependency task/s is/are not done");
                }
            }
        }, delay, TimeUnit.MILLISECONDS);
        System.out.println(resultTask5.get());

        afterOneMinute = startDate6.plusMinutes(1);
        duration = Duration.between(startDate6, endDate6);
        delay = Math.abs(duration.toMillis());
        System.out.println("Programming  scheduled at : " + startDate6);
        ScheduledFuture<?> resultTask6 = executorService.schedule(new Runnable() {
            @Override
            public void run() {
                if (task1Flag && task2Flag && task4Flag) {
                    try {
                        task6Flag = true;
                    } catch (Exception e) {
                        task6Flag = false;
                    }
                } else {
                    task6Flag = false;
                    System.out.println("Programming scannot be started because dependency task/s is/are not done");
                }
            }
        }, delay, TimeUnit.MILLISECONDS);
        System.out.println(resultTask6.get());

        afterOneMinute = startDate7.plusMinutes(1);
        duration = Duration.between(startDate7, endDate7);
        delay = Math.abs(duration.toMillis());
        System.out.println("Integration and Testing scheduled at : " + startDate7);
        ScheduledFuture<?> resultTask7 = executorService.schedule(new Runnable() {
            @Override
            public void run() {
                if (task1Flag && task2Flag && task4Flag && task6Flag && task3Flag && task5Flag) {
                    try {
                        task7Flag = true;
                    } catch (Exception e) {
                        task7Flag = false;
                    }
                } else {
                    task7Flag = false;
                    System.out.println(
                        "Integration and Testing scannot be started because dependency task/s is/are not done");
                }
            }
        }, delay, TimeUnit.MILLISECONDS);
        System.out.println(resultTask7.get());

        afterOneMinute = startDate8.plusMinutes(1);
        duration = Duration.between(startDate8, endDate8);
        delay = Math.abs(duration.toMillis());
        System.out.println("Users Training & Testing scheduled at : " + startDate8);
        ScheduledFuture<?> resultTask8 = executorService.schedule(new Runnable() {
            @Override
            public void run() {
                if (task1Flag && task2Flag && task4Flag && task6Flag && task3Flag && task7Flag) {
                    try {
                        task8Flag = true;
                    } catch (Exception e) {
                        task8Flag = false;
                    }
                } else {
                    task8Flag = false;
                    System.out.println(
                        "Users Training & Testing scannot be started because dependency task/s is/are not done");
                }
            }
        }, delay, TimeUnit.MILLISECONDS);
        System.out.println(resultTask8.get());

        afterOneMinute = startDate9.plusMinutes(1);
        duration = Duration.between(startDate9, endDate9);
        delay = Math.abs(duration.toMillis());
        System.out.println("Production Deployment scheduled at : " + startDate8);
        ScheduledFuture<?> resultTask9 = executorService.schedule(new Runnable() {
            @Override
            public void run() {
                if (task1Flag && task2Flag && task4Flag && task6Flag && task3Flag && task7Flag && task8Flag) {
                    try {
                        task9Flag = true;
                    } catch (Exception e) {
                        task9Flag = false;
                    }
                } else {
                    task9Flag = false;
                    System.out
                        .println("Production Deployment scannot be started because dependency task/s is/are not done");
                }
            }
        }, delay, TimeUnit.MILLISECONDS);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(resultTask9.get());

    }
}
