package presenter;

import model.Model;
import model.ModelModule;
import view.Terminal;

public class Presenter {

  private Terminal view;
  private Model model = ModelModule.getInstance().getModel();

  public void setView(Terminal view) {
    this.view = view;
    model.setOnUpdateListener(view);
  }

  public void addString(String string) {
    model.addString(string);
  }

}
