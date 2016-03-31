package business.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.daos.CourtDao;
import data.daos.TrainingDao;
import data.daos.UserDao;
import data.entities.Training;

@Controller
public class TrainingController {
	
	private static final int START_TIME = 9;

    private static final int END_TIME = 23;
	
	private TrainingDao trainingDao;
	
	private CourtDao courtDao;
	
	private UserDao userDao;

	@Autowired
	public void setTrainingDao(TrainingDao trainingDao) {
		this.trainingDao = trainingDao;
	}
	
	@Autowired
	public void setCourtDao(CourtDao courtDao) {
		this.courtDao = courtDao;
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public boolean rightTime(int hour) {
        return hour >= START_TIME && hour <= END_TIME;
    }
		
	
	 public boolean createTraining(int courtId, Calendar trainingDate, String trainer) {
	       Training training = new Training(courtDao.findOne(courtId), trainingDate);
	       if (trainingDao.findByCourtAndTrainingDate(training.getCourt(), training.getTrainingDate()) != null) {
	            return false;
	       }
	       training.setTrainer(userDao.findByUsernameOrEmail(trainer));
	       trainingDao.save(training);
	       return true;
		
	    }
	 

	 public boolean deleteTraining(int trainingId){
		if(trainingDao.findOne(trainingId) == null){
			return false;
		}		 
		trainingDao.delete(trainingId);
		return true;		  
	 }
	 
	 public boolean deleteTraningPlayer(int trainingId){
		 trainingDao.findOne(trainingId).setPlayers(null);
		 return true;		 
	 }
	 
	 
	 public List<Training> showTrainings(){
		 List<Training> trainingList = new ArrayList<>();
	        for (Training training : trainingDao.findAll()) {
	        	trainingList.add(training);
	        }
	        return trainingList;		 
	 }
	 
	
	 
	
	
	
	

}
