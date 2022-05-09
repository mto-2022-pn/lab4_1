package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {
    private final int rocketCount;
    private final PatriotBattery battery;
    private final Executor executor;

    public BetterRadar(int rocketCount, PatriotBattery battery, Executor executor) {
        this.rocketCount = rocketCount;
        this.battery = battery;
        this.executor = executor;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle, rocketCount, executor);
    }

    private void launchPatriot(Scud enemyMissle, int rocketCount, Executor executor) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < rocketCount; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };

        executor.execute(launchPatriotTask);
    }
}
