library mylib;

import 'package:flutter/material.dart';

/**
 * MyClass
 * this is some comment
 */
class ClocA {
  // some comment
  final String myString = "myString";

  /// this returns the local string + the value
  @override
  String myFun(String value) {
    final local = myString;
    /*
        some multiline
        comment
     */
    return local + value;
  }
}
