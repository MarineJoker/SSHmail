package com.liu;

import java.util.List;

public interface BaseService<T> {
	public void save(T t);
	public void update(T model);
	public void delete(int id);
	public T get(int id);
	public List<T>query(); 

}
