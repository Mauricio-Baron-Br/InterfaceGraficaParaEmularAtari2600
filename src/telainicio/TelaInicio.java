package telainicio;

import java.awt.EventQueue;

public class TelaInicio {

	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
		        public void run() {
		           Inicio t = new Inicio();
		           t.setVisible(true);
		        }
		    });
		

	}

}
