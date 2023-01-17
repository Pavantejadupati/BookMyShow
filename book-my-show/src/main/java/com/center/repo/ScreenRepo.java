package com.center.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.center.dto.ScreenDetails;
import com.center.model.Screen;

@Repository
public interface ScreenRepo extends JpaRepository<Screen, Integer> {
	
	@Query(nativeQuery = true, value = "select screen_id as screenId, screen_name as screenName,total_seats as totalSeats from screen where screen_name :screenName")
	public ScreenDetails getScreenByScreenName(@Param("screenName")String screenName);
}
