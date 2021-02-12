package com.tokopedia.oilreservoir

/**
 * Created by fwidjaja on 2019-09-24.
 */
object Solution {
    fun collectOil(height: IntArray): Int {
        var res = 0
        var n = height.size

        for (i in 1 until n - 1) {

            // Find maximum element on left
            var left: Int = height[i]
            for (j in 0 until i) {
                left = left.coerceAtLeast(height[j])
            }

            // Find maximum element on right
            var right: Int = height[i]
            for (j in i + 1 until n) {
                right = right.coerceAtLeast(height[j])
            }

            // Update maximum water value
            res += left.coerceAtMost(right) - height[i]
        }
        return res
    }
}
