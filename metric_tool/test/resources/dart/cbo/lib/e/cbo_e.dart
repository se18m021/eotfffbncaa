library mylib;

import 'sub/cbo_e_sub.dart';
import 'sub/cbo_e_sub.dart' as Alias;

class CboE {
  void method() {
    final cboE = CboESub();
    final cboE2 = Alias.CboESub();
  }
}
