package com.tokopedia.climbingstairs

object Solution {
    fun climbStairs(n: Int): Long {
        // 1 <= n < 90
        val memo = LongArray(n+1)
        return climbing(0, n, memo)
    }

    fun climbing(i: Int, n: Int, memo: LongArray): Long {
        if (i > n) {
            return 0
        }
        if (i == n) {
            return 1
        }
        if (memo[i] > 0) {
            return memo[i]
        }
        memo[i] = climbing(i + 1, n, memo) + climbing(i + 2, n, memo)
        return memo[i]
    }
}
