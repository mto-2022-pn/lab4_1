package edu.iis.mto.multithread;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.Executor;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;
    private final Executor executor = Runnable::run;
    private Scud enemyMissle;

    @BeforeEach
    void setUp() {
        enemyMissle = new Scud();
    }

    @RepeatedTest(100)
    void launchPatriotOnceWhenNoticesAScudMissle() {
        int rocketCount = 1;
        BetterRadar radar = new BetterRadar(rocketCount, batteryMock, executor);
        radar.notice(enemyMissle);
        verify(batteryMock, times(rocketCount)).launchPatriot(enemyMissle);
    }

    @RepeatedTest(100)
    void launchPatriot20TimesWhenNoticesAScudMissle() {
        int rocketCount = 20;
        BetterRadar radar = new BetterRadar(rocketCount, batteryMock, executor);
        radar.notice(enemyMissle);
        verify(batteryMock, times(rocketCount)).launchPatriot(enemyMissle);
    }



}
