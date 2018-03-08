package com.learn.playground.rx.operator;

import com.learn.playground.rx.operator.model.Guest;
import com.learn.playground.rx.operator.model.GuestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GuestProviderTest {

    @Mock private GuestRepository guestRepository;

    @Test
    public void test_load_student_local(){
        GuestProvider provider = new GuestProvider(guestRepository);
        Mockito.when(guestRepository.loadGuest()).thenReturn(new Guest());
        provider.loadGuest()
                .test()
                .awaitCount(1)
                .assertValueCount(1);
    }

    @Test
    public void test_load_student_remote(){
        GuestProvider provider = new GuestProvider(guestRepository);
        provider.loadGuest()
                .test()
                .awaitCount(1)
                .assertValueCount(1);
    }
}
