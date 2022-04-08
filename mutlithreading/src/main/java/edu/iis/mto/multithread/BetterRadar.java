package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {
    private final Executor executor;
    private final int rocketCounter;
    private final PatriotBattery patriotBattery;

    public BetterRadar(Executor executor, int rocketCounter, PatriotBattery patriotBattery) {
        this.executor = executor;
        this.rocketCounter = rocketCounter;
        this.patriotBattery = patriotBattery;
    }
    public void onNotice(Scud enemyMissile){
        executor.execute(()->{
            for(int i=0;i<rocketCounter;i++)
            {
                this.patriotBattery.launchPatriot(enemyMissile);
            }
        });

    }
}
