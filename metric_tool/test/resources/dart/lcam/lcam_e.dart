library mylib;

class LcamE {
  LcamE(String myField) : _myField = myField;

  final String _myField;

  String getField() {
    return _myField;
  }

  String getFieldAsLocalVariable() {
    String _myField = "field as local variable";
    return _myField;
  }
}
