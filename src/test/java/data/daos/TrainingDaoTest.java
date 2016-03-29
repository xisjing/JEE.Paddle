package data.daos;

import static org.junit.Assert.assertNull;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class TrainingDaoTest {
	
	    @Autowired
	    private TrainingDao trainingDao;
	    
	    @Autowired
	    private CourtDao courtDao;
	    
	    @Test
	    public void testFindByCourtAndTrainingDate() {
	        Calendar date = Calendar.getInstance();
	        date.add(Calendar.DAY_OF_YEAR, 1);
	        date.set(Calendar.HOUR_OF_DAY, 10);
	        date.set(Calendar.MINUTE, 0);
	        date.set(Calendar.SECOND, 0);
	        date.set(Calendar.MILLISECOND, 0);
	        assertNull(trainingDao.findByCourtAndTrainingDate(courtDao.findOne(1), date));
	    }

}
