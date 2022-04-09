package edu.iis.mto.multithread;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.Executor;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @Test
    void launchPatriotOnceWhenNoticesAScudMissle() {
        int rocketCount=1;
        Executor executor = Runnable::run;
        BetterRadar betterRadar = new BetterRadar(rocketCount,batteryMock,executor);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock,times(rocketCount)).launchPatriot(enemyMissle);
    }

}
