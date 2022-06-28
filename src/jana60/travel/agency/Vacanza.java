package jana60.travel.agency;

import java.time.LocalDate;
import java.time.Period;

public class Vacanza {

	/*Consegna
	Nel progetto java-travel-agency, creare la classe Vacanza caratterizzata da:
	- destinazione
	- data inizio
	- data fine
	Quando viene creata una nuova Vacanza vanno effettuati dei controlli:
	- destinazione, data inizio e data fine non possono essere null
	- la data inizio non può essere già passata
	- la data fine non può essere prima della data inizio
	Se fallisce la validazione vanno sollevate opportune eccezioni
	La classe Vacanza espone un metodo per calcolare la durata della vacanza (in giorni, mesi, anni).
	Aggiungere una classe Agenzia con metodo main, dove chiediamo all’operatore se vuole inserire una nuova vacanza o uscire. Se vuole proseguire con l’inserimento va chiesta la destinazione, il giorno, mese e anno di partenza e il giorno, mese anno di ritorno.
	Con questi dati va generata una nuova vacanza e in console verrà stampato un messaggio del tipo:
	“Hai prenotato una vacanza di [durata della vacanza] a [destinazione] dal [data inizio formattata] al [data fine formattata]“.
	Se la creazione della vacanza genera un errore, il programma non deve interrompersi ma va gestito con dei messaggi di errore che permettono all’utente di capire cosa è andato storto e di ripetere l’inserimento.*/
	
	// attributi
	  private String destinazione;
	  private LocalDate dataInizio;
	  private LocalDate dataFine;

	  // costruttore
	  public Vacanza(String destinazione, LocalDate dataInizio, LocalDate dataFine)
	      throws NullPointerException, IllegalArgumentException {
	    super();

	    validaDestinazione(destinazione);
	    validaData(dataInizio);
	    validaData(dataFine);
	    validaDataInizioDataFine(dataInizio, dataFine);
	   
	    this.destinazione = destinazione;
	    this.dataInizio = dataInizio;
	    this.dataFine = dataFine;
	  }

	  public String getDestinazione() {
	    return destinazione;
	  }

	  public void setDestinazione(String destinazione) throws NullPointerException {
	    validaDestinazione(destinazione);
	    this.destinazione = destinazione;
	  }

	  public LocalDate getDataInizio() {
	    return dataInizio;
	  }

	  public void setDataInizio(LocalDate dataInizio)
	      throws NullPointerException, IllegalArgumentException {
	    validaData(dataInizio);
	    validaDataInizioDataFine(dataInizio, getDataFine());
	    this.dataInizio = dataInizio;
	  }

	  public LocalDate getDataFine() {
	    return dataFine;
	  }

	  public void setDataFine(LocalDate dataFine)
	      throws NullPointerException, IllegalArgumentException {
	    validaData(dataFine);
	    validaDataInizioDataFine(this.dataInizio, dataFine);
	    this.dataFine = dataFine;
	  }


	  // metodi public
	  public Period getDurata() {
	    return Period.between(getDataInizio(), getDataFine());
	  }

	  public String getDurataString() {
	    Period durata = getDurata();
	    String durataString = "";
	    if (durata.getYears() > 0) {
	      durataString += durata.getYears() + " anni ";
	    }
	    if (durata.getMonths() > 0) {
	      durataString += durata.getMonths() + " mesi ";
	    }
	    durataString += durata.getDays() + " giorni";

	    return durataString;
	  }

	  // metodi private
	  private void validaDestinazione(String destinazione) throws NullPointerException {
	    if (destinazione == null) {
	      throw new NullPointerException("destinazione non può essere null");
	    }
	  }

	  private void validaData(LocalDate data) throws NullPointerException, IllegalArgumentException {
	    if (data == null) {
	      throw new NullPointerException("data non può essere null");
	    }
	    if (data.isBefore(LocalDate.now())) {
	      throw new IllegalArgumentException("data non può essere passata");
	    }
	  }

	  private void validaDataInizioDataFine(LocalDate dataInizio, LocalDate dataFine)
	      throws IllegalArgumentException {
	    if (dataInizio.isAfter(dataFine)) {
	      throw new IllegalArgumentException("data fine non può essere precedente a data inizio");
	    }
	  }
	}


