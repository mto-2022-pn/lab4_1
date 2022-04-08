package edu.iis.mto.multithread;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BetterRadar {

    private int ROCKET_COUNT;
    private PatriotBattery battery;
    private ExecutorService executorService;

    public BetterRadar(PatriotBattery battery, int misslesToLaunch, ExecutorService executorService) {
        this.battery = battery;
        this.executorService = executorService;
        this.ROCKET_COUNT = misslesToLaunch;
    }

    public void notice(Scud enemyMissle) throws InterruptedException {
        launchPatriot(enemyMissle, ROCKET_COUNT);
    }

    private void launchPatriot(Scud enemyMissle, int rocketCount) throws InterruptedException {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < rocketCount; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };
        executorService.execute(launchPatriotTask);
        executorService.shutdown();

    }

}
