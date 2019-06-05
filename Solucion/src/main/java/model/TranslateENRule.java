package model;

class TranslateENRule implements Rule{

  static final String KEY = "EN";

  @Override
  public String applyRule(String string) {
    return  string.replace(KEY, "")
            .replaceAll("the", "el")
            .replaceAll("cat", "gato")
            .replaceAll("is", "está")
            .replaceAll("in", "en")
            .replaceAll("park", "parque");
  }
}
