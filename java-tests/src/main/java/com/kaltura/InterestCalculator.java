package com.kaltura;

public class InterestCalculator {

//  4.	Write an interest calculator that accepts an initial deposit sum, interest rate (annual),
//  optional yearly additional contribution and the number of years to calculate and returns the
//  total balance, total contribution and total interest. You can use any language you want, i
//  ncluding pseudo code.

  public static Return interestCalculator(float depositSum, float interestRate,
                                          float yearlyAddContribution, int years) {
    Return ret = new Return();

    float totalAmount = 0;
    float totalBalance = depositSum;
    float totalContribution = 0;
    float totalInterest = 0;
    for (int i = 1; i <= years; ++i ){
      System.out.println("Year: " + i);

      float yearlyRate = totalBalance * interestRate / 100;
      System.out.println("yearlyInterestPaid:"+yearlyRate);
      totalBalance += yearlyRate;
      if (yearlyAddContribution > 0) {
        totalBalance += totalBalance;
        totalContribution += totalContribution;
      }

      System.out.println("depositSum: " + depositSum );
      System.out.println("principal:" + totalBalance);
      System.out.println("totalAmount:" + totalAmount);

      System.out.println("----------------");
    }

    return ret;
  }



  public static void main(String[] args) {
    //
    float depositSum = 2000;
    float interest = 6;
    int years = 3;
    Return ret = interestCalculator(depositSum, interest, 0, years);
  }
}

class Return {
  public float totalBalance;
  public float totalContribution;
  public float totalInterest;

}

