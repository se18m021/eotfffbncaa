library mylib;

class LcamC {
  LcamC();

  LcamC.secondaryConstructor(myField) {
    this._myField = myField;
  }

  String _myField = "";

  void setField(String myField) {
    _myField = myField;
  }

  String getField() {
    return _myField;
  }
}
