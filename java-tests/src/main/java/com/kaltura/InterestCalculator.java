package com.kaltura;

public class InterestCalculator {

//  4.	Write an interest calculator that accepts an initial deposit sum, interest rate (annual),
//  optional yearly additional contribution and the number of years to calculate and returns the
//  total balance, total contribution and total interest. You can use any language you want, i
//  including pseudo code.

  public static String interestCalculator(float depositSum, float interestRate,
                                          float yearlyContribution, int years) {
    StringBuffer sb = new StringBuffer();

    float totalBalance = depositSum, totalContribution = 0, totalInterest = 0;
    for (int i = 1; i <= years; ++i) {
      float currentBalance = totalBalance;
      float yearlyRate = totalBalance * interestRate / 100;
      totalBalance += yearlyRate;
      totalInterest += yearlyRate;
      if (yearlyContribution > 0) {
        totalBalance += yearlyContribution;
        totalContribution += yearlyContribution;
      }
    }
    sb.append("totalBalance:").append(totalBalance).append(",");
    sb.append("totalContribution:").append(totalContribution).append(",");
    sb.append("totalInterest:").append(totalInterest).append("");

    return sb.toString();
  }


  public static void main(String[] args) {
    float depositSum = 2000;
    float interest = 6;
    int years = 3;
    float addContribution = 100;
    String ret = interestCalculator(depositSum, interest, addContribution, years);
    System.out.println(ret);
  }
}

//  public static String interestCalculator(float depositSum, float interestRate,
//                                          float yearlyContribution, int years) {
//    StringBuffer sb = new StringBuffer();
//
//    float totalBalance = depositSum, totalContribution = 0, totalInterest = 0;
//    for (int i = 1; i <= years; ++i) {
//      float currentBalance = totalBalance;
//      float yearlyRate = totalBalance * interestRate / 100;
//      System.out.print( "currentBalance:" + currentBalance + " yearlyInterestPaid:" + yearlyRate + " yearlyAddContribution:" + yearlyContribution);
//      System.out.println("");
//      totalBalance += yearlyRate;
//      totalInterest += yearlyRate;
//      if (yearlyContribution > 0) {
//        totalBalance += yearlyContribution;
//        totalContribution += yearlyContribution;
//      }
//
//      System.out.print(" totalBalance:" + totalBalance);
//      System.out.print(" totalInterest:" + totalInterest);
//      System.out.print(" yearlyContribution:" + yearlyContribution);
//      System.out.print(" totalContribution:" + totalContribution);
//      System.out.println();
//      System.out.println("----------------");
//    }
//    sb.append("totalBalance:").append(totalBalance).append(",");
//    sb.append("totalContribution:").append(totalContribution).append(",");
//    sb.append("totalInterest:").append(totalInterest).append("");
//
//    return sb.toString();
//  }
