package com.springdemo.dao;

import java.util.List;
import com.springdemo.model.Person;

public interface PersonDAO {

	public void save(Person p);

	public List<Person> list();

}
