package main.java.m3.model.observer;

public interface AsyncSubject<T> {
	
	public void attach(AsyncObserver<T> o);
	
	public void detach(AsyncObserver<T> o);

	public void notifyAsyncObservers();
}
