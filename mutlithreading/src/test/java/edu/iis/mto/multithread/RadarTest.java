package edu.iis.mto.multithread;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.google.common.util.concurrent.MoreExecutors;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    private ExecutorService service = MoreExecutors.newDirectExecutorService();

    @RepeatedTest(100)
    void launchPatriotOnceWhenNoticesAScudMissle() throws InterruptedException {
        BetterRadar betterRadar = new BetterRadar(batteryMock,1,service);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }

}
