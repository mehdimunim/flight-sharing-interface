package com.example.jetty_jersey.dao;

import java.util.List;

import com.example.jetty_jersey.dao.objects.Action;

public interface ActionDao {

	/**
	 * Add a nes action to the database
	 * 
	 * @param action
	 */
	void addAction(Action action);

	/**
	 * @param username
	 * @return the list of actions assigned to a specific user.
	 */
	List<Action> getActions(String username);

}
