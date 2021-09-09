library mylib;

class WmcJ {
  void method1() {
    switch (0) {
      case 0:
        break;
      case 1:
        break;
      case 2:
        switch (2) {
          case 0:
            break;
          default:
            break;
        }
        break;
      default:
        break;
    }
  }

  void method2() {
    switch (0) {
      case 0:
        break;
      default:
        break;
    }
  }
}
