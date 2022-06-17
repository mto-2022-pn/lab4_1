package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar extends Radar {

	private int noOfRockets;
	private PatriotBattery battery;
	private Executor executor = Runnable::run;

	public BetterRadar(PatriotBattery battery, int number) {
		super(battery);
		this.battery = battery;
		this.noOfRockets = number;

	}

	public void notice(Scud enemyMissle) {
		launchPatriot(enemyMissle, noOfRockets);
	}

	private void launchPatriot(Scud enemyMissle, int rocketCount) {
		executor.execute(() -> {
			for (int i = 0; i < rocketCount; ++i) {
				battery.launchPatriot(enemyMissle);
			}
		});
	}
}
