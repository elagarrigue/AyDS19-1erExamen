package model;

class EndRule implements Rule {

  static final String KEY = "end";

  @Override
  public String applyRule(String string) {
    return "end";
  }
}
