package overlappingInterval

import utils.measure


/**
 * @author jerry on 24/09/2020
 * for kotlin
 **/


/*
Asked by SnapChat from the Daily Coding Problem:

Given a list of possible overlapping intervals, return a new list of intervals
where all overlapping intervals have been merged

The input list is not necessarily ordered in any way.
For example:
Input: [(1, 3), (5, 8), (4, 10), (20, 25)]]
Output: [(1, 3), (4, 10), (20, 25)].

We can do this by sorting the intervals by their start time. This way, looking
when looking at the current interval, if it overlaps with the previous one, we can just combine them

Note: Since we have to sort the list, this runs in O(n log n)
*/

fun overlappingIntervals(intervals: Array<Pair<Int, Int>>): Array<Pair<Int, Int>> {
    val result = mutableListOf<Pair<Int, Int>>()

    //sort th array
    intervals.sortBy { it.first }
    println(intervals)

    for (i in 0 until intervals.count()) {
        if (result.isNotEmpty() && intervals[i].first <= result.last().second) {
            val (prevStart, prevEnd) = result.last()
            result[result.count() - 1] = (prevStart to maxOf(intervals[i].second, prevEnd))
        } else {
            result.add(intervals[i])
        }
    }
    return result.toTypedArray()
}

fun overlappingIntervals2(intervals: Array<Pair<Int, Int>>): Array<Pair<Int, Int>> {
    val result = mutableListOf<Pair<Int, Int>>()

    //sort th array
    val sortedIntervals = intervals.sortedBy { it.first }

    for (i in 0 until sortedIntervals.count()) {
        if (result.isNotEmpty() && sortedIntervals[i].first <= result.last().second) {
            val (prevStart, prevEnd) = result.last()
            result[result.count() - 1] = (prevStart to maxOf(sortedIntervals[i].second, prevEnd))
        } else {
            result.add(sortedIntervals[i])
        }
    }
    return result.toTypedArray()
}


fun main() {
    measure("Overlapping Interval - In-place Sort: ") {
        println(overlappingIntervals(arrayOf(1 to 3, 20 to 5, 4 to 10, 5 to 8)).contentToString())
    }

    measure("Overlapping Interval - Not In-place Sort: ") {
        println(overlappingIntervals2(arrayOf(1 to 3, 20 to 5, 4 to 10, 5 to 8)).contentToString())
    }
}