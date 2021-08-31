package main;

import java.awt.EventQueue;

import telainicio.Inicio;

public class Main {

	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
		        public void run() {
		           Inicio t = new Inicio();
		           t.setVisible(true);
		        }
		    });
		

	}

}
