package com.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookmyshow.model.Screen;

@Repository
public interface ScreenRepo extends JpaRepository<Screen, Integer> {
	
	@Query(nativeQuery = true, value = "select * from  screen,theatre where screen.th_id = theatre.theatre_id and screen_name =?1 and theatre.theatre_name =?2")
	public Screen getScreenByScreenName(String screenName, String theatreName);
}
