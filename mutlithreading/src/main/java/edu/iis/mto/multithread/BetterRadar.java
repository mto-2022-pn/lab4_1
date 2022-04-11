package edu.iis.mto.multithread;

public class BetterRadar {
    private int ROCKET_COUNT = 10;
    private final PatriotBattery battery;
    private final int rocketPerEnemyMissile;

    public BetterRadar(PatriotBattery battery) {
        this.battery = battery;
        rocketPerEnemyMissile = 1;
    }
    public BetterRadar(PatriotBattery battery, int rocketPerEnemyMissile) {
        this.battery = battery;
        this.rocketPerEnemyMissile = rocketPerEnemyMissile;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile, rocketPerEnemyMissile);
    }

    private void launchPatriot(Scud enemyMissile, int rocketCount) {
        LaunchPatriotTask task = new LaunchPatriotTask(enemyMissile, rocketCount);
        task.start();
    }
    private class LaunchPatriotTask extends Thread {
        private final int rocketCount;
        private final Scud enemyMissile;
        public LaunchPatriotTask(Scud enemyMissile, int rocketCount) {
            this.enemyMissile = enemyMissile;
            this.rocketCount = rocketCount;
        }
        public void start() {
            for (int i = 0; i < rocketCount && ROCKET_COUNT > 0; i++) {
                battery.launchPatriot(enemyMissile);
                ROCKET_COUNT--;
            }
        }
    }
}
