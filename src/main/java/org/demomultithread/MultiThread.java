package org.demomultithread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThread {

    private static final int DATA_SIZE = 10000;  // Simulate a large data set
    private final ExecutorService executorService = Executors.newFixedThreadPool(3);  // 3 instances

    public static void main(String[] args) {
        MultiThread service = new MultiThread();
        service.runSimulation();
    }

    public void runSimulation() {
        try {
            List<Future<Void>> futures = new ArrayList<>();

            // Submit 3 parallel tasks
            futures.add(executorService.submit(() -> processLargeData("Instance 1")));
            futures.add(executorService.submit(() -> processLargeData("Instance 2")));
            futures.add(executorService.submit(() -> processLargeData("Instance 3")));

            // Wait for all tasks to complete with a timeout to avoid deadlock
            for (Future<Void> future : futures) {
                try {
                    future.get(30, TimeUnit.SECONDS);  // Set a timeout to avoid hanging indefinitely
                } catch (TimeoutException e) {
                    System.err.println("Task execution exceeded timeout: " + e.getMessage());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("All tasks completed or failed.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Proper shutdown of the executor service
            shutdownExecutor();
        }
    }

    // Simulate data processing for a large data set
    private Void processLargeData(String instanceName) throws InterruptedException {
        System.out.println(instanceName + " started processing large data...");

        // Simulate processing of large data
        List<Integer> data = new ArrayList<>(DATA_SIZE);
        for (int i = 0; i < DATA_SIZE; i++) {
            data.add(i);
        }

        // Simulate time-consuming task that could potentially cause deadlock if not handled correctly
        Thread.sleep(3000);  // Simulate data processing delay
        // Simulate dependent task that could potentially cause a deadlock if not handled correctly
        if (instanceName.equals("Instance 1")) {
            // Waiting on another instance's task in a non-blocking way to avoid deadlock
            System.out.println(instanceName + " is waiting for Instance 2 to complete...");
            // Here we simulate the waiting behavior. In a real-world case, use Future.get() or a similar mechanism.
            Thread.sleep(5000);
        }
        if (instanceName.equals("Instance 2")) {
            // Waiting on another instance's task in a non-blocking way to avoid deadlock
            System.out.println(instanceName + " is waiting for Instance 1 to complete...");
            // Here we simulate the waiting behavior. In a real-world case, use Future.get() or a similar mechanism.
            Thread.sleep(5000);
        }

        // Removed the direct waiting between instances to avoid deadlock
        // If necessary, you can use other synchronization mechanisms such as CountDownLatch or Semaphore.

        System.out.println(instanceName + " finished processing data.");
        return null;
    }

    // Shutdown the ExecutorService properly to avoid resource leakage
    private void shutdownExecutor() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
