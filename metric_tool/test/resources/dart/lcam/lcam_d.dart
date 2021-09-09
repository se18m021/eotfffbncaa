library mylib;

class LcamD {
  final String _myField = "myField";
  final String _anotherField = "anotherField";

  String getField() {
    return _myField;
  }

  String getAnotherField() {
    return _anotherField;
  }

  String getCombinedFields() {
    return _myField + _anotherField;
  }
}
