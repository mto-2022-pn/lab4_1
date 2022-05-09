package edu.iis.mto.multithread;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @RepeatedTest(1000)
    void launchPatriotOnceWhenNoticesAScudMissile() {
        int rocketsCount = 1;
        var radar = new BetterRadar(batteryMock, rocketsCount);
        var enemyMissile = new Scud();
        radar.notice(enemyMissile);
        verify(batteryMock, times(rocketsCount)).launchPatriot(enemyMissile);
    }
}
