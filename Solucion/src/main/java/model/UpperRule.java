package model;

class UpperRule implements Rule{

  static final String KEY = "upper";

  @Override
  public String applyRule(String string) {
    return string.replace(KEY, "").toUpperCase();
  }
}
