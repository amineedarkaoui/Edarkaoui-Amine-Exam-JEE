package ma.amine.exam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import ma.amine.exam.model.AutoContract;
import ma.amine.exam.model.Client;
import ma.amine.exam.model.ContractStatus;
import ma.amine.exam.model.HabitationContract;
import ma.amine.exam.model.NiveauCouverture;
import ma.amine.exam.model.Paiement;
import ma.amine.exam.model.SanteContract;
import ma.amine.exam.model.TypeLogement;
import ma.amine.exam.model.TypePaiement;
import ma.amine.exam.repository.ClientRepository;
import ma.amine.exam.repository.ContractRepository;
import ma.amine.exam.repository.PaiementRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

	@Bean
	ApplicationRunner seedData(
			ClientRepository clientRepository,
			ContractRepository contractRepository,
			PaiementRepository paiementRepository) {
		return args -> {
			if (clientRepository.count() > 0 || contractRepository.count() > 0 || paiementRepository.count() > 0) {
				return;
			}

			Client client1 = Client.builder()
					.nom("Amine Edarkaoui")
					.email("amine@example.com")
					.build();
			Client client2 = Client.builder()
					.nom("Sara Benali")
					.email("sara@example.com")
					.build();
			Client client3 = Client.builder()
					.nom("Youssef El Idrissi")
					.email("youssef@example.com")
					.build();

			clientRepository.saveAll(List.of(client1, client2, client3));

			AutoContract autoContract = AutoContract.builder()
					.client(client1)
					.dateSouscription(LocalDateTime.now().minusDays(20))
					.statut(ContractStatus.VALIDE)
					.dateValidation(LocalDateTime.now().minusDays(10))
					.montantCotisation(1200.0)
					.dureeContrat(12)
					.tauxCouverture(0.8)
					.numeroImmatriculation("123-TUN-456")
					.marqueVehicule("Peugeot")
					.modeleVehicule("208")
					.build();

			HabitationContract habitationContract = HabitationContract.builder()
					.client(client2)
					.dateSouscription(LocalDateTime.now().minusDays(15))
					.statut(ContractStatus.EN_COURS)
					.montantCotisation(900.0)
					.dureeContrat(24)
					.tauxCouverture(0.7)
					.typeLogement(TypeLogement.APPARTEMENT)
					.adresseLogement("12 Rue des Fleurs, Rabat")
					.superficie(85.0)
					.build();

			SanteContract santeContract = SanteContract.builder()
					.client(client3)
					.dateSouscription(LocalDateTime.now().minusDays(7))
					.statut(ContractStatus.VALIDE)
					.dateValidation(LocalDateTime.now().minusDays(2))
					.montantCotisation(650.0)
					.dureeContrat(12)
					.tauxCouverture(0.9)
					.niveauCouverture(NiveauCouverture.PREMIUM)
					.nombrePersonnesCouvertes(4)
					.build();

			contractRepository.saveAll(List.of(autoContract, habitationContract, santeContract));

			Paiement paiement1 = Paiement.builder()
					.contract(autoContract)
					.date(LocalDate.now().minusDays(5))
					.montant(BigDecimal.valueOf(100.0))
					.type(TypePaiement.MENSUALITE)
					.build();
			Paiement paiement2 = Paiement.builder()
					.contract(habitationContract)
					.date(LocalDate.now().minusDays(3))
					.montant(BigDecimal.valueOf(250.0))
					.type(TypePaiement.PAIEMENT_ANNUEL)
					.build();
			Paiement paiement3 = Paiement.builder()
					.contract(santeContract)
					.date(LocalDate.now().minusDays(1))
					.montant(BigDecimal.valueOf(75.0))
					.type(TypePaiement.PAIEMENT_EXCEPTIONNEL)
					.build();

			paiementRepository.saveAll(List.of(paiement1, paiement2, paiement3));
		};
	}

}
