package ma.ac.emi.MinuteBrico.Controllers;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ma.ac.emi.MinuteBrico.Models.Client;
import ma.ac.emi.MinuteBrico.Models.ClientAccount;
import ma.ac.emi.MinuteBrico.Services.AccountClientServices;
import ma.ac.emi.MinuteBrico.Services.ClientServices;

@Controller
public class ClientController {

	 private ClientServices clientServices;
	 private AccountClientServices accountClientServices;
 @CrossOrigin()	
 @GetMapping("/Client")
 public List<Client> show() {
	 return clientServices.findAll();
 }
 
 @CrossOrigin()
@PostMapping("/Client")
 public String addClient(@RequestBody Map<String,Object> clientMap) {
	 Client client=new Client(clientMap);
	 ClientAccount aClient=new ClientAccount(clientMap);
	 clientServices.saveClient(client);
	 accountClientServices.addAccountClient(aClient);
	 return "Client Ajouté";
 }
 
 @CrossOrigin()
 @DeleteMapping("/Client")
 public String deleteaccount(@RequestBody int id){
	  accountClientServices.deleteAccount(id);
	  return "Compte supprimé";
 }
 
}
