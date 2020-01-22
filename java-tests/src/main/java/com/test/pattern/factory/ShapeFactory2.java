package com.test.pattern.factory;

public class ShapeFactory2 extends AbstractFactory {

  @Override
  Color getColor(String color) {
    return null;
  }

  @Override
  Shape getShape(String shape) {
    if (shape == null) {
      return null;
    }

    if (shape.equalsIgnoreCase("CIRCLE")) {
      return new Circle();

    } else if (shape.equalsIgnoreCase("RECTANGLE")) {
      return new Rectangle();

    } else if (shape.equalsIgnoreCase("SQUARE")) {
      return new Square();
    }

    return null;
  }
}
