package Gisela.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import Gisela.demo.model.Farm;
import Gisela.demo.repository.iFarmRepository;

public class FarmServiceTest {

    @Mock
    private iFarmRepository farmRepository;

    @InjectMocks
    private FarmService farmService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBuyProducts() {
        List<Object[]> results = new ArrayList<>();
        Object[] row = new Object[4];
        row[0] = new Timestamp(System.currentTimeMillis());
        row[1] = "Sold Chicken";
        row[2] = 400;
        results.add(row);
        when(farmRepository.buyProducts()).thenReturn(results);

        List<Farm> farms = farmService.buyProducts();
        assertEquals(1, farms.size());
        assertEquals("Sold Chicken", farms.get(0).getProductnm());
        assertEquals(Integer.valueOf(400), farms.get(0).getProductprice());
    }

    @Test
    public void testSellProducts() {
        List<Object[]> results = new ArrayList<>();
        Object[] row = new Object[4];
        row[0] = new Timestamp(System.currentTimeMillis());
        row[1] = "New Chicken";
        row[2] = 200;
        results.add(row);
        when(farmRepository.sellProducts()).thenReturn(results);

        List<Farm> farms = farmService.sellProducts();
        assertEquals(1, farms.size());
        assertEquals("New Chicken", farms.get(0).getProductnm());
        assertEquals(Integer.valueOf(200), farms.get(0).getProductprice());
    }

    @Test
    public void testDropProducts() {
        List<Object[]> results = new ArrayList<>();
        Object[] row = new Object[4];
        row[0] = new Timestamp(System.currentTimeMillis());
        row[1] = "Drop Chicken";
        row[2] = null;
        results.add(row);
        when(farmRepository.dropProducts()).thenReturn(results);

        List<Farm> farms = farmService.dropProducts();
        assertEquals(1, farms.size());
        assertEquals("Drop Chicken", farms.get(0).getProductnm());
        assertEquals(null, farms.get(0).getProductprice());
    }

}
