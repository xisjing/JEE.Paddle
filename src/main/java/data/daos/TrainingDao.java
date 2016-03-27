package data.daos;

import java.util.Calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import data.entities.Court;
import data.entities.Reserve;
import data.entities.Training;
import data.entities.User;

public interface TrainingDao extends JpaRepository<Reserve, Integer> {
	
	//show Training 
	<List>Training findbyDate(Calendar trainingDate);
	
	//create Training 
	@Modifying
    @Transactional 
    @Query("insert into(training.court,training.user,training.trainingDate) Training training values (?1,?2,?3)" )
	void createTraining(Court court, User user, Calendar trainingDate);
	
	//delete Training
	@Modifying
    @Transactional 
    @Query("delete from Training training where training.user = ?1")
    void deleteTraining(User trainer);
	
	

}
