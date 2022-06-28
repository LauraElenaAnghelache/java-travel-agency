package jana60.travel.agency;

import java.time.LocalDate;
import java.util.Scanner;

public class Agenzia {

	  public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Benvenuto a Java Travel");

	    // destinazione
	    System.out.println("Dove vuoi andare?");
	    String destinazioneInput = scan.nextLine();

	    // data inizio
	    System.out.println("Quando vuoi partire?");
	    System.out.print("giorno: ");
	    int giornoPartenza = scan.nextInt();
	    System.out.print("mese: ");
	    int mesePartenza = scan.nextInt();
	    System.out.print("anno: ");
	    int annoPartenza = scan.nextInt();
	    LocalDate dataPartenza = null;
	    try {
	      dataPartenza = LocalDate.of(annoPartenza, mesePartenza, giornoPartenza);
	    } catch (Exception e) {
	      System.out.println("Data non valida");
	    }

	    // data fine
	    System.out.println("Quando vuoi tornare?");
	    System.out.print("giorno: ");
	    int giornoArrivo = scan.nextInt();
	    System.out.print("mese: ");
	    int meseArrivo = scan.nextInt();
	    System.out.print("anno: ");
	    int annoArrivo = scan.nextInt();
	    LocalDate dataArrivo = null;
	    try {
	      dataArrivo = LocalDate.of(annoArrivo, meseArrivo, giornoArrivo);
	    } catch (Exception e) {
	      System.out.println("Data non valida");
	    }

	    try {
	      Vacanza nuovaVacanza = new Vacanza(destinazioneInput, dataPartenza, dataArrivo);
	      System.out.println("hai prenotato una vacanza di " + nuovaVacanza.getDurataString() + " a "
	          + nuovaVacanza.getDestinazione());

	    } catch (NullPointerException e) {
	      System.out.println("Tutti i dati devono esssere compilati");
	      System.out.println(e.getMessage());
	    } catch (IllegalArgumentException e) {
	      System.out.println("Dati non validi");
	      System.out.println(e.getMessage());
	    }

	    scan.close();
	  }

	}


