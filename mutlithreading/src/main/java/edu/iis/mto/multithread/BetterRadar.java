package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar extends Radar {

	private final int ROCKET_COUNT;
	private final Executor executor;
	private PatriotBattery battery;

	public BetterRadar(PatriotBattery battery, int rocketCount) {
		super(battery);
		this.battery = battery;
		this.executor = Runnable::run;
		ROCKET_COUNT = rocketCount;
	}

	public BetterRadar(PatriotBattery battery) {
		this(battery, 10);
	}

	public void notice(Scud enemyMissile) {
		launchPatriot(enemyMissile);
	}

	private void launchPatriot(Scud enemyMissile) {
		executor.execute(() -> {
			for(int i = 0; i < ROCKET_COUNT; ++i)
				battery.launchPatriot(enemyMissile);
		});
	}
}
