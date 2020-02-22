package rmi_client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

import rmi_interface.Cars;
import rmi_interface.RMIInterface;

public class Customer {
	private static RMIInterface look_up;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		look_up = (RMIInterface) Naming.lookup("//localhost/MyCarStore");

		boolean findmore;
		do {
			String[] options = { "Show All", "Find a Car", "Exit" };
			int choice = JOptionPane.showOptionDialog(null, "Choose an action", "Option dialog",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

			switch (choice) {
			case 0:
				List<Cars> list = look_up.allCars();
				StringBuilder message = new StringBuilder();
				list.forEach(x -> {
					message.append(x.toString() + "\n");
				});
				JOptionPane.showMessageDialog(null, new String(message));
				break;
			case 1:
				String bus_id = JOptionPane.showInputDialog("Type Bus_Id of the Car you want to find.");
				try {
					Cars response = look_up.findCar(new Cars(bus_id));
					JOptionPane.showMessageDialog(null,
							"Name: " + response.getBus_name() + "\n" + "ID" + response.getBus_id() + "\n" + "Seat_No"
									+ response.getBus_seat_no(),
							response.getDeparture_time(), JOptionPane.INFORMATION_MESSAGE);
				} catch (NoSuchElementException ex) {
					JOptionPane.showMessageDialog(null, "Not found");
				}
				break;
			default:
				System.exit(0);
				break;
			}
			findmore = (JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit",
					JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION);
		} while (findmore);
	}
}
