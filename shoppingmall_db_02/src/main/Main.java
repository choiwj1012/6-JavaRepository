package main;

import MainController.Controller;

public class Main {

	public static void main(String[] args) {
		
		new Controller();
		Controller.getProductController().requestSelectList();
		
		
	}
	
}
