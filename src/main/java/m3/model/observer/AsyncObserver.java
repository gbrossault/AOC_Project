package main.java.m3.model.observer;

import java.util.concurrent.Future;

public interface AsyncObserver<T> {
	
	public Future<Void> update(T t);
	
}
