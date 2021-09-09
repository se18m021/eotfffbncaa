library mylib;

class LcamB {
  LcamB(String myField) : _myField = myField;

  final String _myField;

  String getField() {
    return _myField;
  }

  String getSomethingElse() {
    return "somethingElse";
  }
}
