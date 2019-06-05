package model;

class VowelsRule implements Rule{

  static final String KEY = "vowels";

  @Override
  public String applyRule(String string) {
    return string.replace(KEY, "")
            .replaceAll("a", "4")
            .replaceAll("e", "3")
            .replaceAll("i", "1")
            .replaceAll("o", "0")
            .replaceAll("u", "7");
  }
}
