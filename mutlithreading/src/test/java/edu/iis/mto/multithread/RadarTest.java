package edu.iis.mto.multithread;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @RepeatedTest(10)
    void launchPatriotOnceWhenNoticesAScudMissile() {
        BetterRadar radar = new BetterRadar(batteryMock);
        Scud enemyMissile = new Scud();
        radar.notice(enemyMissile);
        verify(batteryMock).launchPatriot(enemyMissile);
    }

    @RepeatedTest(10)
    void launchPatriotTwiceWhenNoticesAScudMissile() {
        BetterRadar radar = new BetterRadar(batteryMock, 2);
        Scud enemyMissile = new Scud();
        radar.notice(enemyMissile);
        verify(batteryMock, times(2)).launchPatriot(enemyMissile);
    }

}
