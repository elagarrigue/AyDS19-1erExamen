package model;

public class ModelModule {

  private static ModelModule instance = null;

  private ModelImp modelImp;

  private ModelModule() {
    modelImp = new ModelImp(new RulesFactoryImp(), new LoggerImp());
  }

  public static ModelModule getInstance() {
    if (instance == null) {
      instance = new ModelModule();
    }
    return instance;
  }

  public Model getModel() {
    return modelImp;
  }

}
