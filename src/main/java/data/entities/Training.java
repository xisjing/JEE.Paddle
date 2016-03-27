package data.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Training {
	
	@Id
	@GeneratedValue
    private int id;
	
	private User trainer;
	
	private User player;
	
	private Court court;
	
	private Calendar trainingDate;
	
	public Training(Court court, User player, User trainer, Calendar trainingDate) {
        this.court = court;
        this.player = player;
        this.trainer = trainer;
        this.trainingDate = trainingDate;
    }
	
    public int getId(){
    	return id;
    }
    
   
	public Court getCourt() {
		return court;
	}

	public Calendar getTrainingDate() {
		return trainingDate;
	}
	
	 @Override
	 public int hashCode() {
	        return id;
	    }

	 @Override
	  public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        return id == ((Training) obj).id;
	    }

	    @Override
	    public String toString() {
	        String time = new SimpleDateFormat("HH:00 dd-MMM-yyyy ").format(trainingDate.getTime());
	        return "Training [id=" + id + ", courtId=" + court.getId() + ", player =" + player.getId() + ", trainer =" + trainer.getId() + ", date=" + time + "]";
	    }

		public User getTrainer() {
			return trainer;
		}

		public void setTrainer(User trainer) {
			this.trainer = trainer;
		}

		public User getPlayer() {
			return player;
		}

		public void setPlayer(User player) {
			this.player = player;
		}

	}

