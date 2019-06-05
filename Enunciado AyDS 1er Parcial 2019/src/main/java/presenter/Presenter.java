package presenter;

import model.Model;
import view.Terminal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Presenter {

  private Terminal view;
  private Model model = new Model();

  public void setView(Terminal view) {
    this.view = view;
    model.setListener(view);
  }

  public void addString(String string) {
    model.addString(string, now());
  }

  private LocalDateTime now() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm");
    LocalDateTime date = LocalDateTime.now();
    String text = date.format(formatter);
    return LocalDateTime.parse(text, formatter);
  }

}
