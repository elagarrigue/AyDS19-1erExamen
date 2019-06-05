package model;

import java.util.ArrayList;
import java.util.List;

class ModelImp implements Model{

  private OnUpdateListener onUpdateListener;

  private List<String> list = new ArrayList<>();

  private final RulesFactory rulesFactory;
  private final Logger logger;

  ModelImp(RulesFactory rulesFactory, Logger logger) {
    this.rulesFactory = rulesFactory;
    this.logger = logger;
  }

  public void setOnUpdateListener(OnUpdateListener onUpdateListener) {
    this.onUpdateListener = onUpdateListener;
  }

  public void addString(String string) {

    string = applyRule(string);

    log(string);

    addStringToList(string);

    notifyListener();
  }

  private String applyRule(String string) {
    Rule rule = rulesFactory.getRule(string);

    return rule.applyRule(string);
  }

  private void log(String string) {
    logger.logString(string);
  }

  private void addStringToList(String string) {
    list.add(string);
  }

  private void notifyListener() {
    if (onUpdateListener != null) onUpdateListener.onStringsUpdated(list);
  }
}
