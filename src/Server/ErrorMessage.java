package src.Server;

import src.bin.Message;

/**
 * Diese Meldung wird immer dann vom Server an die Clients gesendet, wenn ein Fehler aufgetreten ist.
 * Die Meldung enthält einen String mit der Beschreibung des Fehlers.
 * 
 * @author Andres Scheidegger
 *
 */
public class ErrorMessage implements Message {
  private String errorMessage;

  public ErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
