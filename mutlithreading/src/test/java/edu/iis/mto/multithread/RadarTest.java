package edu.iis.mto.multithread;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.Executor;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @RepeatedTest(100)
    void launchPatriotOnceWhenNoticesSingleScudMissile() {
        int rocketCounter = 1;
        Executor executor = Runnable::run;
        BetterRadar radar = new BetterRadar(executor,rocketCounter, batteryMock);
        Scud enemyMissile = new Scud();
        radar.onNotice(enemyMissile);
        verify(batteryMock, times(rocketCounter)).launchPatriot(enemyMissile);
    }

}
