import presenter.Presenter;
import view.Terminal;

public class Main {

  public static void main(String[] args) {

    Presenter presenter = new Presenter();
    Terminal terminal = new Terminal();

    presenter.setView(terminal);
    terminal.setPresenter(presenter);

    terminal.getInputs();
  }
}
