// Last updated: 1/26/2026, 9:38:11 PM
1class Bank {
2    private long[] balance;
3    private int n;
4
5    public Bank(long[] balance) {
6        this.balance = balance;
7        this.n = balance.length;
8    }
9
10    private boolean validAccount(int account) {
11        return account >= 1 && account <= n;
12    }
13
14    public boolean transfer(int account1, int account2, long money) {
15        if (!validAccount(account1) || !validAccount(account2)) {
16            return false;
17        }
18        if (balance[account1 - 1] < money) {
19            return false;
20        }
21        balance[account1 - 1] -= money;
22        balance[account2 - 1] += money;
23        return true;
24    }
25
26    public boolean deposit(int account, long money) {
27        if (!validAccount(account)) {
28            return false;
29        }
30        balance[account - 1] += money;
31        return true;
32    }
33
34    public boolean withdraw(int account, long money) {
35        if (!validAccount(account)) {
36            return false;
37        }
38        if (balance[account - 1] < money) {
39            return false;
40        }
41        balance[account - 1] -= money;
42        return true;
43    }
44}
45