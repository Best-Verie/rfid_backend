package com.rfid.rfid_backend.Services;

import com.rfid.rfid_backend.model.Card;
import com.rfid.rfid_backend.repository.CardRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceTest {

    @Mock
    private CardRepository cardRepositoryMock;

    @InjectMocks
    private CardService cardService;

    @Test
    public void getAll_success() {
        when(cardRepositoryMock.findAll()).thenReturn(Arrays.asList(new Card("jdhf7890-7980hj",120),
                new Card("fb78495-95n-45f",200)));
        assertEquals(200,cardService.getAll().get(1).getBalance());
    }





}
