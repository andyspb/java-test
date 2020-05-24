package com.lux;

import java.math.BigDecimal;
import java.util.Date;

public class EmployeeAsGoodKeyForMap {
  private final long id;
  private final String name;
  private final Date dateOfBirth;
  private final BigDecimal salary;

  public EmployeeAsGoodKeyForMap(long id, String name, Date dateOfBirth, BigDecimal salary) {
    this.id = id;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.salary = salary;
  }

  //Getter and Setters
  // to String
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EmployeeAsGoodKeyForMap employee = (EmployeeAsGoodKeyForMap) o;
    if (id != employee.id) return false;
    if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
    if (dateOfBirth != null ? !dateOfBirth.equals(employee.dateOfBirth) : employee.dateOfBirth != null) return false;
    return salary != null ? salary.equals(employee.salary) : employee.salary == null;
  }
  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
    result = 31 * result + (salary != null ? salary.hashCode() : 0);
    return result;
  }
}
