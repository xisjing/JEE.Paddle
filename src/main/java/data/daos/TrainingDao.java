package data.daos;

import java.util.Calendar;

import org.springframework.data.jpa.repository.JpaRepository;


import data.entities.Court;
import data.entities.Training;

public interface TrainingDao extends JpaRepository<Training, Integer> {
	
	//show Training 
	Training findByCourtAndTrainingDate(Court court,Calendar trainingDate);
	
	
	
	
}
