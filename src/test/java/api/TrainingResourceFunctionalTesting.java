package api;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import business.api.Uris;
import business.wrapper.AvailableTime;
import data.entities.Training;

public class TrainingResourceFunctionalTesting {
	
	RestService restService = new RestService();
	
	@Test
    public void testcreateTraining() {
        restService.createCourt("1");
        restService.createCourt("2");
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DAY_OF_YEAR, 1);
        day.set(Calendar.HOUR_OF_DAY,12);
        new RestBuilder<String>(RestService.URL).path(Uris.TRAINING).body(new AvailableTime(1, day)).post().build();
        day.set(Calendar.HOUR_OF_DAY,14);
        new RestBuilder<String>(RestService.URL).path(Uris.TRAINING).body(new AvailableTime(2, day)).post().build();
    }
	
	 @Test
	    public void testshowTrainings() {
	        String token = restService.loginAdmin();
	        List<Training> list = Arrays.asList(new RestBuilder<Training[]>(RestService.URL).path(Uris.TRAINING).basicAuth(token, "")
	                .clazz(Training[].class).get().build());
	    }
	 
	 @After
	    public void deleteAll() {
	        new RestService().deleteAll();
	    }


}
