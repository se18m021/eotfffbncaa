library mylib;

class WmcC {
  WmcC();

  WmcC.secondaryConstructor1(String myField) : this();

  WmcC.secondaryConstructor2(int myField) : super() {
  }

  const WmcC.constConstructor();
}
