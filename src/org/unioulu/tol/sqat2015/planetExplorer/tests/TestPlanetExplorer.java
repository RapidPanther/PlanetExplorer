package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	PlanetExplorer planetExplorer;
	
	@Test
	public void testUpdatePositionF(){
		planetExplorer = new PlanetExplorer(3, 3,"(1,1)");
		planetExplorer.updatePosition("f");
		
		assertEquals(0, planetExplorer.getPositionX());
		assertEquals(1, planetExplorer.getPositionY());
	}
	
	
	@Test
	public void testExecuteCommandFFRF() {
		planetExplorer = new PlanetExplorer(3, 3,"(1,1)");
		String testString = planetExplorer.executeCommand("ffrf");
		
		assertEquals("(1,2,E)()", testString);
	}
	
	@Test
	public void testExecuteCommandFFLLLF() {
		planetExplorer = new PlanetExplorer(3, 3,"(1,1)");
		String testString = planetExplorer.executeCommand("ffrf");
		
		assertEquals("(1,2,E)()", testString);
	}
	
	@Test
	public void testExecuteCommandFBFFRF() {
		planetExplorer = new PlanetExplorer(3, 3,"(1,1)");
		String testString = planetExplorer.executeCommand("ffrf");
		
		assertEquals("(1,2,E)()", testString);
	}
	
	@Test
	public void testExecuteCommandFFR() {
		planetExplorer = new PlanetExplorer(3, 3,"(1,1)");
		String testString = planetExplorer.executeCommand("ffr");
		
		assertEquals("(0,2,E)()", testString);
	}
	
	@Test
	public void testExecuteCommandFFRFwithObstacle02() {
		planetExplorer = new PlanetExplorer(3, 3,"(0,2)");
		String testString = planetExplorer.executeCommand("ffrf");
		
		assertEquals("(1,1,E)(0,2)", testString);
	}
	
	@Test
	public void testExecuteCommandFFRFwithObstacle02and11() {
		planetExplorer = new PlanetExplorer(3, 3,"(0,2)(1,1)");
		String testString = planetExplorer.executeCommand("ffrf");
		
		assertEquals("(0,1,E)(0,2)(1,1)", testString);
	}
	
	@Test
	public void testExecuteCommandFFFtopBorder() {
		planetExplorer = new PlanetExplorer(3, 3,"");
		String testString = planetExplorer.executeCommand("fff");
		
		assertEquals("(0,0,N)()", testString);
	}
	
	@Test
	public void testExecuteCommandRFFFRrightBorder() {
		planetExplorer = new PlanetExplorer(3, 3,"");
		String testString = planetExplorer.executeCommand("rfff");
		
		assertEquals("(0,0,E)()", testString);
	}
	
	@Test
	public void testGetObstacles(){
		planetExplorer = new PlanetExplorer(3,3,"(1,1)(2,2)(2,0)");
		String obstaclesString = planetExplorer.getObstacles();
		
		assertEquals(true, obstaclesString.contains("1,1"));
		assertEquals(true, obstaclesString.contains("2,2"));
		assertEquals(true, obstaclesString.contains("2,0"));
		assertEquals(false, obstaclesString.contains("2,1"));
	}
}
