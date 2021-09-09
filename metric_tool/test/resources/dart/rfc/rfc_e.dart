library mylib;

import 'other/rfc_other.dart';

class RfcE1 {
  void method() {
    RfcOther rfcOther = RfcOther();
    rfcOther.method1();
    rfcOther.method2(1);
  }
}

class RfcE2 {
  void method() {
    RfcOther rfcOther = RfcOther();
    rfcOther.method1();
  }
}