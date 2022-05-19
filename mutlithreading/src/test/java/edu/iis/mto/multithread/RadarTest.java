package edu.iis.mto.multithread;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.concurrent.Executor;

@ExtendWith(MockitoExtension.class)
class RadarTest {
    @Mock
    private PatriotBattery batteryMock;

    @RepeatedTest(50)
    void launchPatriotOnceWhenNoticesAScudMissile() {
        int rocketCount = 1;
        Executor executor = Runnable::run;
        BetterRadar betterRadar = new BetterRadar(rocketCount, batteryMock, executor);
        Scud enemyMissile = new Scud();
        betterRadar.notice(enemyMissile);
        verify(batteryMock, times(rocketCount)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(50)
    void launchPatriotTenTimesWhenNoticesAScudMissile() {
        int rocketCount = 10;
        Executor executor = Runnable::run;
        BetterRadar betterRadar = new BetterRadar(rocketCount, batteryMock, executor);
        Scud enemyMissile = new Scud();
        betterRadar.notice(enemyMissile);
        verify(batteryMock, times(rocketCount)).launchPatriot(enemyMissile);
    }

}
