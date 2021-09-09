library mylib;

import 'other/rfc_other.dart';

class RfcF {
  void method() {
    RfcOther rfcOther = RfcOther();
    rfcOther.method1();
    rfcOther.method2(1);
  }
}

void method() {
  RfcOther rfcOther = RfcOther();
  rfcOther.method1();
}
