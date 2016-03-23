package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import data.entities.Token;
import data.entities.User;

public interface TokenDao extends JpaRepository<Token, Integer> {

    Token findByUser(User user);
    
    @Query("delete token.calendar from Token token where token.calender < = ?1")
    void deleteByTime(long canlender);
}
