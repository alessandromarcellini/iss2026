package main.java.test;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.conway.domain.Grid;
import main.java.conway.domain.IGrid;


public class GridTest {
	private IGrid grid = new Grid(10, 10);
	
	@Before
	public void setup() {
		System.out.println("ConwayLifeTest | setup");
	}

	@After
	public void down() {
		System.out.println("ConwayLifeTest | down");
	}
	

}
