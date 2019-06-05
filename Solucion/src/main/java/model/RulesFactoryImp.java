package model;

class RulesFactoryImp implements RulesFactory {

  public Rule getRule(String string) {

    if (string.startsWith(UpperRule.KEY)) {
      return new UpperRule();
    } else if (string.startsWith(VowelsRule.KEY)) {
      return new VowelsRule();
    } else if (string.startsWith(TranslateENRule.KEY)) {
      return new TranslateENRule();
    } else if (string.equals(EndRule.KEY)) {
      return new EndRule();
    } else {
      return new NoRule();
    }
  }
}
