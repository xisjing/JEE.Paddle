package business.api;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.InvalidCourtReserveException;
import business.api.exceptions.InvalidDateException;
import business.controllers.CourtController;
import business.controllers.TrainingController;
import business.wrapper.AvailableTime;
import data.entities.Training;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.TRAINING)

public class TrainingResource {
	
	private TrainingController trainingController;
	
	private CourtController courtController;

    @Autowired
    public void setCourtController(CourtController courtController) {
        this.courtController = courtController;
    }
    
    @Autowired
    public void setTrainingController(TrainingController trainingController) {
        this.trainingController = trainingController;
    }
    
    private void validateDay(Calendar day) throws InvalidDateException {
        Calendar calendarDay = Calendar.getInstance();
        calendarDay.add(Calendar.DAY_OF_YEAR, -1);
        if (calendarDay.after(day)) {
            throw new InvalidDateException("La fecha no puede ser un día pasado");
        }
    }

	
	 @RequestMapping(method = RequestMethod.POST)
	    public void createTraining(@AuthenticationPrincipal User trainer, @RequestBody AvailableTime availableTime)
	            throws InvalidCourtReserveException, InvalidDateException {
	        if (!courtController.exist(availableTime.getCourtId())) {
	            throw new InvalidCourtReserveException("" + availableTime.getCourtId());
	        }
	        Calendar date = availableTime.getTime();
	        date.set(Calendar.MINUTE, 0);
	        date.set(Calendar.SECOND, 0);
	        date.set(Calendar.MILLISECOND, 0);
	        if (!trainingController.rightTime(date.get(Calendar.HOUR_OF_DAY))) {
	            throw new InvalidCourtReserveException(date.get(Calendar.HOUR_OF_DAY) + " fuera de rango");
	        }
	        this.validateDay(date);
	        if (!trainingController.createTraining(availableTime.getCourtId(), date, trainer.getUsername())) {
	            throw new InvalidCourtReserveException(availableTime.getCourtId() + "-" + availableTime.getTime());

	        }
	    }
	 
	 @RequestMapping(method = RequestMethod.GET)
	    public List<Training> showTrainings() {
	        return trainingController.showTrainings();
	    }
	 
	 @RequestMapping(value = Uris.ID, method = RequestMethod.DELETE)
	    public void deleteTraining(@PathVariable int id) {
	        trainingController.deleteTraining(id);
	    }
	 
	 @RequestMapping(value = Uris.ID, method = RequestMethod.PUT)
	    public void deleteTraningPlayer(@PathVariable int id) {
	        trainingController.deleteTraningPlayer(id);
	    }
	 
	
	}

    


