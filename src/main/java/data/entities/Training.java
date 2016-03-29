package data.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Training {
	
	@Id
	@GeneratedValue
    private int id;
	
	@OneToMany
    private List<User> players;
		
	@ManyToOne
	@JoinColumn
	private User trainer;
		
	@ManyToOne
	@JoinColumn
	private Court court;
	
	private Calendar trainingDate;

	
	public Training(Court court, List<User> players, User trainer, Calendar trainingDate) {
        this.court = court;
        this.players = new ArrayList<User>();
        this.trainer = trainer;
        this.trainingDate = trainingDate;
    }
	
	public Training(Court court,Calendar trainingDate){
		this(court,null,null,trainingDate);
		
	}
	
	public Training(){
		
	}
	
	public int getId() {
		return id;
	}
	
	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}

	public List<User> getPlayers() {
		return players;
	}

	//? this.players = players;
	public void setPlayers(List<User> players) {
		this.players = new ArrayList<User>();
	}
	
	public Court getCourt() {
		return court;
	}

	public Calendar getTrainingDate() {
		return trainingDate;
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
	        return "Training [id=" + id + ", courtId=" + court.getId() + ", players =" + players.get(id)  + ", trainer =" + trainer.getId() + ", date=" + time + "]";
	    }

		

		

	}

