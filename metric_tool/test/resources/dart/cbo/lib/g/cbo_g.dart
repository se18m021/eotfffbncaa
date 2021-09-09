library mylib;

import '../other/cbo_static_class.dart';
import 'sub/cbo_g_static.dart' as Alias;


class CboG {
  void method() {
    CboStaticClass.method1();
    Alias.CboGStatic.method();
  }
}
