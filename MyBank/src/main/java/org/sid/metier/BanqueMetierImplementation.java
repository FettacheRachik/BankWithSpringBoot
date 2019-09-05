package org.sid.metier;

import java.util.Date;

import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Compte;
import org.sid.entities.CompteCourant;
import org.sid.entities.Operation;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BanqueMetierImplementation implements IBanqueMetier{
	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private OperationRepository operationRepository;
	@Override
	public Compte consulterCompte(String codeCompte) {
		// TODO Auto-generated method stub
		
		Compte cp = compteRepository.compteParId(codeCompte);
		
		//Exception non surveillée runtimeException //Crer Exception Metier
		if (cp ==null )throw new RuntimeException ("Compte introuvable");
		return cp;
	}

	@Override
	public void verser(String codeCompte, double montant) {

		Compte cp = consulterCompte(codeCompte);
		Versement v =new Versement (new Date(),montant ,cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()+ montant);
		compteRepository.save(cp);
	}

	@Override
	public void retirer(String codeCompte, double montant) {
		Compte cp = consulterCompte(codeCompte);
		double faciliteCaisse = 0;
		
		if (cp instanceof CompteCourant) {
			faciliteCaisse =(( CompteCourant )cp).getDecouvert();
		}
		
		if (cp.getSolde() + faciliteCaisse<montant) {
			throw new RuntimeException ("Retrait non autorisé :solde insuffisant");
		}
		Retrait r = new Retrait (new Date(),montant , cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
		
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		
		if (codeCpte1.equals(codeCpte2)) {
			throw new RuntimeException("Operation invalide: meme compte");
		}
		retirer(codeCpte1,montant);
		verser(codeCpte2,montant);
		
	}

	@Override
	public Page<Operation> listOperation(String codeCompte, int page, int size) {
		
		return operationRepository.listOperation(codeCompte, new PageRequest(page,size));
		
	}

}
