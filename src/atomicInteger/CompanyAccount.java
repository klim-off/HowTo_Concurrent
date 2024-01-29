package atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class CompanyAccount {
   // private Integer totalMoney;
    private final AtomicInteger totalMoney = new AtomicInteger();

    public CompanyAccount(int totalMoney) {

        this.totalMoney.set(totalMoney);
    }

    public int getTotalMoney() {
        return totalMoney.get();
    }

    public void addMoney(int money) {

        totalMoney.addAndGet( money);
    }
}
