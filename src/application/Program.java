
package application;
import javax.swing.JOptionPane;

import entities.Client;
import services.ClientMapDAO;
import services.IClientDAO;

public class Program {

	private static IClientDAO IClientDAO;
	
	public static void main(String[] args) {
		
		IClientDAO = new ClientMapDAO();
		
		String option = JOptionPane.showInputDialog(null, "Options \n 1 - Registration \n 2 - Search \n "
				+ "4 - Modify \n 5 - Exit", "Register System", JOptionPane.INFORMATION_MESSAGE);
		
		while(!isOptionValid(option)) {
			
			if ("5".equals(option)) {
				exit();
			}
			option = JOptionPane.showInputDialog(null, "Options \n 1 - Registration \n 2 - Search \n "
					+ "4 - Modify \n 5 - Exit", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
		}
		
	while(isOptionValid(option)) {
			
			if ("5".equals(option)) {
				exit();
			} 
			else if (isRegisterOption(option)) {
				String data = JOptionPane.showInputDialog(null, "Digite os dados separador por virgula: ",
						"Register", JOptionPane.INFORMATION_MESSAGE);
				registerOption(data);
			}	
			else if (isRegisterSearch(option)) {
				String data = JOptionPane.showInputDialog(null, "Digite os dados para consulta: ",
						"Consults", JOptionPane.INFORMATION_MESSAGE);
				searchOption(data);
			}
			else if (isRegisterDelete(option)) {
				String data = JOptionPane.showInputDialog(null, "Digite o CPF do client: ",
						"Exclusão de cliente", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (isModifyOption(option)) {
				String data = JOptionPane.showInputDialog(null, "Digite o CPF do client: ",
						"Exclusão de cliente", JOptionPane.INFORMATION_MESSAGE);
			}
			option = JOptionPane.showInputDialog(null, "Options \n 1 - Registration \n 2 - Search \n "
					+ "4 - Modify \n 5 - Exit", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	// Funtions for options
	
	private static void exit() {
		JOptionPane.showMessageDialog(null, "Good Bye", "Exit", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
	private static void registerOption (String data) {
		String[] dateSplit = data.split(",");
		
		 Client client = new Client(dateSplit[0],dateSplit[1],dateSplit[2],dateSplit[3],dateSplit[4],dateSplit[5],dateSplit[6]);
	        Boolean isRegistered = IClientDAO.register(client);
	        if (isRegistered) {
	            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso ", 
	            		"Sucesso",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado", 
	            		"Erro",JOptionPane.INFORMATION_MESSAGE);
	        }
	}
	
	private static void searchOption(String data) {
		Client client = IClientDAO.consult(Long.parseLong(data));
		
		if (client != null) {
			JOptionPane.showMessageDialog(null, "Client encontrado:" + client.toString(), 
            		"Sucess",JOptionPane.INFORMATION_MESSAGE);	
		}
		else {
			JOptionPane.showMessageDialog(null, "Client não encontrado", 
            		"Sucess",JOptionPane.INFORMATION_MESSAGE);	
		}
	}
	
	// Validate options
	private static boolean isOptionValid(String option) {
		if ("1".equals(option) || "2".equals(option) || "3".equals(option) || "4".equals(option)) {
			return true;
			}
			return false;
	}
	
	private static boolean isRegisterOption(String option) {
		if ("1".equals(option)) {
			return true;
		}
		return false;
	}
	
	private static boolean isRegisterSearch (String option) {
		if ("2".equals(option)) {
			return true;
		}
		return false;
	}

	private static boolean isRegisterDelete(String option) {
		if ("3".equals(option)) {
			return true;
		}
		return false;
	}
	private static boolean isModifyOption(String option) {
		if ("4".equals(option)) {
			return true;
		}
		return false;
	}

}
