package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {
    private final int rocketNumber;
    private final PatriotBattery patriotBattery;
    private final Executor executor;

    public BetterRadar(int rocketNumber, PatriotBattery patriotBattery, Executor executor) {
        this.rocketNumber = rocketNumber;
        this.patriotBattery = patriotBattery;
        this.executor = executor;
    }

    public void afterNotice(Scud enemyMissile){
        executor.execute(() -> {
            for (int i = 0; i < rocketNumber; i++) {
                patriotBattery.launchPatriot(enemyMissile);
            }
        });
    }
}
