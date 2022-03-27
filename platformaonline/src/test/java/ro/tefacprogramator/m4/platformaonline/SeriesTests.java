package ro.tefacprogramator.m4.platformaonline;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ro.tefacprogramator.m4.platformaonline.controller.SeriesController;
import ro.tefacprogramator.m4.platformaonline.entity.Series;
import ro.tefacprogramator.m4.platformaonline.service.SeriesService;

@WebMvcTest(SeriesController.class)
public class SeriesTests {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private SeriesService service;

    @Test
    void testGetAllSeriesEndpoint() {

        List<Series> mySeries = new ArrayList<Series>();
        Series s1 = new Series();
        s1.setIdSeries(999);
        mySeries.add(s1);

        when(service.getAllSeries()).thenReturn(mySeries);

        try {
            this.mvc.perform(
                MockMvcRequestBuilders.get("/series/getAll")
            )
            .andExpect(
                MockMvcResultMatchers.status().isOk()
            )
            .andExpect(
               MockMvcResultMatchers.jsonPath("$[0].idSeries", Matchers.is(999))
            )
            .andReturn();

        } catch(Exception e) {

        }
    }

}
