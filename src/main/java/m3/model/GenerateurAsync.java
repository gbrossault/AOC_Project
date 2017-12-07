package main.java.m3.model;

import java.util.concurrent.Future;

public interface GenerateurAsync {


	public Future<Integer> getValue();

}
