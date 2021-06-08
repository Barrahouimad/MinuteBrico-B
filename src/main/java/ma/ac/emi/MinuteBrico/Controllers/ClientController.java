package ma.ac.emi.MinuteBrico.Controllers;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import ma.ac.emi.MinuteBrico.Models.BricoleurModel;
import ma.ac.emi.MinuteBrico.Models.Client;
import ma.ac.emi.MinuteBrico.Models.ClientAccount;
import ma.ac.emi.MinuteBrico.Models.Mission;
import ma.ac.emi.MinuteBrico.Repositories.ClientRepository;
import ma.ac.emi.MinuteBrico.Services.AccountClientServices;
import ma.ac.emi.MinuteBrico.Services.ClientServices;

@RestController
public class ClientController {

	 private ClientServices clientServices;
		private final ClientRepository clientrepository ;
		public ClientController(ClientRepository clientRepo) {
			this.clientrepository=clientRepo;
		}
		
 @CrossOrigin()	
 @GetMapping("/Client")
 public List<Client> show() {
	 return clientServices.findAll();
 }
 
 @CrossOrigin()
@PostMapping("/Client")
 public String addClient(@RequestBody Map<String,Object> clientMap) {
	 Client client=new Client(clientMap);
	 String email = client.getEmail();
	 //clientrepository.findByEmail(email);
	 if(clientrepository.findByEmail(email).size() !=0) {
		 return "existe";
	 }
	 clientrepository.save(client);
	 return "Client Ajouté";
 }
 
 
 @CrossOrigin()	
 @GetMapping("/MissionClient/{id}")
 public List<Mission> showMissions(@PathVariable int id) {
	
	 return  clientrepository.findById(id).getMissions();
 }
 
    @CrossOrigin()
	@GetMapping("/ClientAccount/{password}/{email}")
	public List<Client>  indexCheck(@PathVariable String password,@PathVariable String email) {
	                
	 if((clientrepository.findByEmailAndPassword(email,password).size()==0)) {
		   Client client = new Client();
		   client.setFirstName("Null");
			List<Client> list = clientrepository.findByEmailAndPassword(email,password) ;
			list.add(client);
			
			return list;
			
		}
	 
	 
		return clientrepository.findByEmailAndPassword(email,password);

	}
    @CrossOrigin()
	@GetMapping("/Clienttoken/{token}")
	public Client  get(@PathVariable String token) {
		
		
		return clientrepository.findByToken(token);
	}

 
}
