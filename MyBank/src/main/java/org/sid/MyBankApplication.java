package org.sid;

import java.util.Date;

import org.sid.dao.ClientRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Client;
import org.sid.entities.Compte;
import org.sid.entities.CompteCourant;
import org.sid.entities.CompteEpargne;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.sid.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MyBankApplication implements CommandLineRunner{
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	
	@Autowired
	private IBanqueMetier banqueMetier;

	public static void main(String[] args) {
		SpringApplication.run(MyBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*Client c1= clientRepository.save(new Client ("Loic","loic@gmail.com"));
		Client c2 = clientRepository.save(new Client ("Rene","Rene@gmail.com"));
		Client c3 = clientRepository.save(new Client ("Lolo","lolo@gmail.com"));
		
		Compte cpt1 = compteRepository.save(new CompteCourant("c1",new Date(),9000,c1,6000));
		Compte cpt2 = compteRepository.save(new CompteEpargne("c2",new Date(),9000,c2,5.5));

		Compte cpt3 = compteRepository.save(new CompteEpargne("c3",new Date(),239,c2,5.5));
		
		
		operationRepository.save(new Versement (new Date(),10,cpt1));
		operationRepository.save(new Versement (new Date(),20,cpt1));
		operationRepository.save(new Retrait (new Date(),20,cpt1));
		
		operationRepository.save(new Versement (new Date(),100,cpt2));
		operationRepository.save(new Retrait (new Date(),30,cpt1));
		operationRepository.save(new Versement (new Date(),100,cpt2));
		operationRepository.save(new Retrait (new Date(),30,cpt1));
		operationRepository.save(new Versement (new Date(),100,cpt2));
		operationRepository.save(new Retrait (new Date(),30,cpt1));
		operationRepository.save(new Versement (new Date(),100,cpt2));
		operationRepository.save(new Retrait (new Date(),30,cpt1));
		operationRepository.save(new Versement (new Date(),100,cpt2));
		operationRepository.save(new Retrait (new Date(),30,cpt1));
		
		banqueMetier.verser(cpt1.getCodeCompte(), 150000);*/
		
		/*String password = "1234";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		System.err.println("hashedpassword" + hashedPassword);
		*/
	}

}
