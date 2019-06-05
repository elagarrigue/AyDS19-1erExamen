package model;

class NoRule implements Rule{
  @Override
  public String applyRule(String string) {
    return "No rule " + string;
  }
}
