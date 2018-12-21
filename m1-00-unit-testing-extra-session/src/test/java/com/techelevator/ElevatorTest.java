package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ElevatorTest {

	Elevator elevator;
	
	@Before
	public void setup() {
		elevator = new Elevator(1, 10);
	}
	
	@Test
	public void verify_cannot_move_up_when_door_is_open() {
		// Arrange
		elevator.OpenDoor();
		// Act
		boolean didMove = elevator.GoUp(3);
		// Assert 
		Assert.assertFalse("GoUp returned TRUE", didMove);
		Assert.assertEquals("Elevator Moved", 1, elevator.getCurrentLevel());
		
	}
	
	@Test
	public void verify_cannot_move_down_when_door_is_open() {
		// Arrange
		elevator.CloseDoor();
		elevator.GoUp(5);
		elevator.OpenDoor();
		// Act
		boolean didMove = elevator.GoDown(3);
		// Assert
		Assert.assertFalse("GoDown returned TRUE", didMove);
		Assert.assertEquals("Elevator moved", 5, elevator.getCurrentLevel());
		
	}
	
	@Test 
	public void open_door_when_door_is_open() {
		// Arrange
		// Act
		elevator.OpenDoor();
		// Assert
		Assert.assertTrue("Door was closed", elevator.isDoorOpen());
	}
	
	@Test
	public void open_door_when_door_is_closed() {
		// Arrange
		elevator.CloseDoor();
		// Act
		elevator.OpenDoor();
		// Assert
		Assert.assertTrue("Door was closed", elevator.isDoorOpen());
	}
	
	@Test 
	public void close_door_when_door_is_open() {
		// Arrange
		// Act
		elevator.CloseDoor();
		// Assert
		Assert.assertFalse("Door was open", elevator.isDoorOpen());
	}
	
	@Test
	public void close_door_when_door_is_closed() {
		// Arrange
		elevator.CloseDoor();
		// Act
		elevator.CloseDoor();
		// Assert
		Assert.assertFalse("Door was open", elevator.isDoorOpen());
	}
	
	@Test
	public void go_up_from_floor_1() {
		// Arrange
		elevator.CloseDoor();
		// Act
		boolean didMove = elevator.GoUp(3);
		// Assert
		Assert.assertTrue(didMove);
		Assert.assertEquals(3, elevator.getCurrentLevel());
	}
	
	@Test
	public void go_to_top_floor() {
		// Arrange
		elevator.CloseDoor();
		// Act
		boolean didMove = elevator.GoUp(10);
		// Assert
		Assert.assertTrue(didMove);
		Assert.assertEquals(10, elevator.getCurrentLevel());
	}
	
	@Test
	public void goup_and_goup_again() {
		// Arrange
		elevator.CloseDoor();
		elevator.GoUp(5);
		// Act
		boolean didMove = elevator.GoUp(7);
		// Assert
		Assert.assertTrue(didMove);
		Assert.assertEquals(7, elevator.getCurrentLevel());
	}
}
